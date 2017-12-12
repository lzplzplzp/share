package com.zqm.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

 
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.code.util.image.ImageUtils;
 
 
 

/**
 * @Description: controller的基类
 * @Date 2015-4-29 下午10:30:41
 */
public  class BaseController {
	
	private static final String URL_ROOT = "/";
	
	private static final String REDIRECT = "redirect:";
	
	private static final String FORWARD = "forward:";
	
	private static final String REDIRECT_ERROR_PAGE = REDIRECT + "/error/errorPage.html";
	
	private static final String REDIRCT_404_PAGE = REDIRECT + "/error/404.html";
	
	private static final String REDIRCT_500_PAGE = REDIRECT + "/error/500.html";
	
 
	
	
	/**
	 * 页面展现
	 * @param path
	 * @return
	 */
	protected String pageView(String path){
		return "/mb/"+path;
	}
	
    /**
     * 重定向到
     * @param toUrl
     * @return
     */
    protected String redirectTo(String toUrl) {
        if (toUrl == null) {
            toUrl = URL_ROOT;
        }
        StringBuffer sb = new StringBuffer();
        return sb.append(REDIRECT).append(toUrl).toString();
    }
    /**
     * 转发到
     * @param toUrl
     * @return
     */
    protected String forwardTo(String toUrl) {
	if (toUrl == null) {
	    toUrl = URL_ROOT;
	}
	StringBuffer sb = new StringBuffer();
	return sb.append(FORWARD).append(toUrl).toString();
    }
    
    /**
     * 跳转到错误页面（可携带信息）
     * @return
     */
    protected String redirectToErrorPage(String msg) {
    	if(StringUtils.isBlank(msg)){
    		return redirectToErrorPage();
    	}
    	
    	String message = "";
		try {
			message = URLEncoder.encode(msg, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
    	
        StringBuffer sb = new StringBuffer();
        sb.append(REDIRECT_ERROR_PAGE).append("?msg=").append(message).toString();
        return sb.toString();
    }
    
    /**
     * 跳转到错误页面
     * @return
     */
    protected String redirectToErrorPage() {
        return REDIRECT_ERROR_PAGE;
    }
    
    /**
     * 系统错误页 404
     * @return
     */
    protected String redirectTo404Page() {
        return REDIRCT_404_PAGE;
    }

    /**
     * 系统错误页 500
     * @return
     */
    protected String redirectTo500Page() {
        return REDIRCT_500_PAGE;
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
	
	
	
    /**
     * DWZ 失败提示
     * @param msg
     * @return
     */
    public JSONObject dwzFailureMsg(String msg){
        JSONObject json = new JSONObject();
        json.put("statusCode", 300);
        json.put("message",msg);
        return json;
    }

    /**
     * DWZ 成功提示
     * @param navTabId
     * @param callbackType
     * @param forwardUrl
     * @param msg
     * @return
     */
    public JSONObject dwzSuccessMsg(String navTabId, String callbackType, String forwardUrl, String msg){
        JSONObject json = new JSONObject();
        json.put("navTabId", navTabId);
        json.put("callbackType", callbackType);
        json.put("forwardUrl", forwardUrl);
        json.put("statusCode", 200);
        json.put("message", msg);
        return json;
    }
	
}
