package com.example.demo.interfaceTest;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName IInterface.java
 * @Description TODO
 * @createTime 2022年08月09日 16:10:00
 */
@FunctionalInterface
public interface IInterface {

    default void test(){};
    public void name();

}
