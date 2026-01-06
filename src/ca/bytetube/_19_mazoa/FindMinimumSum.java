package ca.bytetube._19_mazoa;

public class FindMinimumSum {
    public static void main(String[] args) {
        int[] power = {3, 4, 1, 6, 2};
        System.out.println(findMinSum2(power));
    }

    public static int findMinSum2(int[] power) {
        int minSum = 0;
        int prev = power[0];
        for (int i = 1; i < power.length; i++) {
            if (power[i] < prev) {
                minSum += prev - power[i];
            } else {
                prev = power[i];
            }
        }

        return minSum;
    }


    public static int findMinSum(int[] power) {
        int n = power.length;
        int minSum = 0;
        for (int i = 0; i < n - 1; i++) {
            int diff = power[i + 1] - power[i];
            if (diff < 0) {
                minSum -= diff;
            }
        }
        return minSum;
    }
}
