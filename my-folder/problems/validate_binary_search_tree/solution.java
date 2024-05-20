/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     long val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(long val) { this.val = val; }
 *     TreeNode(long val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode prev;
    private boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        validBSTHelper(root);
        return isValid;
    }

    private void validBSTHelper( TreeNode node ) {
        if (node == null)
            return;
        validBSTHelper(node.left);
        if(prev != null && node.val <= prev.val) {
            isValid = false;
            return;
        }
        prev = node;
        validBSTHelper(node.right);
    }
}