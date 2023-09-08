class Solution {
    public int monotoneIncreasingDigits(int n) {
        int original = n;
        String result = "";
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        while (n > 0) {
            int curr = n%10;
            array.add(0, n % 10);
            n /= 10;
        }
        System.out.println(array);
        
        boolean increasing = true;
        int slow = -1;
        int monotone_increment = 0;
        for (int i = 0; i < array.size(); i++) {
            int curr = array.get(i);
            
            if (curr > slow && increasing) {
                monotone_increment = i;
            } else if (curr == slow) {
                
            } else {
                increasing = false;
            }
            slow = curr;
        }
        System.out.println(monotone_increment);
        
        if (increasing) {
            return original;
        }
        
        for (int i = 0; i < array.size(); i++) {
            int curr = array.get(i);
            if (i < monotone_increment) {
                result += Integer.toString(curr);
            } else if (i == monotone_increment) {
                if (!increasing) {
                    result += Integer.toString(curr - 1);  
                }
            } else {
                result += Integer.toString(9);
            }
        }
        
        System.out.println(result);
        
        return Integer.parseInt(result);
    }
}