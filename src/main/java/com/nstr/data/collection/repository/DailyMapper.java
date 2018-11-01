/*
*
* DailyMapper.java
* Copyright(C) 2017-2020 http://www.escience.org.cn
* @date 2018-11-01
*/
package com.nstr.data.collection.repository;

import com.nstr.data.collection.model.pojo.Daily;
import com.nstr.data.collection.model.pojo.DailyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailyMapper {
    /**
     *
     * @mbg.generated 2018-11-01
     */
    long countByExample(DailyExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int deleteByExample(DailyExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int insert(Daily record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int insertSelective(Daily record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    List<Daily> selectByExample(DailyExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    Daily selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExampleSelective(@Param("record") Daily record, @Param("example") DailyExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByExample(@Param("record") Daily record, @Param("example") DailyExample example);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKeySelective(Daily record);

    /**
     *
     * @mbg.generated 2018-11-01
     */
    int updateByPrimaryKey(Daily record);

    int insertBatchSelective(List<Daily> records);

    int updateBatchByPrimaryKeySelective(List<Daily> records);
}