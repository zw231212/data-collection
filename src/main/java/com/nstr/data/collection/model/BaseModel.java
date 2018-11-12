package com.nstr.data.collection.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 这个最初使用spring-data的时候为了通用而写的model。
 * 在Daily和DailyColumn、DailyComment这几个表通用的列
 */
@Data
@NoArgsConstructor
public class BaseModel implements Serializable {
    protected Integer id;

    protected String account;//账户id信息
    protected String day;//天数,格式XXXX-XX-XX：年月日，没有中间的横杆
    protected Integer value;//个数信息
    protected Long createTime;
}
