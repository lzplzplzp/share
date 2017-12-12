package com.code.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

/**
 * Session提供者
 */
public interface SessionProvider {

    /**
     * 得到登录的用户id
     *
     * @param request
     * @return
     */
    public Integer getLoginUserId(HttpServletRequest request);


    /**
     * 处理登录
     *
     * @param request
     * @param response
     * @param userId   用户的id
     */
    public void login(HttpServletRequest request,
                      HttpServletResponse response, Integer userId);


    public void logout(HttpServletRequest request, HttpServletResponse response);
    
 
}
