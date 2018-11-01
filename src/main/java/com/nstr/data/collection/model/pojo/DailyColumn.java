/*
*
* DailyColumn.java
* Copyright(C) 2017-2020 http://www.escience.org.cn
* @date 2018-11-01
*/
package com.nstr.data.collection.model.pojo;

public class DailyColumn {
    /**
     * 
     */
    private Integer id;

    /**
     * //账户id信息
     */
    private String account;

    /**
     * //天数,格式XXXX-XX-XX：年月日，没有中间的横杆
     */
    private String day;

    /**
     * //个数信息
     */
    private Integer value;

    /**
     * 
     */
    private Long createTime;

    /**
     * 每列的实际的值
     */
    private String name;

    /**
     * 统计的列名称,//表示存储的数据类型，如果国家，省份，操作系统等各个都统计分别存储一个表的话，表有点多
     */
    private String type;

    /**
     * //平均分
     */
    private Float avgScore;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * //账户id信息
     * @return account //账户id信息
     */
    public String getAccount() {
        return account;
    }

    /**
     * //账户id信息
     * @param account //账户id信息
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * //天数,格式XXXX-XX-XX：年月日，没有中间的横杆
     * @return day //天数,格式XXXX-XX-XX：年月日，没有中间的横杆
     */
    public String getDay() {
        return day;
    }

    /**
     * //天数,格式XXXX-XX-XX：年月日，没有中间的横杆
     * @param day //天数,格式XXXX-XX-XX：年月日，没有中间的横杆
     */
    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    /**
     * //个数信息
     * @return value //个数信息
     */
    public Integer getValue() {
        return value;
    }

    /**
     * //个数信息
     * @param value //个数信息
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 
     * @return create_time 
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 每列的实际的值
     * @return name 每列的实际的值
     */
    public String getName() {
        return name;
    }

    /**
     * 每列的实际的值
     * @param name 每列的实际的值
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 统计的列名称,//表示存储的数据类型，如果国家，省份，操作系统等各个都统计分别存储一个表的话，表有点多
     * @return type 统计的列名称,//表示存储的数据类型，如果国家，省份，操作系统等各个都统计分别存储一个表的话，表有点多
     */
    public String getType() {
        return type;
    }

    /**
     * 统计的列名称,//表示存储的数据类型，如果国家，省份，操作系统等各个都统计分别存储一个表的话，表有点多
     * @param type 统计的列名称,//表示存储的数据类型，如果国家，省份，操作系统等各个都统计分别存储一个表的话，表有点多
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * //平均分
     * @return avg_score //平均分
     */
    public Float getAvgScore() {
        return avgScore;
    }

    /**
     * //平均分
     * @param avgScore //平均分
     */
    public void setAvgScore(Float avgScore) {
        this.avgScore = avgScore;
    }
}