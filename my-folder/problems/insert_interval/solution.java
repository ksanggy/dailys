class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        // base case
        if(intervals.length < 1) {
            mergedIntervals.add(newInterval);
            return mergedIntervals.toArray(new int[0][]);
        }
        // since the 'intervals' is sorted, we skip and add to 'mergedIntevals' until newInterval start
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }
        // we will merge the 'newInterval' until it is not overlapped
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // update start as min of two
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            // update end as max of two
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        mergedIntervals.add(newInterval);
        // add remaining
        while(i < intervals.length) {
            mergedIntervals.add(new int[] {intervals[i][0],intervals[i][1]});
            i++;
        }
        return mergedIntervals.toArray(new int[0][]);
    }
}