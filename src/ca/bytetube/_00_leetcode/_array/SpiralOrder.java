package ca.bytetube._00_leetcode._array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * @author dall.
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            //leftTop--->rightTop
            for (int i = left; i <= right; i++) list.add(matrix[top][i]);
            top++;

            //rightTop--->rightBottom
            for (int i = top; i <= bottom; i++) list.add(matrix[i][right]);
            right--;

            if (top > bottom || left > right) break;

            //rightBottom--->leftBottom
            for (int i = right; i >= left; i--) list.add(matrix[bottom][i]);
            bottom--;

            //leftBottom--->leftTop
            for (int i = bottom; i >= top; i--) list.add(matrix[i][left]);
            left++;

        }

        return list;
    }
}
