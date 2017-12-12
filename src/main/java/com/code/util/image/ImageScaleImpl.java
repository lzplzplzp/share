package com.code.util.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;


import java.io.IOException;

//import magick.Magick;
import org.springframework.stereotype.Service;

/**
 * 图片缩小类
 * 
 * 根据环境情况选择java图片缩小方式或专业的magick图片缩小方式
 * 
 * 
 */
@Service
public class ImageScaleImpl implements ImageScale {

	public void resizeFix(File srcFile, File destFile, int boxWidth,
			int boxHeight) throws Exception {
		if (isMagick) {
//			MagickImageScale.resizeFix(srcFile, destFile, boxWidth, boxHeight);
		} else {
			AverageImageScale.resizeFix(srcFile, destFile, boxWidth, boxHeight);
		}
	}

	public void resizeFix(File srcFile, File destFile, int boxWidth,
			int boxHeight, int cutTop, int cutLeft, int cutWidth, int catHeight)
			throws Exception {
		if (isMagick) {
//			MagickImageScale.resizeFix(srcFile, destFile, boxWidth, boxHeight,
//					cutTop, cutLeft, cutWidth, catHeight);
		} else {
			AverageImageScale.resizeFix(srcFile, destFile, boxWidth, boxHeight,
					cutTop, cutLeft, cutWidth, catHeight);
		}
	}

	public void imageMark(File srcFile, File destFile, int minWidth,
			int minHeight, int pos, int offsetX, int offsetY, String text,
			Color color, int size, int alpha) throws Exception {
		if (isMagick) {
//			MagickImageScale.imageMark(srcFile, destFile, minWidth, minHeight,
//					pos, offsetX, offsetY, text, color, size, alpha);
		} else {
			AverageImageScale.imageMark(srcFile, destFile, minWidth, minHeight,
					pos, offsetX, offsetY, text, color, size, alpha);
		}
	}

	public void imageMark(File srcFile, File destFile, int minWidth,
			int minHeight, int pos, int offsetX, int offsetY, File markFile)
			throws Exception {
		if (isMagick) {
//			MagickImageScale.imageMark(srcFile, destFile, minWidth, minHeight,
//					pos, offsetX, offsetY, markFile);
		} else {
			AverageImageScale.imageMark(srcFile, destFile, minWidth, minHeight,
					pos, offsetX, offsetY, markFile);
		}
	}

	/**
	 * 检查是否安装magick
	 */
//	public void init() {
//		if (tryMagick) {
//			try {
//				System.setProperty("jmagick.systemclassloader", "no");
//				new Magick();
//				log.info("using jmagick");
//				isMagick = true;
//			} catch (Throwable e) {
//				log.warn("load jmagick fail, use java image scale. message:{}",
//						e.getMessage());
//				isMagick = false;
//			}
//		} else {
//			log.info("jmagick is disabled.");
//			isMagick = false;
//		}
//	}

	private static final boolean isMagick = false;
//	private boolean tryMagick = true;
	/**
	 * 默认用JAVA
	 */
//	private boolean tryMagick = false;
//	public void setTryMagick(boolean tryMagick) {
//		this.tryMagick = tryMagick;
//	}

	@Override
	public void resizeFix(BufferedImage srcImgBuff, File destFile,
			int boxWidth, int boxHeight) throws IOException {
		AverageImageScale.resizeFix(srcImgBuff, destFile, boxWidth, boxHeight); 
	}
}
