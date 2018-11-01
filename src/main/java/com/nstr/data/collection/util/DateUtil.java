package com.nstr.data.collection.util;

import com.nstr.data.collection.config.AppConstant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Long[] getLongTypeBeginAndEnd(String type, int year, int month, int day){
        Date[] dates = getBeginAndEnd(type, year, month, day);
        return new Long[]{
                dates[0].getTime(),
                dates[1].getTime()
        };
    }

    public static Date[] getBeginAndEnd(String type, int year, int month, int day){
        Date[] dates = {
                getBegin(type, year, month, day),
                getEnd(type, year, month, day)
        };
        if("week".equals(type)){
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.setTime(dates[0]);
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
            dates[0] = calendar.getTime();

            calendar.add(Calendar.DAY_OF_WEEK, 6);
            setDayLastCalendar(calendar);
            dates[1] = calendar.getTime();
        }
        return dates;
    }

    public static String[] getBeginAndEnd(String type, String pattern ,int year, int month, int day){
        if(StringUtil.isNullOrBlank(pattern)){
            pattern = "yyyy-MM";
        }
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(pattern);
        Date[] dates = getBeginAndEnd(type, year, month, day);
        return new String[]{
                            format.format(dates[0]),
                            format.format(dates[1])
                        };
    }

    /**
     * 检查日期的类型信息
     * @param type
     * @return
     */
    public static String checkType(String type){
        if(StringUtil.isNullOrBlank(type) || !AppConstant.dateTypes.contains(type) ||
            "week".equals(type)){
            type = "day";
        }
        return type;
    }

    /**
     * 获取指定年份或者月份的开始日期和结束日期
     * @param type 获取信息的类型，有day,month,year三种取值类型
     * @param year 指定的年份
     * @param month 指定的月份
     * @return
     */
    public static Date getBegin(String type, int year, int month,  int day){
        type = checkType(type);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        //设置年月日信息
        setCalendar(calendar, type, year, month, day, false);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * 设置时间的通用的方法
     * @param calendar
     * @param type
     * @param year
     * @param month
     * @param day
     * @param end 是否是求最后一天
     * @return
     */
    private static Calendar setCalendar(Calendar calendar,String type, int year, int month,  int day, boolean end){
        switch (type){
            case "day":
                calendar.set(Calendar.DATE, day);
            case "month":
                calendar.set(Calendar.MONTH, month-1);
            case "year":
                if(end && !"day".equals(type)){
                    boolean leapYear = isLeapYear(year);
                    int actualMaximum = calendar.getActualMaximum(Calendar.DATE);
                    if(leapYear && month == 2){
                        actualMaximum += 1;
                    }
                    calendar.set(Calendar.DATE, actualMaximum);
                }
                calendar.set(Calendar.YEAR, year);
                break;
        }
        return calendar;
    }

    /**
     * 判断是不是闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ;
    }

    /**
     * 获取指定年份和月份的结束日期，在取出2月份的时候一直有问题
     * @param type
     * @param year
     * @param month
     * @return
     */
    public static Date getEnd(String type, int year, int month, int day){
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.MONTH,calendar.getActualMaximum(Calendar.MONTH));

        //设置年月日信息
        setCalendar(calendar, type, year, month, day, true);
        //一天的结束时间 yyyy:MM:dd 23:59:59
        setDayLastCalendar(calendar);
        return calendar.getTime();
    }

    private static void setDayLastCalendar(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
    }

    public static void main(String[] args) {

        String formerDate = getFormerDate("2018111","yyyyMMdd");
        System.out.println(formerDate);
        Date[] days = getBeginAndEnd("month",2016,2,1);
        for (Date day : days) {
            System.out.println(day);
        }

        String[] days2 = getBeginAndEnd("week","yyyy-MM-dd HH:mm:ss",2018,11,2);
        for (String s : days2) {
            System.out.println(s);
        }

        //设置日历对象的年月日（设置为3月1日，注意月是从0开始计的，所以为2）
        Calendar c = Calendar.getInstance();
        c.set(2016, 2,1);

        //将时间往前推1天
        c.add(Calendar.DATE, -1);

        System.out.println("该年2月的天数为："+c.get(Calendar.DATE)+"天");
        LocalDate inputDate = LocalDate.parse("2018-11-01");
        TemporalAdjuster FIRST_OF_WEEK = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.minusDays(localDate.getDayOfWeek().getValue()-DayOfWeek.MONDAY.getValue()));
        System.out.println(FIRST_OF_WEEK);
        System.out.println(inputDate.with(FIRST_OF_WEEK));
        TemporalAdjuster LAST_OF_WEEK = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.plusDays(DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue()));
        System.out.println(inputDate.with(LAST_OF_WEEK));
    }

    public static String getFormerDate(String dstr, String pattern) {
        if(StringUtil.isNullOrBlank(pattern)){
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.format(format.parse(dstr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dstr;
    }

}
