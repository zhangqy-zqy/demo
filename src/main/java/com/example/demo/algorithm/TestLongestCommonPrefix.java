package com.example.demo.algorithm;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestLongestCommonPrefix.java
 * @Description 最长公共前缀
 * @createTime 2022年08月19日 09:19:00
 */
public class TestLongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1 || "".equals(strs[0])){return strs[0];}
        StringBuilder strPrefix = new StringBuilder();
        int index=0;
        for (int i = 0; i < strs[0].length(); i++) {
            char prefixChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if ((str.length()<index+1)  || (str.charAt(index)!= prefixChar)){
                    return strPrefix.toString();
                }
            }
            strPrefix.append(prefixChar);
            index++;
        }
        return strPrefix.toString();
    }
}
