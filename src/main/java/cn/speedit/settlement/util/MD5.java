package cn.speedit.settlement.util;

import java.security.MessageDigest;

public class MD5 {
	/**
	 * 
	 */
	private String salt = "";
	private static final String key;
	private static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	static {
		key = "aa";
	}
	public final static String md5(String s, String salt) {
		try {
			s = s + salt;// 为了漏洞扫描！！！
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	public final static String md5(String s) {
		return md5(s, new MD5().getSalt());
	}
	public final static String md5UTF8(String s) {
		try {
			byte[] strTemp = s.getBytes("UTF-8");
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public final static String md5() {
		return md5(key);
	}
	/**
	 * @param salt
	 *            the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * TODO 简介 . TODO 详细说明 .
	 * 
	 * @return 刘永杰2018年10月24日下午4:52:38
	 */
	public String getSalt() {
		return this.salt;
	}
}
