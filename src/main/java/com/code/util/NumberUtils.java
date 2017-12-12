package com.code.util;

import java.math.BigDecimal;
 


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
 


public class NumberUtils {
	/**
	 * 随生成 指定最小值 和 最大值之间的随机数  包含最小值 不包含最大值
	 * @description
	 * @return
	 */
	public static int randomBetween(int min,int max ){
		return (int) (Math.random()*(max-min)+min);
	}
	
	/**
	 * 获取指定数范围的随机数
	 * @description
	 * @param num
	 * @return
	 */
	public static int randomInt(int num){
		return RandomUtils.nextInt(num);
	}
	
	/** 
	* 分变元
	* @param v1 乘数  钱  单位分
	*  
	*/  
	public static double feiToyuan(int money) {
		BigDecimal b1 = new BigDecimal(money);
		BigDecimal b2 = new BigDecimal(0.01);
		double dMoney = b1.multiply(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() ;
		return dMoney;
	}
	
  

    /**
     * 元转分
     *
     * @param bigDecimal 元
     * @return 分
     */
    public static int yuan2Fen(String bigDecimal) {
    	
        if (StringUtils.isNotBlank(bigDecimal)) { 
            return   new BigDecimal(bigDecimal).multiply(new BigDecimal(100)).intValue() ;
        }
        return 0;
    }
	
	
	public static void main(String[] args) {  
//		final ExecutorService exec = Executors.newFixedThreadPool(1); 
//		exec.submit(new Runnable() {
//			@Override
//			public void run() {
//				//
//				
//			}
//		}) ;
		
		System.out.println(feiToyuan(99)); 
		 
		
		
//		int money = 99;
//		BigDecimal b1 = new BigDecimal(money);
//		BigDecimal b2 = new BigDecimal(0.01);
//		double dMoney = b1.multiply(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() ;
//		System.out.println(dMoney); 
	}
}
