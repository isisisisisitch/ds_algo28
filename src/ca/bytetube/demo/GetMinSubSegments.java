package ca.bytetube.demo;

import java.util.Map;

/*
split a string consisting of prefixes of "0" or "1" into several subsegments of even len,
such that each segment can be transformed into "all 1s" or "all 0s" with the min num of flips,
while finding the min num of subsegments under the condition of min flips count
 */
public class GetMinSubSegments {
    public static void main(String[] args) {
        System.out.println(getMinSubSegments("110011"));
    }

    public static int getMinSubSegments(String frames) {
        int n = frames.length();
        int[] pre0 = new int[n + 1];
        int[] pre1 = new int[n + 1];
        char[] charArray = frames.toCharArray();
        for (int i = 1; i <= n; i++) {
            pre0[i] = pre0[i - 1] + (charArray[i - 1] == '0' ? 1 : 0);
            pre1[i] = pre1[i - 1] + (charArray[i - 1] == '1' ? 1 : 0);
        }
        //① Define state dp[i] store the min flips and min segments for the first i characters
        int[] minFlips = new int[n + 1];//0
        int[] minSegs = new int[n + 1];//0

        //② Set initial state (boundary)
        for (int i = 1; i <= n; i++) {
            minFlips[i] = Integer.MAX_VALUE / 2;
            minSegs[i] = Integer.MAX_VALUE / 2;

        }
        minFlips[0] = 0;
        minSegs[0] = 0;

        //③ Determine the state transition equation
        //i indicates the first i characters, eg. "1110011000" i = 4:sub:"1110"
        for (int i = 2; i <= n; i++) {
            //len:len indicates the current even-length
            for (int len = 2; len <= i; len += 2) {
                //j is the beginning of the current subsegments
                int j = i - len;
                int count0 = pre0[i] - pre0[j];
                int count1 = pre1[i] - pre1[j];
                int flips = Math.min(count0, count1);
                int totalFlips = minFlips[j] + flips;
                int totalSegments = minSegs[j] + 1;

                //lexicographic order
                //(3,2)<(3,3)<(4,1)
                if (totalFlips < minFlips[i] || totalFlips == minFlips[i] && totalSegments < minSegs[i]) {
                    minFlips[i] = totalFlips;
                    minSegs[i] = totalSegments;
                }


            }
        }

        return minSegs[n];

    }
}
