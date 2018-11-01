package com.nstr.data.collection.repository;

import com.nstr.data.collection.exception.SQLException;

import java.util.Map;

public class SqlSelectProvider {

    /**
     * 多列SQL的统计，但是SQL的映射是个问题。
     * 其实多列的统计有时候还是挺有意思的，比如resourceid和userid的统计，比如userid和area等区域信息的统计，
     * 比如resourceid和area信息的统计，还有浏览器操作系统等信息列之间的混合统计
     * @param paras
     * @return
     */
    public String columns(Map<String, Object> paras){
        String[] columns = (String[]) paras.get("columns");
        if(columns == null || columns.length == 0){
            throw new SQLException("没有传入需要统计的列信息！");
        }
        String sql = "SELECT account,count(id) as value,${column} as name,'${column}' as type, " +
                "avg(score) as avg_score," +
                "DATE_FORMAT(FROM_UNIXTIME(create_time/1000,'%Y%m%d'),'%Y%m%d') as day," +
                "UNIX_TIMESTAMP(now())*1000 create_time   " +
                "FROM nstr_resource_comment " +
                "GROUP BY account,day,${column}";

        return sql;
    }
}
