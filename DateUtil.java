package com.dlkj.exam.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 线程安全的日期工具
 *
 * @author 朱天强
 * @date 2018/6/5
 */
public class DateUtil {
    private static final DateTimeFormatter DTF_YEAR = DateTimeFormatter.ofPattern("yyyy");
    private static final DateTimeFormatter DTF_DAY = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DTF_DAYS = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter DTF_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DTF_TIMES = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * 现在时间（年）
     *
     * @return DTF_YEAR
     */
    public static String getThisYear() {
        return DTF_YEAR.format(LocalDate.now());
    }

    /**
     * 现在时间（天）
     *
     * @return DTF_DAY
     */
    public static String getThisDay() {
        return DTF_DAY.format(LocalDate.now());
    }

    /**
     * 现在时间（天）
     *
     * @return DTF_DAYS
     */
    public static String getThisDays() {
        return DTF_DAYS.format(LocalDate.now());
    }

    /**
     * 现在时间（秒）
     *
     * @return DTF_TIME
     */
    public static String getThisTime() {
        return DTF_TIME.format(LocalDate.now());
    }

    /**
     * 现在时间（秒）
     *
     * @return DTF_TIMES
     */
    public static String getThisTimes() {
        return DTF_TIMES.format(LocalDate.now());
    }

    /**
     * 比较两个时间的大小
     *
     * @param dateString1    时间1
     * @param dateString2    时间2
     * @param dateTimeFormat 时间格式
     * @return -1:时间1小于时间2 | 0:时间1等于时间2 | 1:时间1大于时间2
     */
    public static Integer compare(final String dateString1, final String dateString2, final String dateTimeFormat) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        final LocalDateTime dateTime1 = LocalDateTime.parse(dateString1, dateTimeFormatter);
        final LocalDateTime dateTime2 = LocalDateTime.parse(dateString2, dateTimeFormatter);
        if (dateTime1.isBefore(dateTime2)) {
            return -1;
        } else if (dateTime1.equals(dateTime2)) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 校验日期是否合法
     *
     * @param dateString     时间
     * @param dateTimeFormat 时间格式
     * @return Boolean
     */
    public static Boolean validate(final String dateString, final String dateTimeFormat) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        try {
            LocalDateTime.parse(dateString, dateTimeFormatter);
            return true;
        } catch (final Exception e) {
            return false;
        }
    }

    /**
     * 在原时间上增加x个时间单位
     *
     * @param dateString     时间
     * @param x              增加x
     * @param chronoUnit     时间单位
     * @param dateTimeFormat 时间格式
     * @return 增加后的时间
     */
    public static String add(final String dateString, final Long x, final ChronoUnit chronoUnit, final String dateTimeFormat) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        final LocalDateTime dateTime = LocalDateTime.parse(dateString, dateTimeFormatter);
        final LocalDateTime newTime = dateTime.plus(x, chronoUnit);
        return dateTimeFormatter.format(newTime);
    }

    /**
     * 增加x小时
     *
     * @param dateString     时间
     * @param hours          小时
     * @param dateTimeFormat 时间格式
     * @return 增加后的时间
     */
    public static String addHours(final String dateString, final Long hours, final String dateTimeFormat) {
        return add(dateString, hours, ChronoUnit.HOURS, dateTimeFormat);
    }

    /**
     * 增加x分钟
     *
     * @param dateString     时间
     * @param minutes        分钟
     * @param dateTimeFormat 时间格式
     * @return 增加后的时间
     */
    public static String addMinutes(final String dateString, final Long minutes, final String dateTimeFormat) {
        return add(dateString, minutes, ChronoUnit.MINUTES, dateTimeFormat);
    }

    /**
     * 增加x秒
     *
     * @param dateString     时间
     * @param seconds        秒
     * @param dateTimeFormat 时间格式
     * @return 增加后的时间
     */
    public static String addSeconds(final String dateString, final Long seconds, final String dateTimeFormat) {
        return add(dateString, seconds, ChronoUnit.SECONDS, dateTimeFormat);
    }


    /**
     * 是否为闰年
     *
     * @param dateString     时间
     * @param dateTimeFormat 时间格式
     * @return 增加后的时间
     */
    public static Boolean isLeapYear(final String dateString, final String dateTimeFormat) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        final LocalDate dateTime = LocalDate.parse(dateString, dateTimeFormatter);
        return dateTime.isLeapYear();
    }
}