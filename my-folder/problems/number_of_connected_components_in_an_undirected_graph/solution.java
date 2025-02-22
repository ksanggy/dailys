class Solution {
    //     0   1   2   3   4
    // 0 [ 0 , 1 , 0 , 0 , 0 ]
    // 1 [ 0 , 0 , 0 , 0 , 0 ]
    // 2 [ 0 , 0 , 0 , 0 , 0 ]
    // 3 [ 0 , 0 , 0 , 0 , 0 ]
    // 4 [ 0 , 0 , 0 , 0 , 0 ]
    public int countComponents(int n, int[][] edges) {
        int provinces = 0;
        boolean[] visited = new boolean[n];

        List<Integer>[] adjList = new ArrayList[n]; 
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(adjList, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(List<Integer>[] adjList, boolean[] visited, int i) {
        visited[i] = true;
        for(int j = 0; j < adjList[i].size(); j++) {
            if(!visited[adjList[i].get(j)]) {
                dfs(adjList, visited, adjList[i].get(j));
            }
        }
    }
}