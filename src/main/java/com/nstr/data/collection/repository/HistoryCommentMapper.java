/*
*
* HistoryCommentMapper.java
* Copyright(C) 2017-2020 http://www.escience.org.cn
* @date 2018-11-01
*/
package com.nstr.data.collection.repository;

import com.nstr.data.collection.model.pojo.HistoryComment;
import com.nstr.data.collection.model.pojo.HistoryCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 需要改造，因为表名称不是固定的
 */
public interface HistoryCommentMapper {
    /**
     *
     * @mbg.generated 2018-11-01
     */
    long countByExample(HistoryCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int deleteByExample(HistoryCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int insert(HistoryComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int insertSelective(HistoryComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    List<HistoryComment> selectByExampleWithBLOBs(HistoryCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    List<HistoryComment> selectByExample(HistoryCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    HistoryComment selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExampleSelective(@Param("record") HistoryComment record, @Param("example") HistoryCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExampleWithBLOBs(@Param("record") HistoryComment record, @Param("example") HistoryCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExample(@Param("record") HistoryComment record, @Param("example") HistoryCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKeySelective(HistoryComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKeyWithBLOBs(HistoryComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKey(HistoryComment record);

    int insertBatchSelective(List<HistoryComment> records);

    int updateBatchByPrimaryKeySelective(List<HistoryComment> records);
}