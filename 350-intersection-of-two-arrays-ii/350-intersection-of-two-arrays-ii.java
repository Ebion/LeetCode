class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        HashMap<Integer, Integer> checker = new HashMap<Integer, Integer>();
        
        List<Integer> result = new ArrayList<Integer>();
        
        if (len1 >= len2) {
            for (int i = 0; i < len1; i++) {
                int curr = nums1[i];
                if (checker.containsKey(curr)) {
                    int value = checker.get(curr);
                    value++;
                    checker.put(curr, value);
                } else {
                    checker.put(curr, 1);
                }
            }
            
            for (int i = 0; i < len2; i++) {
                int curr = nums2[i];
                if (checker.containsKey(curr)) {
                    int value = checker.get(curr);
                    if (value >= 1) {
                        value--;
                        checker.put(curr,value);
                        result.add(curr);
                    }
                }
            }
        } else {
            for (int i = 0; i < len2; i++) {
                int curr = nums2[i];
                if (checker.containsKey(curr)) {
                    int value = checker.get(curr);
                    value++;
                    checker.put(curr, value);
                } else {
                    checker.put(curr, 1);
                }
            }
            
            for (int i = 0; i < len1; i++) {
                int curr = nums1[i];
                if (checker.containsKey(curr)) {
                    int value = checker.get(curr);
                    if (value >= 1) {
                        value--;
                        checker.put(curr,value);
                        result.add(curr);
                    }
                }
            }
        }
        
        return listToArray(result);
    }
    
    private int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
         
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
         
        return result;
    }
}