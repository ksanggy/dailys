class Solution {
    public int largestAltitude(int[] gain) {
        int[] trip = new int[gain.length + 1];
        trip[0] = 0; // trip starts at altitude 0
        int maxAlt = 0;

        for(int i = 1; i <= gain.length; i++) {
            trip[i] = trip[i - 1] + gain[i - 1];
            maxAlt = Math.max(trip[i], maxAlt);
        }
        return maxAlt;
    }
}