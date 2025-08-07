package ca.bytetube._03_linkedlist;


import ca.bytetube._03_linkedlist.doubly.DoublyCircularLinkedList;
import ca.bytetube._03_linkedlist.doubly.LinkedList;
import ca.bytetube._03_linkedlist.singly.SinglyCircularLinkedList;

public class Main {
    public static void main(String[] args) {
//        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(0, i);
//        }
//        while (!list.isEmpty()){
//            list.remove(0);
//        }
//        System.out.println(list.set(5, 10));
//
//        System.out.println(list.contains(10));
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//
//        list.add(0,99);

        //list.add(list.size,99);



//        while (!list.isEmpty()){
//            list.remove(0);
//        }

//        Integer removed = list.remove(5);
//        System.out.println(removed);
        DoublyCircularLinkedList<Integer> list = new DoublyCircularLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        while (!list.isEmpty()){
            list.remove(0);
        }

        System.out.println();

    }


    public static void test(List<Integer> list) {
        //list.add(0, 10);
    }


}
