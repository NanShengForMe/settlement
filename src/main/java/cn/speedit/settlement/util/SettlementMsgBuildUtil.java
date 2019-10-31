package cn.speedit.settlement.util;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import cn.speedit.settlement.bean.msg.*;
import cn.speedit.settlement.exception.ConvertEncodedByteIOException;
import cn.speedit.settlement.helper.AccountHelper;
import cn.speedit.settlement.helper.LogHelper;
import org.apache.axis.encoding.Base64;

/**
 * 简介：复翼集中结算报文构建Util
 * 
 * @author 李珂 2017年10月20日 上午9:29:32
 */
public class SettlementMsgBuildUtil {

	public static final SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat FORMAT_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static final String FINANCIAL_VERSION = AccountHelper.getVersion();
	private static final String FINANCIAL_USER_ID = AccountHelper.getUserId();
	private static final String FINANCIAL_ENCODE = AccountHelper.getEncode();
	private static final String MODULE = "assets";

	private static Map<String, Integer> FIELD_LENGTH_MAPPING = new TreeMap<String, Integer>(); // 报文属性名与长度对应关系

	private static final String[] CHARS = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	
	static {
		FIELD_LENGTH_MAPPING.put("fileName", 50);

		FIELD_LENGTH_MAPPING.put("provCode", 10);
		FIELD_LENGTH_MAPPING.put("provName", 100);
		FIELD_LENGTH_MAPPING.put("shortName", 100);
		FIELD_LENGTH_MAPPING.put("taxNo", 20);
		FIELD_LENGTH_MAPPING.put("taxAddr", 100);
		FIELD_LENGTH_MAPPING.put("invoiceName", 100);
		FIELD_LENGTH_MAPPING.put("acnt", 40);
		FIELD_LENGTH_MAPPING.put("accbank", 100);
		FIELD_LENGTH_MAPPING.put("branchcode", 12);
		FIELD_LENGTH_MAPPING.put("contactAddr", 100);
		FIELD_LENGTH_MAPPING.put("contact", 40);
		FIELD_LENGTH_MAPPING.put("tel", 40);
		FIELD_LENGTH_MAPPING.put("mobilephone", 11);
		FIELD_LENGTH_MAPPING.put("email", 40);
		FIELD_LENGTH_MAPPING.put("eInvoice", 1);
		FIELD_LENGTH_MAPPING.put("remark", 400);
		FIELD_LENGTH_MAPPING.put("inputUser", 20);

		FIELD_LENGTH_MAPPING.put("sno", 21);
		FIELD_LENGTH_MAPPING.put("bCode", 8);

		FIELD_LENGTH_MAPPING.put("uniPrjCode", 32);
		FIELD_LENGTH_MAPPING.put("oldUniPrjCode", 32);
		FIELD_LENGTH_MAPPING.put("newUniPrjCode", 32);
		FIELD_LENGTH_MAPPING.put("orderNo", 60);
		FIELD_LENGTH_MAPPING.put("frozenUser", 20);
		FIELD_LENGTH_MAPPING.put("confirmUser", 20);

		FIELD_LENGTH_MAPPING.put("品牌", 200);
		FIELD_LENGTH_MAPPING.put("货号", 200);
		FIELD_LENGTH_MAPPING.put("规格", 200);
		// FIELD_LENGTH_MAPPING.put("数量", 200);
		// FIELD_LENGTH_MAPPING.put("单价", 200);

		FIELD_LENGTH_MAPPING.put("applyUser", 20);

		FIELD_LENGTH_MAPPING.put("invoiceType", 40);
		FIELD_LENGTH_MAPPING.put("invoiceCode", 20);
		FIELD_LENGTH_MAPPING.put("invoiceNo", 20);
	}

	private StringBuilder xmlHeadInfo = new StringBuilder();

