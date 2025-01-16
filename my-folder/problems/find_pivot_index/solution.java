class Solution {
    // intution:
    // solve both prefix sum from left and right
    public int pivotIndex(int[] nums) {
        // do the left prefix sum
        int[] leftPrefixSum = new int[nums.length];
        for(int i = 1; i < nums.length; i++)
            leftPrefixSum[i] = leftPrefixSum[i - 1] + nums[i - 1];

        int[] rightPrefixSum = new int[nums.length];
        for(int i = nums.length - 2; i >= 0; i--) {
            rightPrefixSum[i] = rightPrefixSum[i+1] + nums[i + 1];
        }
        for(int i = 0; i < nums.length; i++)
            if(leftPrefixSum[i] == rightPrefixSum[i])
                return i;
        return -1;
    }
}