/**
 * 
 */
package com.code.controller;
 
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.session.SessionProvider;
 

/**
 * 菜单
 * @author 400
 *
 */
@Controller
public class MenuAct {
	/**
	 * shop 模板前缀
	 */
	public static final String menu ="/system/" ;
	
	@Resource(name = "session")
	private SessionProvider session;
 
	
	/**
	 * 左边菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/left")
	public String left(HttpServletRequest request,
			HttpServletResponse response) {
		return menu + "left";
	}
	
	/**
	 * 首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/right")
	public String right(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		Integer id = session.getLoginUserId(request) ;

	    //TODO 查询用户
	 
		return menu + "right";
	}

	
	
	
	
}
