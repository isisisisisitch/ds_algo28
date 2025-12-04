package ca.bytetube._18_ggoa;

public class SplitCount {

    public static int solution(int[] A) {
        int n = A.length;
        if (n <= 1) return 1;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], A[i]);
        }

        suffixMin[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], A[i]);
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prefixMax[i] <= suffixMin[i + 1]) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        SplitCount sol = new SplitCount();

        // Test 1
        int[] A1 = {1, 3, 2, 4};
        System.out.println("Test 1: " + sol.solution(A1) + " (expected 2)");

        // Test 2
        int[] A2 = {3, 2, 10, 9};

        System.out.println("Test 2: " + sol.solution(A2) + " (expected 1)");

        // Test 3
        int[] A3 = {5, 5, 5};
        // Already sorted, every split works => 4
        System.out.println("Test 3: " + sol.solution(A3) + " (expected 2)");

        // Test 4
        int[] A4 = {2, 1, 3, 2, 4};
        System.out.println("Test 4: " + sol.solution(A4) + " (expected 2)");

        // Test 5
        int[] A5 = {10};
        System.out.println("Test 5: " + sol.solution(A5) + " (expected 0)");

        // Test 6
        int[] A6 = {3, 2};
        // split at i=0:
        // left=[3], right=[2]
        // sorted → [3][2] not sorted → 0
        System.out.println("Test 6: " + sol.solution(A6) + " (expected 0)");

        // Test 7
        int[] A7 = {3, 1, 2};
        // splits:
        // i=0 → left=[3] right=[1,2] → [3,1,2] not sorted
        // i=1 → left=[3,1] right=[2] → [1,3,2] not sorted
        // => 0
        System.out.println("Test 7: " + sol.solution(A7) + " (expected 0)");
    }
}
