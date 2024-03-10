class Solution {
    public void gameOfLife(int[][] board) {
        // base case
        if(board.length < 1 || board[0].length < 1)
            return;

        // set up variables
        int rows = board.length;
        int cols = board[0].length;

        // first phase, the process to check for next stage state
        // 2 - will be dead next stage, -1 - will be alive next stage
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // count for living cells
                int liveCellCount = 0;
                for (int k = row - 1; k <= row + 1; k++) {
                    for (int l = col - 1; l <= col + 1; l++) {
                        if(k == row && l == col)
                            continue;
                        if(k >= 0 && k < rows && l >= 0 && l < cols && board[k][l] > 0)
                            liveCellCount++;
                    }
                }

                // apply the rules provided by the problem
                // the next state will be dead if liveCellCount < 2 or > 3,
                // and the current cell is alive
                if(board[row][col] == 1 && (liveCellCount < 2 || liveCellCount > 3))
                    board[row][col] = 2;
                // the next state will be alive if liveCellCount == 3, and the current cell is dead
                if(board[row][col] == 0 && liveCellCount == 3)
                    board[row][col] = -1;
            }
        }
        
        // loop through the board again to apply the next state change
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cell = board[i][j];
                if(cell == 2)
                    board[i][j] = 0;
                else if(cell == -1)
                    board[i][j] = 1;
            }
        }
    }
}