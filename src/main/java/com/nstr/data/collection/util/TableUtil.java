package com.nstr.data.collection.util;


import com.nstr.data.collection.config.AppConstant;

import java.util.Calendar;

public class TableUtil {

    /**
     * 生成表格的日期后缀
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
                int day = instance.get(Calendar.DAY_OF_MONTH);
                result += day;
            case "month":
                int month = instance.get(Calendar.MONTH)+1;
                if(StringUtil.isNullOrBlank(result)){
                    result += month;
                }else{
                    result = month + "_" + result;
                }
            case "year":
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
        String s = generateDateStr("123123");
        System.out.println(s);
    }
}
