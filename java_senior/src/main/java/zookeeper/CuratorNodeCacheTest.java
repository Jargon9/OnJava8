package zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorNodeCacheTest {

    private static final String PATH = "/example/cache4";

    public static void main(String[] args) {
        try (CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", new ExponentialBackoffRetry(1000, 3))) {
            client.start();
            Thread.sleep(1000L);
            NodeCache nodeCache = new NodeCache(client, PATH);

            nodeCache.start(true);
            if(nodeCache.getCurrentData() != null){
                System.out.println("节点的初始化数据为："+new String(nodeCache.getCurrentData().getData()));
            }else{
                System.out.println("节点初始化数据为空。。。");
            }

            nodeCache.getListenable().addListener(new ConfigNodeDataListener(nodeCache));

            client.create().orSetData().creatingParentsIfNeeded().forPath(PATH,String.valueOf(System.currentTimeMillis()).getBytes());
            Thread.sleep(50L);
            client.setData().forPath(PATH,String.valueOf(System.currentTimeMillis()).getBytes());
            Thread.sleep(50L);
            client.setData().forPath(PATH,String.valueOf(System.currentTimeMillis()).getBytes());
            Thread.sleep(50L);
            client.setData().forPath(PATH,String.valueOf(System.currentTimeMillis()).getBytes());
            Thread.sleep(50L);
            client.setData().forPath(PATH,String.valueOf(System.currentTimeMillis()).getBytes());
            Thread.sleep(50L);
            client.setData().forPath(PATH,String.valueOf(System.currentTimeMillis()).getBytes());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
