class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        boolean[] dp = new boolean[length];
        
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                dp[i] = true;
            } else if (nums[i] == 0) {
                dp[i] = false;
            } else {
                int step = 0;
                int curr_val = nums[i];
                boolean curr = false;
                while (step < curr_val) {
                    step++;
                    if (dp[i + step]) {
                        curr = true;
                        break;
                    }
                }
                dp[i] = curr;
            }
        }
        return dp[0];
    }
}