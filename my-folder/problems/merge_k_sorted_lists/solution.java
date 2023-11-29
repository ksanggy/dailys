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
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. check for empty lists or null
        if(lists == null || lists.length == 0)
            return null;

        // 2. set priority queue to use to sort the nodes in asc order
        PriorityQueue<ListNode> priorityQueue =
                new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        // 3. set dummy and tail nodes
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        // 4. add the nodes to priority queue
        for(ListNode node : lists)
            if(node != null)
                priorityQueue.add(node);
        // 5. while queue is not empty, link the nodes in order from the queue
        while(!priorityQueue.isEmpty()) {
            tail.next = priorityQueue.poll();
            tail = tail.next;
            if(tail.next != null)
                priorityQueue.add(tail.next);
        }
        return dummy.next;
    }
}