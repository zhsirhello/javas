package algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 利用lindedhashmap实现LRU
 * @param <K>
 * @param <V>
 */
public class LRUImple1<K,V> extends LinkedHashMap<K,V> {
    private int cachesize;
    public LRUImple1(int cache){
        super(16,0.75f,true);
        this.cachesize=cache;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>cachesize;
    }
}
