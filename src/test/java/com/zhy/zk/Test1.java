package com.zhy.zk;

import org.apache.zookeeper.*;

public class Test1 {
    private static final String connectString = "192.168.6.130:2181";
    private static final int sessionTimeout = 20000;


    public static void main(String[] arg) throws Exception{
        ZooKeeper zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // 鏀跺埌浜嬩欢閫氱煡鍚庣殑鍥炶皟鍑芥暟锛堝簲璇ユ槸鎴戜滑鑷繁鐨勪簨浠跺鐞嗛�昏緫锛�
                System.out.println(event.getType() + "---" + event.getPath());
            }
        });
        String nodeCreated = zkClient.create("/eclipse", "hellozk".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }


}
