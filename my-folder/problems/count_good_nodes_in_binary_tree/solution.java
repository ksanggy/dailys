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
    private int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null)
            return 0;

        dfs(root, Integer.MIN_VALUE);    
        return count;
    }

    private void dfs(TreeNode node, int max) {
        if(node == null)
            return;

        if(node.val >= max) {
            count++;
            max = Math.max(max, node.val);
        }

        if(node.left != null)
            dfs(node.left, max);
        if(node.right != null)
            dfs(node.right, max);
    }
}