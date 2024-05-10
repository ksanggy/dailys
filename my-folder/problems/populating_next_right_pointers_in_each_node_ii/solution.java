/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node dummyHead = new Node(0);
        Node pre = dummyHead;
        Node temp = root;
        while (temp != null) {
            if (temp.left != null) {
                pre.next = temp.left;
                pre = pre.next;
            }
            if (temp.right != null) {
                pre.next = temp.right;
                pre = pre.next;
            }
            temp = temp.next;
            if (temp == null) {
                pre = dummyHead;
                temp = dummyHead.next;
                dummyHead.next = null;
            }
        }
        return root;
    }
}