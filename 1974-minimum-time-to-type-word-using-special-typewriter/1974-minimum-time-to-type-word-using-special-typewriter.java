class Solution {
    public int minTimeToType(String word) {
        char[] ch = word.toCharArray();
        char slow = 'a';
        
        int result = ch.length;
        for (int i = 0; i < ch.length; i++) {
            
            char curr = ch[i];
            int curr_asc = curr;
            int slow_asc = slow;
            
            int clock = Math.abs(slow_asc - curr_asc);
            if (clock > 13) {
                clock = Math.abs(clock - 26);
            }
            
            System.out.println(clock);
            
            result += clock;
            slow = curr;
        }
        
        return result;
    }
}