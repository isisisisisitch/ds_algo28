package ca.bytetube._17_sort.cmp;

import ca.bytetube._17_sort.utils.Asserts;
import ca.bytetube._17_sort.utils.Integers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] randomArray = Integers.random(20000, 1, 2000000);
        testSorts(randomArray, new BubbleSort(),
                new BubbleSort2(),
                new BubbleSort3(),
                new SelectionSort(),
                new InsertionSort(),
                new InsertionSort2(),
                new InsertionSort3(),
                new HeapSort(),
                new MergeSort()
                );
    }

    public static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }

        Arrays.sort(sorts);
        for (Sort s : sorts) {
            System.out.println(s);
        }
    }
}
