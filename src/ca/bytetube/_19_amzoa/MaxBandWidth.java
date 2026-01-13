package ca.bytetube._19_amzoa;

import java.util.*;

public class MaxBandWidth {
    public static void main(String[] args) {
        int[] capacity = new int[]{5, 3, 6};
        System.out.println(maxBandWidth2(capacity, 4));
    }


    private static class Pair {
        int i, j, sum;

        public Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public static int maxBandWidth2(int[] capacity, int connectionCount) {
        int max = 0;
        int n = capacity.length;
        Arrays.sort(capacity);
        int[] sorted = new int[n];
        for (int k = 0; k < n; k++) sorted[k] = capacity[n - 1 - k];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((o1, o2) -> o2.sum - o1.sum);
        Set<String> visited = new HashSet<>();
        maxHeap.offer(new Pair(0, 0, sorted[0] + sorted[0]));
        visited.add("0,0");
        for (int count = 0; count < connectionCount && !maxHeap.isEmpty(); count++) {
            Pair top = maxHeap.poll();
            max += top.sum;
            int i = top.i;
            int j = top.j;
            //next row
            if (i + 1 < n && !visited.contains((i + 1) + "," + j)) {
                maxHeap.offer(new Pair(i + 1, j, sorted[i + 1] + sorted[j]));
                visited.add((i + 1) + "," + j);
            }
            //next col
            if (j + 1 < n && !visited.contains(i + "," + (j + 1))) {
                maxHeap.offer(new Pair(1, j + 1, sorted[i] + sorted[j + 1]));
                visited.add(i + "," + (j + 1));
            }

        }


        return max;
    }


    public static int maxBandWidth(int[] capacity, int connectionCount) {
        int n = capacity.length;
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sums.add(capacity[i] + capacity[j]);
            }
        }

        sums.sort(Collections.reverseOrder());

        int max = 0;
        for (int i = 0; i < connectionCount && i < sums.size(); i++) {
            max += sums.get(i);
        }

        return max;
    }
}
