class RecentCounter {

    private Queue<Integer> recentCounter;

    public RecentCounter() {
        recentCounter = new LinkedList<>();
    }

    // requirement:
    // 1. return number of requests that has "HAPPENED" in the past 3K ms (inclusive of new request)
        // [t - 3K , t]
    // 2. GUARANTEED every call to ping uses strictly larger value of t than prev call (the catch)
    // Intuition:
        // using of queue data structure and actually removing the element whenever it is not in range
    public int ping(int t) {
        recentCounter.add(t);

        // we check the lower bound as requirement says upperbound the inclusive of the new t
        while(recentCounter.peek() < t - 3000)
            recentCounter.poll();
        
        return recentCounter.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */