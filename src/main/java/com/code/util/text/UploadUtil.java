package com.code.util.text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.codefollow.base.context.ThreadContext;

import com.code.util.web.WebUtils;

/**
 * @author Camus
 * 2015年4月21日
 * 
 */
public class UploadUtil {
    
    private static final Logger logger = LoggerFactory.getLogger(UploadUtil.class);

	//临时路径
	// TODO 有真实文件服务器后需更改
	private static final String UPLOAD_FILE_PATH = "uploadfile/";
//	private static final String UPLOAD_PICTURE_PATH = "uploadpciture/";
//	/**
//	 * 上传文件到文件服务器，返回文件地址
//	 * @param fileInputStream 文件流
//	 * @param 文件后缀
//	 * @return 资源地址
//	 */
//	public static URI uploadFileToServer(InputStream fileInputStream, String suffix) {
//		if(fileInputStream == null)return null;
//		if(suffix ==null)suffix = ".tmp";
//		HttpServletRequest req = ThreadContext.request();
//		String rootPath = req.getSession().getServletContext().getRealPath("/") + UPLOAD_FILE_PATH;
//		String fileName = new Date().getTime()+ "_" + (int)(Math.random()*10000) +suffix;
//		logger.info("上传文件路径->"+rootPath + fileName);
//		FileOutputStream os;
//		int b = 0;
//		try {
//			os = new FileOutputStream(new File(rootPath +fileName));
//			while( (b = fileInputStream.read() ) != -1){
//				os.write(b);  
//			}
//			os.flush();
//			os.close();  
//			fileInputStream.close();
//			String resourceUrl = WebUtils.getWebRoot(req) + UPLOAD_FILE_PATH + fileName;
//			logger.info("文件web请求路径->"+ resourceUrl);
//			return new URI(resourceUrl);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}catch (IOException e) {
//			e.printStackTrace();
//		}catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

//	/**
//	 * 上传图片到服务器
//	 * @param fileInputStream 图片流
//	 * @param 后缀
//	 * @return 资源地址
//	 */
//	public static URI uploadPictureToServer(InputStream fileInputStream, String suffix) {
//		return uploadFileToServer(fileInputStream, suffix);
//	}

	/**
	 * 检查图片格式
	 * @param fileName
	 * @return
	 */
	public static boolean checkPictureName(String fileName){
		if(fileName == null || "".equals(fileName.trim()))return false;
		return fileName.endsWith(".jpg") || fileName.endsWith(".png");
	}
	
	/**
	 * 检查文件格式
	 */
	public static boolean checkFileName(String fileName){
		if(fileName == null || "".equals(fileName.trim()))return false;
		return !fileName.endsWith(".exe");
	}
	/**
	 * 获取文件后缀名
	 * @param fileName
	 * @return
	 */
	public static String getSuffix(String filename){
		if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) { 
                return filename.substring(dot);
            }
        }
		return filename;
	}
}
