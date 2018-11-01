/*
 *
 * DailyColumnMapper.java
 * Copyright(C) 2017-2020 http://www.escience.org.cn
 * @date 2018-11-01
 */
package com.nstr.data.collection.repository;

import com.nstr.data.collection.model.pojo.DailyColumn;
import com.nstr.data.collection.model.pojo.DailyColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DailyColumnMapper {
    /**
     *
     * @mbg.generated 2018-11-01
     */
    long countByExample(DailyColumnExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int deleteByExample(DailyColumnExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int insert(DailyColumn record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int insertSelective(DailyColumn record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    List<DailyColumn> selectByExample(DailyColumnExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    DailyColumn selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExampleSelective(@Param("record") DailyColumn record, @Param("example") DailyColumnExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExample(@Param("record") DailyColumn record, @Param("example") DailyColumnExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKeySelective(DailyColumn record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKey(DailyColumn record);

    int insertBatchSelective(List<DailyColumn> records);

    int insertBatch(List<DailyColumn> records);

    int updateBatchByPrimaryKeySelective(List<DailyColumn> records);
}