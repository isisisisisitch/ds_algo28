package ca.bytetube._19_amzoa;

import java.util.Arrays;

public class GetValidConfigurations {
    public static void main(String[] args) {
        int[] coordinationThreshold1 = {3, 0, 0, 3, 3};//2
        int[] coordinationThreshold2 = {6, 0, 3, 3, 6, 7, 2, 7};//3
        System.out.println(getValidConfigurations(coordinationThreshold2));

    }

    public static int getValidConfigurations(int[] coordinationThreshold) {
        int n = coordinationThreshold.length;
        //6,0,3,3,6,7,2,7
        //0,2,3,3,6,6,7,7
        Arrays.sort(coordinationThreshold);

        int countAtMostKMinus1 = 0;
        int countAtMostK = 0;
        int validConfigs = 0;
        for (int k = 0; k <= n; k++) {
            int limitForMustWork = k - 1;
            while (countAtMostKMinus1 < n && coordinationThreshold[countAtMostKMinus1] <= limitForMustWork) {
                countAtMostKMinus1++;
            }
            while (countAtMostK < n && coordinationThreshold[countAtMostK] <= k) {
                countAtMostK++;
            }
            if (countAtMostKMinus1 == k && countAtMostK == countAtMostKMinus1) {
                validConfigs++;
            }
        }
        return validConfigs;
    }
}
