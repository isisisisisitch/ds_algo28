package ca.bytetube._00_leetcode.stack;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

    private static class Node {
        int val;
        Node next;
        int min;

        public Node(int val, Node next, int min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }

    Node head;

    public MinStack() {
        head = new Node(0, null, Integer.MAX_VALUE);
    }

    public void push(int val) {
        head = new Node(val, head, Math.min(val, head.min));
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
//    private Stack<Integer> dataS;
//    private Stack<Integer> minS;
//
//    public MinStack() {
//        dataS = new Stack<>();
//        minS = new Stack<>();
//    }
//
//    public void push(int val) {
//        dataS.push(val);
//        if (minS.isEmpty()) minS.push(val);
//        else if (val <= minS.peek()) minS.push(val);
//    }
//
//    public void pop() {
//        int pop = dataS.pop();
//        if (pop == minS.peek()) minS.pop();
//    }
//
//    public int top() {
//        return dataS.peek();
//    }
//
//    public int getMin() {
//        return minS.peek();
//    }
}
