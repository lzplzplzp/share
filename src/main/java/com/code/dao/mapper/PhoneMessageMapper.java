package com.code.dao.mapper;


import com.code.model.PhoneMessage;

public interface PhoneMessageMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PhoneMessage record);

    int insertSelective(PhoneMessage record);

    PhoneMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PhoneMessage record);

    int updateByPrimaryKey(PhoneMessage record);
}