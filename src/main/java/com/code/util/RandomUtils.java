package com.code.util;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 石头
 * @author 单车
 */
public class RandomUtils {


	/**
	 * 根据用户id 活动id 批次号生成随机数
	 * @param userId     用户id
	 * @param activityId 活动id
	 * @param batchNum   批次号,第一次值传1
	 * @return
	 */
	public static String encodeRandom(int userId, int activityId, int batchNum) {
		if (activityId >= 46656) {
			throw new RuntimeException("activityId超过46655次了");
		}
		if (batchNum < 1 ) {
			throw new RuntimeException("batchNum最小值为1");
		}
		batchNum--;
		if (batchNum >= 36) {
			throw new RuntimeException("batchNum超过35次了");
		}
		String activity = getFixationLength(Integer.toString(activityId, 36), 3);
		String batch = Integer.toString(batchNum, 36);
		return activity + batch + Integer.toString(userId, 36);
	}

	private static String getFixationLength(String str, int wishLength){
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ;i<(wishLength-str.length());i++){
			sb.append("0");
		}
		return sb.append(str).toString();
	}



	/**
	 * 根据随机数解析出 用户id 活动id 批次号
	 * @param random
	 * @return
	 */
	public static Map<String, Integer> decodeRandom(String random){
		if(StringUtils.isBlank(random)){
			throw new RuntimeException("random is null ");
		}
		if(random.trim().length()<4){
			throw new RuntimeException("random值不正确，请检查");
		}
		Map<String, Integer> map = new HashMap<>();
		Integer activityId = Integer.valueOf(random.substring(0, 3), 36) ; //第1到3位为活动id
		Integer batchNum = Integer.valueOf(random.substring(3, 4), 36);//第4位为活动批次号
		Integer userId = Integer.valueOf(random.substring(4), 36);
		map.put("userId", userId);
		map.put("activityId", activityId);
		map.put("batchNum", ++batchNum);
		return map;
	}

}
