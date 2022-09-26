import java.util.ArrayList;

class Solution {
    public int pivotIndex(int[] nums) {
        int counter = 0;
        int nums_len = nums.length;
        ArrayList<Integer> running_arr = new ArrayList<Integer>(nums_len);
        for (int i = 0; i < nums_len; i++) {
            counter += nums[i];
            running_arr.add(counter);
        }
        
        for (int i = 0; i < nums_len; i++) {
            int curr = running_arr.get(i);
            int left_side = curr - nums[i];
            int right_side = counter - curr;
            if (left_side == right_side) {
                return i;
            }
        }
    
        return - 1;
    }
}