package ca.bytetube._12_recursion;

public class TailRecursion {
    public static void main(String[] args) {
        TailRecursion tailRecursion = new TailRecursion();

        System.out.println(tailRecursion.factorial0(10));
        System.out.println(tailRecursion.factorial(10));
    }

    public int factorial0(int n) {
        if (n <= 1) return 1;
        return factorial0(n - 1) * n;
    }

    public int factorial(int n) {
        if (n <= 1) return 1;

        return factorial(n, 1);
    }

    private int factorial(int n, int res) {
        if (n <= 1) return res;
        return factorial(n - 1, res * n);
    }
}
