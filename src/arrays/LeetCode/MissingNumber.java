package arrays.LeetCode;

/*  Write a java function called findMissingNumberInArray that takes 
 *  an integer array containing n -1 unique elements from a range of 
 *  1 to n, with one missing number, and returns the missing number. 
 */
public class MissingNumber {
    public static int findMissingNumberInArray(int[] array) {
        int n = array.length - 1;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int number : array) {
            actualSum += number;
        }

        return expectedSum - actualSum;
    }

    private static void runTest(String testName, int[] inputArray, int expectedResult) {
        int actualResult = MissingNumber.findMissingNumberInArray(inputArray);
        System.out.println("\n" + testName);
        System.out.print("Input: { ");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i]);
            if (i < inputArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
        System.out.println("Expected: " + expectedResult);
        System.out.println("Actual:   " + actualResult);

        if (actualResult == expectedResult) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL - Mismatch!");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Running Manual Test Cases ---");

        // Test Case 1
        runTest("Test 1: Array {1, 2}", new int[] { 1, 2 }, -2);

        // Test Case 2
        runTest("Test 2: Array {1, 2, 3, 4}", new int[] { 1, 2, 3, 4 }, -4);

        // Test Case 3
        runTest("Test 3: Empty Array {}", new int[] {}, 0);

        // Test Case 4
        runTest("Test 4: Array {5}", new int[] { 5 }, -5);

        // Test Case 5
        runTest("Test 5: Array {0, 1, 3}", new int[] { 0, 1, 3 }, -1);

        // Test Case 6
        runTest("Test 6: Array {-1, 0, 1}", new int[] { -1, 0, 1 }, 3);

        // Test Case 7
        runTest("Test 7: Array {1, 2, 2, 4}", new int[] { 1, 2, 2, 4 }, -3);

        // Test Case 8
        runTest("Test 8: {1, 2, 4, 5}", new int[] { 1, 2, 4, 5 }, -6);

        System.out.println("--- Manual Test Cases Finished ---");
    }
}
