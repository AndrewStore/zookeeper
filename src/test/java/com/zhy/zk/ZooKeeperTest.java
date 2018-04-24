package com.zhy.zk;

import org.apache.zookeeper.*;

public class ZooKeeperTest {

    public static final String connctAddr = "192.168.6.128:2181,192.168.6.129:2181,192.168.6.130:2181";

    public static final int sessionTimeOut = 2000;

    public static void main(String[] args) throws Exception{


        final ZooKeeper zk = new ZooKeeper(connctAddr, sessionTimeOut, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.getType()+"--------"+event.getPath());
            }
        });

        System.out.println("--------创建节点---------");
        if(zk.exists("/test",false)==null){
               zk.create("/test","znode1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        System.out.println("---------查看节点是否创建成功----------");
        System.out.println(new String(zk.getData("/test",false,null)));
        //
        //System.out.println("---------修改节点的数据---------");
        //zk.setData("/test","NewZNode1".getBytes(),-1);
        //System.out.println("---------查看修改是否成功--------");
        //System.out.println(new String(zk.getData("/test",false,null)));
        //
        //System.out.println("---------删除节点---------");
        //zk.delete("/test",-1);
        //System.out.println("---------查看是否删除成功---------");
        //System.out.println("节点状态：" + zk.exists("/test", false));
        //zk.close();
        //ZooKeeper zk = new ZooKeeper("192.168.6.130:2181", 3000, null);
        //System.out.println("=========创建节点===========");
        //if(zk.exists("/test", false) == null)
        //{
        //    zk.create("/test", "znode1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //}
        //System.out.println("=============查看节点是否安装成功===============");
        //System.out.println(new String(zk.getData("/test", false, null)));
        //
        //System.out.println("=========修改节点的数据==========");
        //zk.setData("/test", "zNode2".getBytes(), -1);
        //System.out.println("========查看修改的节点是否成功=========");
        //System.out.println(new String(zk.getData("/test", false, null)));
        //
        //System.out.println("=======删除节点==========");
        //zk.delete("/test", -1);
        //System.out.println("==========查看节点是否被删除============");
        //System.out.println("节点状态：" + zk.exists("/test", false));
        //zk.close();
    }
}