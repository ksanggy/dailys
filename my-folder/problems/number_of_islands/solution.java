class Solution {
    public int numIslands(char[][] grid) {
        int totalIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // loop through grid
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                // if and only if it is land we will do following logic
                if(grid[i][j] == '1') { // first land discovery
                    totalIslands++;
                    visitAdjacentDFS(grid, i, j);
                }
            }
        }
        return totalIslands;
    }

    private static void visitAdjacentDFS( char[][] grid, int x, int y ) {
        // invalid cell
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return;
        // if '0', it either means water or already visited
        if(grid[x][y] == '0')
            return;
        // mark the land cell to visited by marking it as water 0
        grid[x][y] = '0';
        // we visit all adjacent lands of the current cell
        visitAdjacentDFS(grid, x + 1, y);
        visitAdjacentDFS(grid, x - 1, y);
        visitAdjacentDFS(grid, x, y + 1);
        visitAdjacentDFS(grid, x, y - 1);
    }
}