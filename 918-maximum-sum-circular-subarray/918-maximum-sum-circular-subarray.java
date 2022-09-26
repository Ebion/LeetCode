class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // 2 cases, max = maxSubArray
        int max_sub_array = maxSubArray(nums);
        System.out.println(max_sub_array);
        
        // OR array can go circular, thus the max can be (sum of array - minimum sub array)
        int min_sub_array = minSubArray(nums);
        int sum = sum(nums);
        
        if (sum != min_sub_array) {
            //output the max of the 2
            int result = Math.max(max_sub_array, sum - min_sub_array);
            return result;
        } else {
            //corner case if all numbers are negative then best result will be from max_sub_array;
            return max_sub_array;
        }
    }
    
    public int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
    
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
    
    public int minSubArray(int[] nums) {
        int min_result = nums[0];
        int min_at_point = 2147483647;
        
        for (int i = 0; i < nums.length; i++) {
            if (min_at_point > 0) {
                min_at_point = 0;
            }
            min_at_point += nums[i];
            if (min_at_point < min_result) {
                min_result = min_at_point;
            }
        }
        return min_result;
    }
}