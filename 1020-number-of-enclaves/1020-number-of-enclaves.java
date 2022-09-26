class Solution {
    
    static int area;
    
    public int numEnclaves(int[][] grid) {
        grid = CornerFill(grid, 1);
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
                if (grid[i][j] == 1) {
                    grid = dfs(grid, i, j, 1);
                    //System.out.println(area);
                    result += area;
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
        area = 0;
        Queue<Point> queue = new LinkedList<Point>();
        
        
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        Point start = new Point(x, y);
        queue.add(start);
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            area++;
            int curr_x = curr.x;
            int curr_y = curr.y;
            
            if (target == 0) {
                grid[curr_x][curr_y] = 1;
            } else {
                grid[curr_x][curr_y] = 0;
            }
            
            if (curr_x > 0 && grid[curr_x - 1][curr_y] == target && !visited[curr_x - 1][curr_y]) {
                Point up = new Point(curr_x - 1, curr_y);
                queue.add(up);
                visited[curr_x - 1][curr_y] = true;
            }
            
            if (curr_x < rows - 1 && grid[curr_x + 1][curr_y] == target && !visited[curr_x + 1][curr_y]) {
                Point down = new Point(curr_x + 1, curr_y);
                queue.add(down);
                visited[curr_x + 1][curr_y] = true;
            }
            
            if (curr_y > 0 && grid[curr_x][curr_y - 1] == target && !visited[curr_x][curr_y - 1]) {
                Point left = new Point(curr_x, curr_y - 1);
                queue.add(left);
                visited[curr_x][curr_y - 1] = true;
            }
            
            if (curr_y < cols - 1 && grid[curr_x][curr_y + 1] == target && !visited[curr_x][curr_y + 1]) {
                Point right = new Point(curr_x, curr_y + 1);
                queue.add(right);
                visited[curr_x][curr_y + 1] = true;
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