/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Node,Node> nodeList = new HashMap<>();
        return dfs(node,nodeList);
    }
    
    public Node dfs(Node node, Map<Node,Node> nodeList){
        if(nodeList.get(node)!= null){
            return nodeList.get(node);
        }
        Node newNode = new Node(node.val);
        nodeList.put(node, newNode);
        for(Node n : node.neighbors){
            newNode.neighbors.add(dfs(n, nodeList));
        }
        return nodeList.get(node);
    }
}