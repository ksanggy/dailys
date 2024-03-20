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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        // set up variables of slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        // traverse the fast pointer by n times
        for (int i = 0; i < n; i++)
            fast = fast.next;
        if(fast == null)
            return head.next;
        // loop while fast.next is not null
        // we want to traverse both pointers to the next node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next; // fast will have moved by n times, so it is ahead of the slow pointer
        }
        slow.next = slow.next.next;
        return head;
    }
}