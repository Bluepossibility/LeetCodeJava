package Solutions;

public class Solution867 {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] ans = new int[cols][rows];
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++) {
                ans[c][r] = matrix[r][c];
            }
        }
        return ans;
    }
}
