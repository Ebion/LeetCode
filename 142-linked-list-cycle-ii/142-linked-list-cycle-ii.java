/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Integer> hash = new HashMap<ListNode, Integer>();
        ListNode pointer = head;
        int pos = 0;
        
        while (pointer != null) {
            if (hash.containsKey(pointer)) {
                break;
            } else {
                hash.put(pointer, pos);
                pointer = pointer.next;
                pos++;
            }
        }
        
        return pointer;
        
    }
}