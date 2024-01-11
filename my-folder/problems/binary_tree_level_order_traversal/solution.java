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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // base case
        if(root == null)
            return result;

        // instantiate queue to hold current level node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // work through all nodes until queue is empty
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelList.add(current.val);
                // if left node is not empty add to queue for next procedure
                if(current.left != null)
                    queue.offer(current.left);
                // if right node is not empty add to queue for next procedure
                if(current.right != null)
                    queue.offer(current.right);
            }
            result.add(levelList);
        }
        return result;
    }
}