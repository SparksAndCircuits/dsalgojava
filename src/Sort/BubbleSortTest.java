import java.util.Arrays;

public class BubbleSortTest {
    private static int testRun = 0;
    private static int testPassed = 0;

    private static void assertArrayEquals(int[] expected, int[] actual, String message) {
        testRun++;
        if (Arrays.equals(expected, actual)) {
            System.out.println("The test has passed: " + getCurrentTestName() + " -" + testPassed++);
        } else {
            System.out.println("The test has failed: " + getCurrentTestName() + " - " + message);
            System.out.println("The expected result is: " + Arrays.toString(expected));
            System.out.println("The actual result is: " + Arrays.toString(actual));
        }
    }

    private static String getCurrentTestName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        for (StackTraceElement element : stackTrace) {
            String methodName = element.getMethodName();
            if (methodName.startsWith("test") && !methodName.equals("testperformanceWithWorstCase")) {
                return methodName;
            }
        }

        return "unknownTest";
    }

    private static void testEmptyArray() {
        int[] array = {};
        int[] expected = {};

        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Empty Array should remain empty");
    }

    private static void testSingleArray() {
        int[] array = { 5 };
        int[] expected = { 5 };

        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Single element array should remain unchanged");
    }

    private static void testTwoElementsInOrder() {
        int[] array = { 1, 2 };
        int[] expected = { 1, 2 };
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Already sorted two elements should remain in order");
    }

    private static void testTwoElementsReversed() {
        int[] array = { 2, 1 };
        int[] expected = { 1, 2 };
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Reverse two elements should be sorted");
    }

    private static void testAlreadySortedArray() {
        int[] array = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Already sorted array should remain sorted");
    }

    private static void testReverseSortedArray() {
        int[] array = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Reversed sorted array should be sorted correctly");
    }

    private static void testRandomOrder() {
        int[] array = { 3, 1, 4, 1, 5, 9, 2, 6 };
        int[] expected = { 1, 1, 2, 3, 4, 5, 6, 9 };
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Random order array should be sorted");
    }

    private static void testDuplicateElements() {
        int[] array = { 3, 3, 1, 2, 2, 1 };
        int[] expected = { 1, 1, 2, 2, 3, 3 };
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Array with duplicates should be sorted correctly");
    }

    private static void testAllSameElement() {
        int[] array = { 7, 7, 7, 7, 7 };
        int[] expected = { 7, 7, 7, 7, 7 };
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Array with all same elements should remain unchanged.");
    }

    public static void testNegativeNumbers() {
        int[] array = { -3, -1, -4, -2 };
        int[] expected = { -4, -3, -2, -1 };
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Array with negative numbers should be sorted correctly");
    }

    public static void testMixedPositiveAndNegativeNumbers() {
        int[] array = { 3, -1, 4, -2, 0, 5 };
        int[] expected = { -2, -1, 0, 3, 4, 5 };
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Mixed postive and negative numbers should be sorted correctly.");
    }

    private static void testLargeNumbers() {
        int[] array = { Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1000000, -1000000 };
        int[] expected = { Integer.MIN_VALUE, -1000000, 0, 1000000, Integer.MAX_VALUE };
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Large numbers including integer limits should be sorted correctly.");
    }

    private static void testLargerArray() {
        int[] array = { 64, 34, 25, 12, 22, 11, 90, 88, 76, 50, 42 };
        int[] expected = { 11, 12, 22, 25, 34, 42, 50, 64, 76, 88, 90 };
        BubbleSort.bubbleSort(array);
        assertArrayEquals(expected, array, "Larger array should be sorted correctly");
    }

    private static void testInPlaceSorting() {
        int[] original = { 3, 1, 4, 2 };
        int[] reference = original;

        BubbleSort.bubbleSort(original);

        if (original == reference) {
            System.out.println("The test has passed:");
            testPassed++;
        } else {
            System.out.println("The test has failed.");
        }

        testRun++;

        int[] expected = { 1, 2, 3, 4 };
        assertArrayEquals(expected, original, "Array should be sorted correctly in place");
    }

    private static void testperformanceWithWorstCase() {
        int size = 100;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = size - 1;
        }

        long startTime = System.nanoTime();
        BubbleSort.bubbleSort(array);
        long endTime = System.nanoTime();

        boolean isSorted = true;

        for (int i = 0; i < size - 1; i++) {
            if (array[i] > array[i + 1]) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            System.out.println("The test has passed.");
            System.out.println("Performance: " + (endTime - startTime) / 1_000_000 + " ms for " + size + " elements");
            testPassed++;
        } else {
            System.out.println("The test has failed");
        }

        testRun++;
    }

    public static void main(String[] args) {
        System.out.println("--- Buble sort test is starting ---");

        testEmptyArray();
        testSingleArray();
        testTwoElementsInOrder();
        testTwoElementsReversed();
        testAlreadySortedArray();
        testReverseSortedArray();
        testRandomOrder();
        testDuplicateElements();
        testAllSameElement();
        testNegativeNumbers();
        testMixedPositiveAndNegativeNumbers();
        testLargeNumbers();
        testLargerArray();
        testInPlaceSorting();
        testperformanceWithWorstCase();

        System.out.println("\n--- Test Results ---");
        System.out.println("Test run: " + testRun);
        System.out.println("Test passed: " + testPassed);
        System.out.println("Test failed: " + (testRun - testPassed));
    }
}
