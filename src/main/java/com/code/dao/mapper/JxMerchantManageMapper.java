package com.code.dao.mapper;

import com.code.model.JxMerchantManage;
import com.code.model.JxMerchantManageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JxMerchantManageMapper {
    long countByExample(JxMerchantManageExample example);

    int deleteByExample(JxMerchantManageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JxMerchantManage record);

    int insertSelective(JxMerchantManage record);

    List<JxMerchantManage> selectByExample(JxMerchantManageExample example);

    JxMerchantManage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JxMerchantManage record, @Param("example") JxMerchantManageExample example);

    int updateByExample(@Param("record") JxMerchantManage record, @Param("example") JxMerchantManageExample example);

    int updateByPrimaryKeySelective(JxMerchantManage record);

    int updateByPrimaryKey(JxMerchantManage record);

    JxMerchantManage selectByCompanyId(Integer companyId);

}