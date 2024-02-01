class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int profit = 0;
        while(right < prices.length) {
            if(prices[left] < prices[right])
                profit = Math.max(profit, prices[right] - prices[left]);
            else
                left = right;
            right++;
        }
        return profit;
    }
}