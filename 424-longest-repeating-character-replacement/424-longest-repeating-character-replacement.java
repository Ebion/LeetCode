class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int char_count[] = new int[26];
        
        int start = 0;
        int end = 0;
        int s_len = s.length();
        char[] arr = s.toCharArray();
        
        int max_consec = 0;
        while (end < s_len) {
            char curr = arr[end];
            char_count[curr - 'A']++;
            int curr_count = char_count[curr - 'A'];
            
            max_consec = Math.max(curr_count, max_consec);
            
            // end - start + 1 is the total length (+1 to account for first letter)
            int k_used = end - start + 1 - max_consec;
            if (k_used > k) {
                char start_ = arr[start];
                start++;
                
                char_count[start_ - 'A']--;
            }
            
            result = Math.max(result, end - start + 1);
            end++;
        }
        
        return result;
    }
}