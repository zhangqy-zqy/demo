package com.example.demo.testCode;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName TestClas.java
 * @Description TODO
 * @createTime 2021年05月27日 10:29:00
 */
public class TestDemo {


    public static void main(String[] args) throws Exception {


        CountDownLatch countDownLatch = new CountDownLatch(1);


        ZooKeeper zk=new ZooKeeper("node03:2181,node02:2181,node04:2181",
                30000,
                new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        String path = watchedEvent.getPath();
                        Event.KeeperState state = watchedEvent.getState();
                        Event.EventType type = watchedEvent.getType();
                        switch (type){
                            case None:
                                break;
                            case NodeCreated:
                                break;
                            case NodeDeleted:
                                break;
                            case NodeDataChanged:
                                break;
                            case NodeChildrenChanged:
                                break;
                        }

                        switch (state){
                            case Unknown:
                                break;
                            case Disconnected:
                                System.out.println("Disconnected........");
                                break;
                            case NoSyncConnected:
                                break;
                            case SyncConnected:
                                System.out.println("SyncConnected........");
                                countDownLatch.countDown();
                                break;
                            case AuthFailed:
                                break;
                            case ConnectedReadOnly:
                                break;
                            case SaslAuthenticated:
                                break;
                            case Expired:
                                break;
                        }
                    }
                });


        countDownLatch.await();
        ZooKeeper.States state = zk.getState();
        switch (state) {
            case CONNECTING:
                System.out.println("ing........");
                break;
            case ASSOCIATING:
                break;
            case CONNECTED:
                System.out.println("ed........");
                break;
            case CONNECTEDREADONLY:
                break;
            case CLOSED:
                break;
            case AUTH_FAILED:
                break;
            case NOT_CONNECTED:
                break;
        }


        String data = zk.create("/xxoo", "olddata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        Stat stat= new  Stat();
        zk.getData("/xxoo", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("getData watch: "+watchedEvent.toString());
                try {
                    zk.getData("/xxoo",this,stat);
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },stat);

        Stat stat1 = zk.setData("/xxoo", "newdata".getBytes(), stat.getVersion());
        zk.setData("/xxoo", "newdata".getBytes(),stat1.getVersion() );


        Thread.sleep(222222222222L);
    }


}
