package ca.bytetube._08_heap;

import ca.bytetube._08_heap.printer.BinaryTrees;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        topK(new Integer[]{70, 30, 34, 73, 60, 68, 43, 86, 15, 1, 64, 65, 54, 77, 25, 72, 78, 90, 57}, 3);

    }

    public static void topK(Integer[] data, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < data.length; i++) {
            int val = data[i];
            if (minHeap.size() < k) {
                minHeap.add(val);
            } else if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(val);
            }
        }

        System.out.println(minHeap);
    }

    public static void test3() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < 30; i++) {
            if (minHeap.size < 3) {
                minHeap.add(i);
            } else if (i > minHeap.get()) {
                minHeap.replace(i);
            }

        }
        BinaryTrees.println(minHeap);
    }

    public static void test2() {
        BinaryHeap<Integer> maxHeap = new BinaryHeap<>((o1, o2) -> o2 - o1, new Integer[]{30, 34, 73, 60, 68, 43});
        BinaryTrees.println(maxHeap);
    }


    public static void test1() {
        BinaryHeap<Integer> maxHeap = new BinaryHeap<>();
        maxHeap.add(72);
        maxHeap.add(68);
        maxHeap.add(50);
        maxHeap.add(43);
        maxHeap.add(38);
        maxHeap.add(47);
        maxHeap.add(21);
        maxHeap.add(14);
        maxHeap.add(80);
        BinaryTrees.println(maxHeap);
        System.out.println("=========================");
        maxHeap.remove();
        BinaryTrees.println(maxHeap);

    }
}
