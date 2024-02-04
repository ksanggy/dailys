class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int vote = 1;
        for (int i = 1; i < nums.length; i++) {
            if(candidate == nums[i])
                vote++;
            else {
                vote--;
                // if 'vote' is 0, we switch the candidate
                if(vote == 0) {
                    candidate = nums[i];
                    vote = 1; // init value
                }
            }
        }
        // check if it is majority
        int count = 0;
        for (int num : nums) {
            if(num == candidate)
                count++;
        }
        // return 'candidate' as answer if 'count' is gt nums.length / 2 as this was the condition for being majority
        return (nums.length / 2) <= count ? candidate : -1;
    }
}