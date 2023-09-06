import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int numslen = nums.length;
        
        int curr = -1;
        for (int i = 0; i < numslen; i++) {
            curr = nums[i];
            int count = map.getOrDefault(curr, 0);
            map.put(curr, count + 1);
            if (count + 1 > numslen/2) {
                break;
            }
        }
        
        return curr;
    }
}