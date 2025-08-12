package ca.bytetube._00_leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * @author dall.
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        //monotonic queue
        Deque<Integer> deque = new LinkedList<>();
        int w = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                while (w > deque.peekFirst()) {
                    deque.removeFirst();
                }
                res[w++] = nums[deque.peekFirst()];

            }
        }
        return res;
    }
}
