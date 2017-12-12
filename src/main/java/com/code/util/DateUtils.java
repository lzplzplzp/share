/**
 * 
 */
package com.code.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 
/**
 * @author hezhengjun
 *   时间工具类
 */
public class DateUtils {
	private static Logger log = LoggerFactory.getLogger(DateUtils.class);
	public static final String MINUTE_ONLY_HHMM = "HHmm";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";


	/**
	 * 安全的格式化时间
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String safeFormatTime(Date date,String pattern){
		FastDateFormat fdf = FastDateFormat.getInstance(pattern);
		return fdf.format(date) ;
	}
	
	/**
	 * 判断给定的的小时和分钟是否比当前的Calendar时间小时和分谁大(比如，给定小时和分的时间是10点30 ,
	 *   现在Calendar时间为10点31,则给定时间--<--当前Calendar时间)
	 * @param cal
	 * @param hour
	 * @param minute
	 * @return 给定小时和分的时间>=当前时间返回true
	 */
	public static boolean isValidHourAndMinute(Calendar cal ,short hour,short minute){
		int timeHour = cal.get(Calendar.HOUR_OF_DAY) ;
		if( timeHour>hour){
			return false ;
		}
		if(timeHour ==hour&&cal.get(Calendar.MINUTE) >minute ){
			return false ;
		}
		return true ;
	}
	
	
	/**
	 * 格式化时间
	 * @param dateString
	 * @param pattern  yyyy-MM-dd
	 * @return
	 */
	public static Date dateToString(String dateString, String pattern) {
		SimpleDateFormat formatDate = new SimpleDateFormat(pattern);
		try {
			Date time = formatDate.parse(dateString);
			return time;
		} catch (ParseException e) {
			log.error("dateToString error:", e);
		}
		return null;
	}
 
	
	
	/**
	 * 以友好的方式显示时间
	 * @param req
	 * @param time
	 * @return
	 */
	public static String friendlyTime(Date date) {
		if(date==null){
			return "" ;
		}
		Calendar cal = Calendar.getInstance();
		int time = (int) ((cal.getTimeInMillis() - date.getTime()) / 1000);
		if (time < 60) {
			return "刚刚";
		}
		if (time > 86400) {
			int day = time / 86400;
			if (day == 1) {
				cal.setTime(date);
				return "昨天";
			} else if (day < 30) {
				return day + "天前";
			} else if (day < 360) {
				int moth = day / 30;
				return moth + "个月前";
			} else {
				int year = day / 360;
				return year + "年前";
			}
		} 
		else if (time > 3600) {
			int hour = time / 3600;
			return hour + "小时前";
		} else {
			int hour = time / 60;
			return hour + "分钟前";
		}
//		return "今天" ;
	}
	
	/**
	 * 计算是否在同一个天(24小时)
	 * @param oldTime
	 * @param newTime
	 * @return
	 */
	public static boolean isSameDay(long oldTime ,long newTime){
		long remain = newTime-oldTime ;
		if( remain < 86400000 ){
			return true ;
		}
		return false ;
	}
	
	/**
	 * 计算是否在1个小时内
	 * @param oldTime
	 * @param newTime
	 * @return
	 */
	public static boolean isSameHour(long oldTime ,long newTime){
		long remain = newTime-oldTime ;
		if( remain < 3600000 ){
			return true ;
		}
		return false ;
	}
	
	
	/**
	 * 计算是否在30分钟内
	 * @param oldTime
	 * @param newTime
	 * @return
	 */
	public static boolean isSameHalfHour(long oldTime ,long newTime){
		long remain = newTime-oldTime ;
		if( remain < 1800000 ){
			return true ;
		}
		return false ;
	}
	
	/**
	 * @description  获取当天的开始日期和时间
	 * @return   
	 * @throws ParseException
	 */
	public static Date getStartTimeDay() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * @description 获取几天前的日期时间
	 * @param day    具体几天 正数为几天以前 ,负数为几天以后
	 * @return
	 */
	public static Date getTimeAgo(int day){
		Calendar c = Calendar.getInstance();  
        c.add(Calendar.DATE, - day);  
       return c.getTime();
	}
	
