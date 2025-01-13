class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int k = 1;
        int max = 0;
        int start = 0;
        int end;
        for(end = 0; end < nums.length; end++) {
            if(nums[end] == 0)
                k--;
            while(k < 0){
                if(nums[start] == 0) {
                    k++;
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}