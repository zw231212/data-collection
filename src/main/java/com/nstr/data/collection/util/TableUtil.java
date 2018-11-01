package com.nstr.data.collection.util;


import com.nstr.data.collection.config.AppConstant;

import java.util.Calendar;

public class TableUtil {

    /**
     * 生成当前日期的表格的日期后缀
     * @param type
     * @return
     */
    public static String  generateDateStr(String type){
        if(StringUtil.isNullOrBlank(type) || !AppConstant.dateTypes.contains(type)){
            type = "month";
        }
        type = type.toLowerCase();
        Calendar instance = Calendar.getInstance();
        String result = "";
        switch (type){
            case "day":
                instance.add(Calendar.DATE,-1);
                int day = instance.get(Calendar.DAY_OF_MONTH);
                result += day;
            case "week":
                if(!"day".equals(type)){
                    if("week".equals(type)){
                        instance.add(Calendar.WEEK_OF_MONTH, -1);
                    }

                    int week = instance.get(Calendar.WEEK_OF_MONTH);
                    if(StringUtil.isNullOrBlank(result)){
                        result += week;
                    }else{
                        result = week + "_" + result;
                    }
                }
            case "month":
                if("month".equals(type)){
                    instance.add(Calendar.MONTH, -1);
                }
                int month = instance.get(Calendar.MONTH) + 1;
                if(StringUtil.isNullOrBlank(result)){
                    result += month;
                }else{
                    result = month + "_" + result;
                }
            case "year":
                if("year".equals(type)){
                    instance.add(Calendar.YEAR, -1);
                }
                int year = instance.get(Calendar.YEAR);
                if(StringUtil.isNullOrBlank(result)){
                    result += year;
                }else{
                    result = year + "_" + result;
                }
                break;
        }

        return result;
    }

    /**
     * 生成时间相对应的表名称
     * @param prefix
     * @param type
     * @return
     */
    public static String generateTableName(String prefix, String type){
        if(StringUtil.isNullOrBlank(prefix)){
            prefix = AppConstant.COMMENT_TABLE;
        }
        String dateStr = generateDateStr(type);

        return prefix+"_"+dateStr;
    }

    public static void main(String[] args) {
        String s = generateDateStr("week");
        System.out.println(s);
    }
}
