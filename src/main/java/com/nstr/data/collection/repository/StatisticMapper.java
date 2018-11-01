package com.nstr.data.collection.repository;

import com.nstr.data.collection.model.pojo.Daily;
import com.nstr.data.collection.model.pojo.DailyColumn;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StatisticMapper {

    /**
     * 基本信息的一个统计
     * @return
     */
    @Select("SELECT account,count(id) as value," +
            "DATE_FORMAT(FROM_UNIXTIME(create_time/1000,'%Y%m%d'),'%Y%m%d') as day," +
            "avg(score) as avg_score," +
            "min(score) as min_score  " +
            "from nstr_resource_comment " +
            "GROUP BY account,day")
    List<Daily> commonStatic();

    /**
     * 统计国家、省份、城市、浏览器、操作系统等任意一个字段的
     * @param area
     * @return
     */
    @Select("SELECT account,count(id) as value,${area} as name,'${area}' as type, avg(score) as avg_score," +
            "DATE_FORMAT(FROM_UNIXTIME(create_time/1000,'%Y%m%d'),'%Y%m%d') as day " +
            "FROM nstr_resource_comment " +
            "GROUP BY account,day,${area}")
    List<DailyColumn> areaStatic(@Param("area") String area);//区域省份和地区统计
}
