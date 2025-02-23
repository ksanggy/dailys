class Solution {
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adjList = new HashMap<>();

        for(int[] connection : connections) {
            adjList.computeIfAbsent(connection[0], d -> new ArrayList<List<Integer>>())
                    .add(Arrays.asList(connection[1], 1));
            adjList.computeIfAbsent(connection[1], d -> new ArrayList<List<Integer>>())
                    .add(Arrays.asList(connection[0], 0)); // undirected

        }
        dfs(0, -1, adjList);
        return count;
    }

    public void dfs(int node, int parent, Map<Integer, List<List<Integer>>> adjList) {
        if(!adjList.containsKey(node)) {
            return;
        }

        for(List<Integer> neighbours : adjList.get(node)) {
            int neighbour = neighbours.get(0);
            int direction = neighbours.get(1);

            if(neighbour != parent) {
                count += direction;
                dfs(neighbour, node, adjList);
            }
        }
    }
}