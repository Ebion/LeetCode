class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        
        int[] char_count = new int[26];
        
        for (char c: p.toCharArray()) {
            char_count[c - 'a'] += 1;
        }
        
        int left = 0;
        int right = 0;
        int count = p.length();
        
        char[] s_arr = s.toCharArray();
        
        while (right < s.length()) {
            
            // if letter in char_count, decrement it and decrease count
            char curr = s_arr[right];
            if (char_count[curr - 'a'] >= 1) {
                count--;
            }
            
            char_count[curr - 'a'] -= 1;
            right++;
            
            if (count == 0) {
                result.add(left);
            }
            
            if (right - left == p.length()) {
                char left_char = s_arr[left];
                // if the char_count was initally negative, means that it was a useless char not in p
                if (char_count[left_char - 'a'] >= 0) {
                    count++;
                }
                char_count[left_char - 'a'] += 1;
                left++;
            }
        }
        
        return result;
    }
}