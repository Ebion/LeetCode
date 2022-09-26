class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);
        String first_str = strs[0];
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();
        
        int end = -1;
        for (int i = 0; i < first.length; i++) {
            System.out.println(first[i] + " " + last[i]);
            if (first[i] == last[i]) {
                end = i;
            } else {
                break;
            }
        }
        
        return first_str.substring(0, end + 1);
    }
}