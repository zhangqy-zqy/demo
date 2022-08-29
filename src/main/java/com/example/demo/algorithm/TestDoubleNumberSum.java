package com.example.demo.algorithm;


import com.example.demo.util.ArrayCreateUtils;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestDoubleNumberSum.java
 * @Description TODO
 * @createTime 2022年08月18日 11:26:00
 */
public class TestDoubleNumberSum {

    public static void main(String[] args) {
        int time = 10000;
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < time; i++) {
            int[] array = ArrayCreateUtils.generalCreateArray(maxSize, maxValue);
            int[] newArray = ArrayCreateUtils.copyArray(array);
            //int[] sort = TestSort.insertSort(newArray);
            //int[] sort = TestSort.selectSort(newArray);
            int[] sort = TestSort.bubbleSort(newArray);


        }

    }
}
