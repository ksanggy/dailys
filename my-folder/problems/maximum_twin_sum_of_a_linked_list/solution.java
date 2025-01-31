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
    // for faster lookup we can hold the other half of the linkedlist in a hashmap (key = index, value = node.val)
    // we can do this because the definition of twin of ith node is n-1 - i if 0<= i <= (n/2) - 1
    public int pairSum(ListNode head) {
        HashMap<Integer, Integer> lookupTable = new HashMap<>();
        int idx = 0;
        while(head != null) {
            lookupTable.put(idx, head.val);
            head = head.next;
            idx++;
        }
        int middleIdx = (idx + 1) / 2;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= middleIdx; i++ ) {
            int twinIndex = idx - 1 - i;
            int twinSum = lookupTable.get(i) + lookupTable.get(twinIndex);
            max = Math.max(max, twinSum);
        }

        return max;
    }
}