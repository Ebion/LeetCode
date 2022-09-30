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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean more10 = false;
        ListNode result = new ListNode(0);
        ListNode pointer = new ListNode(0);
        pointer = result;
        while (l1 != null || l2 != null || more10) {
            int tot = 0;
            if (l1 != null) {
                tot += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tot += l2.val;
                l2 = l2.next;
            }
            
            if (more10) {
                tot += 1;
                more10 = false;
            }
            
            if (tot >= 10) {
                tot -= 10;
                more10 = true;
            }
            
            pointer.next = new ListNode(tot);
            pointer = pointer.next;
        }
        return result.next;
        
    }
}