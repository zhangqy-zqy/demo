package com.example.demo.algorithm;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestLongestPalindrome.java
 * @Description 最长回文子串
 * @createTime 2022年08月21日 11:41:00
 */
public class TestLongestPalindrome {

    public static void main(String[] args) {
        //String s="babad";
        String s="cbbd";
        String longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);

    }

    public static String longestPalindrome(String s) {
        if(s.length()<2){return "";}
        int pre=0;
        int post=1;
        StringBuilder str=new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            while (pre>=0 && post<s.length()){
                if(s.charAt(pre) == s.charAt(post)){
                    if((post - pre) >str.length()){
                        str=new StringBuilder();
                        str.append(s, pre, post+1);
                    }
                    pre--;
                    post++;
                }else{
                    break;
                }
            }
            pre=i-1;
            if(pre<0){
                pre=0;
            }
            post=i+1;
            if(post>s.length()){
                post=s.length();
            }
        }
        return str.toString();
    }
}
