public class StockTrading {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            // If the current price is higher than the previous day's price, we have a profit opportunity:
            if (prices[i] > prices[i - 1]) {
                // Accumulate the profit by subtracting yesterday's price from today's price.
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        // At the end, maxProfit holds the total profit accrued through all transactions.
        return maxProfit;
    }
}