	{
		xmlHeadInfo.append(format("<?xml version=\"1.0\" encoding=\"%s\"?>", FINANCIAL_ENCODE));
		xmlHeadInfo.append("<root>");
		xmlHeadInfo.append("	<head>");
		xmlHeadInfo.append(format("		<version>%s</version>",FINANCIAL_VERSION ));
		xmlHeadInfo.append(format("		<user_id>%s</user_id>",FINANCIAL_USER_ID ));
		xmlHeadInfo.append("		<func_id>[:funcId]</func_id>");
		xmlHeadInfo.append("		<seq_id>[:seqId]</seq_id>");
		xmlHeadInfo.append("		<seq_datetime>[:submitTime]</seq_datetime>");
		xmlHeadInfo.append("	</head>");
		xmlHeadInfo.append("	<body>");
		xmlHeadInfo.append("		[:body]");
		xmlHeadInfo.append("	</body>");
		xmlHeadInfo.append("</root>");
	}

	/**
	 * 简介：根据所传入的功能代码（funcId），构建请求头信息
	 * 
	 * @author 李珂 2017年10月20日 上午10:23:51
	 * @param funcId
	 * @return 请求头信息
	 */
	private String getXmlHeadInfo(String funcId) {
		String xmlStr = xmlHeadInfo.toString();

		xmlStr = xmlStr.replace("[:funcId]", funcId);
		xmlStr = xmlStr.replace("[:seqId]", generateShortUuid());
		xmlStr = xmlStr.replace("[:submitTime]", FORMAT_TIME.format(new GregorianCalendar().getTime()));

		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：构建“上传文件”的报文<br>
	 * 详细说明：功能代码1399
	 * 
	 * @author 李珂 2017年10月20日 下午1:41:59
	 * @param files
	 *            包含SettlementFile的List
	 * @return 文件上传的请求报文
	 *
	 * @modified by zoujidi
	 * 		传参类型修改（与框架解耦）
	 */
	public String composeFileUploadMsg(List<SettlementFile> files) {
		String xmlStr = this.getXmlHeadInfo("1399");
		StringBuilder bodyXml = new StringBuilder();

		bodyXml.append("<upload_files>");
		for (SettlementFile file : files) {
			// DocumentResource dr = ResourceManager.getResource(MODULE, fileId);
			// File file = ResourceManager.getFile(dr, false);

			bodyXml.append("		<upload_file>");
			bodyXml.append(format("			<file_name>%s</file_name>",shortenStr(transform(file.getFilename(), ""), getLengthByField("fileName")) ));
			bodyXml.append(format("			<file_str>%s</file_str>",composeToEncodedByteStr(file.getFile()) ));
			bodyXml.append("		</upload_file>");
		}
		bodyXml.append("</upload_files>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 根据字节数组生成文件
	 * @param bytes 字节数组
	 * @param filePath 文件路径
	 * @param fileName 文件名称
	 * @author Zoujidi
	 * @date 2019/9/21 11:00
	 */
	public static void byte2file(byte[] bytes, String filePath, String fileName){
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;

		try {
			File dir = new File(filePath);
			if (!dir.exists() && !dir.isDirectory()){
				dir.mkdirs();
			}
			file = new File(filePath+fileName);

			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bytes);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null){
					bos.close();
				}
				if(fos != null){
					fos.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 简介：构建“下载文件”的报文<br>
	 * 详细说明：功能代码1398
	 *
	 * @author 邹及第 2019年9月20日 上午9:35:59
	 * @param fileCode
	 *            文件统一码（对应上传文件返回的统一码）
	 * @return 文件下载的返回报文
	 */
	public String composeFileDownloadMsg(String fileCode){
		String xmlStr = this.getXmlHeadInfo("1398");
		StringBuilder bodyXml = new StringBuilder();

		bodyXml.append(format("<file_code>%s</file_code>", fileCode));

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());

		LogHelper.record(xmlStr);
		return xmlStr;
	}


	/**
	 * 简介：构建“供应商注册”的报文<br>
	 * 详细说明：功能代码1301
	 * 
	 * @author 李珂 2017年10月20日 下午5:22:59
	 * @param prov
	 *            供应商信息Bean
	 * @return 供应商注册的请求报文
	 */
	public String composeProvRegMsg(SettlementProvider prov) {
		String xmlStr = this.getXmlHeadInfo("1301");
		StringBuilder bodyXml = new StringBuilder();

		Set<String> ingoreFields = new HashSet<String>();
		ingoreFields.add("provCode");

		bodyXml.append("<js_provider>");
		bodyXml.append(reflectToXmlElements(prov, ingoreFields));
		bodyXml.append("</js_provider>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：构建“供应商更新”的报文<br>
	 * 详细说明：功能代码1302
	 * 
	 * @author 李珂 2017年10月21日 上午11:21:01
	 * @param prov
	 *            供应商信息Bean
	 * @return 供应商更新的请求报文
	 */
	public String composeProvUpdMsg(SettlementProvider prov) {
		String xmlStr = this.getXmlHeadInfo("1302");
		StringBuilder bodyXml = new StringBuilder();

		Set<String> ingoreFields = new HashSet<String>();

		bodyXml.append("<js_provider>");
		bodyXml.append(reflectToXmlElements(prov, ingoreFields));
		bodyXml.append("</js_provider>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：构建“生成订单，冻结项目额度”的报文<br>
	 * 详细说明：功能代码1321
	 * 
	 * @author 李珂 2017年10月21日 下午2:59:15
	 * @param orderGenList
	 *            包含生成订单Bean的List
	 * @return 生成订单，冻结项目额度的请求报文
	 */
	public String composeOrderGenMsg(List<SettlementOrderGen> orderGenList) {
		String xmlStr = this.getXmlHeadInfo("1321");
		StringBuilder bodyXml = new StringBuilder();

		Set<String> ingoreFields = new HashSet<String>();
		bodyXml.append("<orders>");
		for (SettlementOrderGen orderGen : orderGenList) {
			bodyXml.append("<order>");
			bodyXml.append(reflectToXmlElements(orderGen, ingoreFields));
			bodyXml.append("</order>");
		}
		bodyXml.append("</orders>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：构建“取消订单，释放冻结金额”的报文<br>
	 * 详细说明：功能代码1322
	 * 
	 * @author 李珂 2017年10月21日 下午3:24:08
	 * @param orderCancelList
	 *            包含取消订单Bean的List
	 * @return 取消订单，释放冻结金额的请求报文
	 */
	public String composeOrderCancelMsg(List<SettlementOrderCancel> orderCancelList) {
		String xmlStr = this.getXmlHeadInfo("1322");
		StringBuilder bodyXml = new StringBuilder();

		Set<String> ingoreFields = new HashSet<String>();
		bodyXml.append("<orders>");
		for (SettlementOrderCancel orderCancel : orderCancelList) {
			bodyXml.append("<order>");
			bodyXml.append(reflectToXmlElements(orderCancel, ingoreFields));
			bodyXml.append("</order>");
		}
		bodyXml.append("</orders>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：构建“更换项目”的报文<br>
	 * 详细说明：功能代码1323
	 * 
	 * @author 李珂 2017年10月21日 下午4:01:07
	 * @param prjChangeList
	 *            包含更换项目Bean的List
	 * @return 更换项目的请求报文
	 */
	public String composePrjChangeMsg(List<SettlementPrjChange> prjChangeList) {
		String xmlStr = this.getXmlHeadInfo("1323");
		StringBuilder bodyXml = new StringBuilder();

		Set<String> ingoreFields = new HashSet<String>();
		bodyXml.append("<orders>");
		for (SettlementPrjChange prjChange : prjChangeList) {
			bodyXml.append("<order>");
			bodyXml.append(reflectToXmlElements(prjChange, ingoreFields));
			bodyXml.append("</order>");
		}
		bodyXml.append("</orders>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：构建“取消结算申请”的报文<br>
	 * 详细说明：功能代码1342
	 * 
	 * @author 李珂 2017年10月21日 下午4:07:20
	 * @param provCode
	 *            供应商编码
	 * @param applyNo
	 *            结算申请号
	 * @return 取消结算申请的请求报文
	 */
	public String composeApplyCancelMsg(String provCode, int applyNo) {
		String xmlStr = this.getXmlHeadInfo("1342");
		StringBuilder bodyXml = new StringBuilder();

		bodyXml.append("<apply>");
		bodyXml.append(format("		<prov_code>%s</prov_code>",shortenStr(transform(provCode, ""), getLengthByField("provCode")) ));
		bodyXml.append(format("		<apply_no>%s</apply_no>",applyNo ));
		bodyXml.append("</apply>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：构建“收货确认”的报文<br>
	 * 详细说明：功能代码1331
	 * 
	 * @author 李珂 2017年10月21日 下午4:54:45
	 * @param orderReceiveVoList
	 *            包含确认收货BeanVo的List<br>
	 *            orderReceiceVo
	 *            <ul>
	 *            <li>PaymentOrderReceive</li>
	 *            <li>List&lt;PaymentOrderReceiveDetail&gt;
	 *            orderReceiveDetailList</li>
	 *            </ul>
	 * @return 收货确认的请求报文
	 */
	public String composeOrderReceiveMsg(List<SettlementOrderReceiveJo> orderReceiveVoList) {
		String xmlStr = this.getXmlHeadInfo("1331");
		StringBuilder bodyXml = new StringBuilder();

		bodyXml.append("<orders>");
		for (SettlementOrderReceiveJo paymentOrderReceiveVo : orderReceiveVoList) {
			bodyXml.append("<order>");
			/* 构建外层xml */
			Set<String> ingoreFields = new HashSet<String>();
			bodyXml.append(reflectToXmlElements(paymentOrderReceiveVo.getOrderReceive(), ingoreFields));
			/* 构建内层xml */
			bodyXml.append("		<order_dtls>");
			for (SettlementOrderReceiveDetail orderReceiveDetail : paymentOrderReceiveVo.getOrderReceiveDetailList()) {
				bodyXml.append("		<order_dtl>");
				bodyXml.append(format("			<品牌>%s</品牌>",shortenStr(transform(orderReceiveDetail.getBrand(), ""), getLengthByField("品牌")) ));
				bodyXml.append(format("			<货号>%s</货号>",shortenStr(transform(orderReceiveDetail.getItemNo(), ""), getLengthByField("货号")) ));
				bodyXml.append(format("			<规格>%s</规格>",shortenStr(transform(orderReceiveDetail.getSpec(), ""), getLengthByField("规格")) ));
				bodyXml.append(format("			<数量>%s</数量>",orderReceiveDetail.getNum() ));
				bodyXml.append(format("			<单价>%s</单价>",orderReceiveDetail.getPrice().toPlainString() ));
				bodyXml.append("		</order_dtl>");
			}
			bodyXml.append("		</order_dtls>");
			bodyXml.append("</order>");
		}
		bodyXml.append("</orders>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：构建“申请结算”的报文<br>
	 * 详细说明：功能代码1341
	 * 
	 * @author 李珂 2017年10月21日 下午5:24:04
	 * @param applyJo
	 *            申请结算的BeanJo<br>
	 *            applyJo
	 *            <ul>
	 *            <li>List&lt;String&gt; orderNoList</li>
	 *            <li>List&lt;PaymentInvoice&gt; invoiceList</li>
	 *            </ul>
	 * @return 申请结算的请求报文
	 */
	public String composeApplyMsg(SettlementApplyJo applyJo) {
		String xmlStr = this.getXmlHeadInfo("1341");
		StringBuilder bodyXml = new StringBuilder();

		bodyXml.append("<apply>");
		/* 构建外层xml */
		Set<String> ingoreFields = new HashSet<String>();
		ingoreFields.add("orderNoList");
		ingoreFields.add("invoiceList");
		bodyXml.append(reflectToXmlElements(applyJo, ingoreFields));
		/* 构建内层xml-订单号列表 */
		bodyXml.append("		<orders>");
		for (String order_no : applyJo.getOrderNoList()) {
			bodyXml.append("			<order>");
			bodyXml.append(format("				<order_no>%s</order_no>",shortenStr(transform(order_no, ""), getLengthByField("orderNo")) ));
			bodyXml.append("			</order>");
		}
		bodyXml.append("		</orders>");
		/* 构建内层xml-发票列表 */
		bodyXml.append("		<invoices>");
		for (SettlementInvoice invoice : applyJo.getInvoiceList()) {
			bodyXml.append("			<invoice>");
			bodyXml.append(reflectToXmlElements(invoice, new HashSet<String>()));
			bodyXml.append("			</invoice>");
		}
		bodyXml.append("		</invoices>");
		bodyXml.append("</apply>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：构建“查询结算进度”的报文<br>
	 * 详细说明：功能代码1343
	 * 
	 * @author 李珂 2017年10月21日 下午4:13:13
	 * @param provCode
	 *            供应商编码
	 * @param applyNo
	 *            结算申请号
	 * @return 查询结算进度的请求报文
	 */
	public String fetchApplyProgress(String provCode, int applyNo) {
		String xmlStr = this.getXmlHeadInfo("1343");
		StringBuilder bodyXml = new StringBuilder();

		bodyXml.append("<apply>");
		bodyXml.append(format("		<prov_code>%s</prov_code>",shortenStr(transform(provCode, ""), getLengthByField("provCode")) ));
		bodyXml.append(format("		<apply_no>%s</apply_no>",applyNo ));
		bodyXml.append("</apply>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：构建“根据工号获取项目列表”的请求报文<br>
	 * 详细说明：功能代码1311
	 * 
	 * @author 李珂 2017年10月21日 上午11:45:38
	 * @param sno
	 *            工号
	 * @param bcode
	 *            费用项代码
	 * @return 根据工号获取项目列表的请求报文
	 */
	public String fetchPrjRecsBySno(String sno, String bcode) {
		String xmlStr = this.getXmlHeadInfo("1311");
		StringBuilder bodyXml = new StringBuilder();

		bodyXml.append("<other_info>");
		bodyXml.append(format("		<sno>%s</sno>",shortenStr(transform(sno, ""), getLengthByField("sno")) ));
		bodyXml.append(format("		<b_code>%s</b_code>",shortenStr(transform(bcode, ""), getLengthByField("bCode")) ));
		bodyXml.append("</other_info>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：构建“根据项目代码获取项目信息”的请求报文<br>
	 * 详细说明：功能代码1312
	 * 
	 * @author 李珂 2017年10月21日 下午12:14:17
	 * @param uniPrjCode
	 *            项目代码
	 * @param bcode
	 *            费用项代码
	 * @return 根据项目代码获取项目信息的请求报文
	 */
	public String fetchPrjRecByPrjCode(String uniPrjCode, String bcode) {
		String xmlStr = this.getXmlHeadInfo("1312");
		StringBuilder bodyXml = new StringBuilder();

		bodyXml.append("<other_info>");
		bodyXml.append(format("		<uni_prj_code>%s</uni_prj_code>",shortenStr(transform(uniPrjCode, ""), getLengthByField("uniPrjCode")) ));
		bodyXml.append(format("		<b_code>%s</b_code>",shortenStr(transform(bcode, ""), getLengthByField("bCode")) ));
		bodyXml.append("</other_info>");

		xmlStr = xmlStr.replace("[:body]", bodyXml.toString());
		LogHelper.record(xmlStr);
		return xmlStr;
	}

	/**
	 * 简介：替换特殊字符，处理空和"null"<br>
	 * 详细说明：处理<、>、&
	 * 
	 * @author 李珂 2017年10月20日 下午5:15:40
	 * @param str
	 * @param defaultStr
	 *            所传str为null时的默认字符串
	 * @return 替换后的字符串
	 */
	private static String transform(String str, String defaultStr) {
		return (CommonUtil.isNe(str) || str == "null") ? defaultStr : str.replace("&", "﹠").replace("<", "＜").replace(">", "＞");
	}

	/**
	 * 简介：按所给对象，反射成xml<br>
	 * 详细说明：如果属性是字符串，还做了特殊字符过滤、属性长度截取
	 * 
	 * @author 李珂 2017年10月20日 下午4:10:03
	 * @param target
	 *            目标对象
	 * @param ingoreFields
	 *            忽略域（驼峰命名）
	 * @return xml字符串
	 */
	private static <T extends Object> String reflectToXmlElements(T target, Set<String> ingoreFields) {
		StringBuilder xmlDetail = new StringBuilder();

		Class<?> classType = target.getClass();
		Field[] classTypeFileldArr = classType.getDeclaredFields();

		for (int i = 0; i < classTypeFileldArr.length; i++) {
			String fieldName = classTypeFileldArr[i].getName(), underscoreName = camelToUnderscore(fieldName);

			if (fieldName.startsWith("serialVersionUID") || fieldName.startsWith("FIELD_") || (fieldName.toUpperCase()).indexOf("ID") != -1)
				continue;

			if (ingoreFields.contains(fieldName))
				continue;

			/* 构造get方法名 */
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			Method getMethod = null;
			try {
				xmlDetail.append(format("<%s>",underscoreName ));
				getMethod = classType.getMethod(getMethodName);
				Object val = getMethod.invoke(target);
				if (val instanceof BigDecimal) {
					xmlDetail.append(((BigDecimal) val).toPlainString());
				} else if (val instanceof Date) {
					xmlDetail.append(FORMAT_DATE.format((Date) val));
				} else {
					xmlDetail.append(shortenStr(transform(String.valueOf(val), ""), getLengthByField(fieldName)));
				}
				xmlDetail.append(format("</%s>",underscoreName ));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LogHelper.record(xmlDetail.toString());
		return xmlDetail.toString();
	}

	/**
	 * 简介：将驼峰命名转换成下划线命名
	 * 
	 * @author 李珂 2017年10月20日 下午4:00:42
	 * @param name
	 *            驼峰命名的字符串，如“shortName”
	 * @return 转换成下划线后的命名，如“short_name”
	 */
	private static String camelToUnderscore(String name) {
		if (name == null)
			return "";

		StringBuilder result = new StringBuilder();
		result.append(name.substring(0, 1).toLowerCase());
		for (int i = 1; i < name.length(); i++) {
			String s = name.substring(i, i + 1);
			if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
				result.append("_");
			}
			result.append(s.toLowerCase());
		}
		return result.toString();
	}

	/**
	 * 简介：构建特定长度的字符串
	 * 
	 * @author 李珂 2017年10月20日 上午10:55:45
	 * @param str
	 *            原字符串
	 * @param length
	 *            <ul>
	 *            <li>限定长度</li>
	 *            <li>null, 如果没有限定长度</li>
	 *            </ul>
	 * @return
	 * 		<ul>
	 *         <li>截取后的字符串</li>
	 *         <li>当length为null的时候，返回原字符串</li>
	 *         </ul>
	 */
	private static String shortenStr(String str, Integer length) {
		if (length == null)
			return str;
		return (str.length() > length) ? str.substring(0, length) : str;
	}

	/**
	 * 简介：将文件读取成字节数组，并按Base64编码
	 * 
	 * @author 李珂 2017年10月20日 上午11:08:01
	 * @param file
	 * @return 编码后的文件字符串
	 */
	private static String composeToEncodedByteStr(File file) {
		InputStream in = null;
		int length = Long.valueOf(file.length()).intValue();
		byte[] byteArr = new byte[length];

		// 构建当所前遍历文件的字节数组 
		int offset = 0, read = 0, rest = length, toRead = length > 512 ? 512 : length;
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			while (rest > 0 && (read = in.read(byteArr, offset, toRead)) != -1) {
				offset += read;
				rest = length - offset;
				toRead = rest > 512 ? 512 : rest;
				LogHelper.record("offset:" + offset + "; read:" + read + "; rest:" + rest + "; toRead:" + toRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new ConvertEncodedByteIOException("读文件IO异常！");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new ConvertEncodedByteIOException("关闭流IO异常！");
			}
		}
		return Base64.encode(byteArr);
	}

	/**
	 * 简介：根据属性名获取字段最大长度
	 * 
	 * @author 李珂 2017年10月23日 上午9:25:16
	 * @param fieldName
	 *            驼峰命名的属性名
	 * @return
	 * 		<ul>
	 *         <li>属性名最大长度</li>
	 *         <li>null, 如果没有指定长度</li>
	 *         </ul>
	 */
	private static Integer getLengthByField(String fieldName) {
		if (!FIELD_LENGTH_MAPPING.containsKey(fieldName))
			return null;
		return FIELD_LENGTH_MAPPING.get(fieldName);
	}
	
	/**
     * 简介：生成8位无重复字符串
     *
     * @return
     */
    public static final String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(CHARS[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

	public static String format(String str, Object... parmas) {
		if (parmas == null || parmas.length == 0) {
			return str;
		} else {
			return String.format(str, parmas);
		}
	}

}
