package com.example.demo.algorithm;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestIsValid.java
 * @Description TODO
 * @createTime 2022年08月19日 14:11:00
 */
public class TestIsValid {
    private static Logger logger=LoggerFactory.getLogger(TestIsValid.class);

    public static boolean isValid(String s) {
        if ((s.length() % 2) != 0) {
            return false;
        }
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("[", "]");
        hashMap.put("(", ")");
        hashMap.put("{", "}");
        StringBuilder str=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String chartAtStr = hashMap.get(String.valueOf(s.charAt(i)));
            if(chartAtStr!=null){
                str.append(s.charAt(i));
            }else{
                if(str.length()-1<0){
                    return false;
                }
                String preStr = hashMap.get(String.valueOf(str.charAt(str.length() - 1)));
                if(!String.valueOf(s.charAt(i)).equals(preStr)){
                    return false;
                }
                str.delete(str.length() - 1,str.length());
            }

        }
        return str.length() <= 0;
    }

    public static void main(String[] args) {
        //String str="(([]){})";
        //String str="{[]}";
        //String str="([)]";
        String str=")(";
        boolean valid = isValid(str);
        System.out.println(valid);
        logger.info("asdasdasd");
        Assert.assertEquals(1,2);
    }
}
