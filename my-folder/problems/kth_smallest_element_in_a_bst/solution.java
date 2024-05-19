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
    private int answer = -1;
    private int counter = 1;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraverse(root, k);
        return answer;
    }

    private void inorderTraverse( TreeNode root, int k ) {
        if (root == null) return;
        inorderTraverse(root.left, k);
        if(counter == k)
            answer = root.val;
        counter++;
        inorderTraverse(root.right, k);
    }
}