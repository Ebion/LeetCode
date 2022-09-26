/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pointer = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            pointer = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pointer.next= null;
        
        ListNode left_side = sortList(head);
        ListNode right_side = sortList(slow);
        
        return merge(left_side, right_side);
    }
    
    public ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        
        while (left != null && right  != null) {
            if (left.val < right.val) {
                pointer.next = left;
                left = left.next;
            } else {
                pointer.next = right;
                right = right.next;
            }
            pointer = pointer.next;
        }
        
        if (left != null) {
            pointer.next = left;
            left = left.next;
        }
        
        if (right != null) {
            pointer.next = right;
            right = right.next;
        }
        
        return result.next;
    }
}