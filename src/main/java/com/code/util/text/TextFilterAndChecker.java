package com.code.util.text;

import org.apache.commons.lang3.StringUtils;

/**
 *  
 *  标题检查escapeText 前的长度
 *  内容检查escapeText后的长度
 * 
 */
public class TextFilterAndChecker {
	
	public static final int titleMin = 4;
	
	public static final int titleMax = 100;
	/**
	 * 主题和回复一样
	 */
	public static final int contentMax = 20000 ;
	/**
	 * 主题和回复一样
	 */
	public static final int contentMin = 4 ;
	/**
	 * 评论为第三级
	 */
	public static final int commentMin = 4;
	/**
	 * 评论为第三级
	 */
	public static final int commentMax = 100;
	
	/**
	 * 过滤文本是否包含敏感词
	 * @param txt
	 * @return 包含返回true  TODO 暂不实现为不包含false
	 */
	public static boolean hasSensitiveWord(String txt){
		return false ;
	}

	/**
	 * 检查长度--标题检查escapeText 前的长度,内容检查escapeText后的长度
	 * @param text
	 * @param min
	 * @param max
	 * @return 符合要求为true
	 */
	public static boolean checkLength(String text,int min,int max){
		if(StringUtils.isBlank(text)){
			return false ;
		}
		if(text.length()>=min && text.length()<= max){
			return true ;
		}
		return false ;
	}
}
