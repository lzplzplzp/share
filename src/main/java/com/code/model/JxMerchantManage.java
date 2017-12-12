package com.code.model;

import java.util.Date;

/**
 * 存管融资方管理表
 */
public class JxMerchantManage {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 登录名，即邮箱
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实名字
     */
    private String name;

    /**
     * 电话不能为空
     */
    private String cell;

    private String random;

    /**
     * 是否为系统管理员 1为系统管理员，2企业用户 默认是0 ,备用
     */
    private Integer isAdmin;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;

    /**
     * 设置登录权限,备用
     */
    private Integer status;

    /**
     * 融资方id
     */
    private Integer companyId;

    /**
     * 0未设置交易密码,1已设置交易密码
     */
    private Integer isSetPayPwd;

    /**
     * 登录已经失败次数
     */
    private Integer failCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getIsSetPayPwd() {
        return isSetPayPwd;
    }

    public void setIsSetPayPwd(Integer isSetPayPwd) {
        this.isSetPayPwd = isSetPayPwd;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }
}