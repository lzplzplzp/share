package com.code.service;

import com.code.dao.mapper.SysConfMapper;
import com.code.model.SysConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysConfService {
    @Autowired
    private SysConfMapper sysConfMapper;

    public String selectValByKey(String attr) {
        SysConf sysConf = sysConfMapper.selectByPrimaryKey(attr);
        return sysConf.getVal();
    }
}
