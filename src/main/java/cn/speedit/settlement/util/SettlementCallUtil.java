package cn.speedit.settlement.util;

import java.io.IOException;
import java.io.StringReader;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import cn.speedit.settlement.bean.Record;
import cn.speedit.settlement.bean.rtn.QueryPrjRecsesRtn;
import cn.speedit.settlement.bean.rtn.QueryPrjRtn;
import cn.speedit.settlement.helper.AccountHelper;
import cn.speedit.settlement.helper.LogHelper;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.wingsoft.wws.webservice.v20180508.WingsoftWebServiceStub;


/**
 * 简介：复翼集中结算调用及解析Util
 * 
 * @author 李珂 2017年10月23日 上午10:26:58
 */
public class SettlementCallUtil {

	private static final String ENCODE = AccountHelper.getEncode();
	private static final String USERKEY = AccountHelper.getUserKey();
	private static final String URL = AccountHelper.getUrl();

	/**
	 * 测试方法
	 * @param content
	 * @return
	 */
  public static String sayHello(String content){
      WingsoftWebServiceStub stub = getWebServiceInstance(null);
      WingsoftWebServiceStub.SayHello sayHello = new WingsoftWebServiceStub.SayHello();
      sayHello.setName(content);
      WingsoftWebServiceStub.SayHelloResponse sayHelloResponse = null;
      try {
          sayHelloResponse = stub.sayHello(sayHello);
      } catch (AxisFault e) {
          e.printStackTrace();
      } catch (RemoteException e) {
          e.printStackTrace();
      }
      return sayHelloResponse.get_return();
  }
	
	/**
	 * 获取实例
	 */
	public static WingsoftWebServiceStub getWebServiceInstance(String financeUrl) {
		WingsoftWebServiceStub stub = null;
		financeUrl = financeUrl == null ? URL : financeUrl;
		try {
			stub = new WingsoftWebServiceStub(financeUrl);
			Options options = stub._getServiceClient().getOptions();
			options.setTimeOutInMilliSeconds(300 * 1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stub;
	}
	
	/**
	 * 简介 天翼提供MD5加密函数
	 * 
	 * @param source
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @author Liaogm 2016年5月11日下午4:29:34
	 */
	public static String getMD5(byte[] source) throws NoSuchAlgorithmException {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(source);
		byte tmp[] = digest.digest();
		char dest[] = new char[16 * 2];
		int k = 0;
		for (int i = 0; i < 16; i++) {
			byte byte0 = tmp[i];
			dest[k++] = hexDigits[byte0 >>> 4 & 0xf];
			dest[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(dest);
	}
	
	/**
	 * TODO 简介：提交接口申请
	 * 
	 * @author 李珂 2017年10月24日 下午1:03:27
	 * @param xmlData
	 *            由CentralizedPaymentMsgBuildUtil构建的请求报文
	 * @return 接口返回的原始报文
	 */
	public static String submit(String xmlData) {
		WingsoftWebServiceStub stub;
		String result = null;
		
		String userkey = USERKEY;
		String encode = ENCODE;
		
		try {
			stub = getWebServiceInstance(null);
			WingsoftWebServiceStub.Submit submit = new WingsoftWebServiceStub.Submit();
			xmlData = xmlData.trim();
			String sign = xmlData + userkey;
			// sign = getMD5(sign.getBytes(encode));
			sign = MD5.md5(sign);
			submit.setSign(sign);
			submit.setXmlData(xmlData);
			WingsoftWebServiceStub.SubmitResponse submitResponse = stub.submit(submit);
			result = submitResponse.get_return();
		} catch (Exception e) {
			if(result == null){
				return result;
			}
			e.printStackTrace();

		}
		return result;
		
//		StringBuilder testXml = new StringBuilder();
//		testXml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
//		testXml.append("<return>ok</return>");
//		testXml.append("<return><prov_code>0001p</prov_code></return>");
//		testXml.append("<error><msg>1-msg</msg><type>1</type></error>");
//		return testXml.toString();
	}

	/**
	 * 简介：解析返回XML
	 * 
	 * @author 李珂 2017年10月23日 下午1:42:55
	 * @param xml
	 * @param multiElement
	 *            是否是列表XML
	 *            <ul>
	 *            <li>true：返回xml元素为列表</li>
	 *            <li>false：返回xml元素为单一对象</li>
	 *            </ul>
	 * @return List&lt;Record&gt; 任何情况，均返回由record组成的List
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static List<Record> parseReturnXml(String xml, boolean multiElement) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		db = dbf.newDocumentBuilder();

		StringReader sr = new StringReader(xml);
		InputSource is = new InputSource(sr);
		Document doc = null;
		doc = db.parse(is);

		Element root = doc.getDocumentElement(); // 根元素

		List<Record> rtn = new ArrayList<Record>();
		if (xml.indexOf("error") != -1) {
			/* 解析提交失败的返回报文 */
			Record record = new Record();
			record.put("result", "failure"); // 标识为失败
			parseElement(root, record);
			rtn.add(record);
		} else {
			/* 解析提交成功的返回报文 */
			if (multiElement) {
				Set<String> nodeNameSet = getListElementName(root);
				for (String nodeName : nodeNameSet) {
					NodeList nodeList = root.getElementsByTagName(nodeName);
					int loopTime = nodeList.getLength();
					for (int i = 0; i < loopTime; i++) {
						Record record = new Record();
						parseElement((Element) nodeList.item(i), record);
						rtn.add(record);
					}
				}
			} else {
				Record record = new Record();
				parseElement(root, record);
				rtn.add(record);
			}
		}

		/* print log */
		for (Record record : rtn) {
			LogHelper.record(record);
		}
		return rtn;
	}

	/**
	 * 简介：解析返回（以bean对象返回）
	 *
	 * @author 邹及第 2019年9月26日 上午9:21:22
	 * @param xml
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static List<Record> parseReturnXml(String xml, Class clazz) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		db = dbf.newDocumentBuilder();

		StringReader sr = new StringReader(xml);
		InputSource is = new InputSource(sr);
		Document doc = null;
		doc = db.parse(is);

		Element root = doc.getDocumentElement(); // 根元素

		List<Record> rtn = new ArrayList<Record>();
		if (xml.indexOf("error") != -1) {
			/* 解析提交失败的返回报文 */
			Record record = new Record();
			record.put("result", "failure"); // 标识为失败
			parseElement(root, record);
			rtn.add(record);
		} else {
			/* 解析提交成功的返回报文 */
			Record record = new Record();
			record.put("result", XmlParseUtil.xml2Bean(xml, clazz));
			rtn.add(record);
		}

		/* print log */
		for (Record record : rtn) {
			LogHelper.record(record);
		}
		return rtn;
	}

