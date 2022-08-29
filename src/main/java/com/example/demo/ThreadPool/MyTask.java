package com.example.demo.ThreadPool;

import java.util.concurrent.Callable;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName MyTask.java
 * @Description TODO
 * @createTime 2022年08月10日 17:56:00
 */
public class MyTask implements Callable<Integer> {

    private Integer num;


    public MyTask(Integer num) {
        this.num = num;
    }


    private Integer process() {
        try {
            Thread.sleep(200);	//模拟处理延时
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this.num+1;	//整数进行加1操作
    }

    @Override
    public Integer call() throws Exception {
        return process();
    }


}
