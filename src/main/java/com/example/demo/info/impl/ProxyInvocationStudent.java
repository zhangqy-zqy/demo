package com.example.demo.info.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocationStudent<T> implements InvocationHandler {

    private T classT;

    public ProxyInvocationStudent(T classT) {
        this.classT = classT;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("开始进入被代理对象的方法！");

        Object invoke = method.invoke(classT, args);

        System.out.println("结束被代理对象的方法！");


        return invoke;
    }
}
