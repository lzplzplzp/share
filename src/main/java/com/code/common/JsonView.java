package com.code.common;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

/**
 * @author Camus
 * @date 2015年5月14日
 * @description 
 */
public class JsonView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json;charset=UTF-8");        
        response.setHeader("Cache-Control","no-store,max-age=0,no-cache,must-revalidate");        
        response.addHeader("Cache-Control","post-check=0,pre-check=0");        
        response.setHeader("Pragma", "no-cache");
		PrintWriter out = response.getWriter();
		out.print(model.get("jsonview"));
	}
}
