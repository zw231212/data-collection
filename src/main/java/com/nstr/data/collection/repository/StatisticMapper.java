package com.nstr.data.collection.repository;

import com.nstr.data.collection.model.pojo.Daily;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StatisticMapper {

    @Select("SELECT account,count(id) as comment_num," +
            "DATE_FORMAT(FROM_UNIXTIME(create_time/1000,'%Y%m%d'),'%Y%m%d') as day," +
            "avg(score) as avg_score," +
            "min(score) as min_score  " +
            "from nstr_resource_comment " +
            "GROUP BY account,day")
    List<Daily> commonStatic();
}
