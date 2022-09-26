class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> checker = new HashSet<String>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int curr_val = board[i][j];
                
                if (curr_val == 46) {
                    continue;
                }
                System.out.println(curr_val);
                String row = curr_val + " row : " + i;
                String col = curr_val + " col : " + j;
                String block = curr_val + " block : " + i/3 + "-" + j/3;
                
                if (!checker.add(row) || !checker.add(col) || !checker.add(block)) {
                    return false;
                }
            }
        }
        return true;
    }
}