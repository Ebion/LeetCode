class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] result = new int[r][c];
        
        int rows_input = mat.length;
        int cols_input = mat[0].length;
        int size_input = rows_input * cols_input;
        int size_output = r*c;
        
        if (size_output != size_input) {
            return mat;
        }
        
        // reference for output array
        int row_num = 0;
        int col_num = 0;
        
        for (int i = 0; i < rows_input; i++) {
            for (int j = 0; j < cols_input; j++) {
                result[row_num][col_num] = mat[i][j];
                col_num++;
                if (col_num == c) {
                    col_num = 0;
                    row_num++;
                }
            }
        }
        
        return result;
    }
}