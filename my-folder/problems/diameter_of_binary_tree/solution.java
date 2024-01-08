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
    private int maxDiameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameterDFS(root);
        return maxDiameter;
    }

    private int findDiameterDFS( TreeNode root ) {
        // base case
        if(root == null)
            return -1; // a root that is not null has 0 height. null is considered -1;
        // traverse binary tree to get height of left and right
        int left = findDiameterDFS(root.left);
        int right = findDiameterDFS(root.right);
        // calculate diameter and update the value
        maxDiameter = Math.max(maxDiameter, 2 + left + right); // adding 2 because left and right edges from current node.
        return 1 + Math.max(left, right);
    }
}