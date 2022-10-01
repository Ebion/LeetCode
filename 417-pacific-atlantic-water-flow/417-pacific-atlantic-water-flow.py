class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rows = len(heights)
        cols = len(heights[0])
        
        cords1 = set();
        # go by left side
        for x in range(0, rows):
            self.dfs(heights, x, 0, cords1, 0)
        
        # go by the top side (this is pacific)
        for y in range(0, cols):
            self.dfs(heights, 0, y, cords1, 0)
        
        cords2 = set()
        # now from right side
        for x in range(0, rows):
            self.dfs(heights, x, cols - 1, cords2, 0)
        for y in range(0, cols):
            self.dfs(heights, rows - 1, y, cords2, 0)
        
        return list(cords1 & cords2)
    
    
    def dfs(self, grid, x, y, cords, prev_height):
        if (x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0])):
            return
        if ((x,y) in cords):
            return
        ## we are approaching from the corners, so if the height is not equals or more, cannot flow
        ## Therefore if previous corner is higher than now, means its impossible
        if (grid[x][y] < prev_height):
            return
        
        # All checks pass, add into cords
        cords.add((x,y))
        
        # Go all 4 directions
        for (x2, y2) in [(1, 0),(-1, 0),(0, -1),(0, 1)]:
            x_new = x + x2
            y_new = y + y2
            self.dfs(grid, x_new, y_new, cords, grid[x][y])