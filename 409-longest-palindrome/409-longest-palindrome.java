class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
        char[] s_arr = s.toCharArray();
        
        for (int i = 0; i < s_arr.length; i++) {
            char curr = s_arr[i];
            if (counter.containsKey(curr)) {
                counter.put(curr, counter.get(curr) + 1);
            } else {
                counter.put(curr, 1);
            }
        }
        
        boolean odd_one = false;
        int result = 0;
        for (Integer count : counter.values()) {
            if (count >= 2) {
                if (count%2 == 1) {
                    if (!odd_one) {
                        odd_one = true;
                    }
                    int add = count - 1;
                    result += add;
                } else {
                    result += count;
                }
            } else if (count == 1 && !odd_one) {
                odd_one = true;
            }
        }
        
        if (odd_one) {
            result++;
            return result;
        } else {
            return result;
        }
    }
}