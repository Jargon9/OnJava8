package zookeeper;

import com.alibaba.fastjson.JSONObject;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jinxingguang
 */
public class ConfigDataChangeListener implements CuratorCacheListener {

    private String path;


    private static ReentrantLock lock = new ReentrantLock();


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void event(CuratorCacheListener.Type type, ChildData oldData, ChildData newData) {
//        logger.info("Trigger dynamic config change {} {]", type, newData);
        String s = new String(newData.getData(), Charset.defaultCharset());
        Map map = JSONObject.parseObject(s, Map.class);
        switch (type) {
            case NODE_CHANGED:
                 System.out.println(String.format("Node changed. map: [%s]  cost: [%d]", map, System.currentTimeMillis()));
            case NODE_CREATED:
                System.out.println(String.format("Node created: map: [%s] cost: [%d]", map, System.currentTimeMillis()));
            case NODE_DELETED:
                System.out.println(String.format("Node deleted. map: [%s] cost: [%d]", map, System.currentTimeMillis()));
        }
    }
}
