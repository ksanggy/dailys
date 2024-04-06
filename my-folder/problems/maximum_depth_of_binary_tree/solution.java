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
    public int maxDepth(TreeNode root) {
        int minimumTreeDepth = 0;
        // 0. base case
        if(root == null)
            return 0;
        // 1. setup queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 2. process queues to find the minimum depth
        while(!queue.isEmpty()) {
            minimumTreeDepth++; // increment min tree depth by 1 -> this is the current tree level
            int currLevelSize = queue.size();
            for(int i = 0; i < currLevelSize; i++) {
                TreeNode currNode = queue.poll();
                // if there are no children node, return current minimumTreeDepth value
//                if(currNode.left == null && currNode.right == null)
//                    return minimumTreeDepth;
                if(currNode.left != null)
                    queue.offer(currNode.left);
                if(currNode.right != null)
                    queue.offer(currNode.right);
            }
        }
        return minimumTreeDepth;
    }
}