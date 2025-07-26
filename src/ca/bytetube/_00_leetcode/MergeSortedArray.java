package ca.bytetube._00_leetcode;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * @author dall.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int cur = nums1.length - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[cur--] = nums1[i--];
            } else {
                nums1[cur--] = nums2[j--];
            }
        }

    }
}
