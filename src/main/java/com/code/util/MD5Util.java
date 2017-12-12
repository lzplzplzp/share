/**
 * 
 */
package com.code.util;

/**
 * @author 400
 *
 */
import java.security.MessageDigest;

public class MD5Util {
	
	public static String md5(String source) {
		
		StringBuffer sb = new StringBuffer(32);
		try {
			MessageDigest md 	= MessageDigest.getInstance("MD5");
			byte[] array 		= md.digest(source.getBytes("utf-8"));
				
			for (int i = 0; i < array.length; i++) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toLowerCase().substring(1, 3));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			
		return sb.toString();
	}

	

	public static void main(String[] args) {
		System.out.println(MD5Util.md5("1234EXsyas1256"));
		System.out.println(MD5Util.md5("password").length());
	}
}
