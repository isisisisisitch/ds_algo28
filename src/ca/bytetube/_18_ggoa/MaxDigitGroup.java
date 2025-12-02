package ca.bytetube._18_ggoa;

import java.util.ArrayList;
import java.util.List;

public class MaxDigitGroup {

    private static boolean shareDigit(int a, int b) {
        int a1 = a / 10, a2 = a % 10;
        int b1 = b / 10, b2 = b % 10;
        return a1 == b1 || a1 == b2 || a2 == b1 || a2 == b2;
    }

    public static int solution2(int[] numbers) {
        int maxGroup = 0;
        for (int d = 0; d <= 9; d++) {
            List<Integer> candidates = new ArrayList<>();
            for (int num : numbers) {
                int t = num / 10, o = num % 10;
                if (t == d || o == d) {
                    candidates.add(num);
                }
            }
            int n = candidates.size();
            boolean valid = true;
            for (int i = 0; i < n && valid; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (!shareDigit(candidates.get(i), candidates.get(j))) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                maxGroup = Math.max(maxGroup, n);
            }
        }


        return maxGroup;
    }


    public static int solution1(int[] numbers) {
        int[] digits = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            int ones = numbers[i] % 10;
            int tens = (numbers[i] - ones) / 10;
            digits[ones]++;
            if (tens != ones) digits[tens]++;
        }
        int max = 1;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, digits[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{52, 25, 11, 52, 34, 55}));  // 4
        System.out.println(solution2(new int[]{71, 23, 57, 15}));          // 2
        System.out.println(solution2(new int[]{11, 33, 55}));              // 1
        System.out.println(solution2(new int[]{90, 90, 90}));              // 3
    }
}
