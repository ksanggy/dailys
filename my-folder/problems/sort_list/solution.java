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
    public static ListNode sortList(ListNode head) {
        // 0. base case - guard clause to pop call stack during recursive call on self
        if(head == null || head.next == null)
            return head;

        // 1. get the mid node
        ListNode leftHalf = head;
        ListNode rightHalf = getMiddleNode(head);

        // 2. sort the left && right half - this calls self method recursively until single node is left
        leftHalf = sortList(leftHalf);
        rightHalf = sortList(rightHalf);

        // 3. proceed to merge the nodes in ascending order
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while(leftHalf != null && rightHalf != null) {
            if(leftHalf.val < rightHalf.val) {
                result.next = leftHalf;
                leftHalf = leftHalf.next;
            } else {
                result.next = rightHalf;
                rightHalf = rightHalf.next;
            }
            result = result.next;
        }

        // 4. connect the remaining nodes
        if(rightHalf != null)
            result.next = rightHalf;
        else
            result.next = leftHalf;
        // 5. return the head of sorted merged list
        return dummy.next;
    }

    private static ListNode getMiddleNode( ListNode head ) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // disconnecting the node previous to middle node from the middle node to further process (divide and conquer)
        return slow;
    }
}