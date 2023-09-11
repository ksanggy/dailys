class Solution {
    public int numIdenticalPairs(int[] nums) {
        int pairCount = 0;
        int low = 0;
        int max = nums.length;

        while(low < max) {
            int high = low + 1;
            while(high < max) {
                if(nums[low] == nums[high]) {
                    pairCount++;
                }
                high++;
            }
            low++;
        }

        return pairCount;
    }
}