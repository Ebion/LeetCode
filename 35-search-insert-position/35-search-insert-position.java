class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        
        int start = 0;
        int end = length - 1;
        
        while(end >= start) {
            int midpoint = start + (end - start)/2;
            // System.out.println(nums[midpoint]);
            if (nums[midpoint] == target) {
                return midpoint;
            } else if (nums[midpoint] > target) {
                end = midpoint - 1;
            } else {
                start = midpoint + 1;
            } 
        }
        
        return start;
    }
}