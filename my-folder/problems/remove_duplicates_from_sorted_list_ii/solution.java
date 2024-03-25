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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        // set two variables to track previous node and a current node
        ListNode dummy = new ListNode(-200);
        dummy.next = head;
        ListNode temp = dummy;
        ListNode current = head;

        while(current != null && current.next != null) {
            if(current.val == current.next.val) {
                while(current.next != null && current.val == current.next.val)
                    current = current.next;
                temp.next = current.next;
            }
            else
                temp = temp.next;
            current = current.next;
        }
        return dummy.next;
    }
}