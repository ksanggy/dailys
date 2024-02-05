class Solution {
    public int maxProfit(int[] prices) {
        // use Two pointers approach
        int left = 0; // 'left' pointer will track the smallest price
        int maxProfit = 0; // current max profit variable
        for (int right = 1; right < prices.length; right++) {
            // right pointer tracks the current price
            if(prices[right] > prices[left]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            }
            else
                left = right;
        }
        return maxProfit;
    }
}