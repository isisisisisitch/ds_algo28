package ca.bytetube._17_sort.uncmp;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        Integer[] arr = {7, 3, 5, 8, 6, 7, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Integer[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
            if (min > arr[i]) min = arr[i];
        }
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) counts[arr[i] - min]++;
        for (int i = 1; i < counts.length; i++) counts[i] += counts[i - 1];
        int[] newArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) newArray[--counts[arr[i] - min]] = arr[i];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArray[i];
        }
    }

    public static void sort1(Integer[] arr) {

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }

        int[] counts = new int[max + 1];
        for (int i = 0; i < arr.length; i++) counts[arr[i]]++;
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                arr[index++] = i;
            }
        }

    }

//    private static void printArray(Integer[] arr){
//        for ()
//    }
}
