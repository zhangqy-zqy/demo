package com.example.demo.algorithm;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestJiSuan.java
 * @Description TODO
 * @createTime 2022年08月18日 20:59:00
 */
public class TestJiSuan {
    public static void main(String[] args) {

        int timeCount=1000000;
        int count =0;
        for (int i = 0; i < timeCount; i++) {
            if(randomOneEndFive()>3){
                count++;
            }
        }
        System.out.println((double) count/timeCount);
        System.out.println((double) 1/6);

        count =0;
        int[] array=new int[9];
        for (int i = 0; i < timeCount; i++) {
            array[randomZeroEndSeven()]++;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println("下标"+i+"出现了："+array[i]+"次");
        }
    }

    public static int randomZeroEndSeven(){
        return (randomZeroEndOne())+(randomZeroEndOne()<<1)+(randomZeroEndOne()<<2);
    }

    public static int randomZeroEndOne(){
        int ans=0;
        do {
            ans= randomOneEndFive();
        }while (ans==3);
        return ans < 3 ? 0:1;
    }


    public static int randomOneEndFive(){
        return (int) (1+Math.random()*5);
    }
}
