package com.code.model;

import java.util.Date;

/**
 * 活动短连接 活动计数
 */
public class JxActivityUrl {
    /**
     * id
     */
    private Integer id;

    /**
     * id
     */
    private Integer userId;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 活动id
     */
    private Integer activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 批次号
     */
    private Integer batchNum;

    /**
     * 短连接后面生成的随机标识
     */
    private String url;

    /**
     * 用户第一次打开是的id地址
     */
    private String ip;

    /**
     * 点击次数
     */
    private Integer clickCount;

    /**
     * 链接首次打开时间
     */
    private Date firstOpenTime;

    /**
     * 创建时间
     */
    private Date ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(Integer batchNum) {
        this.batchNum = batchNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Date getFirstOpenTime() {
        return firstOpenTime;
    }

    public void setFirstOpenTime(Date firstOpenTime) {
        this.firstOpenTime = firstOpenTime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}