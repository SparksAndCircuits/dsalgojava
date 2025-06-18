public class InsertionSortTest {
    public static boolean testEmptyArray() {
        int[] array = {};
        int[] expected = {};
        InsertionSort.insertionSort(array);
        return arraysEqual(array, expected);
    }

    public static boolean testSingleElement() {
        int[] array = { 5 };
        int[] expected = { 5 };
        InsertionSort.insertionSort(array);
        return arraysEqual(array, expected);
    }

    public static boolean testAlreadySorted() {
        int[] array = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        InsertionSort.insertionSort(array);
        return arraysEqual(array, expected);
    }

    public static boolean testReversedSorted() {
        int[] array = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        InsertionSort.insertionSort(array);
        return arraysEqual(array, expected);
    }

    public static boolean testRandomArray() {
        int[] array = { 3, 1, 4, 1, 5, 9, 2, 6 };
        int[] expected = { 1, 1, 2, 3, 4, 5, 6, 9 };
        InsertionSort.insertionSort(array);
        return arraysEqual(array, expected);
    }

    public static boolean testDuplicates() {
        int[] array = { 5, 2, 8, 2, 9, 1, 5, 5 };
        int[] expected = { 1, 2, 2, 5, 5, 5, 8, 9 };
        InsertionSort.insertionSort(array);
        return arraysEqual(array, expected);
    }

    public static boolean testNegativeNumbers() {
        int[] array = { -3, 5, -1, 0, -8, 2 };
        int[] expected = { -8, -3, -1, 0, 2, 5 };
        InsertionSort.insertionSort(array);
        return arraysEqual(array, expected);
    }

    public static boolean testLargeArray() {
        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            array[i] = 100 - i;
        }

        InsertionSort.insertionSort(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean testTwoElements() {
        int[] array = { 2, 1 };
        int[] expected = { 1, 2 };
        InsertionSort.insertionSort(array);
        return arraysEqual(array, expected);
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void printArray(int[] array) {
        System.out.println("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.println(", ");
            }

            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Running Insertion Sort Test Cases. ---\n");

        int passedTests = 0;
        int totalTests = 0;

        // Test Case 1: Empty array
        totalTests++;
        if (testEmptyArray()) {
            System.out.println("  Test 1 PASSED: Empty array");
            passedTests++;
        } else {
            System.out.println("  Test 1 FAILED: Empty array");
        }

        // Test Case 2: Single element array
        totalTests++;
        if (testSingleElement()) {
            System.out.println("  Test 2 PASSED: Single element array");
            passedTests++;
        } else {
            System.out.println("  Test 2 FAILED: Single element array");
        }

        // Test Case 3: Already sorted array
        totalTests++;
        if (testAlreadySorted()) {
            System.out.println("  Test 3 PASSED: Already sorted array");
            passedTests++;
        } else {
            System.out.println("  Test 3 FAILED: Already sorted array");
        }

        // Test Case 4: Reverse sorted array
        totalTests++;
        if (testReversedSorted()) {
            System.out.println("  Test 4 PASSED: Reverse sorted array");
            passedTests++;
        } else {
            System.out.println("  Test 4 FAILED: Reverse sorted array");
        }

        // Test Case 5: Random unsorted array
        totalTests++;
        if (testRandomArray()) {
            System.out.println("  Test 5 PASSED: Random unsorted array");
            passedTests++;
        } else {
            System.out.println("  Test 5 FAILED: Random unsorted array");
        }

        // Test Case 6: Array with duplicates
        totalTests++;
        if (testDuplicates()) {
            System.out.println("  Test 6 PASSED: Array with duplicates");
            passedTests++;
        } else {
            System.out.println("  Test 6 FAILED: Array with duplicates");
        }

        // Test Case 7: Array with negative numbers
        totalTests++;
        if (testNegativeNumbers()) {
            System.out.println("  Test 7 PASSED: Array with negative numbers");
            passedTests++;
        } else {
            System.out.println("  Test 7 FAILED: Array with negative numbers");
        }

        // Test Case 8: Large array
        totalTests++;
        if (testLargeArray()) {
            System.out.println("  Test 8 PASSED: Large array");
            passedTests++;
        } else {
            System.out.println("  Test 8 FAILED: Large array");
        }

        // Test Case 9: Two elements (edge case for the bug)
        totalTests++;
        if (testTwoElements()) {
            System.out.println("Test 9 PASSED: Two elements");
            passedTests++;
        } else {
            System.out.println("Test 9 FAILED: Two elements");
        }

        System.out.println("\n" + "=".repeat(40));
        System.out.println("Test Results: " + passedTests + "/" + totalTests + " tests passed");

        if (passedTests == totalTests) {
            System.out.println("All tests passed!  ");
        } else {
            System.out.println("Some tests failed. Please check your implementation.");
        }
    }
}
