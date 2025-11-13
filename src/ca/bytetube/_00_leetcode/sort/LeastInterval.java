package ca.bytetube._00_leetcode.sort;

import java.util.Map;

/**
 * https://leetcode.com/problems/task-scheduler/
 *
 * @author dall.
 */
public class LeastInterval {
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
}
