package com.nstr.data.collection.repository;

import org.apache.ibatis.annotations.Param;

/**
 * 通用的数据库操作
 */
public interface CommonMapper {

    /**
     * 创建表格
     * @param statement 创建语句
     */
    void create(@Param("statement") String statement);

    /**
     * 删除表格
     * @param tableName
     */
    void dropTable(@Param("tableName") String tableName);

    /**
     * 清空表格数据
     * @param tableName
     */
    void truncateTable(@Param("tableName") String tableName);
}
