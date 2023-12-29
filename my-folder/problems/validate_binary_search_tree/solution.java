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
    public static boolean isValidBST(TreeNode root) {
        return validBSTRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validBSTRecursive( TreeNode node, long low, long high ) {
        // 0. base case -
        if(node == null)
            return true;
        // 1. check for validity
        if(!(node.val > low) || !(node.val < high ))
            return false;
        return validBSTRecursive(node.left, low, node.val) && validBSTRecursive(node.right, node.val, high);
    }
}