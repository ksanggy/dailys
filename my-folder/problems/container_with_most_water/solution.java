class Solution {
    // init intuition :
    // if we were to just solve by the flow of what is given, then TC = quadratic
    // two pointer to compare and calculate area to find max container will be more efficient.
    // it boils down to how or when to move either of the two pointers.
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1; // start from the other end to maximize efficiency as index plays a role in calculating area.
        int maxArea = 0; // max area to return
        while(left < right) {
            int currHeight = Math.min(height[left], height[right]);
            int area = Math.abs((left - right) * currHeight);
            maxArea = Math.max(maxArea, area);

            // we move the pointer that is of a smaller value
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}