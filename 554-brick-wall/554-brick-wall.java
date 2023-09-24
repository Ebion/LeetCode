class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int length_of_wall = -1;

        for (List<Integer> bricks: wall) {
            int curr_pos = 0;
            for (int brick: bricks) {
                // For each brick layer, count all the spaces within the bricks and add into hashmap
                // key = position of the cut and value is the number of empty spaces
                curr_pos += brick;
                hashMap.compute(curr_pos, (k, v) -> (v == null) ? 1 : v + 1);
                
                if (curr_pos > length_of_wall) {
                    length_of_wall = curr_pos;
                }
            }
        }
        
        int cut = -1;
        int max_val = -1;        
        int thickestWall = wall.size();
        
        if (hashMap.size() == 1) {
            return thickestWall;
        }
        
        // Now we just need to find the thickestWall - the most number of empty spaces = Best cut which intersects the least number of bricks
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
            
            // Need to not count the cut at the 0th position and the cut at the last position
            // Basically cannot cut outside the wall on its left and right
            if (value > max_val && key != 0 && key != length_of_wall) {
                cut = key;
                max_val = value;
            }
        }
        
        // the cut variables is actually not needed
        return thickestWall - max_val;
    }
}