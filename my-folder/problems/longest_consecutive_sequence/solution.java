class Solution {
    public int longestConsecutive(int[] nums) {
        // base case
        if(nums.length == 0)
            return 0;
        // variables
        Set<Integer> set = new HashSet<>();
        int longestConsecutive = 1;
        // add all num in nums to the set to keep track of numbers
        for(int num : nums)
            set.add(num);
        // loop through 'nums' to find for longest consecutive
        for(int num : nums) {
            // only start to find longest consecutive if num is the start of a sequence
            if(!set.contains(num - 1)) {
                int count = 1;
                while(set.contains(num + 1)) { // check if next number of the sequence exists in the set
                    num++;
                    count++;
                }
                longestConsecutive = Math.max(longestConsecutive, count);
            }
            if(longestConsecutive > (nums.length / 2))
                break;
        }
        return longestConsecutive;
    }
}