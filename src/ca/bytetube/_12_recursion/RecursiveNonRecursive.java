package ca.bytetube._12_recursion;

import java.util.Stack;

public class RecursiveNonRecursive {

    public static void main(String[] args) {
        RecursiveNonRecursive recursive = new RecursiveNonRecursive();
        recursive.log(4);
        System.out.println("======================");
        recursive.log1(4);
    }

    public void log(int n) {
        if (n < 1) return;
        log(n - 1);
        int v = n + 10;
        System.out.println(v);
    }

    public void log2(int n){
        for (int i = 11; i <= n + 4; i++) {
            System.out.println(i);
        }
    }

    public void log1(int n) {
        Stack<Frame> stack = new Stack<>();
        while (n > 0) {
            stack.push(new Frame(n, n + 10));
            n--;
        }

        while (!stack.isEmpty()){
            Frame frame = stack.pop();
            System.out.println(frame.v);
        }

    }

    private static class Frame {
        int n;
        int v;

        public Frame(int n, int v) {
            this.n = n;
            this.v = v;
        }
    }

}
