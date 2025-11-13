package ca.bytetube._17_sort.cmp;

public class InsertionSort3<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int start = 1; start < array.length; start++) {
            T val = array[start];
            int insertIndex = search(start);
            for (int i = start; i > insertIndex; i--) {
                array[i] = array[i - 1];
            }
            array[insertIndex] = val;
        }
    }

    private int search(int index) {
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(array[index], array[mid]) < 0) end = mid;
            else begin = mid + 1;

        }

        return begin;
    }
}
