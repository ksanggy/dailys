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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // base case 
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode temp = new ListNode(-1);
        ListNode result = temp;

        while(list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if(val1 < val2) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1 == null)
            temp.next = list2;
        else
            temp.next = list1;
        return result.next;
    }
}