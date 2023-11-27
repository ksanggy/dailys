/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. find the length
        int lengthOfListA = getLength(headA);
        int lengthOfListB = getLength(headB);
        // 2. get difference, offset
        int offset = Math.abs(lengthOfListB - lengthOfListA);
        ListNode currA = headA;
        ListNode currB = headB;
        if(lengthOfListA > lengthOfListB) {
            currA = applyOffsetToList(offset, headA);
        } else {
            currB = applyOffsetToList(offset, headB);
        }

        // 3. loop
        while(currA != null && currB != null) {
            if(currA == currB)
                return currA;
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }

    public ListNode applyOffsetToList(int offset, ListNode head) {
        for(int i = 0; i < offset; i++) {
            head = head.next;
        }
        return head;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}