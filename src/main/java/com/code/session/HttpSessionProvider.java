package com.code.session;
 
import org.springframework.stereotype.Service;
 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

/**
 * HttpSession提供类
 */
@Service("session") // 不写括号里的值也是默认名称是类名（头字母小写）
public class HttpSessionProvider implements SessionProvider {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }


    @Override
    public Integer getLoginUserId(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        return (Integer) session.getAttribute("uid");
    }

    @Override
    public void login(HttpServletRequest request, HttpServletResponse response,
                      Integer userId) {
        HttpSession session = request.getSession();
        session.setAttribute("uid", userId);
    }


 


 
}
