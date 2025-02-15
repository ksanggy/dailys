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

    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return 0;
        
        Deque<TreeNode> deq = new ArrayDeque<>();
        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        int result = 0;
        deq.offer(root);

        while(!deq.isEmpty()) {
            int size = deq.size();
            int sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode curr = deq.poll();

                sum += curr.val;

                if(curr.left != null)
                    deq.offer(curr.left);
                if(curr.right != null)
                    deq.offer(curr.right);
            }

            if(sum > maxSum) {
                maxSum = sum;
                result = level;
            }
            
            level++;
        }
        return result;
    }
}