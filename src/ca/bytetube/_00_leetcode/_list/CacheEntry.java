package ca.bytetube._00_leetcode._list;

public interface CacheEntry<V> {
    V getValue();

    void setValue(V value);

    long getLastAccessTime();

    void updateLastAccessTime();
}
