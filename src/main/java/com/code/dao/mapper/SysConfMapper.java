package com.code.dao.mapper;


import com.code.model.SysConf;

import java.util.List;

public interface SysConfMapper {
    int deleteByPrimaryKey(String attr);

    int insert(SysConf record);

    int insertSelective(SysConf record);

    SysConf selectByPrimaryKey(String attr);

    int updateByPrimaryKeySelective(SysConf record);

    int updateByPrimaryKey(SysConf record);

	List<SysConf> findAll();

    Integer addQiShu(String attr);

}