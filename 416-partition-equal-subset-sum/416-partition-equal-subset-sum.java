import java.util.stream.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        int target = sum/2;
        set.add(0);
        
        for (int num: nums) {
            Iterator<Integer> it = set.iterator();
            Set<Integer> temp = new HashSet<Integer>();
            while (it.hasNext()) {
                int curr = it.next();
                if (curr == target) {
                    return true;
                }
                if (curr > target) {
                    continue;
                }
                int new_num = curr + num;
                temp.add(curr);
                temp.add(new_num);
            }
            set = temp;
        }
        
        return false;
    }
}