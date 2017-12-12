package com.code.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
 

/**
 * 可逆的加解密算法
 * @author 400
 *
 */
public class Encryp {
	public static final String desKey = "_,Xjv^D8" ;


	/**
	 * 加密
	 * @param key 密药
	 * @param message 要加密的内容
	 * @return
	 * @throws Exception
	 */
	public static String add(String key,String message ) throws Exception{
		try {
			key = key.substring(0, 8) ;
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
			return toHexString(cipher.doFinal(message.getBytes("UTF-8"))).toUpperCase();
		} catch (Exception e) {
			throw new Exception("DES加密出错", e) ;
		}
	}

	/**
	 * 解密
	 * @param key 密药
	 * @param message 要加密的内容
	 * @return
	 * @throws Exception
	 */
	public  static String jie(String key,String message) throws Exception {
		try {
			key = key.substring(0, 8) ;
			message = urlDecode(message, "utf-8");
			byte[] src = fromHexString(message);
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
			cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
			byte[] retByte = cipher.doFinal(src);
			return new String(retByte);
		} catch (Exception e) {
			throw new Exception("DES解密出错", e) ;
		}
	}

 
 

	private  static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	private  static String toHexString(byte[] buf) {
		return toHexString(buf, null, Integer.MAX_VALUE);
	}

	private static String toHexString(byte[] buf, String sep, int lineLen) {
		if (buf == null)
			return null;
		if (lineLen <= 0)
			lineLen = Integer.MAX_VALUE;
		StringBuilder res = new StringBuilder(buf.length * 2);
		for (int i = 0; i < buf.length; i++) {
			int b = buf[i];
			res.append(HEX_DIGITS[(b >> 4) & 0xf]);
			res.append(HEX_DIGITS[b & 0xf]);
			if (i > 0 && (i % lineLen) == 0)
				res.append('\n');
			else if (sep != null && i < lineLen - 1)
				res.append(sep);
		}
		return res.toString();
	}

	private static final int charToNibble(char c) {
		if (c >= '0' && c <= '9') {
			return c - '0';
		} else if (c >= 'a' && c <= 'f') {
			return 0xa + (c - 'a');
		} else if (c >= 'A' && c <= 'F') {
			return 0xA + (c - 'A');
		} else {
			return -1;
		}
	}

	private static byte[] fromHexString(String text) {
		text = text.trim();
		if (text.length() % 2 != 0)
			text = "0" + text;
		int resLen = text.length() / 2;
		int loNibble, hiNibble;
		byte[] res = new byte[resLen];
		for (int i = 0; i < resLen; i++) {
			int j = i << 1;
			hiNibble = charToNibble(text.charAt(j));
			loNibble = charToNibble(text.charAt(j + 1));
			if (loNibble == -1 || hiNibble == -1)
				return null;
			res[i] = (byte) (hiNibble << 4 | loNibble);
		}
		return res;
	}

	
	private  static String urlDecode(String content, String charset) {
		try {
			if (content != null) {
				return URLDecoder.decode(content, charset);
			} else {
				return "";
			}
		} catch (UnsupportedEncodingException ex) {
			return content;
		}
	}

	public static void main(String[] args) throws Exception {
 
		System.out.println(add(desKey,"hzj.400@qq.com")); 
		System.out.println(jie(desKey,add(desKey,"hzj.400@qq.com"))); 
	}
 

}
