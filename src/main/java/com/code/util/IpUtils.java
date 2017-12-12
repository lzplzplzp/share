package com.code.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class IpUtils {
	
	protected final static Logger LOG = LoggerFactory.getLogger(IpUtils.class);
	/**
	 * 获取ip
	 */
	public static String getClientIp(HttpServletRequest request) {
	       String ip = request.getHeader("x-forwarded-for");
	       if(LOG.isDebugEnabled()) {
//	    	   LOG.debug("x-forwarded-for = {}", ip);
	       }
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getHeader("Proxy-Client-IP");
	           if(LOG.isDebugEnabled()) {
//		    	   LOG.debug("Proxy-Client-IP = {}", ip);
		       }
	       }
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getHeader("WL-Proxy-Client-IP");
	           if(LOG.isDebugEnabled()) {
//		    	   LOG.debug("WL-Proxy-Client-IP = {}", ip);
		       }
	       }
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getRemoteAddr();
	           if(LOG.isDebugEnabled()) {
//		    	   LOG.debug("RemoteAddr-IP = {}", ip);
		       }
	       }
	       if(StringUtils.isNotEmpty(ip)) {
	    	   ip = ip.split(",")[0];
	       }
	       return ip;
	   }
	/**
	 * 验证是否ip 匹配，可以使用*代替
	 * @param ip
	 * @param ips
	 * @return
	 */
	public static boolean ipMatch(String ip, String ips[]) {
		if(ips == null || ips.length == 0) {
			throw new IllegalArgumentException("ips is null or emtpy");
		}
		boolean f = false;
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < ips.length; i++) {
			list.add( ips[i].replaceAll("\\*", "\\\\d+").replaceAll("\\.", "\\\\.") );
		}
		
		for(String e : list) {
			if(ip.matches(e)) {
				f = true;
				break;
			}
		}
		
		return f;
	}
	
	/**
	 * 获取终端用户的设备
	 * @param request
	 * @return
	 */
	public static String getEquipment(HttpServletRequest request) {
		String userAgent = request.getHeader("user-agent").toLowerCase();
		if(StringUtils.isBlank(userAgent)){
			return "";
		}
		if(userAgent.contains("android")) {
			return "android";
		}else if(userAgent.contains("iphone")) {
			return "iphone";
		}else if(userAgent.contains("ipad")) {
			return "ipad";
		}else if(userAgent.contains("pad")) {
			return "pad";
		}else{ 
			return "pc";
		}
	}
}
