class Solution {
    public int findCenter(int[][] edges) {
        int most_appeared = -1;
        
        int first = edges[0][0];
        int second = edges[0][1];
        
        for (int i = 0; i < 2; i++) {
            if (edges[1][i] == first) {
                return first;
            }
        }
        return second;
    }
}