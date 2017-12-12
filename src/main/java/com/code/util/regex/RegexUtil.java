package com.code.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * @Description: 正则验证的工具类
 * @Author zhang
 * @Date 2015-5-5 下午11:44:26
 */
public class RegexUtil {
	
	
	public static final String EMAIL_REGULAR = "^((([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+(\\.([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+)*)|((\\x22)((((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(([\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x7f]|\\x21|[\\x23-\\x5b]|[\\x5d-\\x7e]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(\\\\([\\x01-\\x09\\x0b\\x0c\\x0d-\\x7f]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]))))*(((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(\\x22)))@((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))$";
	
	public static final String PHONE_REGULAR = "^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\\d{8}";
	
	private static final Pattern EMAIL_REGEX_PATTERN = Pattern.compile(EMAIL_REGULAR, Pattern.DOTALL);
	
	private static final Pattern PHONE_REGEX_PATTERN = Pattern.compile(PHONE_REGULAR, Pattern.DOTALL);
	
	/**
	 * 判断一个字符串是不是邮箱
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str){
		return isMatch(str, EMAIL_REGEX_PATTERN);
	}
	
	/**
	 * 判断一个字符串是不是手机号
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str){
		return isMatch(str, PHONE_REGEX_PATTERN);
	}
    
	/**
	 * 判断给定字符串是否符合正则格式
	 * @param str
	 * @param regxStr
	 * @return
	 */
    public static boolean isMatch(String str, String regxStr){
    	Pattern regx = Pattern.compile(regxStr, Pattern.DOTALL);
        return isMatch(str, regx);
    }
    
    /**
     * 判断给定字符串是否符合正则格式
     * @param str
     * @param regx
     * @return
     */
    public static boolean isMatch(String str, Pattern regx){
    	if(StringUtils.isBlank(str)){
    		return false;
    	}
        Matcher matcher = regx.matcher(str);
        return matcher.matches();
    }

    public static void main(String[] args) {
		System.out.println(isEmail("@378545239@qq.40.com"));
		System.out.println(isEmail("378545239@qq"));
		System.out.println(isPhone("1746574829"));
		System.out.println(isPhone("18601207361"));
		System.out.println(isPhone("185014207361"));
		System.out.println(isPhone(""));
		System.out.println(isPhone(null));
	}
    
}
