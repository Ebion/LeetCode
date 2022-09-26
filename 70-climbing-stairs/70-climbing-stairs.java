class Solution {
    public int climbStairs(int n) {
        int fb_1 = 1;
        int fb_2 = 2;
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            for (int i = 2; i < n; i++) {
                int fb_i = fb_2 + fb_1;
                fb_1 = fb_2;
                fb_2 = fb_i;
                System.out.println(i + "Ans: " + fb_2);
            }
            return fb_2;
        }
   }
}