package ca.bytetube._17_sort.uncmp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        Double[] arr = {0.34, 0.47, 0.29, 0.84, 0.45, 0.38, 0.35, 0.76};
        sort(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void sort(Double[] arr) {
        List<Double>[] buckets = new List[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (int) (arr[i] * buckets.length);
            List<Double> bucket = buckets[bucketIndex];
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[bucketIndex] = bucket;
            }
            bucket.add(arr[i]);
        }
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            buckets[i].sort(null);
            for (double d : buckets[i]) arr[index++] = d;
        }
    }
}
