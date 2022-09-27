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
        
        ListNode headNode = new ListNode(0);
        ListNode headNext = headNode;

        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                headNext.next = list2;
                list2 = list2.next;
            }else {
                headNext.next = list1;
                list1 = list1.next;
            }
            headNext = headNext.next;
        }

        if(list1 == null){
            headNext.next = list2;
        }
        if(list2 == null){
            headNext.next = list1;
        }
        return headNode.next;
    }
}