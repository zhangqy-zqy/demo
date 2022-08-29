package com.example.demo;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2022年03月17日 11:25:00
 */
public class Test {
    public static void main(String[] args) {
        Long timeLong=1650855494L;
        timeLong=timeLong-timeLong%60;
        System.out.println(timeLong);
    }
}
