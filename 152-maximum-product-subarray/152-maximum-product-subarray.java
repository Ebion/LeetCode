class Solution {
    public int maxProduct(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int max = 0;
        int min = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            
            int temp_max = Math.max(curr*max, Math.max(curr, curr*min));
            min = Math.min(curr*max, Math.min(curr, curr*min));
            max = temp_max;
            
            result = Math.max(max, result);
        }
        
        return result;
    }
}