import java.util.regex.*;

class Solution {
    public int countValidWords(String sentence) {
        String regex = "^[a-z]+(?:-[a-z]+)?[!.,]?$|^!$|^,|^\\.$";
        Pattern pattern = Pattern.compile(regex);
        
        String[] words = sentence.split("\\s+");
        
        int result = 0;
        for (String word : words) {
            System.out.println(word);
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                result++;
            }
        }
        return result;
    }
}