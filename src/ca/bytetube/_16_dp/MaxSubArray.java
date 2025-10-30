package ca.bytetube._16_dp;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("array can not be null or empty! ");
        if (nums.length == 1) return nums[0];
        //① Define state
        int dp = nums[0];
        int max = nums[0];
        //③ Determine the state transition equation
        for (int i = 1; i < nums.length; i++) {
            //if dp(i – 1) ≤ 0, dp(i) = nums[i]
            if (dp <= 0) dp = nums[i];
                //if dp(i – 1) > 0, dp(i) = dp(i – 1) + nums[i]
            else dp = nums[i] + dp;
            max = Math.max(max, dp);
        }

        return max;

    }


    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("array can not be null or empty! ");
        if (nums.length == 1) return nums[0];
        //① Define state
        int[] dp = new int[nums.length];
        //② Set initial state (boundary)
        dp[0] = nums[0];
        int max = dp[0];
        //③ Determine the state transition equation
        for (int i = 1; i < nums.length; i++) {
            //if dp(i – 1) ≤ 0, dp(i) = nums[i]
            if (dp[i - 1] <= 0) dp[i] = nums[i];
                //if dp(i – 1) > 0, dp(i) = dp(i – 1) + nums[i]
            else dp[i] = nums[i] + dp[i - 1];
            max = Math.max(max, dp[i]);
        }

        return max;

    }
}
