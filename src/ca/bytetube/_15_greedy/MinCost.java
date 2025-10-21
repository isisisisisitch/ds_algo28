package ca.bytetube._15_greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A gold bar needs to be cut into two pieces, and each cut costs a number of coins equal to the bar’s current length.
 * For example, if the bar’s length is 20, no matter how it’s divided, the cut will cost 20 coins.
 * <p>
 * A group of people wants to divide the gold bar into exact portions, and the goal is to minimize the total cutting cost.
 * <p>
 * For instance, given the array {10, 20, 30}, representing three people, the total gold bar length is 10 + 20 + 30 = 60.
 * The bar needs to be divided into parts of lengths 10, 20, and 30.
 * • If you first cut the 60-length bar into 10 and 50, the cost is 60; then cut the 50-length bar into 20 and 30,
 * costing 50, for a total of 110 coins.
 * • However, if you first cut the 60-length bar into 30 and 30, costing 60, then cut one of the 30-length bars
 * into 10 and 20, costing 30, the total cost is only 90 coins.
 * <p>
 * The problem:
 * Given an array of integers representing target segment lengths,
 * return the minimum total cutting cost to divide the gold bar accordingly.
 */
public class MinCost {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 4, 3, 7, 1, 8};
        System.out.println(minCost(arr));
        System.out.println(minCost1(arr));
    }


    public static int minCost(int[] arr) {
        int minCost = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int e : arr) heap.add(e);

        while (heap.size() > 1) {
            int subCost = heap.poll() + heap.poll();
            minCost += subCost;
            heap.add(subCost);
        }

        return minCost;

    }

    public static int minCost1(int[] arr) {
        Arrays.sort(arr);
        int minCost = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            int subCost = subSum(arr, i);
            minCost += subCost;
        }

        return minCost;
    }

    private static int subSum(int[] arr, int len) {
        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += arr[i];
        }

        return sum;
    }
}
