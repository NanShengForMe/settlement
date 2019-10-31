package cn.speedit.settlement.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cn.speedit.settlement.bean.Record;
import cn.speedit.settlement.exception.ValidatorRequiredException;

/**
 * 简介：集中结算Util
 * 
 * @author 李珂 2017年10月24日 下午2:35:14
 */
public class SettlementUtil {
	/* Key，用于身份校验 */
	private static final String KEY = "s1Na66nxingyi@).ShizaI#$biDe";
	private static final SimpleDateFormat FORMAT_MM = new SimpleDateFormat("MM");
	/* 必填字段对应关系 */
	private static Map<String, String[]> requiredFieldsMapping = new HashMap<String, String[]>();

	static {
		requiredFieldsMapping.put("provReg", new String[] { "provName", "acnt", "accbank", "branchcode", "eInvoice", "inputUser" }); // 供应商注册
		requiredFieldsMapping.put("provUpd", new String[] { "provCode", "provName", "acnt", "accbank", "branchcode", "eInvoice", "inputUser" }); // 供应商更新
	}

	/**
	 * 简介：比较两个对象指定域的差异
	 * 
	 * @author 李珂 2017年10月26日 下午2:29:36
	 * @param source
	 * @param target
	 * @param fields
	 *            指定域
	 * @return 差异域组成的Set
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T, K extends Object> Set<String> compareDiffFields(T source, K target, Set<String> fields)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Set<String> diffFields = new HashSet<String>();
		Class<?> classTypeT = source.getClass(), classTypeK = target.getClass();
		for (String fieldName : fields) {
			/* 构造get方法名 */
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

			String sourceVal = String.valueOf(classTypeT.getMethod(getMethodName).invoke(source)).trim();
			String targetVal = String.valueOf(classTypeK.getMethod(getMethodName).invoke(target)).trim();

			if (!sourceVal.equals(targetVal)) {
				diffFields.add(fieldName);
			}
		}
		return diffFields;
	}

	/**
	 * 简介：验证对象必填字段
	 * 
	 * @author 李珂 2017年10月24日 下午2:58:14
	 * @param key
	 *            requiredFieldsMapping中的key，决定具体验证的必填字段
	 * @param target
	 *            被验证对象
	 * @return true：验证通过；false：验证不通过
	 */
	public static <T extends Object> Boolean validateData(String key, T target) {
		Boolean validatePass = false;
		String[] requiredFields = requiredFieldsMapping.get(key);

		if (CommonUtil.isNe(requiredFields))
			throw new ValidatorRequiredException("不存在对应关系！");
		if (target == null)
			throw new ValidatorRequiredException("待验证对象为空！");

		Class<?> classType = target.getClass();
		Field[] targetFieldArr = classType.getDeclaredFields();

		for (int i = 0; i < targetFieldArr.length; i++) {
			Boolean currFieldNull = false;
			String fieldName = targetFieldArr[i].getName();
			for (String requiredField : requiredFields) {
				/* 当前属性属于必填字段 */
				if (requiredField.equals(fieldName)) {
					/* 构造get方法名 */
					String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					try {
						Method getMethod = classType.getMethod(getMethodName);
						Object val = getMethod.invoke(target);
						if (CommonUtil.isNe(val)) {
							currFieldNull = true;
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new ValidatorRequiredException(e.getMessage());
					}
				}
			}
			if (currFieldNull) {
				validatePass = false;
				break;
			} else {
				validatePass = true;
			}
		}
		return validatePass;
	}


	/**
	 * 简介：组织报文错误信息
	 * 
	 * @author 李珂 2017年10月26日 上午11:19:22
	 * @param rtn
	 * @return
	 */
	public static String composeRrrorMsg(Record rtn) {
		return "接口调用错误：" + rtn.get("type") + " - " + rtn.get("msg");
	}

	/**
	 * 简介：生成汇总编号<br>
	 * 详细说明：YYYYMM + 4位流水号
	 * 
	 * @param currentMaxNo
	 *            当前最大编号
	 * @param year 当前年份
	 * @author 李珂 2017年10月27日 上午9:49:15
	 * @return 生成的汇总编号
	 */
	public static String genSettlementCode(String currentMaxNo, Integer year) {
		String theNo = null;
		String prefix = String.valueOf(year) + FORMAT_MM.format(new GregorianCalendar().getTime());
		if ("".equals(currentMaxNo) || currentMaxNo == null) {
			theNo = prefix + "0001";
		} else {
			String subStr = currentMaxNo.substring(6);
			int val = Integer.valueOf(subStr) + 10001;
			theNo = prefix + String.valueOf(val).substring(1);
		}
		return theNo;
	}

}
