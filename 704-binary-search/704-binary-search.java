class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int first = 0;
        int last = length - 1;
        
        while (first <= last) {
            int mid_pt = (first+last)/2;
            int curr = nums[mid_pt];
            if (target == curr) {
                return mid_pt;
            } else if (target > curr) {
                first = mid_pt + 1;
            } else if (target < curr) {
                last = mid_pt - 1;
            }
        }
        
        return -1;
    }
}