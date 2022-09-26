class Solution {
    public int closedIsland(int[][] grid) {
        grid = CornerFill(grid, 0);
        int rows = grid.length;
        int cols = grid[0].length;
        
        //for (int i = 0; i < rows; i++) {
        //    for (int j = 0; j < cols; j++) {
        //        System.out.print(grid[i][j]);
        //    }
        //    System.out.println("");
        //}
        
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    result++;
                    grid = dfs(grid, i, j, 0);
                }
            }
        }
        
        return result;
    }
    
    public int[][] CornerFill(int[][] grid, int target) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Make all 0 from edges to 1, start from 1st and last row
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == target) {
                grid = dfs(grid, 0, i, target);
            }
        }
        
        for (int i = 0; i < cols; i++) {
            if (grid[rows-1][i] == target) {
                grid = dfs(grid, rows-1, i, target);
            }
        }
        
        //Now from first and last column
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == target) {
                grid = dfs(grid, i, 0, target);
            }
        }
        
        for (int i = 0; i < rows; i++) {
            if (grid[i][cols - 1] == target) {
                grid = dfs(grid, i, cols - 1, target);
            }
        }
        
        return grid;
    }
    
    public int[][] dfs(int[][] grid, int x, int y, int target) {
        Queue<Point> queue = new LinkedList<Point>();
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        Point start = new Point(x, y);
        queue.add(start);
        
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            int curr_x = curr.x;
            int curr_y = curr.y;
            
            if (target == 0) {
                grid[curr_x][curr_y] = 1;
            } else {
                grid[curr_x][curr_y] = 0;
            }
            
            if (target == 0) {
                grid[curr_x][curr_y] = 1;
            }
            
            if (curr_x > 0 && grid[curr_x - 1][curr_y] == target) {
                Point up = new Point(curr_x - 1, curr_y);
                queue.add(up);
            }
            
            if (curr_x < rows - 1 && grid[curr_x + 1][curr_y] == target) {
                Point down = new Point(curr_x + 1, curr_y);
                queue.add(down);
            }
            
            if (curr_y > 0 && grid[curr_x][curr_y - 1] == target) {
                Point left = new Point(curr_x, curr_y - 1);
                queue.add(left);
            }
            
            if (curr_y < cols - 1 && grid[curr_x][curr_y + 1] == target) {
                Point right = new Point(curr_x, curr_y + 1);
                queue.add(right);
            }
        }
        
        return grid;
    }
    
    public class Point {
        public int x;
        public int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}