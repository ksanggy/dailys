class Solution {
    public int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lowestPrice) lowestPrice = prices[i];
            int diff = prices[i] - lowestPrice;
            if(diff > profit) profit = diff;
        }
        return profit;
    }
}