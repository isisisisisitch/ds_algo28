package ca.bytetube._00_leetcode.sort;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * @author dall.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[begin] <= nums[mid]) {
                if (nums[begin] <= target && target < nums[mid]) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[end - 1] >= target) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }
        }

        return -1;
    }
}
