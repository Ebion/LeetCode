class Solution {
    public int countSeniors(String[] details) {
        int result = 0;
        
        for (String detail: details) {
            String age = detail.substring(11,13);
            System.out.println(age);
            if (Integer.parseInt(age) > 60) {
                result++;
            }
        }
        
        return result;
    }
}