	/**
	 * @description 获取指定时间几天前的日期时间
	 * @param day    具体几天 正数为几天以前 ,负数为几天以后
	 * @return
	 */
	public static Date getTimeDayAgo(Date start ,int day){
		Calendar c = Calendar.getInstance();  
		c.setTime(start); 
        c.add(Calendar.DATE, - day);  
       return c.getTime();
	}
	
	
	/**
	 * @description 获取几天前的日期时间的0点
	 * @param day    具体几天 正数为几天以前 ,负数为几天以后
	 * @return
	 */
	public static Date getTimeAgoZero(int day) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -day);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	
	/**
	 * @description 获取几天前的日期时间的0点
	 * @param day    具体几天 正数为几天以前 ,负数为几天以后
	 * @return
	 */
	public static Date getTimeAgoZero(Date start ,int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(start); 
		c.add(Calendar.DATE, -day);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	
	public static Date setTime(int year,int month,int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	/**
	 * @description 获取几天前的日期时间的23点59分59秒
	 * @param day    具体几天 正数为几天以前 ,负数为几天以后
	 * @return
	 */
	public static Date getTimeAgoTimeEnd(int day) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -day);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	
	
	
	/**
	 * 计算指定时间的多少分钟(之前minute为正，之后minute为负)
	 * @param now
	 * @param minute
	 * @return
	 */
	public static Date getTimeAgo(Date now, int minute) {
		minute = minute * 60 * 1000;
		long time = now.getTime() - minute;
		return new Date(time);
	}
	
	
	/**
	 * 获取当前时间到当天结束时间的秒数
	 * @description
	 * @return
	 */
	public static int getAgoLastTime(){
		 Calendar todayEnd = Calendar.getInstance();  
	     todayEnd.set(Calendar.HOUR_OF_DAY, 23);  
	     todayEnd.set(Calendar.MINUTE, 59);  
	     todayEnd.set(Calendar.SECOND, 59);  
		 long end = todayEnd.getTime().getTime();
         long start = new Date().getTime();
         return (int)((end - start)/1000);
		
	}
	
 
	
	
	
	/** 
     * 获取指定时间 月的 天数 
     * */  
    public static int getMonthDay(Date date) {  
          
        Calendar a = Calendar.getInstance(); 
        a.setTime(date);
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE);  
        return maxDate;  
    }
    
    /**
     * 得到上月的结束时间
     * @return
     */
    public static Date getLastEndDate(){
    	  //取得系统当前时间
        Calendar cal = Calendar.getInstance();
        //取得系统当前时间所在月第一天时间对象
        cal.set(Calendar.DAY_OF_MONTH, 1);
        //日期减一,取得上月最后一天时间对象
        cal.add(Calendar.DAY_OF_MONTH, -1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime() ;
    }
    
    /**
     * 得到上周的结束时间
     * @return
     */
	public static Date getLastWeekEndDate() {
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
		int offset2 = 7 - dayOfWeek;
		cal.add(Calendar.DATE, offset2 - 7);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime() ;
	}

    
    
    /**
     * 返回指定时间为年的第几月
     * @param date
     * @return 格式为: 年的第几月_年的第几周
     */
    public static Integer getMonth(Date date) {   
        Calendar a = Calendar.getInstance(); 
        a.setTime(date);
       return (a.get(Calendar.MONTH)+1) ;
    }
    
    /**
     * 返回指定时间为年的第几周
     * @param date
     * @return 
     */
    public static Integer  getWeek(Date date) {  
        Calendar a = Calendar.getInstance(); 
        a.setTime(date);
       return  a.get(Calendar.WEEK_OF_YEAR)  ;

    }
    
    
    public static Integer  getYear(Date date) {  
        Calendar a = Calendar.getInstance(); 
        a.setTime(date);
       return  a.get(Calendar.YEAR)  ;
    }
    
    /**
     * 返回指定日期的 当天的某个具体时间的date类型
     * @date        当天日期的Date类型
     * @hour		想要的时间
     * @minute      想要的分钟
     * @description 
     * @return
     */
    public static Date dayOfHourTime(Date date,int hour,int minute){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, hour);	
		calendar.set(Calendar.MINUTE, minute);	
		return calendar.getTime();//指定日期的10点
    }
    
    
 
    
    /**
     * 指定时间的下一年的结束时间(类似合同，比如2015.5.1到2017-04-30)
     * @return
     */
    public static Date setBackYearFrontDay(Date date){
  	   Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
  	   if(getMonthDay(calendar.getTime())==29){
  		 calendar.add(Calendar.DATE, -2);
  	   }else{
  		 calendar.add(Calendar.DATE, -1);
  	   }
       calendar.add(Calendar.YEAR, 1);
       return calendar.getTime() ; 
    }
	public static String getMinuteOnlyStrHHmm(Date date) {
		return safeFormatTime(date, MINUTE_ONLY_HHMM);
	}

	public static String getDayStr(Date date) {
		return safeFormatTime(date, YYYY_MM_DD);
	}
    
	
	public static void main(String[] args) throws InterruptedException {
	  	  Date date = setTime(2017, 2, 5) ;
	 Date s = 	getTimeAgoTimeEnd(0) ;
       System.out.println(safeFormatTime(date,"yyyy-MM-dd HH:mm:ss"));
       if(date.before(s)){  
    	   System.out.println("///////////");
       }

	}
	
}
