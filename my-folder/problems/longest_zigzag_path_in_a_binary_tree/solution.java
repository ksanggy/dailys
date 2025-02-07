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
    // Intuition:
    // dfs but with alternating flags to choose the next node path
    // length is defined as nodes visited - 1 (single node length = 0) thus
    // need to initially call on both left and right for first node
    // isLeft boolean will act as the swtich representing the curr node's position of tree (left or right)
    private int longestLength = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null)
            return 0;    
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return longestLength;
    }

    private void dfs(TreeNode node, boolean isLeft, int steps) {
        if(node == null)
            return;
        longestLength = Math.max(longestLength, steps); // update the longest lenth value
        
        // decide which direction next will be valid
        if(isLeft) { // curr node's position is left so next will be right
            dfs(node.left, true, 1);
            dfs(node.right, false, steps + 1);
        }
        else { // curr node's pos is right so next will be left
            dfs(node.left, true, steps + 1);
            dfs(node.right, false, 1);
        }
    }
}