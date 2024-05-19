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
    private int prev = Integer.MAX_VALUE;
    private int min = Integer.MAX_VALUE;
    public int getMinimumDifference( TreeNode root) {
        if(root == null) return 0;
        findMin(root);
        return min;
    }

    private void findMin( TreeNode root ) {
        if(root == null) return;
        getMinimumDifference(root.left);
        min = Math.min(min, Math.abs(prev - root.val));
        prev = root.val;
        getMinimumDifference(root.right);
    }
}