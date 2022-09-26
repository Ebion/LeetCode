class Solution {
    
    static HashSet<Integer> row_visit;
    static HashSet<Integer> col_visit;
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        row_visit = new HashSet<Integer>();
        col_visit = new HashSet<Integer>();
        
        row_visit.add(rows);
        row_visit.add(-1);
        col_visit.add(columns);
        col_visit.add(-1);
        
        int direction;
        if (columns == 1) {
            direction = 2;
        } else {
            direction = 1;
        }
        
        int[] cords = new int[2];
        cords[0] = 0;
        cords[1] = 0;
        
        while (true) {
            int x = cords[0];
            int y = cords[1];
            int curr = matrix[x][y];
            result.add(curr);
            
            int[] temp = direct(direction, cords);
            if (checkCord(temp)) {
                cords = temp;
            } else {
                appendVisit(direction, temp);
                direction++;
                direction = direction%4;
                temp = direct(direction, cords);
                if (!checkCord(temp)) {
                    break;
                }
                cords = temp;
            }
        }
        
        return result;
        
    }
    
    public static void appendVisit(int n, int[] temp) {
        if (n == 1) {
            row_visit.add(temp[0]);
        } else if (n == 2) {
            col_visit.add(temp[1]);
        } else if (n == 3) {
            row_visit.add(temp[0]);
        } else {
            col_visit.add(temp[1]);
        }
    }
    
    public static boolean checkCord(int[] cords) {
        int x = cords[0];
        int y = cords[1];
        if (row_visit.contains(x) || col_visit.contains(y)) {
            return false;
        }
        return true;
    }
    
    public int[] direct(int n, int[] cords) {
        if (n == 1) {
            return right(cords);
        } else if (n == 2) {
            return down(cords);
        } else if (n == 3) {
            return left(cords);
        } else {
            return up(cords);
        }
    }
    
    public int[] down(int[] cords) {
        int x = cords[0];
        int y = cords[1];
        int[] temp = new int[2];
        temp[0] = x + 1;
        temp[1] = y;
        return temp;
    }
    
    public int[] up(int[] cords) {
        int x = cords[0];
        int y = cords[1];
        int[] temp = new int[2];
        temp[0] = x - 1;
        temp[1] = y;
        return temp;
    }
    
    public int[] right(int[] cords) {
        int x = cords[0];
        int y = cords[1];
        int[] temp = new int[2];
        temp[0] = x;
        temp[1] = y + 1;
        return temp;
    }
    
    public int[] left(int[] cords) {
        int x = cords[0];
        int y = cords[1];
        int[] temp = new int[2];
        temp[0] = x;
        temp[1] = y - 1;
        return temp;
    }
}