class Solution {
    public boolean isValidSudoku(char[][] board) {
        // set up variables (hashsets) to hold rows, columns, and 3x3 square sets of numbers that are unique
        Set<Character> rowSet = null;
        Set<Character> colSet = null;

        for(int i = 0; i < board.length; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for(int j = 0; j < board[i].length; j++) {
                char rChar = board[i][j]; // row characters at current i index
                char cChar = board[j][i]; // column characters at current i index

                if(rChar != '.') {
                    if(rowSet.contains(rChar))
                        return false;
                    else
                        rowSet.add(rChar);
                }
                if(cChar != '.') {
                    if(colSet.contains(cChar))
                        return false;
                    else
                        colSet.add(cChar);
                }
            }
        }

        // check the 3x3 block - only 1-9 in 3x3 block
        // we increment the loop by 3 for both rows and cols
        for(int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                if(!checkBlock(i, j, board))
                    return false;
            }
        }
        // passed all tests so valid sudoku
        return true;
    }

    private static boolean checkBlock( int i, int j, char[][] board ) {
        Set<Character> blockCharacters = new HashSet<>();
        for(int k = i; k < i + 3; k++) { // we are incrementing by 3 because blocks are 3 x 3, so we check for the next 3 indices for both row and col
            for(int l = j; l < j + 3; l++) { // same here
                char currChar = board[k][l];
                if(currChar == '.') // skip any cell that is '.', this just means the cell is empty
                    continue;
                if(blockCharacters.contains(currChar)) // since it already exists in the set, not valid sudoku
                    return false;
                blockCharacters.add(currChar); // add to the set to track
            }
        }
        // passed all tests thus it is valid sudoku
        return true;
    }
}