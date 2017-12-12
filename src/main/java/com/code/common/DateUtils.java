package com.code.common;

import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Deprecated
public class DateUtils {

    private static final Logger LOG = LoggerFactory.getLogger(DateUtils.class);

    private static final SimpleDateFormat YEAR = getFormat("yyyy");
    private static final SimpleDateFormat MONTH_DAY = getFormat("MMdd");
    private static final SimpleDateFormat MONTH = getFormat("yyyy-MM");

    private static final SimpleDateFormat DAY = getFormat("yyyy-MM-dd");
    private static final SimpleDateFormat DAY_CHINA = getFormat("yyyy年MM月dd日");
    private static final SimpleDateFormat MONTH_CHINA = getFormat("MM月dd日");
    private static final SimpleDateFormat MONTH_DAY_CHINA = getFormat("MM月dd日HH点");

    private static final SimpleDateFormat HOUR = getFormat("yyyy-MM-dd HH");

    private static final SimpleDateFormat MINUTE = getFormat("yyyy-MM-dd HH:mm");

    private static final SimpleDateFormat SECOND = getFormat("yyyy-MM-dd HH:mm:ss");

    private static final SimpleDateFormat SECOND_ANOTHER = getFormat("yyyyMMddHHmmss");

    private static final SimpleDateFormat MONTH_ONLY = getFormat("MM");

    private static final SimpleDateFormat DAY_ONLY = getFormat("MM:dd");

    private static final SimpleDateFormat MINUTE_ONLY = getFormat("HH:mm");

    private static final SimpleDateFormat SECOND_ONLY = getFormat("HH:mm:ss");

    private static final SimpleDateFormat YEAR_DAY_NUMBER = getFormat("yyMMdd");

    private static final SimpleDateFormat DAY_NUMBER = getFormat("yyyyMMdd");

    private static final SimpleDateFormat MONTH_NUMBER = getFormat("yyyyMM");


    private static final SimpleDateFormat MINUTE_ANOTHER = getFormat("yyyyMMdd-HHmm");

    private static final SimpleDateFormat DAY_NUMBER__ANOTHER = getFormat("yyyMMdd");

