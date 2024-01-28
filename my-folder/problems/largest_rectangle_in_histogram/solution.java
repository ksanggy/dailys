class Solution {
    public int largestRectangleArea(int[] heights) {
        // keep a monotonically increasing stack to use to calculate area of rectangle
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int prevHeight = heights[stack.pop()]; // the height of the prev bar in the stack
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, prevHeight * width);
            }
            stack.push(i);
        }
        // process the remaining bars left in the stack if any
        while(!stack.isEmpty()) {
            int prevHeight = heights[stack.pop()]; // the height of the prev bar in the stack
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            max = Math.max(max, prevHeight * width);
        }
        return max;
    }
}