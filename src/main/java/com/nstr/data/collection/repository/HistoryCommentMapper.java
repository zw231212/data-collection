/*
*
* ResourceCommentMapper.java
* Copyright(C) 2017-2020 http://www.escience.org.cn
* @date 2018-10-31
*/
package com.nstr.data.collection.repository;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface HistoryCommentMapper {

    void create(@Param("tableName") String tableName);

    void transferData(@Param("begin") long begin, @Param("end") long end,
                      @Param("generationTime") Date generationTime,
                      @Param("tableName") String tableName);
}