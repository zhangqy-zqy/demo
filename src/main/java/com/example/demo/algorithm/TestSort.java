package com.example.demo.algorithm;

import com.example.demo.util.ArrayCreateUtils;

import java.util.Arrays;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestSort.java
 * @Description TODO
 * @createTime 2022年08月18日 11:26:00
 */
public class TestSort {

    public static void main(String[] args) {

        int time = 10000;
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < time; i++) {
            int[] array = ArrayCreateUtils.generalCreateArray(maxSize, maxValue);
            int[] newArray = ArrayCreateUtils.copyArray(array);
            //int[] sort = insertSort(newArray);
            //int[] sort = selectSort(newArray);
            int[] sort = bubbleSort(newArray);
            Arrays.sort(array);
            if (!ArrayCreateUtils.isEqual(sort, array)) {
                System.out.println("array:");
                ArrayCreateUtils.print(array);
                System.out.println("sort:");
                ArrayCreateUtils.print(sort);
            }
        }
        System.out.println("nice.....");

    }

    /**
     * 冒泡排序
     *
     * @param nums nums
     * @return int[]
     */
    public static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j-1] > nums[j]) {
                    ArrayCreateUtils.swap(nums, j-1, j);
                }
            }
        }
        return nums;
    }


    /**
     * 选择排序
     *
     * @param nums nums
     * @return int[]
     */
    public static int[] selectSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            ArrayCreateUtils.swap(nums, i, minIndex);
        }
        return nums;
    }

    /**
     * 插入排序
     *
     * @param nums nums
     * @return int[]
     */
    public static int[] insertSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            int pre = i;
            while (pre - 1 >= 0 && nums[pre] < nums[pre - 1]) {
                ArrayCreateUtils.swap(nums, pre, (pre - 1));
                pre--;
            }
        }
        return nums;
    }


}
