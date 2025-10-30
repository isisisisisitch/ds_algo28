package ca.bytetube._16_dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
//        System.out.println(coinChange3(41));
//        System.out.println(coinChange2(41));
//        System.out.println(coinChange1(41));
        System.out.println(Integer.MAX_VALUE + 1);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];//0
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin || dp[i - coin] == -1) continue;
                min = Math.min(dp[i - coin], min);
            }
            if (min == Integer.MAX_VALUE) dp[i] = -1;
            else dp[i] = min + 1;

        }

        return dp[amount];
    }


    public static int coinChange3(int n) {
        int[] dp = new int[n + 1];//0
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE - 1;
            if (i >= 1) min = Math.min(dp[i - 1], min);//2
            if (i >= 5) min = Math.min(dp[i - 5], min);
            if (i >= 20) min = Math.min(dp[i - 20], min);
            if (i >= 25) min = Math.min(dp[i - 25], min);
            dp[i] = min + 1;

        }

        return dp[n];
    }


    public static int coinChange2(int n) {

        int[] coins = {1, 5, 20, 25};
        int[] dp = new int[n + 1];//is the minimum number of coins needed to get n cents

        for (int coin : coins) {
            if (n < coin) continue;
            dp[coin] = 1;
        }

        return coinChange2(n, dp);

    }

    private static int coinChange2(int n, int[] dp) {
        if (n < 1) return Integer.MAX_VALUE - 1;
        if (dp[n] == 0) {
            int min1 = Math.min(coinChange2(n - 25, dp), coinChange2(n - 20, dp));
            int min2 = Math.min(coinChange2(n - 5, dp), coinChange2(n - 1, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }


    public static int coinChange1(int n) {
        if (n < 1) return Integer.MAX_VALUE - 1;

        if (n == 25 || n == 20 || n == 5 || n == 1) return 1;
        int min1 = Math.min(coinChange1(n - 25), coinChange1(n - 20));
        int min2 = Math.min(coinChange1(n - 5), coinChange1(n - 1));

        return Math.min(min1, min2) + 1;

    }
}
