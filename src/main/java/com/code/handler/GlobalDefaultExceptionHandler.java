package com.code.handler;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.zqm.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler extends BaseController {

    private static Logger log = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);
    
    public static final String VIEW_ERROR = "error";
    public static final String VIEW_ERROR_JSON = "error_json";

    @ExceptionHandler(Exception.class)
    public Object defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        String requestURI = request.getRequestURI();
        StringBuilder uri = new StringBuilder(requestURI);
        String queryString = request.getQueryString();
        if (!StringUtils.isEmpty(queryString)) {
            uri.append("?").append(queryString);
        }
        // 打印异常
        log.error("统一异常处理："+"请求地址: " + uri.toString() + "   ", e); 
        ModelAndView modelAndView = new ModelAndView();
        if (isAjaxRequest(request)) {
        	log.error("统一异常处理", e); 
            // ajax request
        	return dwzFailureMsg("系统异常,请稍后重试");
        } else {
            // non-ajax request
            // 跳错误页面
            modelAndView.addObject("message", e.getMessage());
            modelAndView.setViewName(VIEW_ERROR);
        }
        return modelAndView;
    }

    /**
     * 是否是ajax请求
     *
     * @param request 当前请求
     * @return 是true，否则false
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")) || "XMLHttpRequest".equalsIgnoreCase("x-requested-with");
    }
}
