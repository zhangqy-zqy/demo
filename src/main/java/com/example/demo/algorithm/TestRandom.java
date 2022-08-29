package com.example.demo.algorithm;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestRandom.java
 * @Description TODO
 * @createTime 2022年08月19日 09:09:00
 */
public class TestRandom {
    public static void main(String[] args) {
        int timeNumber=1000000;
        int[] array = new int[10];
        for (int i = 0; i < timeNumber; i++){
            array[(int) (Math.random() * 5)]++;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("下标为:"+i+",数据量是："+array[i]);
        }
    }
}
