class Solution {
    public int[] runningSum(int[] nums) {
        int counter = 0;
        int length_arr = nums.length;
        int[] result = new int[length_arr];
        for (int i = 0; i < length_arr; i++) {
            counter += nums[i];
            result[i] = counter;
        }
        return result;
    }
}