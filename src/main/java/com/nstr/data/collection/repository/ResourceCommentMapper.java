/*
*
* ResourceCommentMapper.java
* Copyright(C) 2017-2020 http://www.escience.org.cn
* @date 2018-10-31
*/
package com.nstr.data.collection.repository;

import com.nstr.data.collection.model.pojo.ResourceComment;
import com.nstr.data.collection.model.pojo.ResourceCommentExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceCommentMapper {
    /**
     *
     * @mbg.generated 2018-10-31
     */
    long countByExample(ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    int deleteByExample(ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    int insert(ResourceComment record);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    int insertSelective(ResourceComment record);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    List<ResourceComment> selectByExampleWithBLOBs(ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    List<ResourceComment> selectByExample(ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    ResourceComment selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    int updateByExampleSelective(@Param("record") ResourceComment record, @Param("example") ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    int updateByExampleWithBLOBs(@Param("record") ResourceComment record, @Param("example") ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    int updateByExample(@Param("record") ResourceComment record, @Param("example") ResourceCommentExample example);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    int updateByPrimaryKeySelective(ResourceComment record);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    int updateByPrimaryKeyWithBLOBs(ResourceComment record);

    /**
     *
     * @mbg.generated 2018-10-31
     */
    int updateByPrimaryKey(ResourceComment record);

    int insertBatchSelective(List<ResourceComment> records);

    int updateBatchByPrimaryKeySelective(List<ResourceComment> records);
}