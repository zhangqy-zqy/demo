package com.example.demo.info.impl;

import com.example.demo.info.Person;

public class StudentProxy implements Person {

    private Student stu;

    public StudentProxy(Student stu) {
        if(stu.getClass()==Student.class){
            this.stu=stu;
        }
    }

    @Override
    public String getGiveMoney() {
        System.out.println("这是代理交的学费！");
        return stu.getGiveMoney();
    }
}
