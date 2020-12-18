package bak.me;

import java.util.LinkedHashMap;

/**
 * LRU 实现
 */
public class LRUCache {
    int cap;
    LinkedHashMap<Integer, String> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public String get(int key) {

        if (!cache.containsKey(key)) {
            return "";
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, String val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        String val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);

        cache.put(1,"a");
        cache.put(2,"b");
        cache.put(3,"c");
        cache.put(4,"d");
        cache.put(5,"e");

        cache.put(6,"f");
        cache.get(3);
        cache.get(4);
        cache.put(3,"c");

        System.out.println(cache);

    }
}