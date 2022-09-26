class Solution {
    public boolean isSubsequence(String s, String t) {
        int i1 = 0;
        int i2 = 0;
        
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        
        int edge_case_s = s_arr.length;
        int limit = t_arr.length;
        
        if (limit == 0) {
            if (edge_case_s == 0) {
                return true;
            }
            return false;
        }
        
        for (char c : s_arr) {
            if (i2 == limit) {
                return false;
            }
            while (c != t_arr[i2]) {
                if (i2 == limit - 1) {
                    return false;
                } else {
                    i2++;  
                }
            }
            i2++;
        }
        return true;
    }
}