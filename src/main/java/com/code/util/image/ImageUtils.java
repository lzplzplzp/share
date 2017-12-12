package com.code.util.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.imageio.ImageIO;
/**
 * 图片辅助类
 * 
 * 
 */
public  class ImageUtils {
	
	/**
	 * 图片的后缀
	 */
	public static final Set<String> IMAGE_EXT = new HashSet<String>();
	static{
		IMAGE_EXT.add("jpg");
		IMAGE_EXT.add("jpeg");
		IMAGE_EXT.add("gif");
		IMAGE_EXT.add("png");
		IMAGE_EXT.add("bmp");
	}
	
	

	/**
	 *检查图片的后缀是否正确
	 * "jpg", "jpeg", "gif", "png", "bmp" 为文件后缀名者为图片
	 * @param ext
	 * @return 验证通过返回true
	 */
	public static boolean isValidImageExt(String ext) {
		if (ext == null) {
			return false;
		}
		ext = ext.toLowerCase(Locale.ENGLISH);
		if (IMAGE_EXT.contains(ext)) {
			return true;
		}
		return false;
	}

	
	/**
	 * 生成唯一的文件名字(id+时间戳)
	 * @param userId 用户id
	 * @param ext 文件后缀
	 * @return
	 */
	public static String createUniqueName(Integer userId, String ext) {
		return userId + "-" + new Date().getTime() + "." + ext;
	}
	
	
	/**
	 * 生成唯一的聊天图片名字
	 * @param receiveId
	 * @param sendId
	 * @param random
	 * @param ext
	 * @return
	 */
	public static String createChatUniqueName(String receiveId,int sendId,String random, String ext) {
		return receiveId + "-" + sendId +"-"+random+ "." + ext;
	}

	/**
	 * 文字水印
	 * @param pressText 水印文字
	 * @param targetImg 目标图片
	 * @param fontName 字体名称
	 * @param fontStyle 字体样式
	 * @param color 字体颜色
	 * @param fontSize 字体大小
	 * @param x 修正值
	 * @param y 修正值
	 * @param alpha 透明度
	 */
	
	/**
	 * 1949家文字水印
	 * @param time 水印时间
	 * @param pressText 水印文字
	 * @param targetImg 目标图片
	 * @param alpha  透明度
	 */
	public static void pressText(String time,String pressText, File targetImg,  float alpha) {
		try {
			Image src = ImageIO.read(targetImg);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			g.setColor(Color.BLACK);
			g.setFont(new Font("黑体", 36, 160));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
//			g.drawString(pressText, (width - (getLength(pressText) * fontSize)) / 2 + x, (height - fontSize) / 2 + y);
			int base = height/5 ;
			int x = (width - (getLength(pressText) * 160)) / 2 ;
			g.drawString(pressText,x ,base );
			g.drawString(pressText, x ,base*2 );
			g.drawString(pressText, x,base*3 );
			g.drawString(time, x  ,(height - 160) / 2 );
			g.drawString(pressText,  x  ,base*4 );
			g.drawString(pressText, x ,base*5 );
			g.dispose();
			ImageIO.write((BufferedImage) image, "jpg", targetImg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static int getLength(String text) {
		int length = 0;
		for (int i = 0; i < text.length(); i++) {
			if (new String(text.charAt(i) + "").getBytes().length > 1) {
				length += 2;
			} else {
				length += 1;
			}
		}
		return length / 2;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Checks if the underlying input stream contains an image.
	 * 文件流检查太麻烦
	 * @param in
	 *            input stream of an image
	 * @return <code>true</code> if the underlying input stream contains an
	 *         image, else <code>false</code>
	 */
	@Deprecated
	public static boolean isImage(final InputStream in) {
		ImageInfo ii = new ImageInfo();
		ii.setInput(in);
		return ii.check();
	}

	/**
	 * 获得水印位置
	 * 
	 * @param width
	 *            原图宽度
	 * @param height
	 *            原图高度
	 * @param p
	 *            水印位置 1-5，其他值为随机。1：左上；2：右上；3：左下；4：右下；5：中央。
	 * @param offsetx
	 *            水平偏移。
	 * @param offsety
	 *            垂直偏移。
	 * @return 水印位置
	 */
	@Deprecated
	public static Position markPosition(int width, int height, int p,
			int offsetx, int offsety) {
		if (p < 1 || p > 5) {
			p = (int) (Math.random() * 5) + 1;
		}
		int x, y;
		switch (p) {
		// 左上
		case 1:
			x = offsetx;
			y = offsety;
			break;
		// 右上
		case 2:
			x = width + offsetx;
			y = offsety;
			break;
		// 左下
		case 3:
			x = offsetx;
			y = height + offsety;
			break;
		// 右下
		case 4:
			x = width + offsetx;
			y = height + offsety;
			break;
		// 中央
		case 5:
			x = (width / 2) + offsetx;
			y = (height / 2) + offsety;
			break;
		default:
			throw new RuntimeException("never reach ...");
		}
		return new Position(x, y);
	}

	/**
	 * 水印位置
	 * 
	 * 包含左边偏移量，右边偏移量。
	 * 
	 * @author liufang
	 * 
	 */
	@Deprecated
	public static class Position {
		private int x;
		private int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}

}
