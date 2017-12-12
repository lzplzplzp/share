package com.code.model;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String url;

    private String name;

    private String img;

    private Integer appShowCount;

    private Integer wxShowCount;

    private Integer pubUserCount;

    private Integer joinUserCount;

    private Integer downloadCount;

    private Integer regCount;

    private Integer buyUserCount;

    /**
     * 活动专区的优先级别，小于等于0不显示
     */
    private Integer priority;

    private Integer status;

    private Date ctime;

    private Date beginTime;

    private Date endTime;

    private String detail;
    
    private String channel;
    /**
     * 屏蔽的版本
     */
    private String screenVersion;

    /**
     * 是否新人活动
     */
    private Integer isNewbie;
    
    /**
     * 重点推荐活动的优先级别，小等于0不显示
     */
    private Integer priorityTop;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getAppShowCount() {
        return appShowCount;
    }

    public void setAppShowCount(Integer appShowCount) {
        this.appShowCount = appShowCount;
    }

    public Integer getWxShowCount() {
        return wxShowCount;
    }

    public void setWxShowCount(Integer wxShowCount) {
        this.wxShowCount = wxShowCount;
    }

    public Integer getPubUserCount() {
        return pubUserCount;
    }

    public void setPubUserCount(Integer pubUserCount) {
        this.pubUserCount = pubUserCount;
    }

    public Integer getJoinUserCount() {
        return joinUserCount;
    }

    public void setJoinUserCount(Integer joinUserCount) {
        this.joinUserCount = joinUserCount;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Integer getRegCount() {
        return regCount;
    }

    public void setRegCount(Integer regCount) {
        this.regCount = regCount;
    }

    public Integer getBuyUserCount() {
        return buyUserCount;
    }

    public void setBuyUserCount(Integer buyUserCount) {
        this.buyUserCount = buyUserCount;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		 this.channel = channel == null ? null : channel.trim();
	}

	public String getScreenVersion() {
		return screenVersion;
	}

	public void setScreenVersion(String screenVersion) {
		this.screenVersion = screenVersion;
	}

	public Integer getIsNewbie() {
		return isNewbie;
	}

	public void setIsNewbie(Integer isNewbie) {
		this.isNewbie = isNewbie;
	}

	public Integer getPriorityTop() {
		return priorityTop;
	}

	public void setPriorityTop(Integer priorityTop) {
		this.priorityTop = priorityTop;
	}
}