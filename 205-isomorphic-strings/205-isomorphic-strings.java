import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> chardict = new HashMap<Character, Character>();
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int n = s_arr.length;
        int i = 0;
        
        while (i < n) {
            char ss = s_arr[i];
            char tt = t_arr[i];
            if (chardict.keySet().contains(ss)) {
                if (tt != chardict.get(ss)) {
                    return false;
                }
            } else if (chardict.values().contains(tt)) {
                if (chardict.keySet().contains(ss)) {
                    if (chardict.get(tt) != ss) {
                        return false;
                    } 
                } else {
                    return false;
                }
            } else {
                chardict.put(ss, tt);
            }
            i++;
        }
        return true;
    }
}