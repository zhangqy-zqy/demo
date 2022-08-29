package com.example.demo.algorithm;

import java.util.Stack;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestAddBinary.java
 * @Description TODO
 * @createTime 2022年08月20日 16:18:00
 */
public class TestAddBinary {
    public static void main(String[] args) {
        String s = addBinary("100", "110010");
        System.out.println(s);
    }

    public static String addBinary(String a, String b) {
        //a = "11", b = "1"
        Stack<String> aStackNumber = new Stack<>();
        Stack<String> bStackNumber = new Stack<>();
        Stack<String> returnStackNumber = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            aStackNumber.push(String.valueOf(a.charAt(i)));
        }
        for (int i = 0; i < b.length(); i++) {
            bStackNumber.push(String.valueOf(b.charAt(i)));
        }
        int index = 0;
        String pre = "0";
        while (aStackNumber.size() > 0 && bStackNumber.size() > 0) {
            String aStr = aStackNumber.pop();
            String bStr = bStackNumber.pop();
            if ("0".equals(aStr) && "0".equals(bStr)) {
                if ("0".equals(pre)) {
                    returnStackNumber.push("0");
                } else {
                    returnStackNumber.push("1");
                }
                pre = "0";
            } else if (("1".equals(aStr) && "0".equals(bStr)) || ("1".equals(bStr) && "0".equals(aStr))) {
                if ("0".equals(pre)) {
                    returnStackNumber.push("1");
                    pre = "0";
                } else {
                    returnStackNumber.push("0");
                    pre = "1";
                }
            } else if (("1".equals(aStr) && "1".equals(bStr))) {
                if ("0".equals(pre)) {
                    returnStackNumber.push("0");
                } else {
                    returnStackNumber.push("1");
                }
                pre = "1";
            }
            index++;
        }
        while (aStackNumber.size() > 0) {
            String pop = aStackNumber.pop();
            if ("1".equals(pop)) {
                if ("0".equals(pre)) {
                    returnStackNumber.push("1");
                    pre = "0";
                } else {
                    returnStackNumber.push("0");
                    pre = "1";
                }
            } else {
                if ("0".equals(pre)) {
                    returnStackNumber.push("0");
                } else {
                    returnStackNumber.push("1");
                }
                pre = "0";
            }
        }
        while (bStackNumber.size() > 0) {
            String pop = bStackNumber.pop();
            if ("1".equals(pop)) {
                if ("0".equals(pre)) {
                    returnStackNumber.push("1");
                    pre = "0";
                } else {
                    returnStackNumber.push("0");
                    pre = "1";
                }
            } else {
                if ("0".equals(pre)) {
                    returnStackNumber.push("0");
                } else {
                    returnStackNumber.push("1");
                }
                pre = "0";
            }
        }
        if ("1".equals(pre)) {
            returnStackNumber.push("1");
        }
        StringBuilder str = new StringBuilder();
        while (returnStackNumber.size() > 0) {
            str.append(returnStackNumber.pop());
        }
        return str.toString();
    }

}
