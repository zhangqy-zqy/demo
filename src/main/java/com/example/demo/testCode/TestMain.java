package com.example.demo.testCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestMain.java
 * @Description TODO
 * @createTime 2022年07月25日 10:26:00
 */
public class TestMain {
    public static void main(String[] args) {

        ConcurrentHashMap<String, String> stringConcurrentHashMap = new ConcurrentHashMap<>();
        stringConcurrentHashMap.put(null,null);

        List<String> strings = Collections.synchronizedList(new ArrayList<String>());
    }
}
