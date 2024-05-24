class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        // check top and bottom most boarder for O
        for(int i = 0; i < cols; i++) {
            if(board[0][i] == 'O') checkSurrounding(board, 0, i);
            if(board[rows - 1][i] == 'O') checkSurrounding(board, rows - 1, i);
        }
        // check left and right most boarder for O
        for(int i = 0; i < rows; i++) {
            if(board[i][0] == 'O') checkSurrounding(board, i, 0);
            if(board[i][cols - 1] == 'O') checkSurrounding(board, i, cols - 1);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }

    private static void checkSurrounding( char[][] board, int i, int j ) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = 'T';
        checkSurrounding(board, i + 1, j);
        checkSurrounding(board, i - 1, j);
        checkSurrounding(board, i, j + 1);
        checkSurrounding(board, i, j - 1);
    }
}