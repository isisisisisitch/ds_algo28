package ca.bytetube._15_greedy;

import java.util.Arrays;

public class Pirates {
    public static void main(String[] args) {
        //W is 30, Wi is 3, 5, 4, 10, 7, 14, 2, 11
        System.out.println(pirates(30, new int[]{3, 5, 4, 10, 7, 14, 2, 11}));
    }

    //Every time, give priority to the lightest antique
    public static int pirates(int W, int[] weights) {
        if (W <= 0 || weights == null || weights.length == 0) return 0;
        Arrays.sort(weights);
        int weight = 0;
        int count = 0;
        for (int i = 0; i < weights.length; i++) {
            int newWeight = weights[i] + weight;
            if (newWeight <= W) {
                weight = newWeight;
                count++;
            }
        }

        return count;
    }
}
