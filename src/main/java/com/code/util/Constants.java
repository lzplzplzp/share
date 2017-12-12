package com.code.util;


/**
 * @description  统一常量定义类
 */
public class Constants {
	/**
	 * 默认的分页展示数
	 */
	public final static int LIST_PAGE_SIZE            =15 ;
	
 
	/**
	 * 页面操作提示信息
	 */
	public static final String hint = "hint";
 
	/**
	 * 系统错误提示
	 */
	public static final String systemError ="系统异常,请您稍后重试" ;
	
	
	/**
	 * spring mvc主动返回 404错误页面
	 */
	public static final String url404 = "/404";
	/**
	 * spring mvc主动返回 500错误页面
	 */
	public static final String url500 = "/500";
	
	/**
	 * 跳转到登录页面的url
	 */
	public static final String toLogin = "redirect:/login" ;
	
	/**
	 * 网站根url TODO 完善
	 */
	public static final String baseUrl = "http://s" ;
	
	public static final String desKeySeparate ="_" ;
	/**
	 * cookie盐的最大长度
	 */
	public static final int cookieRandomLength =13 ;
	/**
	 * 用户密码的盐的最大长度
	 */
	public static final int passwordRandomLength =13 ;
	 
	/**
	 * 图片验证码的key
	 */
	public static final String validatePic ="vpc" ;
     
	public static final int squeezedFileSizeMB = 30; 
	/**上传附件大小*/
	public static final int squeezedFileSize = 1024*1024*squeezedFileSizeMB;
 
 
 
}
