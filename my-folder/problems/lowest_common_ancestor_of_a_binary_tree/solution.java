/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        List<TreeNode> pPathList = new ArrayList<>();
        List<TreeNode> qPathList = new ArrayList<>();
        generatePathList(root, p, pPathList);
        generatePathList(root, q, qPathList);
        int i;
        for (i = 0; i < pPathList.size() && i < qPathList.size(); i++) {
            if (pPathList.get(i).val != qPathList.get(i).val)
                break;
        }
        return pPathList.get(i - 1);
    }

    private static boolean generatePathList( TreeNode root, TreeNode target, List<TreeNode> pathList) {
        if(root == null) return false;
        pathList.add(root);
        if(root.val == target.val || generatePathList(root.left, target, pathList) || generatePathList(root.right, target, pathList)) {
            return true;
        }
        pathList.remove(pathList.size() - 1);
        return false;
    }
}