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
    public ListNode swapNodes(ListNode head, int k) {
                if(head == null)
            return null;
        // pointers of the first and second half (the nodes that need swapping)
        ListNode first = null;
        ListNode second = head;
        // fast pointer to use later to find node that is k nodes from the end
        ListNode fast = head;

        // move the fast pointer by k - this sets the pointer at kth node
        for (int i = 1; i < k; i++)
            fast = fast.next;

        first = fast; // kth node from head
        
        while(fast.next != null) {
            second = second.next;
            fast = fast.next;
        }

        int temp = second.val;
        second.val = first.val;
        first.val = temp;
        return head;
    }
}