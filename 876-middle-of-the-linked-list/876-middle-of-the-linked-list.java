/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 1,2,3,4,5,6
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        if (head.next == null) {
            return head;
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                break;
            } else {
                fast = fast.next; 
            }
            
            if (fast == null) {
                break;
            } else if (fast.next == null) {
                break;
            }
        }
        
        return slow;
    }
}