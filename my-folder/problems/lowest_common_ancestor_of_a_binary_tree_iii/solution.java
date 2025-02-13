/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    private Map<Node, Integer> nodeMap = new HashMap<>();
    private Node answer = null;
    public Node lowestCommonAncestor(Node p, Node q) {
        dfs(p, q);
        return answer;
    }

    private void dfs(Node p, Node q) {
        if(p == null && q == null)
            return;
        
        if(p == q) {
            answer = p;
            return;
        }
        
        if(p != null) {
            nodeMap.put(p, nodeMap.getOrDefault(p, 0) + 1);
            if(nodeMap.get(p).intValue() > 1) {
                answer = p;
                return;
            }
            p = p.parent;
        }
        if(q != null) {
            nodeMap.put(q, nodeMap.getOrDefault(q, 0) + 1);
            if(nodeMap.get(q).intValue() > 1) {
               answer = q;
                return;
            }
            q = q.parent;
        }
        dfs(p, q);
    }
}