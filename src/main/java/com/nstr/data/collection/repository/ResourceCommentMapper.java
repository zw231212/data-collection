/*
*
* ResourceCommentMapper.java
* Copyright(C) 2017-2020 http://www.escience.org.cn
* @date 2018-11-01
*/
package com.nstr.data.collection.repository;

import com.nstr.data.collection.model.pojo.ResourceComment;
import com.nstr.data.collection.model.pojo.ResourceCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceCommentMapper {
    /**
     *
     * @mbg.generated 2018-11-01
     */
    long countByExample(ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int deleteByExample(ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int insert(ResourceComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int insertSelective(ResourceComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    List<ResourceComment> selectByExampleWithBLOBs(ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    List<ResourceComment> selectByExample(ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    ResourceComment selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExampleSelective(@Param("record") ResourceComment record, @Param("example") ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExampleWithBLOBs(@Param("record") ResourceComment record, @Param("example") ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExample(@Param("record") ResourceComment record, @Param("example") ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKeySelective(ResourceComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKeyWithBLOBs(ResourceComment record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKey(ResourceComment record);

    int insertBatchSelective(List<ResourceComment> records);

    int insertBatch(List<ResourceComment> records);

    int updateBatchByPrimaryKeySelective(List<ResourceComment> records);
}