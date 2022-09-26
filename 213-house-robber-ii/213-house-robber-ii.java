class Solution {
    public int rob(int[] nums) {
        int nums_len = nums.length;
        
        if (nums_len == 1) {
            return nums[0];
        }
        //Note that when u rob the first house, you can rob the last
        int[] first_result = Arrays.copyOfRange(nums, 0, nums_len - 1);
        int max_first = robber1(first_result);
        
        //Then if you rob the second house, you can rob the last
        int[] second_result = Arrays.copyOfRange(nums, 1, nums_len);
        int max_second = robber1(second_result);
        
        int max = Math.max(max_first, max_second);
        return max;
    }
    
    public int robber1(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        // when robbing from 2nd house, you should always rob from first if first is worth more
        dp[1]=Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            // You have 2 options, 
            // rob this house and not rob previous,
            // dp[i-2] (cannot rob i-1) + nums[i] (robbed)
            // OR you skip this house, dp[i-1] (did not rob so add nothing)
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }
}