class Solution {    
    /*public int rob(int[] nums) {
        //2 paths here, rob from the first house and rob from second house
        if (nums.length == 1) {
            return nums[0];
        }
        int rob_1 = robbing (0, nums);
        int rob_2 = robbing(1, nums);
        return Math.max(rob_1, rob_2);
    }
    
    public int robbing(int n, int[] nums) {
        int max = nums.length;
        if (n >= max) {
            return 0;
        }
        int robbed = nums[n];
        //cannot rob from 1 to 2, so rob 1 to 3
        //rob from 1 to 3
        int path1 = robbing(n+2, nums) + robbed;
        //rob from 1 to 4, if 1 to 5, might as well rob 3
        int path2 = robbing(n+3, nums) + robbed;
        return Math.max(path1, path2);
    }*/
    
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        // when robbing from 2nd house, you should always rob from first if first is worth more
        dp[1]=Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            // You have 2 options, rob this house and not rob previous, dp[i-2] (cannot rob i-1) + nums[i] (robbed)
            // OR you skip this house, dp[i-1] (did not rob so add nothing)
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }
}