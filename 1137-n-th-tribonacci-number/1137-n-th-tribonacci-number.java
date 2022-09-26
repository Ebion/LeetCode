class Solution {
    public int tribonacci(int n) {
        int[] tri_arr = new int[3];
        tri_arr[0] = 0;
        tri_arr[1] = 1;
        tri_arr[2] = 1;
        int counter = 3;
        
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            while (counter <= n) {
                int curr_tri = tri_arr[0] + tri_arr[1] + tri_arr[2];
                tri_arr[0] = tri_arr[1];
                tri_arr[1] = tri_arr[2];
                tri_arr[2] = curr_tri;
                counter += 1;
            }
            return tri_arr[2];
        }
        
    }
}