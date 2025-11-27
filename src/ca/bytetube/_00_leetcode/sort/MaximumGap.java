package ca.bytetube._00_leetcode.sort;

import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-gap/
 *
 * @author dall.
 */
public class MaximumGap {
    public static void main(String[] args) {
        System.out.println((1000000000 - 9) * 9);
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) return 0;
        int[] maxes = new int[len + 1];
        int[] mins = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            int index = bucketIndex(nums[i], len, min, max);
            mins[index] = hasNum[index] ? Math.min(mins[index], nums[i]) : nums[i];
            maxes[index] = hasNum[index] ? Math.max(maxes[index], nums[i]) : nums[i];
            hasNum[index] = true;
        }
        int maxGap = 0;
        int lastMax = maxes[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                maxGap = Math.max(maxGap, mins[i] - lastMax);
                lastMax = maxes[i];
            }
        }


        return maxGap;
    }

    //[1000000000,99999999,9999999,999999,99999,9999,999,99,9]
    private int bucketIndex(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

}
