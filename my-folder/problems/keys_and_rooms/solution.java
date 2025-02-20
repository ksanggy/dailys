class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);

        while(!stack.isEmpty()) {
            int index = stack.pop();
            List<Integer> neighbours = rooms.get(index);

            if(!visited[index])
                visited[index] = true;
            
            for(int neighbour : neighbours) {
                if(!visited[neighbour])
                    stack.push(neighbour);
            }
        }

        for(boolean visit : visited)
            if(!visit)
                return false;
        return true;
    }
}