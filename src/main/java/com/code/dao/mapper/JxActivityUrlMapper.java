package com.code.dao.mapper;

import com.code.model.JxActivityUrl;
import com.code.model.JxActivityUrlExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface JxActivityUrlMapper {
    long countByExample(JxActivityUrlExample example);

    int deleteByExample(JxActivityUrlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JxActivityUrl record);

	int insertBatch(List<JxActivityUrl> list);

    int insertSelective(JxActivityUrl record);

    List<JxActivityUrl> selectByExample(JxActivityUrlExample example);

    JxActivityUrl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JxActivityUrl record, @Param("example") JxActivityUrlExample example);

    int updateByExample(@Param("record") JxActivityUrl record, @Param("example") JxActivityUrlExample example);

    int updateByPrimaryKeySelective(JxActivityUrl record);

    int updateByPrimaryKey(JxActivityUrl record);

	/**
	 * 根据条件查询活动点击记录
	 * @param mapper 
	 * @return
	 */
	List<JxActivityUrl> getQuertyRecordList(Map<String, Object> mapper);

	/**
	 * 根据条件查询对应总条数
	 * @param mapper 
	 * @return
	 */
	long getTotalRows(Map<String, Object> mapper);

    /**
     * 更新url表访问次数
     * @param map
     * @return
     */
    int updateVisitCount(Map<String, Object> map);
}