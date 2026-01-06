package ca.bytetube._19_mazoa;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class EC2Fee {

    public static void main(String[] args) {
        int[] vmStack = {1, 2, 4};
        int m = 4;
        System.out.println(solution2(vmStack, m));
    }

    public static int VMRevenue(int[] vmStock, int numCustomers) {
        Arrays.sort(vmStock); //RT: nlogn
        int n = vmStock.length;
        int nonzero = 0;
        int revenue = 0;

        //iterations: n
        while (vmStock[nonzero] == 0) {
            nonzero += 1;
        }

        //iterations: m
        while (numCustomers > 0) {
            revenue += vmStock[n - 1] + vmStock[nonzero];
            vmStock[n - 1] -= 1;
            if (vmStock[n - 1] == 0) nonzero++;
            Arrays.sort(vmStock); //RT: nlogn
            numCustomers--;

        }
        //RT: nlogn + n + m*n*logn = O(m*n*log(n))
        return revenue;
    }
    //O((n+m)*logn)
    public static int solution2(int[] vmStock, int m) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int v : vmStock) {
            if (v > 0) {
                map.put(v, map.getOrDefault(v, 0) + 1);
            }
        }
        int revenue = 0;
        for (int i = 0; i < m; i++) {
            Integer max = map.lastKey();
            int min = map.firstKey();
            revenue += max + min;
            map.put(max, map.get(max) - 1);
            if (map.get(max) == 0) {
                map.remove(max);
            }

            if (max - 1 > 0) {
                map.put(max - 1, map.getOrDefault(max - 1, 0) + 1);
            }
        }


        return revenue;

    }

    //O(m*n)
    public static int solution(int[] vmStock, int m) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int v : vmStock) {
            if (v > 0) {
                maxHeap.offer(v);
                minHeap.offer(v);
            }
        }

        int revenue = 0;
        for (int i = 0; i < m; i++) {
            int max = maxHeap.poll();//O(1)
            int min = minHeap.peek();//O(1)
            revenue += max + min;
            int updated = max - 1;
            minHeap.remove(max);//O(n)
            if (updated > 0) {
                maxHeap.offer(updated);//logn
                minHeap.offer(updated);//logn
            }
        }

        return revenue;
    }
}
