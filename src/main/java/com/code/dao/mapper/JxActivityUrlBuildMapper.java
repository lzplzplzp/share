package com.code.dao.mapper;

import com.code.model.JxActivityUrlBuild;
import com.code.model.JxActivityUrlBuildExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface JxActivityUrlBuildMapper {
    long countByExample(JxActivityUrlBuildExample example);

    int deleteByExample(JxActivityUrlBuildExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JxActivityUrlBuild record);

    int insertSelective(JxActivityUrlBuild record);

    List<JxActivityUrlBuild> selectByExample(JxActivityUrlBuildExample example);

    JxActivityUrlBuild selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JxActivityUrlBuild record, @Param("example") JxActivityUrlBuildExample example);

    int updateByExample(@Param("record") JxActivityUrlBuild record, @Param("example") JxActivityUrlBuildExample example);

    int updateByPrimaryKeySelective(JxActivityUrlBuild record);

    int updateByPrimaryKey(JxActivityUrlBuild record);

    /**
     * 根据条件查询分页列表
     * @param mapper
     * @return
     */
    List<JxActivityUrlBuild> getLinkExcelList(Map<String, Object> mapper);

    /**
     * 根据条件查询对应总条数
     * @param mapper
     * @return
     */
    long getTotalRows(Map<String, Object> mapper);

    JxActivityUrlBuild selectMaxBatchNum(Integer activityId);
}