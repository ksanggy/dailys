class Solution {
    public int longestSubarray(int[] nums) {
        int k = 1;
        int start = 0;
        int end = 0;
        int max = 0;
        while(end < nums.length) {
            if(nums[end] == 0)
                k--;
            while(k < 0) {
                if(nums[start] == 0)
                    k++;
                start++;
            }
            max = Math.max(max, end - start);
            end++;
        }
        return max;
    }
}