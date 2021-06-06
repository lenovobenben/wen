package hash;

import java.util.LinkedHashMap;

/**
 * 面试题 16.25. LRU 缓存
 *
 */
public class LRUCache {
    private int cap;
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>(1024, 0.75f, true);

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public Integer get(int key) {
        Integer res = cache.get(key);
        return res == null ? -1 : res;
    }

    public void put(int key, Integer val) {
        if (cache.size() >= this.cap && !cache.containsKey(key)) {
            // 链表头部就是最久未使用/访问的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }
}