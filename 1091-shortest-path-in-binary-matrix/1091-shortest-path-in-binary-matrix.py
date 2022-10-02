class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        visited = set()
        queue = []
    
        if (rows == 0 or cols == 0):
            return -1;
        
        if (grid[0][0] == 1 or grid[rows - 1][cols - 1] == 1):
            return -1;
        
        queue.append((0,0,1))
        
        while (len(queue) > 0):
            x, y, level = queue.pop(0)
            if (x == rows - 1 and y == cols - 1):
                return level
            for x2, y2 in [(1,0),(-1,0),(0,1),(0,-1),(-1,-1),(1,-1),(-1,1),(1,1)]:
                x_new = x + x2
                y_new = y + y2
                if (x_new < 0 or x_new >= rows or y_new < 0 or y_new >= cols):
                    continue
                if ((x_new, y_new) in visited):
                    continue
                if (grid[x_new][y_new] == 0):
                    queue.append((x_new,y_new,level + 1))
                    visited.add((x_new,y_new));
        return -1;
                