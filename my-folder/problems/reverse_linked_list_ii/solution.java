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
    public ListNode reverseBetween(ListNode head, int left, int right) {
                ListNode current = head;
        ListNode prev = null;
        // 1. skip until node index is at left (here loop until left - 1 because we wanna stop before the actual node that need reversing)
        for(int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        // 2. reverse the nodes that are in between left and right
        ListNode lastNodeOfFirstPart = prev;
        ListNode lastNodeOfSublist = current;
        ListNode next = null; // holder variable for next node
        int numberOfNodesForReversal = right - left + 1;
        for (int i = 0; current != null && i < numberOfNodesForReversal; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        // 3. connect the first part
        if(lastNodeOfFirstPart != null)
            lastNodeOfFirstPart.next = prev;
        else
            head = prev;
        // 4. connect the last part
        lastNodeOfSublist.next = current;

        return head;
    }
}