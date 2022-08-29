package com.example.demo.info.impl;

import com.example.demo.info.Person;

/**
 * @author zhangqy
 */
public class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String getGiveMoney() {
        return this.name+"上交了50元钱！";
    }
}
