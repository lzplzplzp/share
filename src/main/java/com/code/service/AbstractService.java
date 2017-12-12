package com.code.service;

 
import javax.annotation.Resource;

import com.code.service.BatchActivityUrlTask;
import com.code.dao.mapper.*;


/**
 * 注入管理类，要注入到service里面的manager全部写在这里，Service类都继承此类，统一获取manager
 * dao声明为protected
 * service不允许注入service，防止循环注入
 * 此层不做事务封装。
 *
 * @author 何正军
 */
public abstract class AbstractService {

    @Resource
    protected JxSmsManageMapper jxSmsManageMapper;
    @Resource
    protected JxActivityUrlMapper jxActivityUrlMapper;
    @Resource
    protected JxActivityUrlBuildMapper jxActivityUrlBuildMapper;
    @Resource
    protected BatchActivityUrlTask batchActivityUrlTask;
    @Resource
    protected JxUserMapper jxUserMapper;
    @Resource
    protected PhoneMessageMapper phoneMessageMapper;
    @Resource
    protected JxMerchantManageMapper jxMerchantManageMapper;
}
