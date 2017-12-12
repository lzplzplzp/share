package com.code.util.upload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.code.util.image.ImageScale;
 

/**
 * 本地文件存储
 * 
 * 
 */
@Service
public class FileRepository implements ServletContextAware {
	private static Logger log = LoggerFactory.getLogger(FileRepository.class);
	/**
	 * 临时原始头像目录
	 */
	public static final String tempHeadPath = "/temp/heads";
	@Resource
	private ImageScale imageScale ;
	
	/**
	 * 为富文本编译器上传图片大小最大为10000px长，670px宽
	 * @param path
	 *            文件BASE路径
	 * @param userId用户ID
	 * @param ext
	 *            文件后缀
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String storeByExt(String path, Integer userId, String ext,
			MultipartFile file) throws IOException {
		String filename = UploadUtils.generateFilename(path, userId, ext);
		File dest = new File(ctx.getRealPath(filename));
		dest = UploadUtils.getUniqueFile(dest);
//		 	 	store(file, dest);
		storeResize(file,dest,995,10000); //启用压缩
		return filename;
	}
	
	
	
	
	/**
	 * 根据用户名保存头像临时大图片
	 * @param userId
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String storeByUserId(Integer userId,
			MultipartFile file) throws IOException {
		String returnName = tempHeadPath+"/"+ userId+".jpg" ;
		File dest = new File(ctx.getRealPath(tempHeadPath+"/"+ userId+".jpg" ));
		UploadUtils.checkDirAndCreate(dest.getParentFile());
		onlyStore(file, dest);
		return returnName;
	}
	
    /**
     * 
     * @param file
     * @param dest  原始图片
     * @param destFile
     * @param boxWidth 缩小图片宽度
     * @param boxHeight 缩小图片长度
     * @throws IOException
     */
	private void storeResize(MultipartFile file, File dest, int boxWidth,
			int boxHeight) throws IOException {
		UploadUtils.checkDirAndCreate(dest.getParentFile());
		BufferedImage srcImgBuff = ImageIO.read(file.getInputStream());
		if (srcImgBuff.getWidth() <= boxWidth
				&& srcImgBuff.getHeight() <= boxHeight) {
			file.transferTo(dest);
			return;
		}
		imageScale.resizeFix(srcImgBuff, dest, boxWidth, boxHeight);
	}
	
	/**
	 * 生成项目的绝对路径的文件名
	 * @param filename
	 * @return
	 */
   public File getRealPathFile(String filename){
	  return new File(ctx.getRealPath(filename));
   }
	
	
	private void store(MultipartFile file, File dest) throws IOException {
		try {
			UploadUtils.checkDirAndCreate(dest.getParentFile());
			file.transferTo(dest);
		} catch (IOException e) {
			log.error("Transfer file error when upload file", e);
			throw e;
		}
	}
	
	private void onlyStore(MultipartFile file, File dest) throws IOException {
		try {
			file.transferTo(dest);
		} catch (IOException e) {
			log.error("Transfer file error when upload file", e);
			throw e;
		}
	}
	
 
 

	private ServletContext ctx;

	public void setServletContext(ServletContext servletContext) {
		this.ctx = servletContext;
	}




	public String storeSqueezed(String path, Integer userId, String ext,MultipartFile file) throws IOException {
		String filename = UploadUtils.getFilename(path, userId, ext);
		File dest = new File(ctx.getRealPath(filename));
		UploadUtils.checkDirAndCreate(dest.getParentFile());
		try {
			onlyStore(file, dest);
			return filename;
		} catch (IllegalStateException | IOException e) {
			log.error("Transfer file error when upload file", e);
			throw e;
		}
	}



	/**
	 * @param userId 用户ID
     * @param file  文件流
     * @param boxWidth 缩小图片宽度
     * @param boxHeight 缩小图片长度
     * @throws IOException
	 */
	public String storeByUserIdResize(Integer userId,MultipartFile file, int boxWidth,int boxHeight) throws IOException {
		String returnName = tempHeadPath+"/"+ userId+".jpg" ;
		File dest = new File(ctx.getRealPath(tempHeadPath+"/"+ userId+".jpg" ));
		UploadUtils.checkDirAndCreate(dest.getParentFile());
		storeResize(file, dest, boxWidth, boxHeight);
		return returnName;
	}
}
