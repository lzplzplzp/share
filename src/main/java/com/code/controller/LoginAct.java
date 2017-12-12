///**
// *
// */
//package com.code.controller;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.code.common.Constants;
//import com.code.common.JsonWrapper;
//import com.code.common.result.Result;
//import com.code.model.JxSmsManage;
//import com.code.service.JxSmsManagerService;
//import com.code.session.SessionProvider;
//import com.code.util.CodeTool;
//import com.code.util.CustomizedPropertyConfigurer;
//import com.code.util.MD5Util;
//import com.code.util.web.BaseWebErrors;
//
//
///**
// * @author 400
// */
//@Controller
//public class LoginAct {
//
//    private static Logger log = LoggerFactory.getLogger(LoginAct.class);
//
//
//    @Resource(name = "session")
//    private SessionProvider session;
//    @Resource
//    private JxSmsManagerService jxSmsManagerService;
//
//
//    /**
//     * 跳转登录主页
//     * @param request
//     * @param response
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String indexLogin(HttpServletRequest request,
//                             HttpServletResponse response, ModelMap model) {
//        Integer id = session.getLoginUserId(request);
//        model.addAttribute("loginMobileOpen", CustomizedPropertyConfigurer.getContextProperty("phone.login.open"));
//        // 无权限
//        if (id == null) {
//             return "testcode";
//        }
//        JxSmsManage um = jxSmsManagerService.getUserManageById(id);
//        if(um!=null && um.getIsAdmin().intValue() == 2){//企业用户，登录跳转到指定界面
//        	return "index2";
//        }
//        return "index";
//    }
//
//    /**
//     * 登录方法
//     * @param phone 手机号
//     * @param passWord 密码
//     * @param captcha 手机验证码
//     * @param imageCode 图形验证码
//     * @param request
//     * @param response
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String login(String phone, String passWord, String captcha,String imageCode,
//                        HttpServletRequest request, HttpServletResponse response, ModelMap model) {
//
//        model.addAttribute("loginMobileOpen", CustomizedPropertyConfigurer.getContextProperty("phone.login.open"));
//
//        model.put("phone",phone);// 回显手机号
//        // 验证手机号
//        if (BaseWebErrors.ifNotPhone(phone, 11)) {
//            model.put(Constants.hint, "请输入手机号");
//            return "testcode"; // 登录页
//        }
//        // 验证密码
//        if (BaseWebErrors.ifBlankAndLength(passWord, 20)) {
//            model.put(Constants.hint, "密码错误");
//            return "testcode";
//        }
//        // 验证图形验证码
//        if (CodeTool.checkimgCode(request, imageCode)!=1) {
//        	model.put(Constants.hint, "图形验证码不正确,请重新输入！") ;
//        	return "testcode" ;
//		}
//        // 手机验证码开关  1为开启,0为关闭 在systemconfig.properties中配置
//        if("1".equals(CustomizedPropertyConfigurer.getContextProperty("phone.login.open"))){
//        	if(BaseWebErrors.ifBlankAndLength(captcha, 6)){
//        		model.put(Constants.hint, "手机验证码错误") ;
//        		return "testcode" ;
//        	}
//
//        	String validate = (String) request.getSession().getAttribute("mobile:"+phone);
//        	if(StringUtils.isBlank(validate)){
//        		model.put(Constants.hint, "验证码过期，请重新输入") ;
//        		return "testcode" ;
//        	}
//
//        	if(!validate.equalsIgnoreCase(captcha)){
//        		model.put(Constants.hint, "验证码错误") ;
//        		return "testcode" ;
//        	}
//        }
//		JxSmsManage um = jxSmsManagerService.getUserMangeByPhone(phone);
//        if (um != null) {
//            String pass = MD5Util.md5(um.getRandom() + passWord);
//            if (um.getPassword().equals(pass)) {
//                session.login(request, response, um.getId());
//                HttpSession session = request.getSession();
//                session.setAttribute("user", um);
//                if(um.getIsAdmin().intValue() == 2){//企业用户，登录跳转到指定界面
//                	return "index2";
//                }
//                return "index";
//            }
//        }
//        model.put(Constants.hint, "用户名/密码错误");
//        return "testcode";
//    }
//
//    @RequestMapping(value = "/logout")
//    public String logout(HttpServletRequest request,
//                         HttpServletResponse response, ModelMap model) {
//        session.logout(request, response);
//        model.addAttribute("loginMobileOpen", CustomizedPropertyConfigurer.getContextProperty("phone.login.open"));
//        return "testcode";
//    }
//
//
//    @RequestMapping(value="/sendPhone", method=RequestMethod.POST)
//    @ResponseBody
//    public  JsonWrapper<Object> sendPhone(HttpServletRequest request,String account)  {
//        JsonWrapper<Object> result = null;
//        try {
//            if(StringUtils.isEmpty(account))
//                return new JsonWrapper<Object>(false, "手机号码不可以为空");
//            Result _result = jxSmsManagerService.sendSms(account);
//            if(_result.isSuccess()){
//                String code = (String)_result.getDefaultModel();
//                HttpSession session = request.getSession();
//                session.setAttribute("mobile:"+account, code);
//            }
//            result = new JsonWrapper<Object>(_result.isSuccess(), _result.getResultCode().getMessage(), _result.getModels().get("flag"));
//        } catch (Exception e) {
//            result = new JsonWrapper<Object>(false, "发送短信失败，请联系管理员");
//            log.error("发送短信出现异常", e);
//        }
//        return result;
//    }
//
//}
