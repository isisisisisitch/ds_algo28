package ca.bytetube._16_dp;

public class FindAim {
    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 13};
        System.out.println(findAim(arr, 14));
    }

    public static boolean findAim(int[] arr, int aim) {
        return findAim(arr, aim, 0, 0);
    }

    private static boolean findAim(int[] arr, int aim, int index, int sum) {
        if (sum == aim) return true;
        if (index == arr.length) return false;
        return findAim(arr, aim, index + 1, sum + arr[index]) || findAim(arr, aim, index + 1, sum);

    }
}
