package com.code.controller.kind;

import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.code.common.Constants;
import com.code.session.SessionProvider;
import com.code.util.image.ImageUtils;
import com.code.util.upload.FileRepository;
import com.code.util.web.WebUtils;
/**
 * 处理kind的上传图片--不用拦截器判断是否登录
 * 
 * @author 400
 * 
 */
@Controller
@RequestMapping("/ajax/kind")
public class KindUploadAct {

	private static Logger log = LoggerFactory.getLogger(KindUploadAct.class);
	/**
	 * 10M
	 */
	private static final int picSize = 1024*1024*10;
	@Resource(name="session")
	private SessionProvider session;
	@Resource
	private FileRepository fileRepository;

	private static final String artPath = "/uploadfile/kind";


	/**
	 * 处理上传文件大小 异常--实测加入此以后，不会上传文件，只是ajax条会等到100%，才跳转到下一页面
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleException(MaxUploadSizeExceededException ex,
			HttpServletRequest request) {
		String currentURL = request.getRequestURI();
		log.error("文件超过最大限制,当前URL为:" + currentURL + " 异常信息:", ex);
		return "redirect:" + currentURL + "_error";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public void uploadArtImage(
			Integer uploadNum,
			Boolean mark,
			@RequestParam(value = "imgFile", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		Integer id = session.getLoginUserId(request) ;
		if (id == null) {
			WebUtils.printOnPage(
					response,
					getError("请您登录以后，操作"));
			return;
		}

		String filename = file.getOriginalFilename();
		// 文件后缀名
		String ext = FilenameUtils.getExtension(filename).toLowerCase(
				Locale.ENGLISH);
		boolean isPic = ImageUtils.isValidImageExt(ext) ;
		if (!isPic) {
			WebUtils.printOnPage(
					response,
					getError("只支持'jpg', 'jpeg', 'gif', 'png', 'bmp'格式"));
			return;
		}

		if (file.getSize() > picSize) {
			WebUtils.printOnPage(
					response,
					getError("图片请不要超过10M,可以用QQ截图以后在上传哦"));
			return;
		}
		try {
			String picPath = fileRepository.storeByExt(artPath, id, ext,
					file);
			// 加上部署路径
			JSONObject obj = new JSONObject();
			obj.put("error", 0);
			obj.put("url", Constants.baseUrl+picPath);//绝对路径
			WebUtils.printOnPage(response,
					obj.toJSONString());
		} catch (Exception e) {
			log.error("uploadArtImage upload file error!", e);
			WebUtils.printOnPage(
					response,
					getError("系统出错，请稍后在试"));
		}

	}

	/**
	 * 显示上传文件大小异常
	 * 
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/upload_error", method = RequestMethod.GET)
	public void inputUploadImage(HttpServletRequest request,
			HttpServletResponse response) {
		WebUtils.printOnPage(
				response,
				getError("图片请不要超过10M,可以用QQ截图以后在上传哦"));
	}

	
	
	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toJSONString();
	}
	
}