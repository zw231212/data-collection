package com.nstr.data.collection.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseModel implements Serializable {
    protected Integer id;

    protected String account;//账户id信息
    protected String day;//天数,格式XXXX-XX-XX：年月日，没有中奖的横杆
    protected Integer value;//评论信息
    protected Long createTime;
}
