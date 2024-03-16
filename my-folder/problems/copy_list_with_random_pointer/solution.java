/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> deepCopy = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            deepCopy.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            deepCopy.get(curr).next = deepCopy.get(curr.next);
            deepCopy.get(curr).random = deepCopy.get(curr.random);
            curr = curr.next;
        }

        return deepCopy.get(head);
    }
}