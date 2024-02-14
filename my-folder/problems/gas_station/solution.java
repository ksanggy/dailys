class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int maxDiff = 0;
        int start = 0;
        int diff = 0;
        for (int i = gas.length - 1; i >= 0 ; i--) {
            if(diff - cost[i] + gas[i] >= maxDiff) {
                maxDiff = diff - cost[i] + gas[i];
                start = i;
            }
            diff += gas[i] - cost[i];
        }
        return diff < 0 ? -1 : start;
    }
}