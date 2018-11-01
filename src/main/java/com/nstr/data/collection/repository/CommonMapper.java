package com.nstr.data.collection.repository;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

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
     * 创建表格
     * @param table 创建语句
     */
    List<String> exists(@Param("tableName") String table);

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

    /**
     * 创建备份表
     * @param tableName
     */
    void createBackUpTable(@Param("tableName") String tableName);

    /**
     * 转移数据到备份表上
     * @param begin
     * @param end
     * @param generationTime
     * @param tableName
     */
    void transferData(@Param("begin") long begin, @Param("end") long end,
                      @Param("generationTime") Date generationTime,
                      @Param("tableName") String tableName);
}
