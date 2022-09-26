class Solution {
    public int[] findBall(int[][] grid) {
        boolean down = false;
        
        int columns = grid[0].length;
        int rows = grid.length;
        
        int[] result = new int[columns];
        
        boolean stuck = false;
        
        for (int i = 0; i < columns; i++) {
            int at_x = 0;
            int at_y = i;
            int curr = grid[at_x][at_y];
            while (true) {
                if (down) {
                    at_x = at_x + 1;
                    down = !down;
                    if (at_x == rows) {
                        stuck = false;
                        break;
                    }
                    curr = grid[at_x][at_y];
                } else {
                    at_y = at_y + curr;
                    if (at_y < 0 || at_y == columns || grid[at_x][at_y] != curr) {
                        stuck = true;
                        break;
                    }
                    curr = grid[at_x][at_y];
                    down = !down;
                }
            }
            if (stuck) {
                result[i] = -1;
            } else {
                result[i] = at_y;
            }
        }
        
        return result;
    }
}