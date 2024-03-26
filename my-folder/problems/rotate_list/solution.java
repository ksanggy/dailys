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
        // base case
        if(head == null || head.next == null)
            return head;

        // find the length of list to use to calculate how many times to skip nodes
        ListNode lastNode = head;
        int length = 1;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            length++;
        }

        // set lastNode.next to head to make the list a cyclic linked list
        lastNode.next = head;

        // calculate how many nodes to skip to find the lastNodeOf
        k %= length;
        int skipCount = length - k;
        ListNode endNode = head;
        for (int i = 0; i < skipCount - 1; i++)
            endNode = endNode.next;
        // set head to endNode.next as the next node of endNode will be the new head
        head = endNode.next;
        endNode.next = null;
        return head;
    }
}