class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> secret_left = new HashMap<Character, Integer>();
        HashMap<Character, Integer> guess_left = new HashMap<Character, Integer>();
        
        char[] s_arr = secret.toCharArray();
        char[] g_arr = guess.toCharArray();
        
        int len = s_arr.length;
        int bull = 0;
        int cow = 0;
        
        for (int i = 0; i < len; i++) {
            char s_curr = s_arr[i];
            char g_curr = g_arr[i];
            
            if (s_curr == g_curr) {
                bull++;
                continue;
            } else {
                if (secret_left.containsKey(g_curr)) {
                    int curr_val = secret_left.get(g_curr);
                    if (curr_val > 0) {
                        curr_val--;
                        cow++;
                        
                        if (curr_val == 0) {
                            secret_left.remove(g_curr);
                        } else {
                            secret_left.replace(g_curr, curr_val);  
                        }
                    }
                } else {
                    if (guess_left.containsKey(g_curr)) {
                        int curr_val = guess_left.get(g_curr);
                        guess_left.replace(g_curr, curr_val + 1);
                    } else {
                        guess_left.put(g_curr, 1);
                    }
                }
                
                if (guess_left.containsKey(s_curr)) {
                    int curr_val = guess_left.get(s_curr);
                    if (curr_val > 0) {
                        curr_val--;
                        cow++;
                        
                        if (curr_val == 0) {
                            guess_left.remove(s_curr);
                        } else {
                            guess_left.replace(s_curr, curr_val);  
                        }
                    }
                } else {
                    if (secret_left.containsKey(s_curr)) {
                        int curr_val = secret_left.get(s_curr);
                        secret_left.replace(s_curr, curr_val + 1);
                    } else {
                        secret_left.put(s_curr, 1);
                    }
                }
            }
        }
        
        String result = bull + "A" + cow +"B";
        return result;
    }
}