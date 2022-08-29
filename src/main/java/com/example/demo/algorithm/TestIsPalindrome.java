package com.example.demo.algorithm;


/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestIsPalindrome.java
 * @Description 是否是回文
 * @createTime 2022年08月18日 15:31:00
 */
public class TestIsPalindrome {
    public static void main(String[] args) {
        String str="race a car";
        boolean palindrome = isPalindrome(str);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        char[] charArray = s.toLowerCase().toCharArray();
        int left =0;
        int right =charArray.length-1;
        while(left<right){
            //1.左小于右的大原则；2.要跳过不是字母和数字的字符
            while(left<right && !Character.isLetterOrDigit(charArray[left])){
                left++;
            }
            //1.左小于右的大原则；2.因为要跳过不是字母和数字的字符
            while(left<right && !Character.isLetterOrDigit(charArray[right])){
                right--;
            }
            //比较是否相同
            if(charArray[left] != charArray[right]){
                return false;
            }
            //左右一比较就要同时移动
            left++;
            right--;
        }
        return true;
    }

}
