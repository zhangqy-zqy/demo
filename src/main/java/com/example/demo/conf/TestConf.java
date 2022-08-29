package com.example.demo.conf;

import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestConf.java
 * @Description TODO
 * @createTime 2022年07月25日 16:51:00
 */
public class TestConf {

    private ZooKeeper zk;
    private CountDownLatch cdlStartUp=new CountDownLatch(1);


    @Before
    public void before() throws Exception {
        String localHost="node02:2181,node03:2181,node04:2181/AppConf";
        DefaultWatch defaultWatch = new DefaultWatch(this.cdlStartUp);
        this.zk=new ZooKeeper(localHost,1000,defaultWatch);
        cdlStartUp.await();
    }

    @After
    public void after() throws Exception {
        this.zk.close();
    }


    @Test
    public void conf() throws Exception {
        String path="/xxoo";
        DataConf dataConf = new DataConf();
        WatchProcess watchProcess = new WatchProcess();
        watchProcess.setZk(this.zk);
        watchProcess.setDataConf(dataConf);

        watchProcess.watch(path);

        //1，节点不存在
        //2，节点存在

        while(true){

            if(dataConf.getData().equals("")){
                System.out.println("conf diu le ......");
                watchProcess.watch(path);
            }else{
                System.out.println(dataConf.getData());

            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
