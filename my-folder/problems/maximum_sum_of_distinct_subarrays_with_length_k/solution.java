class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long answer = 0;
        int start = 0;
        int end;
        long sum = 0;
        
        Map<Integer, Integer> subarray = new HashMap<>();

        for(end = 0; end < nums.length; end++) {
            int lastOccurrence = subarray.getOrDefault(nums[end], -1);

            while(start <= lastOccurrence || end - start + 1 > k) {
                sum -= nums[start];
                start++;
            }

            subarray.put(nums[end], end);
            sum += nums[end];

            if(end - start + 1 == k)
                answer = Math.max(answer, sum);
        }    
        return answer;
    }
}