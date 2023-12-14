package Solutions;

public class Solution2482 {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] ans = new int[rows][cols];
        int[] onesByRows = new int[rows];
        int[] onesByCols = new int[cols];
        for (int r = 0; r < rows; r++) {
            int onesRowCount = 0;
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1){
                    onesRowCount += 1;
                }
            }
            onesByRows[r] = onesRowCount;
        }
        for (int c = 0; c < cols; c++) {
            int onesColCount = 0;
            for (int r = 0; r < rows; r++) {
                if (grid[r][c] == 1){
                    onesColCount += 1;
                }
            }
            onesByCols[c] = onesColCount;
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ans[r][c] = 2 * onesByRows[r] + 2 * onesByCols[c] - cols - rows;
            }
        }
        return ans;
    }
}
