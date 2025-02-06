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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        dfs(root, targetSum, currPath, paths);
        return paths;
    }

    private void dfs(TreeNode node, int target, List<Integer> currPath, List<List<Integer>> paths) {
        if(node == null)
            return;
        target -= node.val;
        currPath.add(node.val);

        if(node.left == null && node.right == null && target == 0)
            paths.add(new ArrayList(currPath));

        if(node.left != null)
            dfs(node.left, target, currPath, paths);
        if(node.right != null)
            dfs(node.right, target, currPath, paths);

        currPath.remove(currPath.size() - 1);
    }
}