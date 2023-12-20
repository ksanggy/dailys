class Solution {
    public int maxArea(int[] height) {
        // 0. base case
        if(height.length == 0)
            return 0;
        // 1. setup pointers and variable maxArea to hold the maximum area combination
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        // 2. loop through while let < right to find the maximum amount of water container can hold
        while(left < right) {
            int containerHeight = Math.min(height[left], height[right]);
            int xAxisDistance = right - left;
            maxArea = Math.max(maxArea, containerHeight * xAxisDistance);

            // if left pointer element is less than or equal to right element then increment left
            if(height[left] <= height[right])
                left++;
            // else increment right
            else
                right--;
        }
        return maxArea;
    }
}