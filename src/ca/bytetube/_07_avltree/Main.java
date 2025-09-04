package ca.bytetube._07_avltree;

import ca.bytetube._07_avltree.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {
//        BinarySearchTree<Student> bst = new BinarySearchTree<>(new StudentComparator());
//
//        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
//        Comparable i = 10;

//        test1();
        AVLTree<Integer> avl = new AVLTree<>();
        avl.add(2);
        avl.add(4);
        avl.add(5);
        avl.add(7);
        avl.add(8);
        avl.add(9);

        avl.add(11);
        // BinaryTrees.println(avl);
        avl.add(12);
        BinaryTrees.println(avl);
        avl.remove(8);
        avl.remove(7);
        avl.remove(9);
        BinaryTrees.println(avl);
        avl.remove(11);
        BinaryTrees.println(avl);
        //avl.add(1);
        //BinaryTrees.println(avl);
        // System.out.println(bst.successor( bst.node(8)));
        // avl.remove(5);
        //BinaryTrees.println(avl);
    }


    public static void test1() {
        Person p1 = new Person(20, "Dal");
        Person p2 = new Person(30, "Bob");
        Person p3 = new Person(35, "Andy");
        Person p4 = new Person(18, "Rose");
        Person p5 = new Person(22, "Felix");
        Person[] people = new Person[5];
        people[0] = p1;
        people[1] = p2;
        people[2] = p3;
        people[3] = p4;
        people[4] = p5;


    }
}
