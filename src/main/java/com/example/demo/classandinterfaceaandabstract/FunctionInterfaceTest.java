package com.example.demo.classandinterfaceaandabstract;

/**
 * @author zhangqy
 * @description TODO
 * @createTime 2022年09月01日 07:24:00
 */
@FunctionalInterface
public interface FunctionInterfaceTest {
    /**
     * 函数接口方法
     */
    public void functionInterfaceMethod();

    /**
     * 可以自定义方法
     */
    default void functionInterfaceMethod1(){};
}
