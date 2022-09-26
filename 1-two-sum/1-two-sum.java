class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> ori_left = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int original = nums[i];
            int left = target - nums[i];
            
            if (ori_left.keySet().contains(original)) {
                int other_num_indx = ori_left.get(original);
                ans[0] = i;
                ans[1] = other_num_indx;
                return ans;
            } else {
                ori_left.put(left, i);
                
            }
        }
        ans[0] = 0;
        ans[1] = 1;
        
        return ans;
    }
}