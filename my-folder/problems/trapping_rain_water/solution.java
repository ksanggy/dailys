class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = height[0];
        int trappedWater = 0;

        for (int i = 0; i < height.length; i++) {
            left[i] = Math.max(height[i], max);
            max = left[i];
        }

        max = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = Math.max(height[i], max);
            max = right[i];
        }

        for (int i = 0; i < height.length; i++) {
            trappedWater += Math.min(left[i], right[i]) - height[i]; // difference of height value will be the value of trapped water
        }
        return trappedWater;
    }
}