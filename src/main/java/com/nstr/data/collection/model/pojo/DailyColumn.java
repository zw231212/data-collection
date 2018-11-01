package com.nstr.data.collection.model.pojo;

import com.nstr.data.collection.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class DailyColumn extends BaseModel implements Serializable {

    private String name;
    private String type;//表示存储的数据类型，如果国家，省份，操作系统等各个都统计分别存储一个表的话，表有点多
    private Float avgScore;//平均分

    @Override
    public String toString() {
        return "DailyColumn{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", account='" + account + '\'' +
                ", day='" + day + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                ", avgScore=" + avgScore +
                ", createTime=" + createTime +
                '}';
    }
}
