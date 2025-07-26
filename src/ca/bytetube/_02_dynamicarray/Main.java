package ca.bytetube._02_dynamicarray;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            arrayList.add(i);
        }

//       while (!arrayList.isEmpty()){
//           arrayList.remove(0);
//       }
        arrayList.set(1, null);


        System.out.println(arrayList.indexOf(null));


//        for (int i = 0; i < 30; i++) {
//            arrayList.add(i);
//        }
//        System.out.println(arrayList);
//
//        ArrayList<Student> arrayList2 = new ArrayList<>();
//        int[] arr = new int[3];

    }
}
