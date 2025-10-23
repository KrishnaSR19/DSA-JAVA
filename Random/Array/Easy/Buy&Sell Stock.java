public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update the minimum price so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate the potential profit
            int profit = price - minPrice;
            // Update the maximum profit found so far
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}