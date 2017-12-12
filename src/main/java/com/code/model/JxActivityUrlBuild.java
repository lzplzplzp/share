package com.code.model;

import java.util.Date;

/**
 * 奖品发放表
 */
public class JxActivityUrlBuild {
    private Integer id;

    private String fileOldName;

    /**
     * 上传文件新名称
     */
    private String fileNewName;

    /**
     * 上传相对文件路径
     */
    private String filePath;

    /**
     * 生成后文件名
     */
    private String buileFileName;

    /**
     * 生成后文件相对路径
     */
    private String buileFilePath;

    /**
     * 0未处理,1处理中,2处理完成,3处理失败
     */
    private Integer status;

    /**
     * 创建人ID
     */
    private Integer cuserId;

    /**
     * 创建人名称
     */
    private String cuserName;

    /**
     * 创建时间
     */
    private Date ctime;

    /**
     * 0为有效,1为删除
     */
    private Integer isDel;

    /**
     * 活动ID
     */
    private Integer activityId;

    /**
     * 批次号
     */
    private Byte batchNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileOldName() {
        return fileOldName;
    }

    public void setFileOldName(String fileOldName) {
        this.fileOldName = fileOldName;
    }

    public String getFileNewName() {
        return fileNewName;
    }

    public void setFileNewName(String fileNewName) {
        this.fileNewName = fileNewName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getBuileFileName() {
        return buileFileName;
    }

    public void setBuileFileName(String buileFileName) {
        this.buileFileName = buileFileName;
    }

    public String getBuileFilePath() {
        return buileFilePath;
    }

    public void setBuileFilePath(String buileFilePath) {
        this.buileFilePath = buileFilePath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCuserId() {
        return cuserId;
    }

    public void setCuserId(Integer cuserId) {
        this.cuserId = cuserId;
    }

    public String getCuserName() {
        return cuserName;
    }

    public void setCuserName(String cuserName) {
        this.cuserName = cuserName;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Byte getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(Byte batchNum) {
        this.batchNum = batchNum;
    }
}