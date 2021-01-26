package com.frog.backend.components.commons.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * Description 基于JDK8 time包的时间工具类
 *
 * @author yxy
 * @date 2020-10-10
 */
public class TimeUtils {

    public static final String STRING_DATE_MARK = "-";
    public static final String STRING_TIME_MARK = ":";

    /**
     * 默认时间格式: yyyy-MM-dd HH:mm:ss
     */
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = TimeFormat.LONG_DATE_PATTERN_LINE.formatter;

    private TimeUtils() {

    }

    /**
     * 默认时间格式String 转 LocalDateTime
     * @param timeStr
     * @return
     */
    public static LocalDateTime stringToLocalDateTime(String timeStr){
        return LocalDateTime.parse(timeStr,DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * LocalDateTime 转 默认时间格式String
     * @param localDateTime
     * @return
     */
    public static String localDateTimeToString(LocalDateTime localDateTime){
        return DEFAULT_DATETIME_FORMATTER.format(localDateTime);
    }

    /**
     * 特定时间格式String 转 LocalDateTime
     * @param timeStr
     * @param timeFormat
     * @return
     */
    public static LocalDateTime stringToLocalDateTime(String timeStr,TimeFormat timeFormat){
        return LocalDateTime.parse(timeStr,timeFormat.formatter);
    }

    /**
     * LocalDateTime 转 特定时间格式String
     * @param localDateTime
     * @param timeFormat
     * @return
     */
    public static String localDateTimeToString(LocalDateTime localDateTime,TimeFormat timeFormat){
        return timeFormat.formatter.format(localDateTime);
    }

    /**
     * 特定时间格式String 转 LocalDate
     * @param timeStr
     * @param timeFormat
     * @return
     */
    public static LocalDate stringToLocalDate(String timeStr,TimeFormat timeFormat){
        return LocalDate.parse(timeStr,timeFormat.formatter);
    }

    /**
     * LocalDate 转 特定时间格式String
     * @param localDate
     * @param timeFormat
     * @return
     */
    public static String localDateToString(LocalDate localDate,TimeFormat timeFormat){
        return timeFormat.formatter.format(localDate);
    }

    /**
     * 特定时间格式String 转 LocalTime
     * @param timeStr
     * @param timeFormat
     * @return
     */
    public static LocalTime stringToLocalTime(String timeStr,TimeFormat timeFormat){
        return LocalTime.parse(timeStr,timeFormat.formatter);
    }

    /**
     * LocalTime 转 特定时间格式String
     * @param localTime
     * @param timeFormat
     * @return
     */
    public static String localTimeToString(LocalTime localTime,TimeFormat timeFormat){
        return timeFormat.formatter.format(localTime);
    }

    /**
     * LocalDateTime 转 Date
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        Date date = Date.from(zonedDateTime.toInstant());
        return date;
    }

    /**
     * Date 转 LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant,zoneId);
    }

    /**
     * 毫秒数 转 LocalDateTime
     * @param millis
     * @return
     */
    public static LocalDateTime millisToLocalDateTime(Long millis){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis),ZoneId.systemDefault());
    }

