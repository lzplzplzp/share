package com.code.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 新版用户主表
 */
public class JxUser {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 手机号码
     */
    private String phone;

    private String password;

    private String ip;

    /**
     * 用户状态：0为禁用；1为注册成功；2为已开户；3为已设置交易密码:
     */
    private Integer status;

    /**
     * 是否为老用户(指江西银行存管之前用户);0为不是；1为老用户
     */
    private Integer isOld;

    /**
     * 身份证号码可逆
     */
    private String idCard1;

    /**
     * 身份证号码不可逆
     */
    private String idCard2;

    /**
     * 用户绑定的银行卡号可逆
     */
    private String bankCard1;

    /**
     * 用户绑定的银行卡号不可逆
     */
    private String bankCard2;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行id
     */
    private Integer bankId;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 最后一次打开时间
     */
    private Date lastOpenTime;

    private Date createTime;

    /**
     * 存管平台分配的账号
     */
    private String accountId;

    /**
     * 账户余额
     */
    private BigDecimal accountBalance;

    /**
     * 老用户总投资额
     */
    private BigDecimal oldBuyAmount;

    /**
     * 用户姓名
     */
    private String realName;

    /**
     * 乐观锁版本控制号
     */
    private Integer version;

    /**
     * 用户生日
     */
    private String birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsOld() {
        return isOld;
    }

    public void setIsOld(Integer isOld) {
        this.isOld = isOld;
    }

    public String getIdCard1() {
        return idCard1;
    }

    public void setIdCard1(String idCard1) {
        this.idCard1 = idCard1;
    }

    public String getIdCard2() {
        return idCard2;
    }

    public void setIdCard2(String idCard2) {
        this.idCard2 = idCard2;
    }

    public String getBankCard1() {
        return bankCard1;
    }

    public void setBankCard1(String bankCard1) {
        this.bankCard1 = bankCard1;
    }

    public String getBankCard2() {
        return bankCard2;
    }

    public void setBankCard2(String bankCard2) {
        this.bankCard2 = bankCard2;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Date getLastOpenTime() {
        return lastOpenTime;
    }

    public void setLastOpenTime(Date lastOpenTime) {
        this.lastOpenTime = lastOpenTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getOldBuyAmount() {
        return oldBuyAmount;
    }

    public void setOldBuyAmount(BigDecimal oldBuyAmount) {
        this.oldBuyAmount = oldBuyAmount;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}