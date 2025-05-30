
import java.util.Arrays;

public class MiddleFunctionTest {

    public static void main(String[] args) {
        System.out.println("--- Running MiddleFunction tests ---\n");

        int passedTests = 0;
        int totalTests = 0;

        // Test 1: Empty array
        totalTests++;
        try {
            int[] input = {};
            int[] expected = {};
            int[] result = MiddleFunction.middle(input);
            if (Arrays.equals(expected, result)) {
                System.out.println("Test 1 PASSED: Empty array");
                passedTests++;
            } else {
                System.out.println("Test 1 FAILED: Empty array - Expected: " + Arrays.toString(expected) + ", Got: "
                        + Arrays.toString(result));
            }
        } catch (Exception e) {
            System.out.println("Test 1 FAILED: Empty array - Exception: " + e.getMessage());
        }

        // Test 2: Single element
        totalTests++;
        try {
            int[] input = { 5 };
            int[] expected = {};
            int[] result = MiddleFunction.middle(input);
            if (Arrays.equals(expected, result)) {
                System.out.println("Test 2 PASSED: Single element");
                passedTests++;
            } else {
                System.out.println("Test 2 FAILED: Single element - Expected: " + Arrays.toString(expected) + ", Got: "
                        + Arrays.toString(result));
            }
        } catch (Exception e) {
            System.out.println("Test 2 FAILED: Single element - Exception: " + e.getMessage());
        }

        // Test 3: Two elements
        totalTests++;
        try {
            int[] input = { 1, 2 };
            int[] expected = {};
            int[] result = MiddleFunction.middle(input);
            if (Arrays.equals(expected, result)) {
                System.out.println("Test 3 PASSED: Two elements");
                passedTests++;
            } else {
                System.out.println("Test 3 FAILED: Two elements - Expected: " + Arrays.toString(expected) + ", Got: "
                        + Arrays.toString(result));
            }
        } catch (Exception e) {
            System.out.println("Test 3 FAILED: Two elements - Exception: " + e.getMessage());
        }

        // Test 4: Three elements
        totalTests++;
        try {
            int[] input = { 1, 2, 3 };
            int[] expected = { 2 };
            int[] result = MiddleFunction.middle(input);
            if (Arrays.equals(expected, result)) {
                System.out.println("Test 4 PASSED: Three elements");
                passedTests++;
            } else {
                System.out.println(" Test 4 FAILED: Three elements - Expected: " + Arrays.toString(expected) + ", Got: "
                        + Arrays.toString(result));
            }
        } catch (Exception e) {
            System.out.println("Test 4 FAILED: Three elements - Exception: " + e.getMessage());
        }

        // Test 5: Four elements
        totalTests++;
        try {
            int[] input = { 1, 2, 3, 4 };
            int[] expected = { 2, 3 };
            int[] result = MiddleFunction.middle(input);
            if (Arrays.equals(expected, result)) {
                System.out.println("Test 5 PASSED: Four elements");
                passedTests++;
            } else {
                System.out.println("Test 5 FAILED: Four elements - Expected: " + Arrays.toString(expected) + ", Got: "
                        + Arrays.toString(result));
            }
        } catch (Exception e) {
            System.out.println("Test 5 FAILED: Four elements - Exception: " + e.getMessage());
        }

        // Test 6: Five elements
        totalTests++;
        try {
            int[] input = { 10, 20, 30, 40, 50 };
            int[] expected = { 20, 30, 40 };
            int[] result = MiddleFunction.middle(input);
            if (Arrays.equals(expected, result)) {
                System.out.println("Test 6 PASSED: Five elements");
                passedTests++;
            } else {
                System.out.println("Test 6 FAILED: Five elements - Expected: " + Arrays.toString(expected) + ", Got: "
                        + Arrays.toString(result));
            }
        } catch (Exception e) {
            System.out.println("Test 6 FAILED: Five elements - Exception: " + e.getMessage());
        }

        // Test 7: Larger array
        totalTests++;
        try {
            int[] input = { 1, 2, 3, 4, 5, 6, 7, 8 };
            int[] expected = { 2, 3, 4, 5, 6, 7 };
            int[] result = MiddleFunction.middle(input);
            if (Arrays.equals(expected, result)) {
                System.out.println("Test 7 PASSED: Larger array");
                passedTests++;
            } else {
                System.out.println("Test 7 FAILED: Larger array - Expected: " + Arrays.toString(expected) + ", Got: "
                        + Arrays.toString(result));
            }
        } catch (Exception e) {
            System.out.println("Test 7 FAILED: Larger array - Exception: " + e.getMessage());
        }

        // Test 8: Negative numbers
        totalTests++;
        try {
            int[] input = { -5, -3, -1, 0, 1, 3, 5 };
            int[] expected = { -3, -1, 0, 1, 3 };
            int[] result = MiddleFunction.middle(input);
            if (Arrays.equals(expected, result)) {
                System.out.println("Test 8 PASSED: Negative numbers");
                passedTests++;
            } else {
                System.out.println("Test 8 FAILED: Negative numbers - Expected: " + Arrays.toString(expected)
                        + ", Got: " + Arrays.toString(result));
            }
        } catch (Exception e) {
            System.out.println("Test 8 FAILED: Negative numbers - Exception: " + e.getMessage());
        }

        // Test 9: Duplicate numbers
        totalTests++;
        try {
            int[] input = { 1, 1, 1, 1, 1 };
            int[] expected = { 1, 1, 1 };
            int[] result = MiddleFunction.middle(input);
            if (Arrays.equals(expected, result)) {
                System.out.println("Test 9 PASSED: Duplicate numbers");
                passedTests++;
            } else {
                System.out.println("Test 9 FAILED: Duplicate numbers - Expected: " + Arrays.toString(expected)
                        + ", Got: " + Arrays.toString(result));
            }
        } catch (Exception e) {
            System.out.println("Test 9 FAILED: Duplicate numbers - Exception: " + e.getMessage());
        }

        // Test 10: Null array
        totalTests++;
        try {
            int[] input = null;
            MiddleFunction.middle(input);
            System.out.println("Test 10 FAILED: Null array - Should have thrown NullPointerException");
        } catch (NullPointerException e) {
            System.out.println("Test 10 PASSED: Null array throws NullPointerException");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 10 FAILED: Null array - Wrong exception type: " + e.getClass().getSimpleName());
        }

        // Test 11: Result array length
        totalTests++;
        try {
            int[] input = { 1, 2, 3, 4, 5, 6 };
            int[] result = MiddleFunction.middle(input);
            if (result.length == input.length - 2) {
                System.out.println("Test 11 PASSED: Result array length");
                passedTests++;
            } else {
                System.out.println("Test 11 FAILED: Result array length - Expected: " + (input.length - 2) + ", Got: "
                        + result.length);
            }
        } catch (Exception e) {
            System.out.println("Test 11 FAILED: Result array length - Exception: " + e.getMessage());
        }

        // Test 12: Original array unmodified
        totalTests++;
        try {
            int[] input = { 1, 2, 3, 4, 5 };
            int[] originalCopy = input.clone();
            MiddleFunction.middle(input);
            if (Arrays.equals(originalCopy, input)) {
                System.out.println("Test 12 PASSED: Original array unmodified");
                passedTests++;
            } else {
                System.out.println("Test 12 FAILED: Original array was modified");
            }
        } catch (Exception e) {
            System.out.println("Test 12 FAILED: Original array unmodified - Exception: " + e.getMessage());
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("Test Results: " + passedTests + "/" + totalTests + " tests passed");
        if (passedTests == totalTests) {
            System.out.println("All tests passed!");
        } else {
            System.out.println("  " + (totalTests - passedTests) + " tests failed");
        }

        System.out.println("--- MiddleFunction tests completed ---\n");
    }

}
