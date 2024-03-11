class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        // base case
        if(nums.length < 1)
            return result;
        // setup variable
        for (int start = 0; start < nums.length; start++) {
            int end = start;
            // if element value + 1 is equal to the next element, then it is continuous so increment end pointer
            while(end < nums.length - 1 && nums[end + 1] == nums[end] + 1)
                end++;

            if(end == start)
                result.add(Integer.toString(nums[start]));
            else
                result.add(nums[start] + "->" + nums[end]);
            start = end;
        }
        return result;
    }
}