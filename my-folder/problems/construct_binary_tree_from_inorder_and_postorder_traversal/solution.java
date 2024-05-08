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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        return build(inorderMap, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode build( Map<Integer, Integer> inorderMap, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd ) {
        if (inorderStart > inorderEnd)
            return null;
        int value = postorder[postorderEnd];
        TreeNode root = new TreeNode(value);
        int inorderMid = inorderMap.get(value);
        root.left = build(inorderMap, inorderStart, inorderMid - 1, postorder, postorderStart, postorderStart + inorderMid - inorderStart - 1);
        root.right = build(inorderMap, inorderMid + 1, inorderEnd, postorder, postorderEnd - inorderEnd + inorderMid, postorderEnd - 1);
        return root;
    }
}