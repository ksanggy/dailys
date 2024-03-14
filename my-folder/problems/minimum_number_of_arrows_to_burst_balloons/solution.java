class Solution {
    public int findMinArrowShots(int[][] points) {
        // base case
        if(points.length < 1)
            return 0;
        // sort the intervals by their Xend in ascending order
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        // setup arrow counter
        int arrows = 1;
        int currEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int nextStart = points[i][0];
            int nextEnd = points[i][1];

            if(currEnd >= nextStart)
                continue;
            arrows++;
            currEnd = nextEnd;
        }
        return arrows;
    }
}