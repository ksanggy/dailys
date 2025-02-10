/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = findLca(root, p, q);

        if(result == p)
            return dfs(p, q) ? p : null;
        else if(result == q)
            return dfs(q, p) ? q : null;

        return result;
    }

    private TreeNode findLca(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null)
            return null;

        if(node == p || node == q)
            return node;

        TreeNode left = findLca(node.left, p, q);
        TreeNode right = findLca(node.right, p, q);

        if(left != null && right != null)
            return node;

        return left != null ? left : right;
    }

    private boolean dfs(TreeNode node, TreeNode targetNode) {
        if(node == targetNode)
            return true;
        if(node == null)
            return false;
        return dfs(node.left, targetNode) || dfs(node.right, targetNode);
    }
}