package ca.bytetube._17_sort.cmp;

import java.util.ArrayList;
import java.util.List;

public class ShellSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        List<Integer> sequence = shellSequence();
        for (Integer step : sequence) {
            insertSort(step);
        }
    }

    private List<Integer> shellSequence() {
        List<Integer> sequence = new ArrayList<>();
        int len = array.length;
        while ((len = len >> 1) > 0) sequence.add(len);
        return sequence;
    }

    private void insertSort(int step) {
        for (int col = 0; col < step; col++) {
            for (int start = col + step; start < array.length; start += step) {
                int cur = start;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }

    }


}
