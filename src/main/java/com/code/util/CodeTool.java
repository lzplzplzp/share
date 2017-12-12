/**
 * 
 */
package com.code.util;


import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang.StringUtils;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.filter.predefined.DoubleRippleFilterFactory;
import org.patchca.filter.predefined.WobbleRippleFilterFactory;
//import org.patchca.filter.predefined.DiffuseRippleFilterFactory;
//import org.patchca.filter.predefined.DoubleRippleFilterFactory;
//import org.patchca.filter.predefined.MarbleRippleFilterFactory;
//import org.patchca.filter.predefined.WobbleRippleFilterFactory;
import org.patchca.service.Captcha;
import org.patchca.service.ConfigurableCaptchaService;

/**
 * 验证码工具类 6个长度 
 * @author 400
 *
 */
public class CodeTool {
	private static final ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
	public static final String validatePic = "vpc" ;
	static{
		//	cs.setColorFactory(new GradientColorFactory());  //彩色
			cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory())); //黑色
	}
    /**
     * 生成验证码     
     * 字母数为RandomWordFactory在设置
     * ConfigurableCaptchaService 图片大小设置
     * @return
     */
	public static Captcha createImage() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		int counter = random.nextInt(2);
		switch (counter) {
		case 0:
			cs.setFilterFactory(new CurvesRippleFilterFactory(cs
					.getColorFactory()));
			break;
		case 1:
			cs.setFilterFactory(new DoubleRippleFilterFactory());
			break;
		case 2:
			cs.setFilterFactory(new WobbleRippleFilterFactory());
			break;
//		case 3:  //看不清楚
//			cs.setFilterFactory(new MarbleRippleFilterFactory());
//			break;

//		case 4: //看不清楚
//			cs.setFilterFactory(new DiffuseRippleFilterFactory());
//			break;
//		}
		}
		//6,6,140,70
		//最小长度，最大长度，宽度，长度
		Captcha cap = cs.getCaptcha(6,6,140,70);
		return cap;

	}
	/**
	 * 正确返回1，验证码错误返回2，超时返回3
	 * @param request
	 * @param imgCode  图片验证码
	 * @return
	 */
	public static int checkimgCode(HttpServletRequest request, String imgCode){
		if(request==null || StringUtils.isBlank(imgCode)){
			return 2; // 验证码
		}
		Object code = request.getSession().getAttribute(validatePic);
		if(code==null){
			return 3;
		}
		if (!StringUtils.equalsIgnoreCase(imgCode, String.valueOf(code))) {
			return 2;
		}
		return 1 ;
	}
	public static void testPic(int pic){
		Captcha  cap = CodeTool.createImage() ;
		try {
			System.out.println(pic+"   "+cap.getChallenge()); 
			ImageIO.write(cap.getImage(), "jpg", new File("D:"+File.separator+"temp"+File.separator+pic+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
 
	public static void main(String[] args) throws IOException {
		testPic(12);
	}

}
