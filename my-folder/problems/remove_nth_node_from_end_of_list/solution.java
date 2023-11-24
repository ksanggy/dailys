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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // using two pointers method
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;
        // 1. offset right node by n
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }
        // 2. keep shifting node until right == null, this brings left at the Nth - 1 node
        while(right != null) {
            right = right.next;
            left = left.next;
        }

        // 3. delete the node
        left.next = left.next.next;
        return dummy.next; // return the original head
        
    }

}