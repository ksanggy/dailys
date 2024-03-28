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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;

        // 1. setup necessary vars that will hold the before, after x
        ListNode before = new ListNode(-200);
        ListNode dummyA = before;
        ListNode after = new ListNode(-200);
        ListNode dummyB = after;
        // 2. loops through to the partition list
        while(head != null) {
            if(head.val < x) {
                dummyA.next = head;
                dummyA = dummyA.next;
            }
            else {
                dummyB.next = head;
                dummyB = dummyB.next;
            }
            head = head.next;
        }
        // 3. set dummyB.next to null if it is not null -> after the loop, anything that comes after dummyB.next is just a repeat
        if(dummyB.next != null)
            dummyB.next = null;
        // 4. connect dummyA (before x) and after (after x, 'after' is the head of the other half)
        dummyA.next = after.next;
        return before.next;
    }
}