package ca.bytetube._01_complexity;

public class Fib {
    public static void main(String[] args) {
        // System.out.println( fib(2));
        // System.out.println( fib(3));
        System.out.println(fib(4));

    }

    //recursion + storage

    /**
     * how to share common data in recursion process:
     * 1.pass the common data to be shared as a parameter of the recursive method
     * 2.use member variable to hold the common data //not recommend
     */

    public static int fib(int n) {//n = 3
        if (n <= 1) return n;
        int[] arr = new int[n + 1];//0

        arr[1] = 1;
        arr[2] = 1;

        return fib(n, arr);

    }

    private static int fib(int n, int[] arr) {//n = 3 [0,1,1,3] || n = 2

        if (arr[n] == 0) {
            arr[n] = fib(n - 1, arr) + fib(n - 2, arr);//1 + 1 = 2
        }

        return arr[n];
    }


    //mapping:fib(n) <==> arr[n]
    public static int fib2(int n) {
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


//F(n) = F(n - 1) + F(n - 2), for n > 1.
//F(0) = 0, F(1) = 1

    /**
     * fib(n)   = fib(n-1) + fib(n-2)
     * fib(n-1) = fib(n-2) + fib(n-3)
     * fib(n-2) = fib(n-3) + fib(n-4)
     * fib(n-3) =  fib(n-4) + fib(n-5)
     * fib(n-4)
     * ...
     * fib(6) = fib(5) + fib(4) = 5 +
     * fib(5) = fib(4) + fib(3) = 3 + 2 = 5
     * fib(4) = fib(3) + fib(2) = 2 + 1 = 3
     * fib(3) = fib(2) + fib(1) = 1 + 1 = 2
     * fib(2) = 1 + 0 = 1
     * fib(1) = 1
     * fib(0) = 0
     * =================
     * fib(2) = fib(1) + fib(0) = 1 + 0 = 1
     * fib(3) =  fib(2) + fib(1) = 1 + 1 = 2
     * ==================
     * fib(4) = fib(3) + fib(2) = 2 + 1 = 3
     * fib(3) =  fib(2) + fib(1) = 1 + 1 = 2
     * fib(2) = fib(1) + fib(0) = 1 + 0 = 1
     */
    public static int fib1(int n) {
        if (n <= 1) return n;

        return fib1(n - 1) + fib1(n - 2);
    }

}
