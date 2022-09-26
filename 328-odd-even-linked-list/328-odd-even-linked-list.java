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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp_odd = new ListNode(0);
        ListNode ref_odd = temp_odd;
        ListNode temp_even = new ListNode(0);
        ListNode ref_even = temp_even;
        
        boolean odd = true;
        
        while (head != null) {
            if (odd) {
                odd = !odd;
                ref_odd.next = head;
                head = head.next;
                ref_odd.next.next = null;
                ref_odd = ref_odd.next;
            } else {
                odd = !odd;
                ref_even.next = head;
                head = head.next;
                ref_even.next.next = null;
                ref_even = ref_even.next;
            }
        }
        
        ref_odd.next = temp_even.next;
        
        return temp_odd.next;
    }
}