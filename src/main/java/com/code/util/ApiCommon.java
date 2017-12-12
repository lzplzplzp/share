package com.code.util;

import java.math.BigInteger;
import java.security.MessageDigest;
 

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class ApiCommon {
	/**
	 * 重要key,不能修改
	 */
	public static final String CODE_KEY = "fuer";	
  
 
	private static String md5(String str) {
		MessageDigest md;
		try {
			// 鐢熸垚涓�釜MD5鍔犲瘑璁＄畻鎽樿
			md = MessageDigest.getInstance("MD5");
			// 璁＄畻md5鍑芥暟
			md.update(str.getBytes());
			// digest()鏈�悗纭畾杩斿洖md5 hash鍊硷紝杩斿洖鍊间负8涓哄瓧绗︿覆銆傚洜涓簃d5
			// hash鍊兼槸16浣嶇殑hex鍊硷紝瀹為檯涓婂氨鏄�浣嶇殑瀛楃
			// BigInteger鍑芥暟鍒欏皢8浣嶇殑瀛楃涓茶浆鎹㈡垚16浣峢ex鍊硷紝鐢ㄥ瓧绗︿覆鏉ヨ〃绀猴紱寰楀埌瀛楃涓插舰寮忕殑hash鍊�
			String retStr = new BigInteger(1, md.digest()).toString(16);
			return retStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
 
	private static String base64Encode(String s) {
		if (s == null)
			return null;
		return (new BASE64Encoder()).encode(s.getBytes())
				.replaceAll("\r\n", "").replaceAll("\n", "");
	}

 
	private static String base64Encode(byte[] s) {
		if (s == null)
			return null;
		return (new BASE64Encoder()).encode(s);
	}
 
	
	private static String base64Decode(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}
	
 
 
	/**
	 * 加密
	 * @param oldStr
	 * @param sideWord 用户id
	 * @return
	 */
	public static String encodeStr(String oldStr, String sideWord){
		oldStr = "{"+oldStr+"}";
		StringBuffer str = new StringBuffer();
		String key = ApiCommon.md5(CODE_KEY + sideWord);
		int keyLen = key.length();
		int strLen = oldStr.length();
		for(int i = 0; i < strLen; i++) {
			int k = i % keyLen;
			str.append((char)(oldStr.charAt(i) ^ key.charAt(k)));
		}
		return ApiCommon.base64Encode(str.toString());
	}
	
  
	/**
	 * 解密
	 * @param oldStr 解密后的字符串
	 * @param sideWord 用户id
	 * @return
	 */
	public static String decodeStr(String oldStr, String sideWord) {

		oldStr = ApiCommon.base64Decode(oldStr);
		StringBuffer str = new StringBuffer();
		String key = ApiCommon.md5(CODE_KEY + sideWord);
		int keyLen = key.length();
		int strLen = oldStr.length();
		for (int i = 0; i < strLen; i++) {
			int k = i % keyLen;
			str.append((char) (oldStr.charAt(i) ^ key.charAt(k)));
		}
		String retStr = str.toString();
		return retStr.substring(1, strLen - 1);

	}
	
	
 
	
	
	
}
