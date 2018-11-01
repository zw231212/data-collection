package com.nstr.data.collection.model.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 数据备份表
 */
@Data
@NoArgsConstructor
public class HistoryComment extends ResourceComment {

    private String tableName;//表名
    private String gid;//根据表名+表内的id生成
    private Date generationTime;//备份表生成时间

}
