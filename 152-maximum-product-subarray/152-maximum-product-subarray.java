class Solution {
    public int maxProduct(int[] nums) {
        int max_result = nums[0];
        int max_at_point = nums[0];
        int min_at_point = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp = Math.max(curr, Math.max(max_at_point * curr, min_at_point * curr));
            min_at_point = Math.min(curr, Math.min(max_at_point * curr, min_at_point * curr));
            
            max_at_point = temp;
            
            if (max_at_point > max_result) {
                max_result = max_at_point;
            }
        }
        return max_result;
    }
}