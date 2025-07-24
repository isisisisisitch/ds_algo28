package ca.bytetube._01_complexity;

public class Main {
    public static void test1(int n) {
        if (n > 10) {
            System.out.println("n > 10");
        } else if (n > 5) {
            System.out.println("n > 5");
        } else if (n > 2) {
            System.out.println("n > 2");
        } else {
            System.out.println("n<= 2");
        }

        //1 + 4 + 4 + 4 = 13
        for (int i = 0; i < 4; i++) {
            System.out.println("test1");
        }
        //1 + 13 = 14
        //O(14) >> O(1)

    }

    public static void test2(int n) {
        //1 + n + n + n = 3n + 1=>O(3n + 1) >> O(n)
        for (int i = 0; i < n; i++) {
            System.out.println("test2");
        }
    }

    public static void test3(int n) {
        //1 + n + n*(3n + 1) + n  = O(3n^2 + 3n + 1 ) O(n^2)
        for (int i = 0; i < n; i++) {
            // 3n + 1
            for (int j = 0; j < n; j++) {
                System.out.println("test3");
            }

        }
    }
    //n = 2 => count = 1
    //n = 4 => count = 2
    //n = 8 => count = 3
    //log2 2 = 1
    //log2 4 = 2
    //log2 8 = 3

    //n = n => log2n
    //i = 1
    //i = 2
    //i = 4
    //==================
    //n = 8 => count = 3
    //i = 1
    //i = 2
    //i = 4
    //i = 8
    public static void test4(int n) {//n = 2
        //1 + log2n + log2n*(3n + 1) + log2n  = (3n + 3) log2n + 1 >> O(n*log2n) >> O(n*logn)
        for (int i = 1; i < n; i *= 2) {
            // 3n + 1
            for (int j = 0; j < n; j++) {
                System.out.println("test4");
            }

        }
    }


}
