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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0)
            return head;

        // 1. find the length of the list
        ListNode lastNode = head;
        int length = 1;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            length++;
        }

        // 2. connect the lastNode to the head of the list -> this creates a circular list
        lastNode.next = head;
        k %= length; // number of rotations to do
        int skipLength = length - k;
        ListNode lastNodeOfRotatedList = head;
        for(int i = 0; i < skipLength - 1; i++)
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;

        // 3. set the lastNodeOfRotatedList.next to the head as it is now the head of the rotated list
        head = lastNodeOfRotatedList.next;
        // 4. set the lastNodeOfRotatedList.next to null as lastNodeOfRotatedList is the end of the sublist
        lastNodeOfRotatedList.next = null;
        return head;
    }
}