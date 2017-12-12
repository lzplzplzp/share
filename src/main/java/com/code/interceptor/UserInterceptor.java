package com.code.interceptor;

 

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.code.model.JxMerchantManage;
import com.code.model.JxSmsManage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.code.session.SessionProvider;


/**
 * 用户拦截器
 *  
 * 
 * @author 400
 * 
 */
public class UserInterceptor extends HandlerInterceptorAdapter {
	private static Logger log = LoggerFactory.getLogger(UserInterceptor.class);
 
	@Resource
	private SessionProvider session ;
 
 
	/**
	 * 没有登录跳转到的页面
	 */
	private static final String noPowerUrl ="/" ;

	
 
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String currentURL = request.getRequestURI();
		if(currentURL == null){
			response.sendRedirect(noPowerUrl);
			return false ;
		}
		currentURL = currentURL.replaceAll("//", "/");
		log.debug("currentURL:"+currentURL); 
		if (currentURL.equalsIgnoreCase(noPowerUrl) ) { 
			return true ;
		}
 
		if (currentURL.equalsIgnoreCase("/autoSign/doSign")) { //自动签章
			return true ;
		}

		if (currentURL.equalsIgnoreCase("/sendPhone")) { //发短信
			return true ;
		}

		if (currentURL.equalsIgnoreCase("/jx/notify/passwordSet")) { //异步通知回调
			return true ;
		}

		if (currentURL.equalsIgnoreCase("/logout")) { //退出/jx/notify/
			return true ;
		}

		if (currentURL.equalsIgnoreCase("/jx/notify/comWithdraw")) { //大额提现回调
			return true ;
		}


		Integer id = session.getLoginUserId(request) ;
		if(id==null||id==0){
			return true;
//			response.sendRedirect(noPowerUrl);
//			return false ;
		}
		 HttpSession httpSession = request.getSession(false);

		JxSmsManage um = (JxSmsManage)httpSession.getAttribute("user");
		 if(um.getIsAdmin().intValue() == 2){//企业用户，不允许有签章系统的权限；
			 if (currentURL.equalsIgnoreCase("/sign/productBillList")) {
				 return false;
			 }
		 }else{//签章系统用户不允许有企业用户的权限
			 if (currentURL.equalsIgnoreCase("/index2")) {
				 return false;
			 }
		 }
         request.setAttribute("user", um);
 
		//统一匹配不需要的问题 可以把需要登录的url?
		log.debug("excludeURL:" + currentURL);
		return true ;
	}
	
//	@Override
//	public void afterCompletion(HttpServletRequest request,
//			HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		 
//	}

	
	

 

}