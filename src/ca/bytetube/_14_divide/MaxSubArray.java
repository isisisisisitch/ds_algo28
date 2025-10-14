package ca.bytetube._14_divide;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * @author dall.
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("array can not be null or empty! ");
        if (nums.length == 1) return nums[0];

        return maxSubArray(nums, 0, nums.length);

    }

    private int maxSubArray(int[] nums, int start, int end) {

        if (end - start < 2) return nums[start];

        int mid = (start + end) >> 1;
        int leftSum = 0;
        int leftMax = Integer.MIN_VALUE;
        for (int i = mid - 1; i >= start; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }


        int rightSum = 0;
        int rightMax = Integer.MIN_VALUE;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);

        }

        return Math.max(Math.max(maxSubArray(nums, start, mid), maxSubArray(nums, mid, end)), (leftMax + rightMax));
    }


    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("array can not be null or empty! ");
        if (nums.length == 1) return nums[0];
        int maxSum = nums[0];
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }


    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("array can not be null or empty! ");
        if (nums.length == 1) return nums[0];
        int maxSum = nums[0];
        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
