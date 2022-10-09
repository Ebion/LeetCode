class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int result = 0;
        
        char[] arr = s.toCharArray();
        int curr_len = 0;
        int start = 0;
        int end = 0;
        
        while (end < arr.length) {
            char curr = arr[end];
            if (set.contains(curr)) {
                set.remove(arr[start]);
                start++;
                curr_len--;
            } else {
                set.add(curr);
                curr_len++;
                end++;
            }
            
            if (curr_len > result) {
                result = curr_len;
            }
        }
        return result;
    }
}