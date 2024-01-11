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
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null || isIdenticalDFS(root, subRoot))
            return true;
        if(root == null)
            return false;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isIdenticalDFS( TreeNode current, TreeNode subRoot ) {
        // base case
        if(current == null && subRoot == null)
            return true;

        if(current == null || subRoot == null || current.val != subRoot.val)
            return false;
        return isIdenticalDFS(current.left, subRoot.left) && isIdenticalDFS(current.right, subRoot.right);
    }
}