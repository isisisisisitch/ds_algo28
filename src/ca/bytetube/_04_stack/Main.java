package ca.bytetube._04_stack;


import ca.bytetube._05_queue.Queue;

public class Main {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < 5; i++) {
//            stack.push(i);
//        }
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }

        //stack.add(10,1);
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }
        while (!queue.isEmpty()){
            System.out.println( queue.deQueue());
        }

    }
}
