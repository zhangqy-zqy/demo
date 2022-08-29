package com.example.demo.ThreadPool;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName MyTest.java
 * @Description TODO
 * @createTime 2022年08月10日 17:58:00
 */
public class MyTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        ThreadPoolExecutor executor = MyThreadPool.createThreadPool();

        List<Future<Integer>> list = new LinkedList<>();
        List<Integer> tempList = new ArrayList<>();
        //创建测试用例
        for (int i = 0; i < 100; i++) {
            tempList.add(100 * (i + 1));
        }
        for (int i = 0; i < tempList.size(); i++) {
            MyTask worker = new MyTask(tempList.get(i));    //执行任务
            //下面两行代码是将执行的返回结果进行汇总
            Future<Integer> submit = executor.submit(worker);
            list.add(submit);
        }
        List<Integer> result = new LinkedList<>();
        for (Future<Integer> f : list) {
            //将汇总好的结果进行轮询，判断任务是否执行完成，确保每个任务执行完成后将结果添加到结果集中
            while (true) {
                if (f.isDone() && !f.isCancelled()) {
                    Integer object = f.get();
                    result.add(object);
                    break;
                }
            }
        }
//		List<Integer> result = new LinkedList<>();
//		for(int i=0; i<tempList.size(); i++) {
//			Thread.sleep(200);
//			Integer integer = tempList.get(i);
//			result.add(integer+1);
//		}
        System.out.println("最终汇总结果：");
        System.out.println(result);
        long end = System.currentTimeMillis();
        System.out.println("work time:" + (end - start) + "ms");
        //终止线程
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");

        int a = 10;
        int b = 20;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        int c = a ^ b;
        System.out.println("c=" + c);

        if (a == 1) {
            System.out.println("a=" + a);
        } else if (a == 2) {
            System.out.println("a=" + a);
        }

        // 注释和注释内容之间只有一个空格
        int x = 1 << 2;
        int z = 3 << 2;
        int testMethod = testMethod(x, z);
        System.out.println(testMethod);


        // 不要用过时的方法  equals方法
        boolean b1 = Objects.equals("xyz", "asd");
        ArrayList<String> list2=new ArrayList();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        List<String> strings = list2.subList(1, 3);
        strings.forEach(System.out::println);
        strings.add("5");
        strings.add("6");
        strings.add("7");
        strings.forEach(System.out::println);
        list2.forEach(System.out::println);
        String[] strings1 = list2.toArray(new String[0]);
        for (String s:strings1){
            System.out.println(s);
        }
    }


    // 注解 deprecated 是启用的含义
    @Deprecated
    public static int testMethod(int a, int b) {
        return a + b;
    }


    public static Boolean equals(String str1, String str2, String str3){
        BigDecimal a = new BigDecimal(str1);
        BigDecimal b = new BigDecimal(str2);
        BigDecimal c = new BigDecimal(str3);
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);
        if (x.equals(y)) {
            System.out.println("true");
            return true;
        } else {
            return false;
        }

    }

}
