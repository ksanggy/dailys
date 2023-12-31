/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public static List<Integer> postorder( Node root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private static void postOrder(Node node, List<Integer> list) {
        // 0. base case
        if(node == null)
            return;
        // 1. traverse children nodes
        for(Node child : node.children)
            postOrder(child, list);
        // 2. add to list
        list.add(node.val);
    }

}