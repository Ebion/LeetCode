import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> roman = new HashMap<String, Integer>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
        
        String[] array_roman = s.split("");
        int total = 0;
        for (int i = 0; i < array_roman.length; i++) {
            String current_roman = array_roman[i];
            
            int current = roman.get(current_roman);
            
            if (i < array_roman.length - 1) {
                String next_roman = array_roman[i+1];
                int next = roman.get(next_roman);

                if (current >= next) {
                    total += current;
                }
                else if (next > current) {
                    total -= current;
                }
                else {
                    System.out.println("error");
                }
            } else {
                total += current;
            }
        }
        
        return total;
    }
}