class Solution {
    public int removeDuplicates(int[] nums) {
        int uniqueIdx = 1;
        for (int current = 1; current < nums.length; current++) {
            if(nums[current - 1] != nums[current]) {
                nums[uniqueIdx] = nums[current];
                uniqueIdx++;
            }
        }
        return uniqueIdx;
    }
}