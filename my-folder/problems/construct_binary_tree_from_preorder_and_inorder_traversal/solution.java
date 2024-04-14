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
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1)
            return null;
        for(int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        return build(preorder, 0, 0, inorder.length - 1);
    }

    private TreeNode build( int[] preorder, int preOrderIndex, int inorderLow, int inorderHigh ) {
        if(preOrderIndex > preorder.length - 1 || inorderLow > inorderHigh)
            return null;

        int currentValue = preorder[preOrderIndex];
        TreeNode root = new TreeNode(currentValue);
        int mid = inorderMap.get(currentValue);

        root.left = build(preorder, preOrderIndex + 1, inorderLow, mid - 1);
        root.right = build(preorder, preOrderIndex + (mid - inorderLow) + 1, mid + 1, inorderHigh);
        
        return root;
    }
}