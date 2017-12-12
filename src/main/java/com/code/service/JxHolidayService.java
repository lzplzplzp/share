package com.code.service;

import com.alibaba.fastjson.JSONArray;
import com.code.constant.SystemConstant;
import com.code.util.DateUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class JxHolidayService {
    @Autowired
    private SysConfService sysConfService;
    
    
    /**
     * 查看传入日期能否进行大额提现
     * Author : huoche
     * @param date
     * @return
     */
	public boolean canLargeAmountWithdraw(Date date){
    	 Set<String> holidaySet = getHolidaySet();
         int timeStr= DateUtils.getMinuteOnlyStrHHmm(date)==null?0:Integer.valueOf(DateUtils.getMinuteOnlyStrHHmm(date));
         if(timeStr<930||timeStr>1630){
        	 return false;
         }
         String dateStr = DateUtils.getDayStr(date);
         if (holidaySet.contains(dateStr)) {
             return false;
         } else {
             return true;
         }
    }

    /**
     * 返回日期字符串(11月11日)
     * 1.在endTime+1的基础上，加上day天
     * 2.查看该日期是否是节假日，如果是，再加1天，直到获得不是节假日
     * 3.返回需要的字段
     *
     * @param endTime 结束时间
     * @param day 在end的基础上，加几天
     * @return 安盈宝1234期已结息，本息100000.00元于下一工作日11月11日17点左右（具体时间以银行准）打入您尾号1111的银行卡。
     */
    public String getRepayTime(Date endTime, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(endTime);
        cal.add(Calendar.DATE, day);
        Set<String> holidaySet = getHolidaySet();
        Date repayTime = getWorkingDays(cal, holidaySet);
        SimpleDateFormat mmdd = new SimpleDateFormat("MM月dd日");
        return mmdd.format(repayTime);
    }

    /**
     * 返回日期字符串(2015-12-28)
     * 1.在endTime+1的基础上，加上day天
     * 2.查看该日期是否是节假日，如果是，再加1天，直到获得不是节假日
     * 3.返回需要的字段
     *
     * @param endTime 结束时间
     * @param day 在end的基础上，加几天
     * @return
     */
    public String getRepayTimeByYYYYMMHH(Date endTime, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(endTime);
        cal.add(Calendar.DATE, day);
        Set<String> holidaySet = getHolidaySet();
        Date repayTime = getWorkingDays(cal, holidaySet);
        return DateUtils.getDayStr(repayTime);
    }

   /* public String getRepayTimeByYYYYMMHHForNoGang(Date endTime, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(endTime);
        cal.add(Calendar.DATE, day);
        Set<String> holidaySet = getHolidaySet();
        Date repayTime = getWorkingDays(cal, holidaySet);
    	return DateUtils.getDayYYYYMMDD(repayTime);
    }*/
    private Date getWorkingDays(Calendar cal, Set<String> holidaySet) {
        String date = DateUtils.getDayStr(cal.getTime());
        if (holidaySet.contains(date)) {
            cal.add(Calendar.DATE, 1);
            return getWorkingDays(cal, holidaySet);
        } else {
            return cal.getTime();
        }
    }


    /**
     * 获取节假日的set
     *
     * @return
     */
    private Set<String> getHolidaySet() {
        @SuppressWarnings("unchecked")
        HashSet<String> holidaySet = new HashSet<String>();
            String holidayStrs = sysConfService.selectValByKey(SystemConstant.Conf.HOLIDAY.getAttr());
            String[] holidayArr = holidayStrs.split(",");
            CollectionUtils.addAll(holidaySet, holidayArr);
        return holidaySet;
    }

    public Boolean isWorkingDay(Date date) {
        String dateStr = DateUtils.getDayStr(date);
        return !getHolidaySet().contains(dateStr);
    }

    /**
     * 判断是否为工作日
     *
     * @param calendar
     * @return true=工作日、false=节假日
     */
    public Boolean isWorkingDay(Calendar calendar) {
        String date = DateUtils.getDayStr(calendar.getTime());
        return !getHolidaySet().contains(date);
    }

    /**
     * 获取下一个工作日
     *
     * @param date
     * @return
     */
    /*public Date getNextWorkingDay(Date date) {
        date = DateUtils.getDayDate(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return getWorkingDays(calendar, getHolidaySet());
    }*/

    /**
     * 获取上一个工作日
     *
     * @param date
     * @return
     */
    /*public Date getPreWorkingDay(Date date) {
        date = DateUtils.getDayDate(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return getPreWorkingDays(calendar, getHolidaySet());
    }*/

    private Date getPreWorkingDays(Calendar cal, Set<String> holidaySet) {
        String date = DateUtils.getDayStr(cal.getTime());
        if (holidaySet.contains(date)) {
            cal.add(Calendar.DATE, -1);
            return getPreWorkingDays(cal, holidaySet);
        } else {
            return cal.getTime();
        }
    }


   /* public RepayHolidayDto isInFutureHoliday(Date endTime) {
        HashMap<String, RepayHolidayDto> hashMap = futureHoliday();
        String key = DateUtil.getFormatdate(endTime, "yyyy-MM-dd");
        return hashMap.get(key);
    }


    private HashMap<String, RepayHolidayDto> futureHoliday() {
        String key = DigestUtils.md5Hex(CacheConstans.FUTURE_HOLIDAYS);
        @SuppressWarnings("unchecked")
        HashMap<String, RepayHolidayDto> retMap = (HashMap<String, RepayHolidayDto>) redisComponent.get(key);
        if (retMap == null) {
            String futureHolidayStr = sysConfService.selectValByKey(Conf.FUTURE_HOLIDAY.getAttr());
            retMap = new HashMap<String, RepayHolidayDto>();
            List<RepayHolidayDto> futureHolidayList2 = JSONArray.parseArray(futureHolidayStr, RepayHolidayDto.class);
            for (RepayHolidayDto repayHolidayDto : futureHolidayList2) {
                retMap.put(DateUtil.getFormatdate(repayHolidayDto.getEndTime(), "yyyy-MM-dd"), repayHolidayDto);
            }
            redisComponent.set(key, retMap, 365 * 24 * 60 * 60L);//放一年缓存
        }
        return retMap;
    }*/
}
