class Solution {
    public int maxSubArray(int[] nums) {
        int max_result = nums[0];
        int max_at_point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max_at_point < 0) {
                max_at_point = 0;
            }
            max_at_point += nums[i];
            if (max_at_point > max_result) {
                max_result = max_at_point;
            }
        }
        return max_result;
    }
}