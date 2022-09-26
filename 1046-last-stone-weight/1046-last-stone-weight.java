import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (int stone: stones) {
            queue.add(stone);
        }
        
        int x;
        int y;
        
        while (queue.size() > 1) {
            y = queue.poll();
            x = queue.poll();
            if(y > x) {
                queue.add(y-x);   
            }
        }
        
        return queue.isEmpty() ? 0 : queue.poll();
    }
}