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
    private List<Integer> rightNodes = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return rightNodes;
        dfs(root, 0);
        return rightNodes;
    }

    private void dfs(TreeNode node, int level) {
        if(level == rightNodes.size()) 
            rightNodes.add(node.val);
        
        if(node.right != null)
            dfs(node.right, level + 1);
        if(node.left != null)
            dfs(node.left, level + 1);
        
    }
}