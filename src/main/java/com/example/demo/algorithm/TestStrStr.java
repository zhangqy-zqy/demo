package com.example.demo.algorithm;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestStrStr.java
 * @Description TODO
 * @createTime 2022年08月20日 15:52:00
 */
public class TestStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){return 0;}
        if(haystack.length() < needle.length()) { return -1;}
        //1 2 3 4 5   1 2
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if (needle.equals(haystack.substring(i,needle.length()+i))){
                return i;
            }
        }
        return -1;
    }
}
