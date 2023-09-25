class Solution {
    public boolean isValid(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        
        HashSet<Character> set = new HashSet<>();
        set.add('{');
        set.add('[');
        set.add('(');
    
        for (char curr: arr) {
            // System.out.println(curr);
            if (set.contains(curr)) {
                // System.out.println("Pushed to stack");
                // System.out.println(curr);
                stack.push(curr);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (!checkPair(open, curr)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public static boolean checkPair(char open, char closed) {
        if (open == '(' && closed == ')') {
            return true;
        }
        if (open == '{' && closed == '}') {
            return true;
        }
        if (open == '[' && closed == ']') {
            return true;
        }
        return false;
    }
}