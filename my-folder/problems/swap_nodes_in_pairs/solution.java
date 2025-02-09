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
    // swapping the nodes is trivial as it is quiet straight forward
    // key point in solving:
    // 1. how to track nodes to be swapped
    // 2. how to reinitialize nodes for the next swap within the iterative loop
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        while(head != null && head.next != null) {
            // nodes to be swapped
            ListNode slow = head;
            ListNode fast = head.next;

            // swap
            prev.next = fast;
            slow.next = fast.next;
            fast.next = slow;

            // reinit head and prev for the next swap
            prev = slow;
            head = slow.next; // this is the jump
        }
        return dummy.next;
    }
}