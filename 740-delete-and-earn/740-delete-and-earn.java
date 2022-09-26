import java.util.Hashtable;

class Solution {
    public int deleteAndEarn(int[] nums) {
        Hashtable<Integer,Integer> hm = new Hashtable<Integer,Integer>();
        int max_num = -1;
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        for (int num: nums) {
            if (num > max_num) {
                max_num = num;
            }
            if (hm.containsKey(num)) {
                hm.replace(num, hm.get(num), hm.get(num) + num);
            } else {
                hm.put(num, num);
            }
        }
        
        int[] dp = new int[max_num + 1];
        dp[0] = 0;
        if (hm.containsKey(1)) {
            dp[1] = hm.get(1);
        }
        
        for (int i = 2; i <= max_num; i++) {
            int value = 0;
            if (hm.containsKey(i)) {
                value = hm.get(i);
            }
            dp[i] = Math.max(dp[i-1], dp[i-2] + value);
        }
        
        return dp[max_num];
    }
}