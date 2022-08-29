package com.example.demo.info;

import com.example.demo.info.impl.ProxyInvocationStudent;
import com.example.demo.info.impl.Student;
import com.example.demo.info.impl.StudentProxy;

import java.lang.reflect.Proxy;

public class ReflyUtil {
    public static void main(String[] args) {

        Student student = new Student("zhangsan");
        String giveMoney = student.getGiveMoney();
        System.out.println(giveMoney);
        System.out.println("-------------------");
        //1.静态代理
        StudentProxy studentProxy = new StudentProxy(student);
        String giveMoney1 = studentProxy.getGiveMoney();
        System.out.println(giveMoney1);
        System.out.println("-------------------");

        //2.动态代理
        ProxyInvocationStudent<Person> personProxyInvocationStudent = new ProxyInvocationStudent(student);
        Person person = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, personProxyInvocationStudent);
        System.out.println(person.getGiveMoney());
    }
}
