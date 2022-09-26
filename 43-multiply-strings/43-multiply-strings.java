class Solution {
    public String multiply(String num1, String num2) {
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] pos = new int[len1 + len2];
        int ten_counter = 0;
        for (int i = 0; i < len1; i++) {
            char curr1 = nums1[len1 - i -1];
            int sum_at_i = 0;
            for (int j = 0; j < len2; j++) {
                char curr2 = nums2[len2 - j - 1];
                int char1 = curr1 - '0';
                int char2 = curr2 - '0';
                
                int multi = char1 * char2;
                
                int pos1 = i + j;
                int pos2 = pos1 + 1;
                
                //add in remainder from last iteration
                int sum = multi + pos[pos1];
                //System.out.println(char1 + " " + char2 + " " + sum);
                pos[pos1] = sum%10;
                pos[pos2] += sum/10;
            }
            ten_counter++;
        }
        
        StringBuilder myStringB = new StringBuilder();
        String myString = new String();
        
        int counter = pos.length - 1;
        while (pos[counter] == 0 && counter > 0) {
            counter--;
        }
        
        if (counter < 0) {
            return "0";
        }
        
        while (counter >= 0) {
            //System.out.println(pos[counter]);
            myStringB.append(pos[counter]);
            counter--;
        }

        myString = myStringB.toString();
        return myString;
    }
}