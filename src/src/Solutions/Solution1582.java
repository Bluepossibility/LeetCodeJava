package Solutions;

public class Solution1582 {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] specialColIndexByRows = new int [n];
        int[] specialRowIndexByCols = new int [m];

        // Iterate over the matrix to find the special column indexes in each row
        for (int r = 0; r < n; r++){
            int rowCount = 0;
            int specialColIndex = -1;
            for (int c = 0; c < m; c++){
                if (mat[r][c] == 1){
                    rowCount += 1;
                    specialColIndex = c;
                }
            }
            specialColIndexByRows[r] = rowCount == 1? specialColIndex : -1;
        }

        // Iterate over the matrix to find the special row indexes in each column
        for (int c = 0; c < m; c++){
            int colCount = 0;
            int specialRowIndex = -1;
            for (int r = 0; r < n; r++){
                if (mat[r][c] == 1){
                    colCount += 1;
                    specialRowIndex = r;
                }
            }
            specialRowIndexByCols[c] = colCount == 1? specialRowIndex : -1;
        }

        // Iterate over the specialColIndexByRows & specialRowIndexByCols to get the answer
        int ans = 0;
        for (int r = 0; r < n; r++){
            // For row r, column specialColIndexByRows[r] is special index
            int specialColIndex = specialColIndexByRows[r];
            if (specialColIndex != -1){
                // As long as the point {r, specialColIndex} is also the unique 1 in the very column
                if (specialRowIndexByCols[specialColIndex] == r){
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
