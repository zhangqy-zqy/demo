package com.example.demo.conf;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName WorkProcess.java
 * @Description TODO
 * @createTime 2022年07月25日 16:58:00
 */
public class WatchProcess implements Watcher, AsyncCallback.StatCallback, AsyncCallback.DataCallback {

    private ZooKeeper zk;
    private String path;
    private DataConf dataConf;
    private CountDownLatch ct=new CountDownLatch(1);

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    public DataConf getDataConf() {
        return dataConf;
    }

    public void setDataConf(DataConf dataConf) {
        this.dataConf = dataConf;
    }

    public void watch(String path) throws InterruptedException {
        this.path=path;
        this.zk.exists(this.path,this,this,"ABC");
        //exit是异步的，因此可能数据还没有取回来，往下执行了，因此让他阻塞住；
        ct.await();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.EventType type = watchedEvent.getType();
        switch (type) {
            case None:
                break;
            case NodeCreated:
                zk.getData(path,this,this,"statCallBack");
                break;
            case NodeDeleted:
                this.dataConf.setData("");
                ct=new CountDownLatch(1);
                break;
            case NodeDataChanged:
                zk.getData(path,this,this,"statCallBack");
                break;
            case NodeChildrenChanged:
                break;
        }


    }

    @Override
    public void processResult(int i, String s, Object o, Stat stat) {
        if(stat!=null){
            zk.getData(path,this,this,"statCallBack");
        }

    }

    @Override
    public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
        if(stat!=null){
            this.dataConf.setData(new String(bytes));
            //当数据取回来的时候 让阻塞的解开往下执行
            ct.countDown();
        }

    }
}
