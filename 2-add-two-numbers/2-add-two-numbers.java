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
        boolean counter = false;
        ListNode fast = new ListNode();
        ListNode result = fast;
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (counter) {
                sum += 1;
                counter = false;
            }
            
            if (sum >= 10) {
                counter = true;
                sum -= 10;
            }
            
            fast.next = new ListNode(sum);
            fast = fast.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int lastNum = l1.val;
            if (counter) {
                lastNum += 1;
                counter = false;
            }
            
            if (lastNum >= 10) {
                counter = true;
                lastNum -= 10;
            }
            fast.next = new ListNode(lastNum);
            fast = fast.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int lastNum = l2.val;
            if (counter) {
                lastNum += 1;
                counter = false;
            }
            
            if (lastNum >= 10) {
                counter = true;
                lastNum -= 10;
            }
            fast.next = new ListNode(lastNum);
            fast = fast.next;
            l2 = l2.next;
        }
        
        if (counter) {
            fast.next = new ListNode(1);
        }
        
        return result.next;
    }
}