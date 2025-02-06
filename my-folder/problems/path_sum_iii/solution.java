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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Initialize with a prefix sum of 0 occurring once
        return pathSumRecursive(root, targetSum, 0, prefixSumCount);
    }

    private int pathSumRecursive(TreeNode node, int targetSum, long currentPathSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }

        currentPathSum += node.val;

        int count = prefixSumCount.getOrDefault(currentPathSum - targetSum, 0); // Check for paths ending here

        prefixSumCount.put(currentPathSum, prefixSumCount.getOrDefault(currentPathSum, 0) + 1); // Update prefix sum count

        count += pathSumRecursive(node.left, targetSum, currentPathSum, prefixSumCount);
        count += pathSumRecursive(node.right, targetSum, currentPathSum, prefixSumCount);

        prefixSumCount.put(currentPathSum, prefixSumCount.get(currentPathSum) - 1); // Backtrack: remove current path sum

        return count;
    }
}