package ca.bytetube._00_leetcode.sort;

import java.util.*;

/**
 * https://leetcode.com/problems/task-scheduler/
 *
 * @author dall.
 */
public class LeastInterval {
    public static void main(String[] args) {
        leastInterval2(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }

    //slot = (maxFreq -1) * (n + 1) + countMax;
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        int maxFreq = 0;
        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
            }
        }
        int countMax = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                countMax++;
            }
        }

        int slots = (maxFreq - 1) * (n + 1) + countMax;
        return Math.max(tasks.length, slots);

    }

    public static int leastInterval2(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int f : freq) {
            if (f > 0) maxHeap.add(f);
        }
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();//tasks not completed
            int cycle = n + 1;

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int cur = maxHeap.poll();
                if (cur - 1 > 0) temp.add(cur - 1);
                time++;
                cycle--;
            }
            for (int remaining : temp) maxHeap.add(remaining);
            if (maxHeap.isEmpty()) break;
            time += cycle;//idle
        }
        return time;
    }
}
