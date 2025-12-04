package ca.bytetube._18_ggoa;

public class FourDigits {
    public static int solution(int S) {

        int[][] dp = new int[5][37];
        dp[0][0] = 1;
        for (int i = 1; i <= 4; i++) {
            for (int s = 0; s <= 36; s++) {
                int ways = 0;
                for (int d = 0; d <= 9; d++) {
                    //d
                    if (s - d >= 0) {
                        ways += dp[i - 1][s - d];
                    }

                }
                dp[i][s] = ways;
            }
        }


        return dp[4][S];

    }

    public static void main(String[] args) {
        System.out.println("S=35 -> " + solution(35) + " (expected 4)");
        System.out.println("S=4  -> " + solution(4) + " (expected 35)");
        System.out.println("S=2  -> " + solution(2) + " (expected 10)");
        System.out.println("S=0  -> " + solution(0) + " (expected 1)");
        System.out.println("S=36 -> " + solution(36) + " (expected 1)");
        System.out.println("S=18 -> " + solution(18) + " (expected 670)");
    }
}
