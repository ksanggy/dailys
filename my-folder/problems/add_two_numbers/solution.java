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
        // set up dummy node to return as result
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carrier = 0; // counter for carrying tens
        while(l1 != null || l2 != null || carrier != 0) {
            int digit1 = l1 != null ? l1.val : 0;
            int digit2 = l2 != null ? l2.val : 0;
            int sum = digit1 + digit2;

            if(carrier > 0) {
                sum += carrier;
                carrier = 0; // reset carrier
            }
            if(sum >= 10)
                carrier++; // increment carrier

            tail.next = new ListNode(sum % 10); // set remaining as the result.next with new node with val
            tail = tail.next;

            // traverse to next node
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return dummy.next;
    }
}