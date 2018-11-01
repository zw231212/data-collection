/*
*
* DailyComment.java
* Copyright(C) 2017-2020 http://www.escience.org.cn
* @date 2018-11-01
*/
package com.nstr.data.collection.model.pojo;

public class DailyComment {
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
     * 信息标签
     */
    private String tags;

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
     * 信息标签
     * @return tags 信息标签
     */
    public String getTags() {
        return tags;
    }

    /**
     * 信息标签
     * @param tags 信息标签
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }
}