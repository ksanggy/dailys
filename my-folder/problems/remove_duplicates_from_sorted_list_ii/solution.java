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

        // 1. set a dummy node to deal with edge cases of first head value being repeated
        ListNode dummy = new ListNode(-200);
        dummy.next = head;
        // 2. set two pointers vars for two pointers approach
        ListNode slow = dummy;
        ListNode fast = dummy.next;
        ListNode prev = dummy; // anchor node to go back to if duplicates happen
        // 3. loop through to remove duplicates
        while(fast != null) {
            if(slow.val == fast.val) {
                while(fast != null && fast.val == slow.val) { // skip nodes until non duplicate values is found
                    fast = fast.next;
                }
                slow = prev; // set back slow to anchor node to remove duplicate
                slow.next= fast; // set slow.next to fast node to skip all duplicate nodes
            }
            // when values are unique move the pointers
            prev = slow; // set new anchor node to slow since it isn't a duplicate
            slow = slow.next;
            if(fast != null)
                fast = fast.next;
        }
        return dummy.next;
    }
}