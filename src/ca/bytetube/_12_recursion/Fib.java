package ca.bytetube._12_recursion;

/**
 * https://leetcode.com/problems/fibonacci-number/
 *
 * @author dall.
 */

public class Fib {

    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n, 0, 1);
    }

    private int fib(int n, int a, int b) {
        if (n <= 1) return b;

        return fib(n - 1, b, a + b);
    }


    public static int fib6(int n) {
        if (n <= 1) return n;
        int a = 0;
        int b = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;

    }


    public static int fib5(int n) {
        if (n <= 1) return n;
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 3; i <= n; i++) {//n = 3
            arr[i & 1] = arr[(i - 1) & 1] + arr[(i - 2) & 1];
        }

        return arr[n & 1];

    }

    public static int fib4(int n) {
        if (n <= 1) return n;
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 3; i <= n; i++) {//n = 3
            arr[i % 2] = arr[(i - 1) % 2] + arr[(i - 2) % 2];
        }

        return arr[n % 2];

    }


    public static int fib3(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {//n = 3
            // fib(2) = fib(1) + fib(0) = arr[2] =  = arr[1] + arr[0];
            arr[i] = arr[i - 1] + arr[i - 2];
            //arr[3] = arr[2] + arr[1] = 1 + 1 = 2
        }

        return arr[n];

    }

    public int fib2(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        return fib2(n, arr);
    }

    private int fib2(int n, int[] arr) {
        if (arr[n] == 0) {
            arr[n] = fib2(n - 1, arr) + fib2(n - 2, arr);
        }

        return arr[n];
    }

    /**
     * fib(n - 1) = fib(n-2) + fib(n-3)
     * fib(n-2) = fib(n-3) + fib(n-4)
     * ...
     * fib(3) = fib(2) + fib(1) = 1 + 1 = 2
     * fib(2) = fib(1) + fib(0) = 1
     * <p>
     * fib(n-3) = fib(n-4) + fib(n-5)
     */
    public int fib1(int n) {
        if (n <= 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }
}