	/**
	 * 简介：获得List元素节点名<br>
	 *
	 * @author 李珂 2017年10月24日 上午9:26:23
	 * @param root
	 * @return HashSet&lt;String&gt; 元素节点名
	 */
	private static HashSet<String> getListElementName(Element root) {
		HashSet<String> rtn = new HashSet<String>();
		HashSet<String> nodeNameSet = new HashSet<String>();
		getAllElementsName(root, nodeNameSet); // 获取所有子元素名

		if (nodeNameSet.isEmpty())
			return null;

		for (String nodeName : nodeNameSet) {
			/* 有多个同名元素，并且这些元素有子元素 */
			if (root.getElementsByTagName(nodeName).getLength() > 1) {
				NodeList list = root.getElementsByTagName(nodeName);
				for (int j = 0; j < list.getLength(); j++) {
					Element currElement = (Element) list.item(j);
					if (hasChildElements(currElement)) {
						rtn.add(currElement.getNodeName());
					}
				}
			}
		}
		return rtn;
	}

	/**
	 * 简介：判断一个元素是否有子元素
	 * 
	 * @author 李珂 2017年10月24日 上午9:13:48
	 * @param root
	 * @return true：有子元素；false：没有子元素
	 */
	private static boolean hasChildElements(Element root) {
		if (root.hasChildNodes()) {
			NodeList childs = root.getChildNodes();
			for (int i = 0; i < childs.getLength(); i++) {
				if (childs.item(i).getNodeType() == Node.ELEMENT_NODE) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 简介：获得给定元素的所有子元素名
	 * 
	 * @author 李珂 2017年10月24日 上午9:02:46
	 * @param root
	 * @param nodeNameSet
	 *            子元素组成的Set
	 */
	private static void getAllElementsName(Element root, HashSet<String> nodeNameSet) {
		NodeList children = root.getChildNodes();

		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				nodeNameSet.add(node.getNodeName());
				getAllElementsName((Element) node, nodeNameSet);
			}
		}
	}

	/**
	 * 简介：解析具体的XML元素
	 * 
	 * @author 李珂 2017年10月23日 下午2:02:37
	 * @param element
	 *            XML元素
	 * @param record
	 *            返回Record对象
	 */
	private static void parseElement(Element element, Record record) {
		String nodeName = element.getNodeName();
		NodeList children = element.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			short nodeType = node.getNodeType();
			if (nodeType == Node.ELEMENT_NODE) {
				parseElement((Element) node, record);
			} else if (nodeType == Node.TEXT_NODE) {
				/* 递归出口 */
				String val = node.getNodeValue().trim();
				if (!val.isEmpty()) {
					record.put(nodeName, node.getNodeValue());
				}
			}
		}
	}

}
