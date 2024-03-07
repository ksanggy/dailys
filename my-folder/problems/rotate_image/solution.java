class Solution {
    public static void rotate(int[][] matrix) {
        // base case
        if(matrix == null || matrix.length < 1)
            return;
        // variable to utilize to make rotations
        int rows = matrix.length;
        int cols = matrix[0].length;
        // transpose the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        reverse(matrix, rows);
    }

    private static void reverse( int[][] matrix, int rows ) {
        // loop again to reverse the transposed matrix
        for (int i = 0; i < rows; i++) {
            int left = 0;
            int right = rows - 1;

            // swap until while left < right pointer
            while(left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}