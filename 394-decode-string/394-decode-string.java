class Solution {
    public String decodeString(String s) {
        Stack<String> stacked = new Stack<String>();
        Stack<Integer> multiplier = new Stack<Integer>();
        
        char[] s_arr = s.toCharArray();
        
        String result = "";
        int i = 0;
        while (i < s_arr.length) {
            char curr = s_arr[i];
            
            if (Character.isDigit(curr)) {
                //if is a digit check if next is digit
                int count = 0;
                while (Character.isDigit(s_arr[i])) {
                    count = 10 * count + ( s_arr[i] - '0' );
                    i++;
                }
                multiplier.push(count);
            } else if (curr == ']') {
                //pop out the front that was stored before opening bracket
                String temp = stacked.pop();
                    
                //we need to empty the integer stack, this stack only has 1 integer at any time     
                int count = multiplier.pop();
                result = result.repeat(count);
                
                //add this result into the front 
                temp += result;
                result = temp;
                i++;
            } else if (curr == '[') {
                //if open, keep the left string in the stack first
                stacked.push(result);
                result = "";
                i++;
            } else {
                result += curr;
                i++;
            }
        }
        return result;
    }
}