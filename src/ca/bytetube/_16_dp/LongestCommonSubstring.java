package ca.bytetube._16_dp;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("ABCD", "BABC"));
    }

    public static int longestCommonSubstring(String str1, String str2) {
        char[] nums1 = str1.toCharArray();
        char[] nums2 = str2.toCharArray();
        char[] rowNums = nums1, colNums = nums2;

        if (nums1.length < nums2.length) {
            colNums = nums1;
            rowNums = nums2;
        }

        int[] dp = new int[colNums.length + 1];
        int max = 0;
        for (int i = 1; i <= rowNums.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colNums.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (rowNums[i - 1] == colNums[j - 1]) {
                    dp[j] = leftTop + 1;
                    max = Math.max(max, dp[j]);
                } else dp[j] = 0;
            }
        }

        return max;
    }

    public static int longestCommonSubstring1(String str1, String str2) {
        char[] nums1 = str1.toCharArray();
        char[] nums2 = str2.toCharArray();

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                //if nums1[i – 1] = nums2[ j – 1]，dp(i, j) = dp(i – 1, j – 1) + 1
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }


                //if nums1[i – 1] ≠ nums2[ j – 1]，dp(i, j) = 0
                else dp[i][j] = 0;
            }
        }

        return max;
    }
}
