package com.code.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.code.model.JxSmsManage;
import com.code.model.JxSmsManageExample;

public interface JxSmsManageMapper {
    long countByExample(JxSmsManageExample example);

    int deleteByExample(JxSmsManageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JxSmsManage record);

    int insertSelective(JxSmsManage record);

    List<JxSmsManage> selectByExample(JxSmsManageExample example);

    JxSmsManage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JxSmsManage record, @Param("example") JxSmsManageExample example);

    int updateByExample(@Param("record") JxSmsManage record, @Param("example") JxSmsManageExample example);

    int updateByPrimaryKeySelective(JxSmsManage record);

    int updateByPrimaryKey(JxSmsManage record);

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	JxSmsManage selectByCompanyId(Integer id);
}