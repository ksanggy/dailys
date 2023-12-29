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
    public static List<Integer> postorderTraversal( TreeNode root) {
        List<Integer> currPaths = new ArrayList<>();
        postOrder(root, currPaths);
        return currPaths;
    }

    private static void postOrder( TreeNode node, List<Integer> currPaths ) {
        Stack<TreeNode> stack = new Stack<>();
        // 0. base case
        if(node == null)
            return;
        TreeNode curr = node;
        stack.push(curr);
        while(!stack.isEmpty()) {
            curr = stack.pop();
            if(curr.left != null)
                stack.push(curr.left);
            if(curr.right != null)
                stack.push(curr.right);
            currPaths.add(0, curr.val);
        }
    }
}