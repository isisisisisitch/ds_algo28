package ca.bytetube._00_leetcode.sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * @author dall.
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freq.keySet()) {
            int f = freq.get(key);
            if (buckets[f] == null) buckets[f] = new LinkedList<>();
            buckets[f].add(key);
        }
        
        int[] res = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k ; i--) {
            if (buckets[i] != null) {
                for (int n:  buckets[i]){
                    res[index++] = n;
                    if (index == k) return res;
                }
            }
        }
        

        return res;
    }
}
