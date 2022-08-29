package com.example.demo.conf;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangqy
 * @version 1.0.0
 * @ClassName DefultWatch.java
 * @Description TODO
 * @createTime 2022年07月25日 16:52:00
 */
public class DefaultWatch implements Watcher {

    private CountDownLatch cdl;

    public DefaultWatch(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.KeeperState state = watchedEvent.getState();
        switch (state) {
            case Unknown:
                break;
            case Disconnected:
                break;
            case NoSyncConnected:
                break;
            case SyncConnected:
                cdl.countDown();
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
}
