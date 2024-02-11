class Solution {
    public int jump(int[] nums) {
        int reachable = 0;
        int jumpCount = 0;
        int levelEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            reachable = Math.max(reachable, i + nums[i]);
            if(reachable >= nums.length - 1)
                return ++jumpCount;
            if(i == levelEnd) {
                jumpCount++;
                levelEnd = reachable;
            }
        }
        return 0;
    }
}