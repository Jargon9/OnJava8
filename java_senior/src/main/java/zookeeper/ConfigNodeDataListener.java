package zookeeper;


import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;

import java.nio.charset.Charset;

public class ConfigNodeDataListener implements NodeCacheListener {
    NodeCache nodeCache;

    public ConfigNodeDataListener(NodeCache nodeCache) {
        this.nodeCache = nodeCache;
    }


    @Override
    public void nodeChanged() throws Exception {
        ChildData currentData = nodeCache.getCurrentData();
        System.out.println("处理数据：" + (System.currentTimeMillis()- Long.valueOf(new String(currentData.getData(), Charset.defaultCharset()))));
    }
}
