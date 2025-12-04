package ca.bytetube._18_ggoa;

public class MinAbsSum {


    public static int solution(int[] A) {
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
        }
        int result = Math.abs(total);
        for (int i = 0; i < A.length; i++) {
            int newSum = total - 2 * A[i];
            result = Math.min(result, Math.abs(newSum));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 3, 2, 5};
        System.out.println(solution(A1));

        int[] A2 = {5, 5, 5};
        System.out.println(solution(A2));

        int[] A3 = {-4, -2, 7};

        System.out.println(solution(A3));

        int[] A4 = {10};
        System.out.println(solution(A4));

        int[] A5 = {-1, 1};

        System.out.println(solution(A5));
    }

}
