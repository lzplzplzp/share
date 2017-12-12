package com.code.dao.mapper;

import com.code.model.JxUser;
import com.code.model.JxUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JxUserMapper {
    long countByExample(JxUserExample example);

    int deleteByExample(JxUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JxUser record);

    int insertSelective(JxUser record);

    List<JxUser> selectByExample(JxUserExample example);

    JxUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JxUser record, @Param("example") JxUserExample example);

    int updateByExample(@Param("record") JxUser record, @Param("example") JxUserExample example);

    int updateByPrimaryKeySelective(JxUser record);

    int updateByPrimaryKey(JxUser record);
}