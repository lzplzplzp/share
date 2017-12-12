package com.code.dao.mapper;

import com.code.model.Activity;

import java.util.List;
import java.util.Map;


public interface ActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKeyWithBLOBs(Activity record);

    int updateByPrimaryKey(Activity record);

    void addAppShowCount(Integer id);

    Integer getAppShowCount(Integer id);

    void addPubUserCount(Integer id);

    void addwxShowCount(Integer id);

    void addJoinUserCount(Integer id);

    void addDownlodaCount(Integer id);

    void addBuyUserCount(Integer id);

    void addRegCount(Integer id);

    List<Activity> getActivitys();

    List<Activity> getActivitys2();

    void addDownloadCount(Integer id);
    /**
     * 后台对活动的列表显示
     */
    List<Activity> backFindByPage(Map<String, Object> mapper);

    long backFindPageCount(Map<String, Object> mapper);

    /**
     * 获取所有在banner条上显示，并正在开展的活动列表
     * @param isTest
     */
    List<Activity> getBannerActivityList(Map<String, Object> mapper);

    /**
     * 获取所有在top条上显示，并正在开展的活动列表
     * @param isTest
     */
    List<Activity> getTopActivityList(Map<String, Object> mapper);

    /**
     * 获取有效的活动
     * @param endTime
     */
    List<Activity> getValidateActivityList(Map<String, Object> mapper);

    /**
     * 获取活动列表
     * @return
     */
    List<Activity> getActivityList();

    /**
     * 获取活动列表
     * @return
     */
    List<Activity> getValidateUnKnownActivityList(Map<String, Object> mapper);
}