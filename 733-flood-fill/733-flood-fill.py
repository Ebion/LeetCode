class Solution(object):
    
    grid = []
    rows = -1;
    cols = -1;
    target = -1;
    original = -1;
    
    def floodFill(self, image, sr, sc, color):
        self.grid = image
        self.rows = len(image)
        self.cols = len(image[0])
        
        if (self.rows == 0 or self.cols == 0):
            return image
        
        self.target = color
        self.original = image[sr][sc]
        self.dfs(sr,sc);
        return self.grid
        
    def dfs(self, x, y):
        if (x < 0 or x >= self.rows or y < 0 or y >= self.cols):
            return
        elif (self.grid[x][y] == self.target or self.grid[x][y] != self.original):
            return
        else: 
            self.grid[x][y] = self.target
            self.dfs(x + 1, y)
            self.dfs(x - 1, y)
            self.dfs(x, y + 1)
            self.dfs(x, y - 1)