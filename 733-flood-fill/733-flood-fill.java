import java.awt.Point;

class Solution {
    
    // let m be length, n be height
    static int m;
    static int n;
    static int startcol;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Point> queue = new LinkedList<Point>();
        Point start = new Point(sr, sc);
        m = image[0].length;
        n = image.length;
        
        startcol = image[sr][sc];
        
        if (startcol == color) {
            return image;
        }
        
        queue.add(start);
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            int curr_len = (int) curr.getX();
            int curr_height = (int) curr.getY();
            
            image[curr_len][curr_height] = color;
            
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
            return true;
        }
    }
}