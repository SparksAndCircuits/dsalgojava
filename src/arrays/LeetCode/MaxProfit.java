/* You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannont achieve any profit, return 0. */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int MaxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > MaxProfit) {
                MaxProfit = price - minPrice;
            }
        }
        return MaxProfit;
    }

    public static void runtTest(String testName, int[] input, int expected, MaxProfit tester) {
        System.out.println("\n" + testName);
        System.out.print("Input [");

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);

            if (i < input.length - 1) {
                System.out.print(",");
            }
        }

        System.out.print("]");

        int result = tester.maxProfit(input);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);

        boolean passed = (result == expected);
        System.out.println("Result: " + (passed ? "PASS " : "FAIL"));

        if (!passed) {
            System.out.println("--- Test has failed ---");
        }
    }

    public static void main(String[] args) {
        MaxProfit tester = new MaxProfit();
        System.out.println("--- MaxProfit Test suite ---");

        // Test case 1: Basic case -buy low, sell high
        runtTest("Test 1: Basic buy low, sell high", new int[] { 7, 1, 5, 26, 4 }, 5, tester);

        // Test Case 2: Prices always decreasing (no profit possible)
        runtTest("Test 2: Always Decreasing", new int[] { 7, 6, 4, 3, 1 }, 0, tester);

        // Test Case 3: Prices always increasing (buy first, sell last)
        runtTest("Test 3: Always Increasign", new int[] { 1, 2, 3, 4, 5 }, 4, tester);

        // Test Case 4: Single element (no transaction possible)
        runtTest("Test 4: Single element", new int[] { 48 }, 0, tester);

        // Test Case 5: Two elements - profit possible
        runtTest("Test 5: Two Elements - Profit", new int[] { 1, 5 }, 4, tester);

        // Test Case 6: Two elements - no profit
        runtTest("Test 6: Two elements - No Profit", new int[] { 5, 1 }, 0, tester);

        // Test Case 7: All same prices
        runtTest("Test 7: All same prices", new int[] { 3, 3, 3, 3 }, 0, tester);

        // Test Case 8: Maximum profit at the end
        runtTest("Test 8: Max Profit at end", new int[] { 2, 4, 1, 7 }, 6, tester);

        // Test Case 9: Maximum profit in the middle
        runtTest("Test 9: Max Profit in Middle", new int[] { 3, 1, 4, 8, 2 }, 7, tester);

        // Test Case 10: Multiple valleys and peaks
        runtTest("Test 10: Multiple Valleys and Peaks", new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }, 8, tester);

        // Test Case 11: Large numbers
        runtTest("Test 11: Large Numbers", new int[] { 1000, 1, 5000 }, 49999, tester);

        // Test Case 12: Zero prices (edge case)
        runtTest("Test 12: Contains zero", new int[] { 0, 6, 3, 2, 8 }, 8, tester);

        // Test Case 13: Minimum possible profit (1)
        runtTest("Test 13: Minimum Profit", new int[] { 5, 6, 5, 6 }, 1, tester);

        // Test Case 14: Empty array (edge case)
        runtTest("Test 14: Empty array", new int[] {}, 0, tester);

        // Test Case 15: Peak at beginning, then decline
        runtTest("Test 15: Peak at beginning", new int[] { 10, 8, 6, 4, 2 }, 0, tester);

        // Test Case 16: Complex pattern
        runtTest("Test 16: Complex pattern", new int[] { 3, 2, 6, 5, 0, 3 }, 4, tester);
    }
}
