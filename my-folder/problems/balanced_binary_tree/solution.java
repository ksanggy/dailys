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
    public boolean isBalanced(TreeNode root) {
        return getHeightDFS(root) != -1;
    }

    private int getHeightDFS( TreeNode current ) {
        // 0. base case (if current node is null, mathematical value is -1 not 0 as 0 is considered not null)
        if(current == null)
            return 0;
        // 1. get height of both left and right tree
        int left = getHeightDFS(current.left);
        int right = getHeightDFS(current.right);
        // 3. if left - right > 1 then it isn't balanced
        if(left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        return 1 + Math.max(left, right); // return the height
    }
}