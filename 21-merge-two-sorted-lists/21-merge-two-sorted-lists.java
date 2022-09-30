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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        
        ListNode resultPointer = result;
        while (list1 != null || list2 != null) {
            
            if (list1 == null) {
                System.out.println("list1 == null");
                resultPointer.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                System.out.println("list2 == null");
                resultPointer.next = list1;
                list1= list1.next;
            } else if (list1.val <= list2.val) {
                System.out.println("trigger 2 >= 1");
                resultPointer.next = list1;
                list1 = list1.next;
            } else if (list2.val < list1.val) {
                System.out.println("trigger 1 > 2");
                resultPointer.next = list2;
                list2 = list2.next;
            }
            
            if (resultPointer.next == null) {
                break;
            }
            resultPointer = resultPointer.next;
        }
        return result.next;
    }
}