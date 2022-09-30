class Solution(object):
    def searchMatrix(self, matrix, target):
        row = self.findRow(matrix, target);
        return self.findColumn(matrix[row - 1], target)
        
    def findRow(self, matrix, target):
        rows = len(matrix);
        for i in range(0, rows):
            first_element = matrix[i][0];
            if (target < first_element):
                return i;
        return rows;
    
    def findColumn(self, arr, target):
        for element in arr:
            if (element == target):
                return True
        return False;
        