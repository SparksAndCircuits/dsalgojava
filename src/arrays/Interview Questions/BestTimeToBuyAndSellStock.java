//You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell the stock. If you cannot achieve any profit, return 0.
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currentProfit = prices[i] - minPrice;

            maxProfit = Math.max(maxProfit, currentProfit);

            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Test - Prices: [7,1,5,3,6,4]");
        System.out.println("Expected: 5 (buy at 1, sell at 6)");
        System.out.println(maxProfit(prices));
    }
}
