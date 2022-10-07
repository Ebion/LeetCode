class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return helper(coins, amount, new int[amount]);
    }
    
    public int helper(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        
        if (dp[amount - 1] != 0) {
            return dp[amount - 1];
        }
        
        int min = Integer.MAX_VALUE;
        for (int coin: coins) {
            int curr = helper(coins, amount - coin, dp);
            if (curr >= 0 && curr < min) {
                min = curr + 1; //Add coin
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            dp[amount - 1] = -1;
        } else {
            dp[amount - 1] = min;
        }
        
        return dp[amount - 1];
    }
}