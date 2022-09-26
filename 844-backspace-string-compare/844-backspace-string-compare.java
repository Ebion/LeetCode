class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        
        int ss = s.length() - 1;
        int tt = t.length() - 1;
        
        int ss_back = 0;
        int tt_back = 0;
        
        char ss_curr;
        char tt_curr;
        
        while (ss >= 0 || tt >= 0) {
            
            if (ss < 0) {
                ss_curr = ' ';
            } else {
                ss_curr = s_arr[ss];
            }
            
            if (tt < 0) {
                tt_curr = ' ';
            } else {
                tt_curr = t_arr[tt];
            }
            
            if (ss_curr == '#') {
                ss--;
                ss_back++;
                continue;
            } 
            
            if (tt_curr == '#') {
                tt--;
                tt_back++;
                continue;
            }
            
            if (ss_back > 0) {
                ss--;
                ss_back--;
                continue;
            }
            
            if (tt_back > 0) {
                tt--;
                tt_back--;
                continue;
            }
            
            if (ss_curr != tt_curr) {
                return false;
            } else {
                ss--;
                tt--;
            }
        }
        
        return true;
    }
}