    private static final String[] monthCinese = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};
    private static final String[] weekCinese = {"一", "二", "三", "四", "五", "六", "日"};


    public static String getYearStr(Date date) {
        synchronized (YEAR) {
            return getStr(date, YEAR);
        }
    }

    public static String getMonthDayStr(Date date) {
        synchronized (MONTH_DAY) {
            return getStr(date, MONTH_DAY);
        }
    }

    public static String getDayStrAnother(Date date) {
        synchronized (DAY_NUMBER__ANOTHER) {
            return getStr(date, DAY_NUMBER__ANOTHER);
        }
    }
    
    public static String getDayYYYYMMDD(Date date) {
        synchronized (DAY_NUMBER) {
            return getStr(date, DAY_NUMBER);
        }
    }

    public static String getYearStr(long date) {
        synchronized (YEAR) {
            return getStr(new Date(date), YEAR);
        }
    }

    public static String getMinuteDbStr(Date date) {
        synchronized (MINUTE_ANOTHER) {
            return getStr(date, MINUTE_ANOTHER);
        }
    }

    public static Date getMinuteDbDate(String str) {
        synchronized (MINUTE_ANOTHER) {
            return getDate(str, MINUTE_ANOTHER);
        }
    }

    public static String getMonthNumberStr(Date date) {
        synchronized (MONTH_NUMBER) {
            return getStr(date, MONTH_NUMBER);
        }
    }

    public static String getSecondOnlyStr(Date date) {
        synchronized (SECOND_ONLY) {
            return getStr(date, SECOND_ONLY);
        }
    }

    public static String getSecondAnotherOnlyStr(Date date) {
        synchronized (SECOND_ANOTHER) {
            return getStr(date, SECOND_ANOTHER);
        }
    }

    public static String getOnlyDayStr(long date) {
        synchronized (DAY_ONLY) {
            return getStr(new Date(date), DAY_ONLY);
        }
    }

    public static String getOnlyMonthStr(Date date) {
        synchronized (MONTH_ONLY) {
            return getStr(date, MONTH_ONLY);
        }
    }

    public static String getSecondDateStr(long date) {
        return getSecondStr(new Date(date));
    }

    public static String getSecondStr(long date) {
        return getSecondOnlyStr(new Date(date));
    }

    public static String getMinuteStr(Date date) {
        synchronized (MINUTE) {
            return getStr(date, MINUTE);
        }
    }

    public static String getMinuteStr(long date) {
        return getMinuteStr(new Date(date));
    }

    public static String getMinuteOnlyStr(Date date) {
        synchronized (MINUTE_ONLY) {
            return getStr(date, MINUTE_ONLY);
        }
    }

    public static String getSecondStr(Date date) {
        synchronized (SECOND) {
            return getStr(date, SECOND);
        }
    }

    public static String getDayStr(Date date) {
        synchronized (DAY) {
            return getStr(date, DAY);
        }
    }

    public static String getDayStrChina(Date date) {
        synchronized (DAY_CHINA) {
            return getStr(date, DAY_CHINA);
        }
    }

    public static String getMonthStrChina(Date date) {
        synchronized (MONTH_CHINA) {
            return getStr(date, MONTH_CHINA);
        }
    }

    public static String getMonthDayStrChina(Date date) {
        synchronized (MONTH_DAY_CHINA) {
            return getStr(date, MONTH_DAY_CHINA);
        }
    }

    public static int getDayNumber(Date date) {
        if (date == null) {
            return 0;
        }
        synchronized (DAY_NUMBER) {
            return Integer.valueOf(getStr(date, DAY_NUMBER));
        }
    }

    public static int getYYDayNumber(Date date) {
        if (date == null) {
            return 0;
        }
        synchronized (YEAR_DAY_NUMBER) {
            return Integer.valueOf(getStr(date, YEAR_DAY_NUMBER));
        }
    }

    /**
     * 获得输入时间的当天开始时间，去掉了毫秒
     * 例如输入：2015-07-31 11:47:18
     * 输出：2015-07-31 00:00:00
     *
     * @param date
     * @return
     */
    public static Date getDayDate(Date date) {
        return getDayDate(getDayStr(date));
    }

    public static String getDayStr(long date) {
        return getDayStr(new Date(date));
    }

    public static Date getSecondDate(String dateStr) {
        synchronized (SECOND) {
            return getDate(dateStr, SECOND);
        }
    }

    public static Date getDayDate(String dateStr) {
        synchronized (DAY) {
            return getDate(dateStr, DAY);
        }
    }

    public static Date getMinuteOnlyDate(String dateStr) {
        synchronized (MINUTE_ONLY) {
            return getDate(dateStr, MINUTE_ONLY);
        }
    }

    public static Date getMinuteDate(String dateStr) {
        synchronized (MINUTE) {
            return getDate(dateStr, MINUTE);
        }
    }

    public static Date getMinuteDate(long time) {
        return getMinuteDate(getMinuteStr(time));
    }

    /**
     * 在输入时间(date)的基础上加offset天
     * 比如输入date:2015-08-01 11:29:46, offset:1
     * return:2015-08-02 11:29:46
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date daysAddOrSub(Date date, int offset) {
        return addOrSub(date, Calendar.DAY_OF_MONTH, offset);
    }

    public static Date hoursAddOrSub(Date date, int offset) {
        return addOrSub(date, Calendar.HOUR_OF_DAY, offset);
    }

    public static Date minutesAddOrSub(Date date, int offset) {
        return addOrSub(date, Calendar.MINUTE, offset);
    }

    public static Date secondsAddOrSub(Date date, int offset) {
        return addOrSub(date, Calendar.SECOND, offset);
    }

    private static Date addOrSub(Date date, int type, int offset) {
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.get(type);
        cal.set(type, cal.get(type) + offset);
        return cal.getTime();
    }

    private static String getStr(Date date, SimpleDateFormat format) {
        if (date == null) {
            return "";
        }
        return format.format(date);
    }

    private static SimpleDateFormat getFormat(String format) {
        return new SimpleDateFormat(format);
    }

    private static Date getDate(String dateStr, SimpleDateFormat format) {
        if ("".equals(dateStr) || dateStr == null)
            return null;
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            LOG.error("format yyyy-MM-dd HH:mm:ss error:", e);
        }
        return null;
    }

    // /////////////////////////////////time
    // tools///////////////////////////////

    /**
     * 是否为TimeString 样式的String 00:00 - 23:59
     *
     * @param toCheck
     * @return
     */
    public static boolean isTimeString(String toCheck) {
        if (!StringUtils.isNotBlank(toCheck)) {
            return false;
        }
        if (toCheck.trim().matches("([0-1][0-9]|2[0-3]):[0-5][0-9]|24:00"))
            return true;
        else
            return false;
    }

    /**
     * 比较两个TimeString 的大小
     *
     * @param ts1
     * @param ts2
     * @return
     */
    public static int compareHHmmInString(String ts1, String ts2) {
        return ts1.compareTo(ts2);
    }

    /**
     * 检测是否在开始与结束之间，前闭后开区间 -1： start 不小于end 0: 不在start 与end之间 1: 在start与end之间
     *
     * @param ts
     * @param start
     * @param end
     * @return
     */
    public static int betweenHHmmInString(String ts, String start, String end) {
        if (compareHHmmInString(start, end) >= 0)
            return -1;
        if (compareHHmmInString(ts, start) < 0)
            return 0;
        if (compareHHmmInString(end, ts) < 0)
            return 0;
        return 1;
    }

    /**
     * 检测两个时间是否相等, 00:00 == 24:00
     *
     * @param ts1
     * @param ts2
     * @return
     */
    public static boolean equalsInTimeString(String ts1, String ts2) {
        if (ts1.equals(ts2))
            return true;
        if (ts1.equals("00:00") || ts1.equals("24:00")) {
            if (ts2.equals("00:00") || ts2.equals("24:00")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检测是否为同一个小时和分钟. 1: cal>c; 0:cal=c; -1:cal<c
     */
    public static int compareHHmm(Calendar cal, Calendar c) {
        if (cal.get(Calendar.HOUR_OF_DAY) > c.get(Calendar.HOUR_OF_DAY)) {
            return 1;
        } else if (cal.get(Calendar.HOUR_OF_DAY) == c.get(Calendar.HOUR_OF_DAY)) {
            if (cal.get(Calendar.MINUTE) > c.get(Calendar.MINUTE))
                return 1;
            else if (cal.get(Calendar.MINUTE) == c.get(Calendar.MINUTE))
                return 0;
            else
                return -1;
        } else
            return -1;
    }

    /**
     * 检测是否在开始与结束之间，闭区间 -1： start 不小于end 0: 不在start 与end之间 1: 在start与end之间
     *
     * @param cal
     * @param start
     * @param end
     * @return
     */
    public static int betweenHHmm(Calendar cal, Calendar start, Calendar end) {
        if (compareHHmm(start, end) != -1)
            return -1;
        if (compareHHmm(cal, start) == -1)
            return 0;
        if (compareHHmm(end, cal) == -1)
            return 0;
        return 1;
    }

    /**
     * 检测是否为同在一天. 1: cal>c; 0:cal=c; -1:cal<c
     */
    public static boolean compareDay(Calendar cal, Calendar c) {
        if (cal.get(Calendar.MONTH) == c.get(Calendar.MONTH)
                && cal.get(Calendar.DAY_OF_MONTH) == c
                .get(Calendar.DAY_OF_MONTH))
            return true;
        else
            return false;
    }

    /**
     * 将00:00格式的字符串转为Calender
     *
     * @param timeString
     * @return Calender
     * @throws Exception
     */
    public static Calendar string2calendar(String timeString) throws Exception {
        if (!DateUtils.isTimeString(timeString))
            throw new Exception("Wrong argument : timeString format error "
                    + timeString);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, getHour(timeString));
        cal.set(Calendar.MINUTE, getMinute(timeString));
        return cal;
    }

    /**
     * 将calendar转为HH:MM格式的字符串
     *
     * @param cal
     * @return
     */
    public static String calendar2TimeString(Calendar cal) {
        return (cal.get(Calendar.HOUR_OF_DAY) > 9 ? cal
                .get(Calendar.HOUR_OF_DAY) : "0"
                + cal.get(Calendar.HOUR_OF_DAY))
                + ":"
                + (cal.get(Calendar.MINUTE) > 9 ? cal.get(Calendar.MINUTE)
                : "0" + cal.get(Calendar.MINUTE));
    }

    /**
     * TimeString 中得到小时信息
     *
     * @param timeString
     * @return
     */
    public static int getHour(String timeString) {
        return Integer.parseInt(timeString.substring(0, 2));
    }

    /**
     * TimeString 中得到分钟信息
     *
     * @param timeString
     * @return
     */
    public static int getMinute(String timeString) {
        return Integer.parseInt(timeString.substring(3, 5));
    }

    public static String getDateStringFromMinute(String minute) {
        return minute.substring(5, 10);
    }

    public static String getMiniteOnlyFromMinute(String minute) {
        return minute.substring(11, 16);
    }

//    public static boolean isMiniteDate(String str) {
//        if (str == null) {
//            return false;
//        }
//        try {
//            MINUTE_ONLY.parse(str);
//            return true;
//        } catch (Exception e) {
//        }
//        return false;
//    }

    public static long getMiniteDate(Date date, String str) {
        if (str == null)
            return 0;
        return getMinuteDate(getDayStr(date) + " " + str).getTime();
    }

    /**
     * 从Date的字符串中只得到月日信息
     *
     * @param dateString
     * @return
     */
    public static String getDateOnlyFromDate(String dateString) {
        return dateString.substring(5, 10);
    }

    @SuppressWarnings("deprecation")
    public static Date getDayByDate(Date date) {
        date.setHours(0);
        date.setSeconds(0);
        date.setMinutes(0);
        return date;
    }

    public static Date getTodayByDate() {
        return getDayDate(new Date());
    }

    // /////////////////////////////date tools////////////////////////////

    /**
     * 将calendar转为MM:DD格式的字符串
     *
     * @param cal
     * @return
     */
    public static String calendar2DateString(Calendar cal) {
        return (cal.get(Calendar.MONTH) + 1 > 9 ? cal.get(Calendar.MONTH) + 1
                : "0" + (cal.get(Calendar.MONTH) + 1))
                + ":"
                + (cal.get(Calendar.DAY_OF_MONTH) > 9 ? cal
                .get(Calendar.DAY_OF_MONTH) : "0"
                + cal.get(Calendar.DAY_OF_MONTH));
    }

    public static boolean isDateString(String toCheck) {
        if (toCheck == null)
            return false;
        if (toCheck.trim().matches("(0[0-9]|1[0-2]):([0-2][0-9]|3[0-1])"))
            return true;
        else
            return false;
    }

    /**
     * 将日期格式的字符串转换为日期类型
     *
     * @param date 支持 yyyy, yyyy-MM, yyyy-MM-dd, yyyy-MM-dd HH, yyyy-MM-dd HH:mm, yyyy-MM-dd HH:mm:dd
     * @return
     */
    @Deprecated
    public static Date toDate(String date) {
        try {
            if (date.length() == 4) {
                return YEAR.parse(date);
            } else if (date.length() == 7) {
                return MONTH.parse(date);
            } else if (date.length() == 10) {
                return DAY.parse(date);
            } else if (date.length() == 13) {
                return HOUR.parse(date);
            } else if (date.length() == 16) {
                return MINUTE.parse(date);
            } else if (date.length() == 19) {
                return SECOND.parse(date);
            } else {
                throw new IllegalArgumentException("unknown date format(" + date + ")");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("unknown date format(" + date + ")");
        }
    }

    /**
     * 获取两个日期相差的天数
     *
     * @param smdate开始时间
     * @param bdate结束时间
     * @return
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 获取格式化后的日期
     *
     * @param date   日期对象
     * @param format 期望的日期格式
     * @return 格式化后的日期字符串
     */
    public static String getFormatdate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 把yyyyMMdd日期转换为yyyy-MM-dd
     *
     * @param umDate 日期字符串yyyyMMdd
     * @return 日期字符串yyyy-MM-dd
     */
    public static String getYeeDateFromUm(String umDate) {
        return umDate.substring(0, 4) + "-" + umDate.substring(4, 6) + "-" + umDate.substring(6, 8);
    }

    /**
     * 检测该时间是否在1-28日之间（包括1-28）
     *
     * @param length
     * @return
     */
    public static boolean dayIn(Integer length) {
        if (1 <= length.intValue() && 28 >= length.intValue()) {
            return true;
        }
        return false;
    }

    /**
     * 两个时间差，要精确到小时
     *
     * @param
     * @return
     */
    public static double getDistanceHours(Date start, Date end) {
        long cha = end.getTime() - start.getTime();
        double result = cha * 1.0 / (1000 * 60 * 60);
        return result;
    }

    /**
     * 有效截至日期
     *
     * @param day
     * @return
     */
    public static Date getValidTime(Date validTime, int day) {
        validTime = DateUtils.getDayDate(validTime);
        validTime = DateUtils.daysAddOrSub(validTime, day);
        validTime = DateUtils.secondsAddOrSub(validTime, -1);

        return validTime;
    }

    /**
     * 参数日期是几号
     *
     * @param date
     * @return
     */
    public static int getCalendarDay(Date date) {
        Calendar cal = Calendar.getInstance();
        int calDate = cal.get(Calendar.DATE);
        return calDate;
    }

    /**
     * 每月月初
     *
     * @param month 0：当月
     * @return
     */
    public static Date getDayYc(int month) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, month);
        // 月初
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date dayYc = DateUtils.getDayDate(cal.getTime());
        return dayYc;
    }

    /**
     * 获取当前月份月初
     *
     * @param now 当前时间
     * @return
     */
    public static Date getCurrentMonthFirstDay(Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return getDayDate(calendar.getTime());
    }

    /**
     * 获取下个月份月初
     *
     * @param now 当前时间
     * @return
     */
    public static Date getNextMonthFirstDay(Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getCurrentMonthFirstDay(now));
        calendar.add(Calendar.MONTH, 1);
        return getDayDate(calendar.getTime());
    }

    /**
     * 获取中文月份
     *
     * @param month 月份
     */
    public static String getMonthChineseStr(Integer month) {
        if (month == null || month <= 0 || month > 12) {
            return "";
        }
        return monthCinese[month - 1];
    }

    /**
     * 获取中文月份
     *
     * @param date 时间
     */
    public static String getMonthChineseStr(Date date) {
        String monthStr = getOnlyMonthStr(date);
        return getMonthChineseStr(Integer.valueOf(monthStr));
    }

    public static Date getEarlyTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        return calendar.getTime();
    }

    /**
     * 获取今天剩余秒数
     *
     * @return
     */
    public static long getTodayResidueSeconds() {
        Date lastDate = getDayDate(daysAddOrSub(new Date(), 1));
        return (lastDate.getTime() - new Date().getTime()) / 1000;
    }

    public static Boolean isOneDay(Date date1, Date date2) {
        Long time = date1.getTime() - date2.getTime();
        time = Math.abs(time);
        time = time / (24 * 60 * 60 * 1000L);
        return time == 0;
    }

    /**
     * 获取中文周几
     *
     * @param date
     * @return
     */
    public static String getDayChineseStr(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (day < 2) {
            day += 7;
        }
        return "周" + weekCinese[day - 2];
    }

    /**
     * 比两个时间 大小
     *
     * @param dt1
     * @param dt2
     * @return 1 dt1>dt2 -1 dt1<dt2  0 相等
     */
    public static int compareDate(Date dt1, Date dt2) {
        if (dt1.getTime() > dt2.getTime()) {
            System.out.println("dt1>dt2");
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            System.out.println("dt1<dt2");
            return -1;
        } else {
            System.out.println("dt1=dt2");
            return 0;
        }
    }

    /**
     * 字符串转成时间
     *
     * @param str
     * @param format
     * @return
     */
    public static Date getDateFormat(String str, String format) throws ParseException {
        if (str == null || StringUtils.isEmpty(str))
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(str);
    }

    /**
     * 当前时间增加 xx 毫秒
     * @param times 
     * @return
     */
    public static Date addDate(long times){
    	Date date = new Date();
    	return new Date(date.getTime()+times) ;
    }
    
    
    
    public static void main(String[] args) throws ParseException {

        List<String> list=new ArrayList<String>();

        HashSet<String> h=new HashSet<String>();
        List<String> list1=new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2=new ArrayList<String>();
        list2.add("a");
        list2.add("d");
        list2.add("e");
//        list.addAll(list1);
//        list.addAll(list2);

        h.addAll(list1);
        h.addAll(list2);

        List<String> list11 = new ArrayList<String>(h);
        Collections.sort(list11, Collator.getInstance(java.util.Locale.CHINA));
        for (String item: list11) {
            System.out.println(item);
            int sumCount=0;
            for (String item1:
                 list1) {
                if(item==item1)
                {
                    sumCount++;
                    break;
                }
            }
            for (String item2:
                    list2) {
                if(item==item2)
                {
                    sumCount++;
                    break;
                }
            }

            list.add(item+sumCount);



        }

        for (String item: list) {


            System.out.println(item);
        }

        /*for(Iterator it=h.iterator();it.hasNext();)
        {
            System.out.println(it.next());



        }*/

//        Collections.sort(list, Collator.getInstance(java.util.Locale.CHINA));
//        for (String item: list) {
//
//
//            System.out.println(item);
//        }




      /*  Date date1=new Date();
      System.out.println(date1);
        System.out.println(addDate(30*60*1000));*/
       
    }
    
	/**
	 * 日期公共函数
	 * @author  shenjunjie
	 * @version  [s001, 2010-11-19]
	 * 
	 * public static final int DAY_OF_WEEK_IN_MONTHget 和 set 的字段数字，指示当前月中的第几个星期。
	 * 与 DAY_OF_WEEK 字段一起使用时，就可以唯一地指定某月中的某一天。
	 * 与 WEEK_OF_MONTH 和 WEEK_OF_YEAR 不同，
	 * 该字段的值并不 取决于 getFirstDayOfWeek() 或 getMinimalDaysInFirstWeek()。
	 * DAY_OF_MONTH 1 到 7 总是对应于 DAY_OF_WEEK_IN_MONTH 1；8 到 14 总是对应于 DAY_OF_WEEK_IN_MONTH 2，
	 * 依此类推。DAY_OF_WEEK_IN_MONTH 0 表示 DAY_OF_WEEK_IN_MONTH 1 之前的那个星期。
	 * 负值是从一个月的末尾开始逆向计数，因此，一个月的最后一个星期天被指定为 DAY_OF_WEEK = SUNDAY, 
	 * DAY_OF_WEEK_IN_MONTH = -1。因为负值是逆向计数的，所以它们在月份中的对齐方式通常与正值的不同。
	 * 例如，如果一个月有 31 天，那么 DAY_OF_WEEK_IN_MONTH -1 将与 DAY_OF_WEEK_IN_MONTH 5 
	 * 和 DAY_OF_WEEK_IN_MONTH 4 的末尾相重叠。
	 */

    private static List <Calendar> holidayList;
    private static boolean holidayFlag;
 
    /**
     * 计算工作日
     * 具体节日包含哪些,可以在HolidayMap中修改
     * @param src 日期(源)
     * @param adddays 要加的天数
     * @exception throws [违例类型] [违例说明]
     * @version  [s001, 2010-11-19]
     * @author  shenjunjie
     */
    public static Calendar addDateByWorkDay(Calendar src,int adddays) {
//	        Calendar result = null;
        holidayFlag = false;
        for (int i = 0; i < adddays; i++)
        {
            //把源日期加一天
            src.add(Calendar.DAY_OF_MONTH, 1);
            holidayFlag =checkHoliday(src);
            if(holidayFlag)
            {
               i--;
            }
//            System.out.println(src.getTime());
        }
//        System.out.println("Final Result:"+src.getTime());
        return src;
    }
 
    /**
     * 校验指定的日期是否在节日列表中
     * 具体节日包含哪些,可以在HolidayMap中修改
     * @param src 要校验的日期(源)
     * @version  [s001, 2010-11-19]
     * @author  shenjunjie
     */
    public static boolean checkHoliday(Calendar src) {
        boolean result = false;
        if (holidayList == null)
        {
            initHolidayList();
        }
        //先检查是否是周六周日(有些国家是周五周六)
        if (src.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || src.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
        {
            return true;
        }
        for (Calendar c : holidayList)
        {
            if (src.get(Calendar.MONTH) == c.get(Calendar.MONTH)
                    && src.get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH))
            {
                result = true;
            }
        }
        return result;
    }
 
    /**
     * 初始化节日List,如果需要加入新的节日,请在这里添加
     * 加的时候请尽量使用Calendar自带的常量而不是魔鬼数字
     * 注:年份可以随便写,因为比的时候只比月份和天
     * @version  [s001, 2010-11-19]
     * @author  shenjunjie
     */
    private static void initHolidayList() {
        holidayList = new ArrayList();
 
        //五一劳动节
        Calendar may1 = Calendar.getInstance();
        may1.set(Calendar.MONTH,Calendar.MAY);
        may1.set(Calendar.DAY_OF_MONTH,1);
        holidayList.add(may1);
 
        Calendar may2 = Calendar.getInstance();
        may2.set(Calendar.MONTH,Calendar.MAY);
        may2.set(Calendar.DAY_OF_MONTH,2);
        holidayList.add(may2);
 
        Calendar may3 = Calendar.getInstance();
        may3.set(Calendar.MONTH,Calendar.MAY);
        may3.set(Calendar.DAY_OF_MONTH,3);
        holidayList.add(may3);
 
        Calendar h3 = Calendar.getInstance();
        h3.set(2000, 1, 1);
        holidayList.add(h3);
 
        Calendar h4 = Calendar.getInstance();
        h4.set(2000, 12, 25);
        holidayList.add(h4);
 
        //中国母亲节：五月的第二个星期日
        Calendar may5 = Calendar.getInstance();
        //设置月份为5月
        may5.set(Calendar.MONTH,Calendar.MAY);
        //设置星期:第2个星期
        may5.set(Calendar.DAY_OF_WEEK_IN_MONTH,2);
        //星期日
        may5.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
//	        System.out.println(may5.getTime());
 
        holidayList.add(may5);
    }
}