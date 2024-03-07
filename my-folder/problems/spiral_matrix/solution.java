class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // base case
        if(matrix == null || matrix.length < 1)
            return result;
        // set up variables
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = cols - 1;
        int top = 0;
        int bottom = rows - 1;

        // looping to visit every element in spiral
        while(left <= right && top <= bottom) {
            // top + right direction
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // move inwards to the bottom
            // right + bottom direction
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // move inwards to the left

            if(top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}