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
    public static ListNode reorderList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        // get second half head
        ListNode middleHead = getMiddleNode(head);
        // setup two halves of the linked list
        ListNode secondHalfHead = reverse(middleHead); // reverse the second half
        ListNode firstHalfHead = head;
        while(firstHalfHead != null && secondHalfHead != null){ // loop through both halves until the end
            // reorder the first half node
            ListNode temp = firstHalfHead.next;
            firstHalfHead.next = secondHalfHead;
            firstHalfHead = temp; // this sets the firstHalfHead to the actual next node of the first half
            // reorder the second half node
            temp = secondHalfHead.next;
            secondHalfHead.next = firstHalfHead;
            secondHalfHead = temp; // this sets the secondHalfHead to the actual next node of the second half
        }
        // after the loop, first half head will be the last node of the list. if it is not null then set next node to null
        if(firstHalfHead != null) {
            firstHalfHead.next = null;
        }
        return head;
    }

    private static ListNode reverse( ListNode head ) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private static ListNode getMiddleNode( ListNode head ) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}