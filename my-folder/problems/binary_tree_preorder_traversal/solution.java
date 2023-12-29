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
    public static List<Integer> preorderTraversal( TreeNode root) {
        List<Integer> currPaths = new ArrayList<>();
        preorder(root, currPaths);
        return currPaths;
    }

    private static void preorder( TreeNode node, List<Integer> currPaths ) {
        Stack<TreeNode> stack = new Stack<>();
        // 0. base case
        if(node == null)
            return;
        // 1. traverse iteratively
        TreeNode curr = node;
        stack.push(curr);
        while(!stack.isEmpty()) {
            curr = stack.pop();
            currPaths.add(curr.val);
            // deal with right node first since stack is LIFO
            if(curr.right != null)
                stack.push(curr.right);
            if(curr.left != null)
                stack.push(curr.left);
        }
    }
}