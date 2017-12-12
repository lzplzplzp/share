/**
 * 
 */
package com.code.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.patchca.service.Captcha;

import com.code.common.Constants;
import com.code.util.CodeTool;

/**
 * 生成图片验证码
 * 
 * @author 400
 */
public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
 

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		HttpSession session = req.getSession();
		//140*70,6个字母
		Captcha cap = CodeTool.createImage() ;
		// 验证码保存到Session中。
		session.setAttribute(Constants.validatePic, cap.getChallenge());
		// 禁止图像缓存。
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = resp.getOutputStream();
 		ImageIO.write(cap.getImage(), "jpeg", sos);
		sos.close();
	}
}

