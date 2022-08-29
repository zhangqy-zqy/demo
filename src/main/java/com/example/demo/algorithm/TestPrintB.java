package com.example.demo.algorithm;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestPrintB.java
 * @Description 输出二级制32位
 * @createTime 2022年08月18日 19:26:00
 */
public class TestPrintB {

    public static void main(String[] args) {
        int num=-1;
        printB(num);
        //8的32位  00000000000000000000000000001000
        //-1的32位  11111111111111111111111111111111
        //第一个是符号位   取反 +1
        // << 左移
        //  >> 带符号右移    >>> 无符号右移
        //相反数  取反加1  b=5  c=-b    c=~b+1

        int a=-2;
        printB(a);
        int b=~a+1;
        System.out.println(b);
        printB(b);
    }

    public static void printB(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print(((num&(1<<i)) == 0) ? "0" : 1);
        }
        System.out.println();
    }
}
