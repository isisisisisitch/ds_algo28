package ca.bytetube._17_sort.cmp;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        int pivotIndex = pivotIndex(begin, end);
        sort(begin, pivotIndex);
        sort(pivotIndex + 1, end);
    }

    private int pivotIndex(int begin, int end) {
        swap(begin, (int) (Math.random() * (end - begin)) + begin);
        //1.backup pivot
        T pivot = array[begin];
        end--;

        while (begin < end) {
            //right--->left
            while (begin < end) {
                if (cmp(array[end], pivot) < 0) {
                    array[begin++] = array[end];
                    break;
                } else {
                    end--;
                }
            }

            //left--->right
            while (begin < end) {
                if (cmp(array[begin], pivot) > 0) {
                    array[end--] = array[begin];
                    break;
                } else {
                    begin++;
                }
            }
        }

        array[begin] = pivot;


        return begin;
    }
}
