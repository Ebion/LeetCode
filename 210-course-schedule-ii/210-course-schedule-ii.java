class Solution {
    HashSet<Integer> visited;
    HashSet<Integer> cycle;
    List<Integer> output;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            List<Integer> temp = new LinkedList<Integer>();
            map.put(i, temp);
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            if (map.containsKey(course)) {
                List<Integer> prev = map.get(course);
                prev.add(prereq);
                //System.out.println("HashMap" + " " + course + " " + map.get(course));
                map.put(course, prev);
            }
        }
        
        output = new ArrayList<Integer>();
        visited = new HashSet();
        cycle = new HashSet();
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs_with_cycle(i, map)) {
                //System.out.println("has cycle");
                int[] empty = new int[0];
                return empty;
            }
        }
        
        int[] result = new int[numCourses];
        
        for (int i = 0; i < output.size(); i++) {
            //System.out.println("hi");
            result[i] = output.get(i);
        }
        
        return result;
    }
    
    public boolean dfs_with_cycle(int node, Map<Integer, List<Integer>> map) {
        if (visited.contains(node)) {
            return true;
        }
        if (cycle.contains(node)) {
            //System.out.println("has cycle");
            return false;
        }
        
        cycle.add(node);
        List<Integer> prereqs = map.get(node);
        for (int j = 0; j < prereqs.size(); j++) {
            Integer prereq = prereqs.get(j);
            if (dfs_with_cycle(prereq, map) == false) {
                //System.out.println("has cycle at " + prereq + node);
                return false;
            }
        }
        
        cycle.remove(node);
        visited.add(node);
        output.add(node);
        return true;
    }
}