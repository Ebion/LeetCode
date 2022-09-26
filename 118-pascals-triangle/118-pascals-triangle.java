class Solution {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return result;
        }
        
        // previous row, start at first row [1]
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);

        for (int i = 2; i <= numRows; i++) {
            // start from 2nd row
            List<Integer> cur = new ArrayList<Integer>();

            //first number is always 1
            cur.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                // add the middle numbers, should be same size as previous row
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            // add last number, always 1
            cur.add(1);

            result.add(cur);
            //set previous to curr
            pre = cur;
        }

        return result;
    }
    
}