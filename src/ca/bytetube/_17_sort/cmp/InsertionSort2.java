package ca.bytetube._17_sort.cmp;

public class InsertionSort2<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int start = 1; start < array.length; start++) {
            int cur = start;
            T val = array[cur];
            while (cur > 0 && cmp(val, array[cur - 1]) < 0) {
                // swap(cur, cur - 1);
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = val;
        }
    }
}
