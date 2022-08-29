package com.example.demo.algorithm;

import com.example.demo.util.ArrayCreateUtils;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestSearchInsert.java
 * @Description TODO
 * @createTime 2022年08月18日 16:28:00
 */
public class TestSearchInsert {

    public static void main(String[] args) {

        int time = 1;
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < time; i++) {
            int[] array = ArrayCreateUtils.generalCreateArray(maxSize, maxValue);
            int[] newArray = ArrayCreateUtils.copyArray(array);
            //int[] sort = insertSort(newArray);
            //int[] sort = selectSort(newArray);
            int[] sort = TestSort.bubbleSort(newArray);
            int number = (int) ((maxValue + 1) * Math.random());


        }
        System.out.println("nice.....");

    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                if(i+1==nums.length){
                    return i+1;
                }
            } else if (nums[i] >= target) {
                return i;
            }
        }
        return 0;
    }
}
