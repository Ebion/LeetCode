class Solution(object):
    rows = 0;
    cols = 0;
    
    def maxDistance(self, grid):
        return self.bfs(grid);
        
    def bfs(self, grid):
        rows = len(grid)
        cols = len(grid)
        if (rows == 0 or cols == 0):
            return -1
        
        queue = []
        for x in range(0, rows):
            for y in range(0, cols):
                if (grid[x][y] == 1):
                    queue.append((x,y))
        
        if (len(queue) == 0 or len(queue) == rows * cols):
            return -1
        
        result = 0
        while(len(queue) != 0):
            result = result + 1
            for i in range(0, len(queue)):
                x, y = queue.pop(0)
                for x2, y2 in [(-1, 0),(1, 0),(0, 1),(0, -1)]:
                    x_new = x + x2
                    y_new = y + y2
                    if (x_new < 0 or x_new >= rows or y_new < 0 or y_new >= cols):
                        continue
                    if (grid[x_new][y_new] >= 1):
                        continue
                    grid[x_new][y_new] = result
                    queue.append((x_new,y_new))
                    #print(grid)
        
        return result - 1;
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            