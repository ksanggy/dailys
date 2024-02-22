class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // find minimum subarray length that the sum >= target
        int start = 0;
        int end = 0;
        int currSum = 0;
        int subarraySize = Integer.MAX_VALUE;
        while(end < nums.length) {
            currSum += nums[end];
            while(currSum >= target) {
                subarraySize = Math.min(subarraySize, end - start + 1);
                currSum -= nums[start];
                start++;
            }
            end++;
        }
        return subarraySize == Integer.MAX_VALUE ? 0 : subarraySize;
    }
}