package ca.bytetube._14_divide;

public class GetMaxInArray {

    public static void main(String[] args) {
        int[] arr = {7, 10, -5, 99, 12, 14, 65, 43, -85, 100};
        System.out.println(getMaxInArray(arr));
    }

    public static int getMaxInArray(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("arr can not be null or empty !");
        if (arr.length == 1) return arr[0];
        return getMaxInArray(arr, 0, arr.length - 1);
    }

    private static int getMaxInArray(int[] arr, int left, int right) {
        if (left == right) return arr[left];
        int mid = (left + right) >> 1;
        int leftMax = getMaxInArray(arr, left, mid);
        int rightMax = getMaxInArray(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);

    }


}
