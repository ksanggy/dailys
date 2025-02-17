/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfsDeleteNode(root, key);
    }

    private TreeNode dfsDeleteNode(TreeNode node, int key) {
        if(node == null)
            return null;
        
        if(node.val < key)
            node.right = dfsDeleteNode(node.right, key);
        else if(node.val > key)
            node.left = dfsDeleteNode(node.left, key);
        else {
            // case 1
            if(node.left == null && node.right == null)
                return null;
            // case 2
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;
            // case 3
            TreeNode inorderSuccessor = findInOrderSuccessor(node.right);
            node.val = inorderSuccessor.val;

            node.right = dfsDeleteNode(node.right, inorderSuccessor.val);
        }
        return node;
    }

    private TreeNode findInOrderSuccessor(TreeNode node) {
        while(node.left != null)
            node = node.left;
        return node;
    }
}