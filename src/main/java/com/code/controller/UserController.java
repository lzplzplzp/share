package com.code.controller;
 

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.dao.mapper.JxSmsManageMapper;
import com.code.model.JxSmsManage;
import com.code.service.JxSmsManagerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.code.session.SessionProvider;
import com.code.util.MD5Util;
import com.zqm.controller.BaseController;

/**
 * 用户及管理员操作
 *
 */
@Controller
public class UserController  extends BaseController{
	
 
	@Resource
	private SessionProvider session;
	@Autowired
	private JxSmsManageMapper jxSmsManageMapper;
	@Autowired
	private JxSmsManagerService jxSmsManagerService;
 
 
	/**
	 * 管理员修改密码页面的跳转
	 * @return
	 */
	@RequestMapping("/change/pwd")
	public String change(){
		return "change/change-password";
	}
	
 
	/**
	 * 管理员修改用户密码
	 * @param oldPassword   原密码
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/change/password")
	@ResponseBody
	public JSONObject updatePWD(String oldPassword,String newPassword,String checkPassword,HttpServletRequest request,HttpServletResponse response){
		if (StringUtils.isBlank(oldPassword)) {
			return dwzFailureMsg("旧密码不能为空");
		}
		if (StringUtils.isBlank(newPassword)) {
			return dwzFailureMsg("新密码不能为空");
		}

		Integer userId = session.getLoginUserId(request);
		JxSmsManage jxSmsManage = jxSmsManageMapper.selectByPrimaryKey(userId);
		String pass = MD5Util.md5(jxSmsManage.getRandom()+oldPassword) ;
    	String nwepass = MD5Util.md5(jxSmsManage.getRandom()+newPassword) ;
		if (StringUtils.isBlank(nwepass)) {
			return dwzFailureMsg("修改密码失败");
		}
		if(jxSmsManage.getPassword().equals(pass)){
			if(nwepass.equals(jxSmsManage.getPassword())){
				return dwzFailureMsg("修改的密码不能与原密码相同") ;
			}
			if(!newPassword.matches("^[a-zA-Z0-9]{8,20}$")){
				return dwzFailureMsg("密码必须包含数字及字母且为9位以上") ;
			}
			if(!newPassword.equals(checkPassword)){
				return dwzFailureMsg("两次输入的密码不一致") ;
			}
			if(jxSmsManagerService.updatePassWordById(userId, nwepass)){
				  return dwzSuccessMsg("change_pwd", "","/change/pwd","修改密码成功");
			}
		}
		return dwzFailureMsg("修改密码失败") ;
	}
 
 
}
