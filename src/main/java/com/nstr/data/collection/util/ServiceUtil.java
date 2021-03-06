package com.nstr.data.collection.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ServiceUtil {

  /**
   * 检查输入的日期
   * @param dates
   * @return
   */
  public static List<String> checkDates(List<String> dates){
    if(dates == null){
      dates = new ArrayList<>();
    }
    if(dates.size() == 0){
      Calendar calendar = Calendar.getInstance();
      calendar.add(Calendar.DATE,-1);
      int year = calendar.get(Calendar.YEAR);
      int month = calendar.get(Calendar.MONTH);
      int day = calendar.get(Calendar.DATE);
      dates.add(DateUtil.getFormerDate(year+""+month+""+day,"yyyyMMdd"));
    }
    return dates;
  }

  public static void setCriteria(Object object, Class clazz){

  }

}
