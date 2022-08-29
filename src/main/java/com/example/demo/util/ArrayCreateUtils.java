package com.example.demo.util;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName ArrayCreateUtils.java
 * @Description TODO
 * @createTime 2022年08月18日 11:35:00
 */
public class ArrayCreateUtils {


    /**
     * 通用创建数组方法
     *
     * @param maxSize  maxSize 最大数量
     * @param maxValue maxValue 最大值
     * @return 数组
     */
    public static int[] generalCreateArray(int maxSize, int maxValue) {
        int[] array = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return array;
    }

    /**
     * 复制数组
     *
     * @param array array
     * @return 新数组
     */
    public static int[] copyArray(int[] array) {
        if (array == null) {
            return null;
        }
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }


    /**
     * 打印数组信息
     *
     * @param nums nums
     */
    public static void print(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println();
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1 arr1
     * @param arr2 arr2
     * @return boolean
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数组里面数据交换
     *
     * @param arr    arr
     * @param index1 index1
     * @param index2 index2
     */
    public static void swap(int[] arr, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
