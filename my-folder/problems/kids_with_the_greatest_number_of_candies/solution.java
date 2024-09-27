class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> results = new ArrayList<>();
        int greatest = 0;
        for(int candy : candies) {
            greatest = Math.max(greatest, candy);
        }

        // check if i-th child will have the greatest number of candies when given extra candies.
        for(int i = 0; i < candies.length; i++) {
            int newCandyCount = candies[i] + extraCandies;
            results.add(newCandyCount >= greatest);
        }

        return results;
    }
}