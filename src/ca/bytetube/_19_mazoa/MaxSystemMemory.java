package ca.bytetube._19_mazoa;

import java.util.Arrays;

public class MaxSystemMemory {
    public static void main(String[] args) {
        System.out.println(maxSystemMemory(6, new int[]{2, 4, 3, 1, 2, 5}));//1,2,2,3,4,5
        System.out.println(maxSystemMemory(4, new int[]{5, 5, 5, 5}));
    }

    public static int maxSystemMemory(int n, int[] memory) {
        Arrays.sort(memory);

        int capacity = 0;
        for (int i = memory.length - 2; i >= 0; i -= 2) {
            capacity += memory[i];
        }

        return capacity;
    }

}
