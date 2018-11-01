/*
*
* DailyCommentMapper.java
* Copyright(C) 2017-2020 http://www.escience.org.cn
* @date 2018-11-01
*/
package com.nstr.data.collection.repository;

import com.nstr.data.collection.model.pojo.DailyComment;
import com.nstr.data.collection.model.pojo.DailyCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailyCommentMapper {
    /**
     *
     * @mbg.generated 2018-11-01
     */
    long countByExample(DailyCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int deleteByExample(DailyCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int insert(DailyComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int insertSelective(DailyComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    List<DailyComment> selectByExampleWithBLOBs(DailyCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    List<DailyComment> selectByExample(DailyCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    DailyComment selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExampleSelective(@Param("record") DailyComment record, @Param("example") DailyCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExampleWithBLOBs(@Param("record") DailyComment record, @Param("example") DailyCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExample(@Param("record") DailyComment record, @Param("example") DailyCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKeySelective(DailyComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKeyWithBLOBs(DailyComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKey(DailyComment record);

    int insertBatchSelective(List<DailyComment> records);

    int insertBatch(List<DailyComment> records);

    int updateBatchByPrimaryKeySelective(List<DailyComment> records);
}