import java.awt.Point;

class Solution {

    static int n; // length
    static int m; // height
    static char startcol;
    
    static int row_end = -1;
    static int col_end = -1;
    
    static boolean[][] visited_island;
    
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        
        visited_island = new boolean[n][m];
        
        int result = 2;
        char color = (char) result;
        for (int row = 0; row < n; row++) { 
            for (int col = 0; col < m; col++) { 
                if (grid[row][col] == '1' && !visited_island[row][col]) {
                    grid = floodFill(grid, row, col);
                    result++;
                }
            }
        }
        
        return result - 2;
    }
    
    public char[][] floodFill(char[][] image, int sr, int sc) {
        Queue<Point> queue = new LinkedList<Point>();
        Point start = new Point(sr, sc);
        n = image.length;
        m = image[0].length;
        
        startcol = image[sr][sc];
        
        queue.add(start);
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            int curr_len = (int) curr.getX();
            int curr_height = (int) curr.getY();
            
            image[curr_len][curr_height] = '0';
            
            if (isValid(curr_len, curr_height - 1)) {
                if (image[curr_len][curr_height - 1] == startcol) {
                    Point new_pt = new Point(curr_len, curr_height - 1);
                    queue.add(new_pt);
                } 
            }
            
            if (isValid(curr_len, curr_height + 1)) {
                if (image[curr_len][curr_height + 1] == startcol) {
                    Point new_pt = new Point(curr_len, curr_height + 1);
                    queue.add(new_pt);
                } 
            } 
            
            if (isValid(curr_len - 1, curr_height)) {
                if (image[curr_len - 1][curr_height] == startcol) {
                    Point new_pt = new Point(curr_len - 1, curr_height);
                    queue.add(new_pt);
                } 
            } 
            
            if (isValid(curr_len + 1, curr_height)) {
                if (image[curr_len + 1][curr_height] == startcol) {
                    Point new_pt = new Point(curr_len + 1, curr_height);
                    queue.add(new_pt);
                } 
            }
        }
        return image;
        
    }
    
    public boolean isValid(int sr, int sc) {
        if (sr >= n) {
            return false;
        } else if (sc >= m) {
            return false;
        } else if (sr < 0 || sc < 0) {
            return false;
        } else {
            if (!visited_island[sr][sc]) {
                visited_island[sr][sc] = true;
                return true;
            }
            else {
                return false;
            }
        }
    }
}