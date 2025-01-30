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
    // intuition:
    // need to do this in O(1) SC & O(n) TC meaning in-place & in single pass
    // we can use two pointers to keep track of the prev nodes for both odd and even
    // connect the prev nodes to the next odd and even nodes until we are done with the input
    // -----------------
    // currOdd & currEven are the tails that iterate the list †ø do the job
    // currHead is kept as is because it will be used as the connecting point with the oddList tail (currOdd.next)
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;
        ListNode currOdd = head;
        ListNode evenHead = head.next;
        
        ListNode currEven = evenHead;
        while(currEven != null && currEven.next != null) {
            // set odd list
            currOdd.next = currEven.next;
            currOdd = currOdd.next;
            // set even list
            currEven.next = currOdd.next; // this moves the currEven pointer to the next even for iteration
            currEven = currEven.next;
        }
        // connect the two lists
        currOdd.next = evenHead;
        return head;
    }
}