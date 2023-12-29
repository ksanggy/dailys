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
   public static List<Integer> inorderTraversal( TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);
        return inOrderList;
    }
    private static void inOrder( TreeNode node, List<Integer> inOrderList ) {
        // 0. base case
        if(node == null)
            return;
        // 1. in-order traversal -> left , current node, right
        inOrder(node.left, inOrderList);
        inOrderList.add(node.val);
        inOrder(node.right, inOrderList);
    }
}