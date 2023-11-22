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
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        // 1. set up init variable 'mergedList'
        ListNode mergedList = new ListNode(0);
        ListNode head = mergedList;
        // 2. loop through to compare each nodes values
        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                head.next = list2;
                list2 = list2.next;
            } else {
                head.next = list1;
                list1 = list1.next;
            }
            head = head.next;
        }

        // 3. check which list reached the end first
        if(list1 == null)
            head.next = list2;
        else
            head.next = list1;
        return mergedList.next; // since we have a dummy of val 0 at head
    }
}