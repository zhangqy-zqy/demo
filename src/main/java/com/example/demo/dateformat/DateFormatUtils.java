package com.example.demo.dateformat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName DateFromatUtils.java
 * @Description TODO
 * @createTime 2022年08月15日 16:49:00
 */
public class DateFormatUtils {

    private static final ZoneId ZONE_ID = ZoneOffset.systemDefault();

    private static final DateTimeFormatter DATE_TIME_FORMATTER_SSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    /**
     * 格式化时间戳
     *
     * @param ms 毫秒
     * @return 格式化后的时间
     */
    public static String formatMs(long ms) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(ms), ZONE_ID);
        return formatMs(localDateTime);
    }

    /**
     * 格式化 localDateTime
     *
     * @param localDateTime localDateTime
     * @return yyyy-MM-dd HH:mm:ss:SSS
     */
    public static String formatMs(LocalDateTime localDateTime) {
        return DATE_TIME_FORMATTER_SSS.format(localDateTime);
    }


    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        String formatMs = formatMs(currentTimeMillis);
        System.out.println(formatMs);
    }

}
