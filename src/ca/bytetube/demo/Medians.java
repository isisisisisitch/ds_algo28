package ca.bytetube.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Medians {
    public static void main(String[] args) {
        int[] median = median(new int[]{1, 2, 3}, 2);
        for (int i = 0; i < median.length; i++) {
            System.out.println(median[i]);
        }
    }


    public static int[] median(int[] values, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : values) {
            maxHeap.offer(v);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] minArr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            minArr[i] = maxHeap.poll();
        }

        Arrays.sort(minArr);
        int minMedian = minArr[(k - 1) / 2];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int v : values) {
            minHeap.offer(v);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] maxArr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            maxArr[i] = minHeap.poll();
        }

        Arrays.sort(maxArr);
        int maxMedian = maxArr[(k - 1) / 2];

        return new int[]{maxMedian, minMedian};
    }
}
