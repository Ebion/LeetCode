import java.util.HashMap;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (counter.keySet().contains(curr)) {
                return true;
            } else {
                counter.put(curr, 1);
            }
        }
        return false;
    }
}