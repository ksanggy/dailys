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
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode middle = findMiddleNode(head);
        ListNode secondHalfHead = reverseLinkedList(middle);
        ListNode copySecondHalfHead = secondHalfHead;
        while(head != null && secondHalfHead != null) {
            if(head.val != secondHalfHead.val) break;
            head = head.next;
            secondHalfHead = secondHalfHead.next;
        }
        reverseLinkedList(copySecondHalfHead);
        return head == null || secondHalfHead == null;
    }

    private static ListNode reverseLinkedList( ListNode head ) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private static ListNode findMiddleNode( ListNode head ) {
        ListNode slow = head;
        ListNode fast = head;
        // find middle node
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}