    /**
     * LocalDateTime 转 毫秒数
     * @param localDateTime
     * @return
     */
    public static Long localDateTimeToMillis(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 毫秒数 转 LocalDate
     * @param millis
     * @return
     */
    public static LocalDate millisToLocalDate(Long millis){
        return millisToLocalDateTime(millis).toLocalDate();
    }

    /**
     * LocalDate 转 毫秒数
     * @param localDate
     * @return
     */
    public static Long localDateToMillis(LocalDate localDate){
        return localDateTimeToMillis(LocalDateTime.of(localDate,LocalTime.MIN));
    }

    /**
     * 毫秒数 转 LocalTime
     * @param millis
     * @return
     */
    public static LocalTime millisToLocalTime(Long millis){
        return millisToLocalDateTime(millis).toLocalTime();
    }

    /**
     * 获取当前时间默认时间格式String
     * @return
     */
    public static String getCurrentTimeString(){
        return DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * 获取当前时间特定时间格式String
     * @param timeFormat
     * @return
     */
    public static String getCurrentTimeString(TimeFormat timeFormat){
        return timeFormat.formatter.format(LocalDateTime.now());
    }

    /**
     * 获取某个时间点当天的开始时间 '00:00'
     * @param localDateTime
     * @return
     */
    public static LocalDateTime getStartTime(LocalDateTime localDateTime){
        return LocalDateTime.of(localDateTime.toLocalDate(),LocalTime.MIN);
    }

    /**
     * 获取某个时间点当天的结束时间 '23:59:59.999999999'
     * @param localDateTime
     * @return
     */
    public static LocalDateTime getEndTime(LocalDateTime localDateTime){
        return LocalDateTime.of(localDateTime.toLocalDate(),LocalTime.MAX);
    }

    /**
     * Date 转 特定时间格式String
     * @param date
     * @param timeFormat
     * @return
     */
    public static String dateToString(Date date,TimeFormat timeFormat){
        return localDateTimeToString(dateToLocalDateTime(date),timeFormat);
    }

    /**
     * 特定时间格式String 转 Date
     * @param timeStr
     * @param timeFormat
     * @return
     */
    public static Date stringToDate(String timeStr,TimeFormat timeFormat){
        return localDateTimeToDate(stringToLocalDateTime(timeStr,timeFormat));
    }

    /**
     * 毫秒数 转 特定时间格式String
     * @param millis
     * @param timeFormat
     * @return
     */
    public static String millisToString(Long millis,TimeFormat timeFormat){
        LocalDateTime localDateTime = millisToLocalDateTime(millis);
        return localDateTimeToString(localDateTime,timeFormat);
    }

    /**
     * 特定时间格式String 转 毫秒数
     * @param timeStr
     * @param timeFormat
     * @return
     */
    public static Long stringToMillis(String timeStr,TimeFormat timeFormat){
        LocalDateTime localDateTime = stringToLocalDateTime(timeStr,timeFormat);
        return localDateTimeToMillis(localDateTime);
    }

    /**
     * LocalDateTime 转 秒
     * @param localDateTime
     * @return
     */
    public static Long localDateTimeToSecond(LocalDateTime localDateTime){
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 秒 转 LocalDateTime
     * @param second
     * @return
     */
    public static LocalDateTime secondToLocalDateTime(Long second){
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(second),ZoneId.systemDefault());
    }

    /**
     * 日期加上一个数，根据field不同加不同值,field为ChronoUnit.*
     * @param localDateTime
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime plus(LocalDateTime localDateTime, Long number, TemporalUnit field){
        return localDateTime.plus(number,field);
    }

    /**
     * 日期减去一个数，根据field不同减不同值，field参数为ChronoUnit.*
     * @param localDateTime
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime minus(LocalDateTime localDateTime,Long number, TemporalUnit field){
        return localDateTime.minus(number,field);
    }

    /**
     * 获取两个日期的差 field参数为ChronoUnit.*
     * @param startTime
     * @param endTime
     * @param field
     * @return
     */
    public static Long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field){
        Period period = Period.between(LocalDate.from(startTime),LocalDate.from(endTime));
        if(field == ChronoUnit.YEARS){
            return Long.valueOf(period.getYears());
        }
        if(field == ChronoUnit.MONTHS){
            return Long.valueOf(period.getYears() * 12 + period.getMonths());
        }
        return field.between(startTime,endTime);
    }

    public enum TimeFormat {
        /**
         * 短时间格式 只保留年月
         */
        SHORT_YEAR_MONTH_PATTERN_LINE("yyyy-MM"),
        SHORT_YEAR_MONTH_PATTERN_SLASH("yyyy/MM"),
        SHORT_YEAR_MONTH_PATTERN_DOUBLE_SLASH("yyyy\\MM"),
        SHORT_YEAR_MONTH_PATTERN_NONE("yyyyMM"),
        /**
         * 短时间格式
         */
        SHORT_DATE_PATTERN_LINE("yyyy-MM-dd"),
        SHORT_DATE_PATTERN_SLASH("yyyy/MM/dd"),
        SHORT_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd"),
        SHORT_DATE_PATTERN_NONE("yyyyMMdd"),
        /**
         * 长时间格式
         */
        LONG_DATE_PATTERN_LINE("yyyy-MM-dd HH:mm:ss"),
        LONG_DATE_PATTERN_SLASH("yyyy/MM/dd HH:mm:ss"),
        LONG_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss"),
        LONG_DATE_PATTERN_NONE("yyyyMMdd HH:mm:ss"),
        /**
         * 长时间格式 带毫秒
         */
        LONG_DATE_PATTERN_WITH_MILSEC_LINE("yyyy-MM-dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_SLASH("yyyy/MM/dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_NONE("yyyyMMdd HH:mm:ss.SSS"),

        /**
         * 时分秒时间格式
         */
        TIME_PATTERN("HH:mm:ss"),
        TIME_PATTERN_WITH_MILSEC("HH:mm:ss.SSS"),
        SHORT_TIME_PATTERN("HHmmss"),
        SHORT_TIME_PATTERN_WITH_MILSEC("HHmmss.SSS"),

        /**
         * 特殊格式 根据需求自定义
         */
        LONG_DATE_PATTERN_WITH_MINUTE("yyyyMMddHHmm"),
        LONG_DATE_PATTERN_WITH_SECOND("yyyyMMddHHmmss");

        public transient DateTimeFormatter formatter;

        TimeFormat(String pattern) {
            formatter = DateTimeFormatter.ofPattern(pattern);
        }
    }
}
