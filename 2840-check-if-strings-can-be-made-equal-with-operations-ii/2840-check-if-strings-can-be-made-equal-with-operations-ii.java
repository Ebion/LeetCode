class Solution {
    public boolean checkStrings(String s1, String s2) {
        
        StringBuilder evenChars1 = new StringBuilder();
        StringBuilder oddChars1 = new StringBuilder();
        StringBuilder evenChars2 = new StringBuilder();
        StringBuilder oddChars2 = new StringBuilder();
        
        for (int i = 0; i < s1.length(); i++) {
            if (i%2 == 0) {
                evenChars1.append(s1.charAt(i));
                evenChars2.append(s2.charAt(i));
            } else {
                oddChars1.append(s1.charAt(i));
                oddChars2.append(s2.charAt(i));
            }
        }
        
        // Convert evenStrings and oddStrings to character arrays
        char[] evenChars1Array = evenChars1.toString().toCharArray();
        char[] oddChars1Array = oddChars1.toString().toCharArray();
        char[] evenChars2Array = evenChars2.toString().toCharArray();
        char[] oddChars2Array = oddChars2.toString().toCharArray();

        // Sort the character arrays
        Arrays.sort(evenChars1Array);
        Arrays.sort(oddChars1Array);
        Arrays.sort(evenChars2Array);
        Arrays.sort(oddChars2Array);
        
        for (int i = 0; i < evenChars1Array.length ; i++) {
            if (evenChars1Array[i] != evenChars2Array[i]) {
                return false;
            }
        }
        
        for (int i = 0; i < oddChars1Array.length ; i++) {
            if (oddChars1Array[i] != oddChars2Array[i]) {
                return false;
            }
        }
        
        return true;        
    }
}