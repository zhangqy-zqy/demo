package com.example.demo.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName UserThreadFactory.java
 * @Description TODO
 * @createTime 2022年08月15日 16:42:00
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    //	定义线程组名称，在 jstack 问题排查时，非常有帮助
    public UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "From UserThreadFactory's " + whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0);
        System.out.println(thread.getName());
        return thread;
    }
}

