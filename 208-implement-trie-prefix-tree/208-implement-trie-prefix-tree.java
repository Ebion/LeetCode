public class TreeNode {
    public HashMap<Character, TreeNode> children;
    public boolean isEnd;

    TreeNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

class Trie {   

    public TreeNode root;
    
    public Trie() {
        root = new TreeNode();
    }
    
    public void insert(String word) {
        TreeNode current = root;
        for (char c: word.toCharArray()) {
            
            // if the children does not have the letter
            if (!current.children.containsKey(c)) {
                // insert the key with a new empty tree below
                current.children.put(c, new TreeNode());
                current = current.children.get(c);
            } 
            // if it has the key then dont need to do anything, just get the root = child
            else {
                current = current.children.get(c);
            }
        }
        // at the end of the loop make the last tree node isEnd = true
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TreeNode current = root;
        for (char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            } else {
                current = current.children.get(c);
            }
        }
        
        // at the end of the loop, need to check if it is a word
        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TreeNode current = root;
        for (char c: prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            } else {
                current = current.children.get(c);
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */