package ca.bytetube._13_backtracking;

/**
 * https://leetcode.com/problems/n-queens-ii/
 *
 * @author dall.
 */
public class TotalNQueens {
    int ways;
    int[] cols;// cols[5] = 6; 表示在第6行的第7列上放置一个queen

    public int totalNQueens(int n) {
        cols = new int[n];
        place(0);
        return ways;
    }

    private void place(int row) {//row = 0
        if (row == cols.length) {
            ways++;
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                cols[row] = col;
                place(row + 1);
            }

        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            //col
            if (cols[i] == col) return false;

            //diagonal
            if (Math.abs(col - cols[i]) == row - i) return false;

        }
        return true;
    }
}
