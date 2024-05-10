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
    public void flatten(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        dfs(root, queue);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(queue.peek() != null)
                node.right = queue.peek();
            node.left = null;
        }
    }

    private static void dfs( TreeNode root, Queue<TreeNode> queue ) {
        if(root == null) return;
        queue.add(root);
        dfs(root.left, queue);
        dfs(root.right, queue);
    }
}