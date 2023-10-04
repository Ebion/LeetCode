class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        
        // If the nums is not val, the index will increase and nums will just replace at element at index, basically doing nothing
        // However if a number where val is found, index will do nothing, staying at its current position, waiting to be replaced by the next element
        // This effectively 'removes' the element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index;
    }
}