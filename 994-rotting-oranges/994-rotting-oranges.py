class Solution:
    queue  = []
    visited = set()
    fresh = 0
    ans = -1
    
    rows = 0;
    cols = 0
    
    def orangesRotting(self, grid: List[List[int]]) -> int:
        self.queue = []
        self.visited = set()
        self.fresh = 0
        self.ans = -1
        
        self.rows = len(grid)
        self.cols = len(grid[0])
        
        for i in range(0, self.rows):
            for j in range(0, self.cols):
                if (grid[i][j] == 2):
                    self.queue.append((i, j))
                if (grid[i][j] == 1):
                    self.fresh = self.fresh + 1    
        
        if (self.fresh == 0):
            return 0
        if (self.fresh > 0 and len(self.queue) == 0):
            return -1
        
        self.bfs(grid, 0)
        
        if (self.fresh == 0):
            return self.ans;
        else:
            return -1;
    
    
    def bfs(self, grid, level):
        size = len(self.queue);
        #print(size)
        
        for i in range(0, size):
            x, y = self.queue.pop(0);
            #print(x, y)
            self.visited.add((x,y));
            
            if (grid[x][y] == 0):
                continue
            elif (grid[x][y] == 1):
                self.fresh = self.fresh - 1
                grid[x][y] = 2
                self.ans = level
            else:
                self.ans = level
            
            if (self.fresh == 0):
                return
            
            for x2, y2 in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                x_new = x + x2
                y_new = y + y2
                if (x_new < 0 or x_new >= self.rows or y_new < 0 or y_new >= self.cols):
                    continue
                elif ((x_new, y_new) not in self.visited):
                    self.queue.append((x_new, y_new));
            
        level = level + 1
        
        if (len(self.queue) == 0):
            return
        
        self.bfs(grid, level)
        #print(self.queue, self.fresh)
        