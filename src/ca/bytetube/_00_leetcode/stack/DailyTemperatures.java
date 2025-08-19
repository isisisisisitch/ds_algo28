package ca.bytetube._00_leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * @author dall.
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];//0
        //monotonic stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;

    }
}
