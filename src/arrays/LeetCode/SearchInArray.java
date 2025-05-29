import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SearchInArray {
    public void linearSearch(int[] intArray, int value) {

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == value) {
                System.out.println("Value is found at the index of " + i);
                return;
            }
        }

        System.out.println(value + "was not found");
    }

    private static int testsPassed = 0;
    private static int testsFailed = 0;
    private static SearchInArray searchInstance = new SearchInArray();

    // Test 1: When value is found at the beginning of the array
    private static void testValueFoundAtBeginning() {
        System.out.println("\nTest 1: Value found at the beginning.");
        int[] array = { 5, 10, 15, 20, 25 };
        String output = captureOutput(() -> searchInstance.linearSearch(array, 5));
        String expected = "Value found is at the index 0";

        if (output.trim().equals(expected)) {
            System.out.println("Passed");
            testsPassed++;
        } else {
            System.out.println("Failed, expected: " + expected);
            System.out.println("Actual: " + output.trim());
            testsFailed++;
        }
    }

    // Test 2: When value is found in the middle of the array
    private static void testValueFoundAtMiddle() {
        System.out.println("\nTest 1: Value found in the middle.");
        int[] array = { 5, 10, 15, 20, 25 };
        String output = captureOutput(() -> searchInstance.linearSearch(array, 15));
        String expected = "Value found is at the index 2";

        if (output.trim().equals(expected)) {
            System.out.println("Passed");
            testsPassed++;
        } else {
            System.out.println("Failed, expected: " + expected);
            System.out.println("Actual: " + output.trim());
            testsFailed++;
        }
    }

    // Test 3: When value is found at the end of the array
    private static void testValueFoundAtEnd() {
        System.out.println("\nTest 1: Value found at the end.");
        int[] array = { 5, 10, 15, 20, 25 };
        String output = captureOutput(() -> searchInstance.linearSearch(array, 25));
        String expected = "Value found is at the index 4";

        if (output.trim().equals(expected)) {
            System.out.println("Passed");
            testsPassed++;
        } else {
            System.out.println("Failed, expected: " + expected);
            System.out.println("Actual: " + output.trim());
            testsFailed++;
        }
    }

    // Test 4: When value is not found in the array
    private static void testValueNotFound() {
        System.out.println("\nTest 1: Value not found.");
        int[] array = { 5, 10, 15, 20, 25 };
        String output = captureOutput(() -> searchInstance.linearSearch(array, 4));
        String expected = "Value found is at the index 0";

        if (output.trim().equals(expected)) {
            System.out.println("Passed");
            testsPassed++;
        } else {
            System.out.println("Failed, expected: " + expected);
            System.out.println("Actual: " + output.trim());
            testsFailed++;
        }
    }

    // Test 5: empty array
    private static void testEmptyArray() {
        System.out.println("\nTest 1: Empty Array.");
        int[] array = {};
        String output = captureOutput(() -> searchInstance.linearSearch(array, 5));
        String expected = "Value found is at the index 0";

        if (output.trim().equals(expected)) {
            System.out.println("Passed");
            testsPassed++;
        } else {
            System.out.println("Failed, expected: " + expected);
            System.out.println("Actual: " + output.trim());
            testsFailed++;
        }
    }

    // Test 6: With single element array
    private static void testSingleElementFound() {
        System.out.println("\nTest 6: Single element found");
        int[] array = { 42 };
        String output = captureOutput(() -> searchInstance.linearSearch(array, 42));
        String expected = "Value is found at the index of 0";

        if (output.trim().equals(expected)) {
            System.out.println("PASSED");
            testsPassed++;
        } else {
            System.out.println("FAILED");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + output.trim());
            testsFailed++;
        }
    }

    // Test 7: with single element array
    private static void testSingleElementNotFound() {
        System.out.println("\nTest 7: Single element not found");
        int[] array = { 42 };
        String output = captureOutput(() -> searchInstance.linearSearch(array, 99));
        String expected = "99 was not found";

        if (output.trim().equals(expected)) {
            System.out.println("PASSED");
            testsPassed++;
        } else {
            System.out.println("FAILED");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + output.trim());
            testsFailed++;
        }
    }

    // Test 8 with duplicate values
    private static void testDuplicateValues() {
        System.out.println("\nTest 8: Duplicate values (finds first)");
        int[] array = { 1, 3, 5, 3, 7 };
        String output = captureOutput(() -> searchInstance.linearSearch(array, 3));
        String expected = "Value is found at the index of 1";

        if (output.trim().equals(expected)) {
            System.out.println("PASSED");
            testsPassed++;
        } else {
            System.out.println("FAILED");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + output.trim());
            testsFailed++;
        }
    }

    // Test 9: with null array (should throw exception)
    private static void testNullArray() {
        System.out.println("\nTest 9 : Null array handling");
        try {
            searchInstance.linearSearch(null, 5);
            System.out.println("FAILED - Expected NullPointerException");
            testsFailed++;
        } catch (NullPointerException e) {
            System.out.println("PASSED - Correctly threw NullPointerException");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("FAILED - Unexpected exception: " + e.getClass().getSimpleName());
            testsFailed++;
        }
    }

    // Test 10 with negative numbers
    private static void testNegativeNumbers() {
        System.out.println("\nTest 10: Negative numbers");
        int[] array = { -5, -2, 0, 3, 7 };
        String output = captureOutput(() -> searchInstance.linearSearch(array, -2));
        String expected = "Value is found at the index of 1";

        if (output.trim().equals(expected)) {
            System.out.println("PASSED");
            testsPassed++;
        } else {
            System.out.println("FAILED");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + output.trim());
            testsFailed++;
        }
    }

    // Test 11 with large array
    private static void testLargeArray() {
        System.out.println("\nTest 11: Large array");
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i * 2;
        }
        String output = captureOutput(() -> searchInstance.linearSearch(array, 998));
        String expected = "Value is found at the index of 499";

        if (output.trim().equals(expected)) {
            System.out.println("PASSED");
            testsPassed++;
        } else {
            System.out.println("FAILED");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + output.trim());
            testsFailed++;
        }
    }

    private static String captureOutput(Runnable task) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(baos));
            task.run();
            return baos.toString();
        } finally {
            System.setOut(originalOut);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Running SearchInArray Test Suite ---");
        testValueFoundAtBeginning();
        testValueFoundAtMiddle();
        testValueFoundAtEnd();
        testValueNotFound();
        testEmptyArray();
        testSingleElementFound();
        testSingleElementNotFound();
        testDuplicateValues();
        testNullArray();
        testNegativeNumbers();
        testLargeArray();

        System.out.println("Test Results:");
        System.out.println("Tests Passed: " + testsPassed);
        System.out.println("Tests Failed: " + testsFailed);
    }

}
