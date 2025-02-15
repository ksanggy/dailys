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
    // Intuition:
    // using bfs we can get all the nodes by level.
    // then we will populate the node's next field to the next in queue
    public Node connect(Node root) {
        if(root == null)
            return root;
        ArrayDeque<Node> deq = new ArrayDeque<>();
        deq.offer(root);
        
        while(!deq.isEmpty()) {
            int levelSize = deq.size();
            for(int i = 0; i < levelSize; i++) {
                Node curr = deq.pop();
                
                if(i < levelSize - 1)
                    curr.next = deq.peek();
                
                if(curr.left != null)
                    deq.offer(curr.left);
                if(curr.right != null)
                    deq.offer(curr.right);
            }
        }
        return root;
    }
}