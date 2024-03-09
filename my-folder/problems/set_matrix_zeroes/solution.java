class Solution {
    public static void setZeroes(int[][] matrix) {
        // base case
        if(matrix.length < 1)
            return;

        // set up two arrays of a boolean type to keep track of row/col that is a zero
        boolean[] isRowZero = new boolean[matrix.length];
        boolean[] isColZero = new boolean[matrix[0].length];

        // loop through (double for loop) to get through ALL cells
        // when value 0 is found, add the row,column value to the list to track
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    isRowZero[i] = true;
                    isColZero[j] = true;
                }
            }
        }

        // go through cells that are of value 0, and proceed to replace all rows and columns' values to zero
        replaceToZero(isRowZero, isColZero, matrix);
    }

    private static void replaceToZero( boolean[] isRowZero, boolean[] isColZero, int[][] matrix ) {
        // replace cell value to 0 IF either current row or column contains a zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(isRowZero[i] || isColZero[j])
                    matrix[i][j] = 0;
            }
        }
    }
}