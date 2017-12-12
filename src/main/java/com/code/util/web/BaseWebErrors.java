package com.code.util.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

 



import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.code.util.image.ImageUtils;

 

/**
 * WEB错误信息
 * 
 * 
 */
public class BaseWebErrors {
	/**
	 * email正则表达式
	 */
	public static final Pattern EMAIL_PATTERN = Pattern
			.compile("^\\w+(\\.\\w+)*@\\w+(\\.\\w+)+$");
	/**
	 * username正则表达式
	 */
	public static final Pattern USERNAME_PATTERN = Pattern
			.compile("^[0-9a-zA-Z\\u4e00-\\u9fa5\\.\\-@_]+$");

	/**
	 * 手机号正则表达式
	 */
	public static final Pattern PHONE_PATTERN = Pattern
			.compile("^(13[0-9]|147|145|15[0-9]|(17[0])|(17[7])|18[0-9])[0-9]{8}$");
	/**
	 * 命中返回true
	 * @param value
	 * @param text
	 *            
	 * @param maxLength
	 * @return
	 */
	public static boolean ifBlankAndLength(String value, int maxLength) {
		if (StringUtils.isBlank(value)) {
			return true;
		}
		return value.length() > maxLength;
	}

	public static boolean ifBlank(String value) {
		if (StringUtils.isBlank(value)) {
			return true;
		}
		return false;
	}

	/**
	 * 检查用户的密码
	 * @param passWord
	 * @return 是正确SHA1密码返回false
	 */
	public static boolean chcekSHA1PassWord(String passWord) {
		if (StringUtils.isNotBlank(passWord) && passWord.length()==40) {
			return false;
		}
		return true;
	}
	
	/**
	 * 检查uuid邀请码是否正确
	 * @param passWord
	 * @return 是正确返回false
	 */
	public static boolean chcekInvitationCode(String invitationCode) {
		if (StringUtils.isNotBlank(invitationCode) && invitationCode.length()==36) {
			return false;
		}
		return true;
	}
	
	
    /**
     * 验证邮箱
     * @param email
     * @param maxLength
     * @return 不是合法邮箱 时返回true
     */
	public static boolean ifNotEmail(String email, int maxLength) {
		if (ifBlankAndLength(email, maxLength)) {
			return true;
		}
		Matcher m = EMAIL_PATTERN.matcher(email);
		if (!m.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * 验证手机号
	 * @param phone
	 * @param maxLength
	 * @return 不是合法手机号 时返回true
	 */
	public static boolean ifNotPhone(String phone, int maxLength) {
		if (ifBlankAndLength(phone, maxLength)) {
			return true;
		}
		Matcher m = PHONE_PATTERN.matcher(phone);
		if (!m.matches()) {
			return true;
		}
		return false;
	}
    /**
     * 验证昵称--出现特殊字符返回true
     * @param username  只能是数字中文字母
     * @param maxLength
     * @return
     */
	public static boolean ifNotNickname(String nickname,int maxLength) {
		if (ifBlankAndLength(nickname, maxLength)) {
			return true;
		}
		if(nickname.length()<2){
			return true ;
		}
		Matcher m = USERNAME_PATTERN.matcher(nickname);
		if (!m.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * 判断图片后缀是否合法，不合法并返回true
	 * @param response
	 * @param obj
	 * @param ext 图片后缀
	 * @return 不合法返回true
	 */
	public static boolean printPicTypeError(HttpServletResponse response,String ext){
		boolean isPic = ImageUtils.isValidImageExt(ext) ;
        if(!isPic){ 
			return true;
        }
		return false ;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(ifNotNickname("as",10)); 
	}
	
	
}
