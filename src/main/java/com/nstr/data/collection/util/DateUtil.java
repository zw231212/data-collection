package com.nstr.data.collection.util;

import com.nstr.data.collection.config.AppConstant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String MONTH_PATTERN = "yyyy-MM";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String MINUTE_ONLY_PATTERN = "mm";
    public static final String HOUR_ONLY_PATTERN = "HH";

    /**
     * 获取指定时间的初始和结束时间
     * @param type
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Long[] getLongTypeBeginAndEnd(String type, int year, int month, int day){
        Date[] dates = getBeginAndEnd(type, year, month, day);
        return new Long[]{
                dates[0].getTime(),
                dates[1].getTime()
        };
    }

    /**
     * 获取指定时间的初始和结束时间
     * @param type
     * @param year
     * @param month
     * @param day
     * @return
     */
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

    /**
     * 获取指定时间的初始和结束时间
     * @param type
     * @param pattern
     * @param year
     * @param month
     * @param day
     * @return
     */
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

    /**
     * 设置一天的结束时间
     * @param calendar
     */
    private static void setDayLastCalendar(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
    }

    /**
     * 根据其实时间参数和offset来获取这之间的全部的全部日期
     * @param begin  其实时间
     * @param offset  偏移信息量
     * @param type    时间类型
     * @return
     */
    public static List<String> getDates(String begin, Integer offset, String type){
        if(StringUtil.isNullOrBlank(type)){
            type = "month";
        }
        Date dateBegin = getDateByType(begin, type);
        List<String> results = new ArrayList<>();
        switch (type){
            case "year":
                Date end = dateAddYears(dateBegin, offset);
                try{
                    List<Date> yearsBetween = getYearsBetween(dateBegin, end);
                    for (Date date1 : yearsBetween) {
                        results.add(dateFormat(date1, YEAR_PATTERN).replaceAll("-",""));
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case "month":
                end = dateAddMonths(dateBegin, offset);
                try{
                    List<Date> yearsBetween = getMonthsBetween(dateBegin, end);
                    for (Date date1 : yearsBetween) {
                        results.add(dateFormat(date1, MONTH_PATTERN).replaceAll("-",""));
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case "day":
                end = dateAddDays(dateBegin, offset);
                try{
                    List<Date> yearsBetween = getDatesBetween(dateBegin, end);
                    for (Date date1 : yearsBetween) {
                        results.add(dateFormat(date1, DATE_PATTERN).replaceAll("-",""));
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
        return results;
    }

    /**
     * 根据日期字符串数据类型获取日期
     * @param dateStr
     * @param type
     * @return
     */
    public static Date getDateByType(String dateStr, String type){
        if(StringUtil.isNullOrBlank(type)){
            return new Date();
        }
        type = type.toLowerCase();
        Date date = null;
        switch (type){
            case "year":
                date = parseDateStr(dateStr,YEAR_PATTERN);
                break;
            case "month":
                date = parseDateStr(dateStr,MONTH_PATTERN);
                break;
            case "day":
                date = parseDateStr(dateStr,DATE_PATTERN);
                break;
        }
        return  date;
    }

    public static Date parseDateStr(String dateStr, String pattern){
        if(StringUtil.isNullOrBlank(pattern)){
            pattern = DATE_PATTERN;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = dateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 时间格式化成字符串
     * @param date Date
     * @param pattern StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN， 如果为空，则为yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static String dateFormat(Date date, String pattern) {
        if(StringUtil.isNullOrBlank(pattern)){
            pattern = DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 字符串解析成时间对象
     * @param dateTimeString String
     * @param pattern StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN，如果为空，则为yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date dateParse(String dateTimeString, String pattern) throws ParseException{
        if(StringUtil.isNullOrBlank(pattern)){
            pattern = DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateTimeString);
    }

    /**
     * 时间加减天数
     * @param startDate 要处理的时间，Null则为当前时间
     * @param days 加减的天数
     * @return Date
     */
    public static Date dateAddDays(Date startDate, int days) {
        if (startDate == null) {
            startDate = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.set(Calendar.DATE, c.get(Calendar.DATE) + days);
        return c.getTime();
    }

    /**
     * 时间加减月数
     * @param startDate 要处理的时间，Null则为当前时间
     * @param months 加减的月数
     * @return Date
     */
    public static Date dateAddMonths(Date startDate, int months) {
        if (startDate == null) {
            startDate = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + months);
        return c.getTime();
    }

    /**
     * 时间加减年数
     * @param startDate 要处理的时间，Null则为当前时间
     * @param years 加减的年数
     * @return Date
     */
    public static Date dateAddYears(Date startDate, int years) {
        if (startDate == null) {
            startDate = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) + years);
        return c.getTime();
    }

    /**
     * 时间比较（如果myDate>compareDate返回1，<返回-1，相等返回0）
     * @param myDate 时间
     * @param compareDate 要比较的时间
     * @return int
     */
    public static int dateCompare(Date myDate, Date compareDate) {
        Calendar myCal = Calendar.getInstance();
        Calendar compareCal = Calendar.getInstance();
        myCal.setTime(myDate);
        compareCal.setTime(compareDate);
        return myCal.compareTo(compareCal);
    }

    /**
     * 获取两个时间中最小的一个时间
     * @param date
     * @param compareDate
     * @return
     */
    public static Date dateMin(Date date, Date compareDate) {
        if(date == null){
            return compareDate;
        }
        if(compareDate == null){
            return date;
        }
        if(1 == dateCompare(date, compareDate)){
            return compareDate;
        }else if(-1 == dateCompare(date, compareDate)){
            return date;
        }
        return date;
    }

    /**
     * 获取两个时间中最大的一个时间
     * @param date
     * @param compareDate
     * @return
     */
    public static Date dateMax(Date date, Date compareDate) {
        if(date == null){
            return compareDate;
        }
        if(compareDate == null){
            return date;
        }
        if(1 == dateCompare(date, compareDate)){
            return date;
        }else if(-1 == dateCompare(date, compareDate)){
            return compareDate;
        }
        return date;
    }

    /**
     * 获取两个日期（不含时分秒）相差的天数，不包含今天
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int dateBetween(Date startDate, Date endDate) throws ParseException {
        Date dateStart = dateParse(dateFormat(startDate, DATE_PATTERN), DATE_PATTERN);
        Date dateEnd = dateParse(dateFormat(endDate, DATE_PATTERN), DATE_PATTERN);
        return (int) ((dateEnd.getTime() - dateStart.getTime())/1000/60/60/24);
    }

    /**
     * 获取两个日期（不含时分秒）相差的天数，包含今天
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int dateBetweenIncludeToday(Date startDate, Date endDate) throws ParseException {
        return dateBetween(startDate, endDate) + 1;
    }

    /**
     * 获取日期时间的年份，如2017-02-13，返回2017
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取日期时间的月份，如2017年2月13日，返回2
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期时间的第几天（即返回日期的dd），如2017-02-13，返回13
     * @param date
     * @return
     */
    public static int getDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }

    /**
     * 获取日期时间当月的总天数，如2017-02-13，返回28
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DATE);
    }

    /**
     * 获取日期时间当年的总天数，如2017-02-13，返回2017年的总天数
     * @param date
     * @return
     */
    public static int getDaysOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    /**
     * 根据时间获取当月最大的日期
     * <li>2017-02-13，返回2017-02-28</li>
     * <li>2016-02-13，返回2016-02-29</li>
     * <li>2016-01-11，返回2016-01-31</li>
     * @param date Date
     * @return
     * @throws Exception
     */
    public static Date maxDateOfMonth(Date date) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int value = cal.getActualMaximum(Calendar.DATE);
        return dateParse(dateFormat(date, MONTH_PATTERN) + "-" + value, null);
    }

    /**
     * 获取两个日期之间的全部日期
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public static List<Date> getDatesBetween(Date startDate, Date endDate) throws Exception {
        if (startDate.compareTo(endDate) > 0){
            throw new Exception("开始时间应该在结束时间之后");
        }
        Long spi = endDate.getTime() - startDate.getTime();
        Long step = spi / (24 * 60 * 60 * 1000);// 相隔天数
        List<Date> dateList = new ArrayList<Date>();
        dateList.add(endDate);
        for (int i = 1; i <= step; i++) {
            dateList.add(
                    new Date(
                            dateList.get(i - 1).getTime()- (24 * 60 * 60 * 1000)
                    )
            );// 比上一天减一
        }
        return dateList;
    }
    /**
     * 获取两个日期之间的所有日期（yyyy-MM-dd）
     * @param begin
     * @param end
     * @return
     * @author XuJD
     * @date 2017-4-1
     */
    public static List<Date> getDatesBetween2(Date begin, Date end) {
        List<Date> result = new ArrayList<>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(begin);
        while(begin.getTime()<=end.getTime()){
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
            begin = tempStart.getTime();
        }
        return result;
    }

    /**
     * 获取两个时间之间的全部月份
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static List<String> getMonthsBetween(String minDate, String maxDate) throws ParseException {
        List<String> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    /**
     * 获取两个时间之间的全部年份
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static List<Date> getYearsBetween(Date minDate, Date maxDate) throws Exception {
        if (minDate.compareTo(maxDate) > 0 ){
            throw new Exception("开始时间应该在结束时间之后");
        }
        List<Date> result = new ArrayList<>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(minDate);
        while(minDate.getTime() <= maxDate.getTime()){
            result.add(tempStart.getTime());
            tempStart.add(Calendar.YEAR, 1);
            minDate = tempStart.getTime();
        }
        return result;
    }

    /**
     * 获取两个时间之间的全部年份
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static List<Date> getMonthsBetween(Date minDate, Date maxDate) throws Exception {
        if (minDate.compareTo(maxDate) > 0){
            throw new Exception("开始时间应该在结束时间之后");
        }
        List<Date> result = new ArrayList<>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(minDate);
        while(minDate.getTime() <= maxDate.getTime()){
            result.add(tempStart.getTime());
            tempStart.add(Calendar.MONTH, 1);
            minDate = tempStart.getTime();
        }
        return result;
    }

    public static String getNow() {
        return dateFormat(new Date(), DATE_PATTERN);
    }

    /**
     * 格式化时间
     * @param dstr
     * @param pattern
     * @return
     */
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

        String dateStr = "2018-07-02";
//    String dateStr2 = "2017-07-02";
//    Date date = parseDateStr(dateStr, MONTH_PATTERN);
//    System.out.println(date);
//    List<String> monthBetween = getMonthsBetween(dateStr2, dateStr);
//
//    Date date1 = dateParse("2016-09", MONTH_PATTERN);
//    Date date2 = dateParse("2018-09", MONTH_PATTERN);
//
//    System.out.println(monthBetween);
//    System.out.println(getYearsBetween(date1,date2));
//    System.out.println(getMonthsBetween(date1,date2));

        List<String> year = getDates(dateStr, 3, "year");
        List<String> month = getDates(dateStr, 10, "month");
        List<String> day = getDates(dateStr, 30, "day");
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);

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

}
