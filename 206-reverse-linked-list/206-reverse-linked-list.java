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
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        
        ListNode storer = null;
        
        while (head != null) {
            ListNode temp = head;
            storer = new ListNode(temp.val);
            storer.next = result;
            result = storer;
            head = head.next;
        }
        
        return storer;
    }
}