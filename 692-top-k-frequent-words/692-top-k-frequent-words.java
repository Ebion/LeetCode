import java.util.Map.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<String>();
        Map<String, Integer> map = new HashMap<>();
        
        for (String word: words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>(
        (a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        for (int i = 0; i < k; i++) {
            Entry<String, Integer> temp = queue.poll();
            result.add(0, temp.getKey());
        }
        
        return result;
    }
}