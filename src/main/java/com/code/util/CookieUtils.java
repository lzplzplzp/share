package com.code.util;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
 
/**
 * Cookie 辅助类
 * 
 * 
 */
public class CookieUtils {
	 
 
	/**
	 * cookie里保存的联合登录key 和签章系统
	 */
	public static final String COOKIE_LOGIN_NAME = "89qwq_902"  ;
	
	
	/**
	 * 域名
	 */
 	public static final String DOMIN = ".zhuaqianmao.com"  ;
 
 
 
 
	/**
	 * 清除cookie
	 * @param response
	 * @param name
	 */
	public static void cleanCookie(HttpServletResponse response,String name){
	      Cookie c = new Cookie(name,null); 
	      c.setMaxAge(0); 
	      c.setPath("/"); 
	      c.setDomain(DOMIN); 
	      response.addCookie(c); 
	}
	
	 
	
	/**
	 * @param request
	 * @param name
	 * @return
	 */
	public static Cookie getDominCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
//				if (DOMIN.equalsIgnoreCase(c.getDomain())&&c.getName().equals(name)) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
		}
		return null;
	}
	
	
	/**
	 * 
	 * 添加cookie,当前浏览器进程有效
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 * @return
	 */
	public static Cookie addDominCookie(HttpServletRequest request,
			HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		cookie.setDomain(DOMIN);
		response.addCookie(cookie);
		return cookie;
	}
	
	public static boolean autoLoginSign(HttpServletRequest request,
			HttpServletResponse response, String phone) throws Exception {
		String value = Encryp.add(Encryp.desKey, phone+"_"+new Date().getTime()) ; 
		addDominCookie(request, response, COOKIE_LOGIN_NAME, value) ;
		return true ;
	}
	
	
	
 
}
