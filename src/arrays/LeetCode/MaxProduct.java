package arrays.LeetCode;

/* How to find the max product of two integers in 
 * the array where all elements are positive.
 */
public class MaxProduct {
    public String maxProduct(int[] array) {
        int maxProduct = 0;
        String pairs = "";

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] * array[j] > maxProduct) {
                    maxProduct = array[i] * array[j];
                    pairs = Integer.toString(array[i]) + "," + Integer.toString(array[j]);
                }
            }
        }

        return pairs;
    }

    public static void runTest(String testName, int[] input, String expected, MaxProduct tester) {
        System.out.println("\n" + testName);
        System.out.print("Input: [");

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            if (i < input.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
        String result = tester.maxProduct(input);
        System.out.println("Expected: \"" + expected + "\"");
        System.out.println("Actual: \"" + result + "\"");

        boolean passed = result.equals(expected);
        System.out.println("Result: " + (passed ? "Pass" : "Fail"));

        if (!passed) {
            System.out.println("--- Issue dected ---");
        }
    }

    public static void main(String[] args) {
        MaxProduct tester = new MaxProduct();
        System.out.println("--- Testing MaxProduct ---");

        // Test case 1: Normal case with distinct values
        runTest("Test 1: Normal case", new int[] { 3, 5, 2, 8, 1 }, "5,8", tester);

        // Test case 2: Largest value at the end
        runTest("Test 2:Largest value at the end", new int[] { 1, 2, 3, 10, 20 }, "10,20", tester);

        // Test case 3: Largest values at the beginning
        runTest("Test 3: Largest value at the beginning", new int[] { 20, 10, 3, 2, 1 }, "20,10", tester);

        // Test case 4: Two elements only
        runTest("Test 4: Two Elements", new int[] { 7, 9 }, "7,9", tester);

        // Test case 5: Multiple pairs with same product
        runTest("Test 5: Same Product Multiple pairs", new int[] { 2, 6, 3, 4 }, "2,6", tester);

        // Test case 6: Array with duplicates
        runTest("Test 6: Array with duplicates", new int[] { 5, 5, 3, 2 }, "5,5", tester);

        // Test case 7: All elemnts are 1
        runTest("Test 7: All Elements are 1", new int[] { 1, 1, 1 }, "1,1", tester);

        // Test case 8: Contains zeros
        runTest("Test 8: Contains zero's", new int[] { 0, 5, 3, 2 }, "5,3", tester);

        // Test case 9: Single element
        runTest("Test 9: Single element", new int[] { 9 }, "", tester);

        // Test case 10: Empty array
        runTest("Test 10: Empty array", new int[] {}, "", tester);

        // Test case 11: Large numbers
        runTest("Test 11: Large numbers", new int[] { 100, 200, 300, 400 }, "300,400", tester);

        // Test case 12: Order matters
        runTest("Test 12: Order matters", new int[] { 4, 3, 6, 2 }, "4,6", tester);

        // Test case 13: Three elements
        runTest("Test 13: Three elements", new int[] { 2, 8, 3 }, "2,8", tester);
    }
}
