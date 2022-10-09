class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //temp result, can be whatever
        int result = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int second = i + 1;
            int third = nums.length - 1;
            //System.out.println(i + " " + second + " " + third);
            
            while (second < third) {
                int curr_sum = nums[i] + nums[second] + nums[third];
                //System.out.println(curr_sum);
                int diff = curr_sum - target;
                if (diff == 0) {
                    return target;
                }
                if (diff > 0) {
                    third--;
                } else {
                    second++;
                }
                
                if (Math.abs(diff) < Math.abs(result - target)) {
                    result = curr_sum;
                }
            }
        }
        
        return result;
    }
}