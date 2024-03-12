class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        // sort the intervals by their first index
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // variables to keep track of current intervals
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];
        int index = 0;
        // loop through the interval
        while( index < intervals.length - 1) {
            int nextStart = intervals[index + 1][0];
            int nextEnd = intervals[index + 1][1];
            if(nextStart <= currEnd) { // is overlapping
                currEnd = Math.max(currEnd, nextEnd);
            }
            else { // not overlap so add to result
                result.add(new int[] {currStart, currEnd});
                currStart = nextStart;
                currEnd = nextEnd;
            }
            index++;
        }
        // add the last element that has not been processed in the above loop
        result.add(new int[] {currStart, currEnd});
        return result.toArray(new int[result.size()][]);
    }
}