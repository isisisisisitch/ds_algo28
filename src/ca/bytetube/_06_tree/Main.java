package ca.bytetube._06_tree;

import ca.bytetube._06_tree.printer.BinaryTrees;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        BinarySearchTree<Student> bst = new BinarySearchTree<>(new StudentComparator());
//
//        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
//        Comparable i = 10;

//        test1();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(7);
        bst.add(4);
        bst.add(9);
        bst.add(2);
        bst.add(5);
        bst.add(8);
        bst.add(11);
        BinaryTrees.println(bst);
        bst.add(12);
        BinaryTrees.println(bst);
        bst.add(1);
        BinaryTrees.println(bst);
       // System.out.println(bst.successor( bst.node(8)));
        bst.remove(5);
        BinaryTrees.println(bst);
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

        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.age - o1.age;
            }
        });
        System.out.println(Arrays.toString(people));


    }
}
