package zookeeper;

import com.alibaba.fastjson.JSONObject;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author jinxingguang
 */
public class curatorCacheTest {
    private static final String PATH = "/example/cache3";

    private static long time = System.currentTimeMillis();

    public static void main(String[] args) throws Exception
    {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        try (CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", new ExponentialBackoffRetry(1000, 3)))
        {
            client.start();
            try (CuratorCache cache = CuratorCache.build(client, PATH))
            {
                // there are several ways to set a listener on a CuratorCache. You can watch for individual events
                // or for all events. Here, we'll use the builder to log individual cache actions
//                CuratorCacheListener listener = CuratorCacheListener.builder()
//                        .forCreates(node -> System.out.println(String.format("Node created: [%s] cost: [%d]", node, System.currentTimeMillis()-time)))
//                        .forChanges((oldNode, node) -> System.out.println(String.format("Node changed. Old: [%s] New: [%s] cost: [%d]", oldNode, node, System.currentTimeMillis()-time)))
//                        .forDeletes(oldNode -> System.out.println(String.format("Node deleted. Old value: [%s] cost: [%d]", oldNode, System.currentTimeMillis()-time)))
//                        .forInitialized(() -> System.out.println("Cache initialized"))
//                        .build();

                CuratorCacheListener listener = new ConfigDataChangeListener();

                // register the listener
                cache.listenable().addListener(listener);

                // the cache must be started
                cache.start();

                // now randomly create/change/delete nodes
                for ( int i = 0; i < 10; ++i )
                {
                    int depth = random.nextInt(1, 4);
                    String path = makeRandomPath(random, depth);
                    if ( random.nextBoolean() )
                    {
                        HashMap<String, String> map = new HashMap<>();
                        map.put(String.valueOf(i), String.valueOf(random.nextLong()));
                        time = System.currentTimeMillis();
                        String o = JSONObject.toJSONString(map);
                        client.create().orSetData().creatingParentsIfNeeded().forPath(path, o.getBytes());
                        Thread.sleep(1200L);
                    }
                    else
                    {
                        client.delete().quietly().deletingChildrenIfNeeded().forPath(path);
                    }

                    Thread.sleep(5);
                }
            }
        }
    }

    private static String makeRandomPath(ThreadLocalRandom random, int depth)
    {
        if ( depth == 0 )
        {
            return PATH;
        }
        return makeRandomPath(random, depth - 1) + "/" + random.nextInt(3);
    }

}
