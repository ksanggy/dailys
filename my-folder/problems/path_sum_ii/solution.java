/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        // base case
        if (root == null)
            return result;
        List<Integer> path = new ArrayList<>();
        findPathDFS(root, targetSum, path, result);
        return result;
    }

    private static void findPathDFS(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result) {
        // base case
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            result.add(new ArrayList<>(path));
        } else {
            findPathDFS(root.left, targetSum - root.val, path, result);
            findPathDFS(root.right, targetSum - root.val, path, result);
        }

        path.remove(path.size() - 1);
    }
}