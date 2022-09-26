class Solution {
    
    public int jump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                dp[i] = 0;
            } else {
                int step = 0;
                int curr_val = nums[i];
                int min_step = 9999999;
                while (step < curr_val) {
                    step++;
                    if (i+step >= length) {
                        break;
                    }
                    if (dp[i + step] < min_step) {
                        min_step = dp[i+step] + 1;
                    }
                }
                dp[i] = min_step;
            }
        }
        return dp[0];
    }
}