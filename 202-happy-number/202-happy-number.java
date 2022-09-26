class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> set = new HashSet<>();
        int sum = n;
        while (sum != 1) {
            Integer[] temp = getDigits(sum);
            
            sum = 0;
            for (int i = 0; i < temp.length; i++) {
                sum += temp[i] * temp[i];
            }
            if (set.contains(sum)) {
                return false;
            } else { 
                set.add(sum);
            }
        }
        
        return true;
    }
    
    public static Integer[] getDigits(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        collectDigits(num, digits);
        return digits.toArray(new Integer[]{});
    }

    private static void collectDigits(int num, List<Integer> digits) {
        if(num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }
}