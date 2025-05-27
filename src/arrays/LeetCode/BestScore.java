package arrays.LeetCode;

/* Given an array, write a function to get the first and second best scores
 * from the array and return it in a new array. The array may contain duplicates.
 */

public class BestScore {
    public static int[] findTopTwoScores(int[] array) {
        int firstHighest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int score : array) {
            if (score > firstHighest) {
                secondHighest = firstHighest;
                firstHighest = score;
            } else if (score > secondHighest && score < firstHighest) {
                secondHighest = score;
            }
        }

        return new int[] { firstHighest, secondHighest };
    }

    public static void printArray(int[] array) {
        System.out.print("[" + array[0] + "," + array[1] + "]");
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    public static void runTest(String testName, int[] input, int[] expected) {
        System.out.println("\n" + testName);
        System.out.print("Input: ");
        System.out.print("[");

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);

            if (i < input.length - 1) {
                System.out.print(",");
            }

        }

        System.out.println("]");

        int[] result = findTopTwoScores(input);
        System.out.print("Expected: ");
        printArray(expected);
        System.out.print("\nActual: ");
        printArray(result);

        boolean passed = arraysEqual(result, expected);
        System.out.println("\nResult: " + (passed ? "PASS" : "FAIL"));

        if (!passed) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Testing BestScores ---");

        // Test Case 1: Basic functionality
        runTest("Test 1: Basic Values", new int[] { 85, 92, 78, 96, 88 }, new int[] { 96, 92 });

        // Test Case 2: Duplicates of highest value
        runTest("Test 2: Duplicates of Highest value", new int[] { 100, 95, 100, 85, 90 }, new int[] { 100, 95 });

        // Test Case 3: Duplicates of second highest value
        runTest("Test 3: Duplicates of Second highest value", new int[] { 100, 95, 90, 95, 85 }, new int[] { 100, 95 });

        // Test Case 4: All same elements
        runTest("Test 4: All the same value", new int[] { 75, 75, 75, 75 }, new int[] { 75, Integer.MIN_VALUE });

        // Test Case 5: Two distinct elements
        runTest("Test 5: Two Distinct Elements", new int[] { 60, 80 }, new int[] { 80, 60 });

        // Test Case 6: Two same elements
        runTest("Test 6", new int[] { 75, 75 }, new int[] { 75, Integer.MIN_VALUE });

        // Test Case 7: Single element
        runTest("Test Case 7: Single element", new int[] { 42 }, new int[] { 42, Integer.MIN_VALUE });

        // Test Case 8: Negative numbers
        runTest("Test 8: Negative Numbers", new int[] { -10, -5, -15, -2, -8 }, new int[] { -2, -5 });

        // Test Case 9: Mix of positive and negative numbers
        runTest("Test 9: Mixed Positive/Negative", new int[] { -5, 10, -2, 8, 3 }, new int[] { 10, 8 });

        // Test Case 10: Contains Integer.MIN_VALUE
        runTest("Test: 10 Contains Integer.MIN_VALUE", new int[] { 100, Integer.MIN_VALUE, 50, 75 },
                new int[] { 100, 75 });

        // Test Case 11: Sequential array
        runTest("Test 11: Sequential array", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, new int[] { 10, 9 });

        // Test Case 12: Reverse order
        runTest("Test 12: Reverse Order", new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }, new int[] { 10, 9 });

        // Test Case 13: Only two Distinct values
        runTest("Test 13: Two Distinct Values", new int[] { 50, 100, 50, 100, 50 }, new int[] { 100, 50 });

    }
}
