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
    public boolean isPalindrome(ListNode head) {
        // null is considered a palindrome
        if(head == null || head.next == null)
            return true;

        // looking for the middle node of the linkedlist to use later for reversing second half of the list
        ListNode tempHead = head;
        ListNode midNode = tempHead;
        ListNode fast = tempHead.next.next;
        while(fast != null && fast.next != null) {
                midNode = midNode.next;
                fast = fast.next.next;
        }

        // reverse the second half of the list
        ListNode prev = null;
        ListNode curr = midNode.next;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // check if palindrome by comparing the first half value to second half value
        ListNode p1 = head;
        ListNode p2 = prev;
        while(p2 != null) {
            if(p2.val != p1.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}