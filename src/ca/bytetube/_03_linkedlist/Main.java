package ca.bytetube._03_linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(0,i);
        }
//        while (!list.isEmpty()){
//            list.remove(0);
//        }
        System.out.println( list.set(5,10));

        System.out.println(list.contains(10));

    }

    public static void test(List<Integer> list) {
        //list.add(0, 10);
    }


}
