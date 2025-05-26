package arrays.LeetCode;

import java.util.Arrays;

public class DuplicateNumbers {
    public static int[] removeDuplicates(int[] array) {
        int n = array.length;
        int[] uniqueArray = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicates = false;

            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    isDuplicates = true;
                    break;
                }
            }

            if (!isDuplicates) {
                uniqueArray[index++] = array[i];
            }
        }

        return Arrays.copyOf(uniqueArray, index);
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 3, 5, 6, 6, 8, 8, 10 };
        System.out.println(Arrays.toString(removeDuplicates(array)));

        System.out.println("--- Testing DuplicateNumbers.removeDuplicates() ---\n");

        // Test 1: Original example from your main method
        System.out.println("Test 1: Original example");
        int[] test1 = { 1, 2, 3, 3, 5, 6, 6, 8, 8, 10 };
        System.out.println("Input: " + Arrays.toString(test1));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test1)));
        System.out.println("Expected: [1,2,5,10] (elements that appear only once)");
        System.out.println();

        // Test 2: no duplicates
        System.out.println("Test 2: No duplicates");
        int[] test2 = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Input: " + Arrays.toString(test2));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test2)));
        System.out.println("Expected: [1,2,5,10] (elements that appear only once)");
        System.out.println();

        // Test 3: All duplicates
        System.out.println("Test 3: All duplicates");
        int[] test3 = { 5, 5, 5, 5, 5 };
        System.out.println("Input: " + Arrays.toString(test3));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test3)));
        System.out.println("Expected: [] (empty array - all elements are duplicates)");

        // Test 4: Single element
        System.out.println("Test 4: Single element");
        int[] test4 = { 42 };
        System.out.println("Input: " + Arrays.toString(test4));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test4)));
        System.out.println("Expected: [42] (single elements has no duplicates)");
        System.out.println();

        // Test 5: Empty array
        System.out.println("Test 5: Empty array");
        int[] test5 = {};
        System.out.println("Input: " + Arrays.toString(test5));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test5)));
        System.out.println("Expected: [] (empty array remains empty)");
        System.out.println();

        // Test 6: Mixed pattern
        System.out.println("Test 6: Mixed pattern");
        int[] test6 = { 1, 1, 2, 3, 3, 4, 5, 5, 6 };
        System.out.println("Input: " + Arrays.toString(test6));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test6)));
        System.out.println("Expected: [] (Elements that appear only once)");
        System.out.println();

        // Test 7: Negative numbers
        System.out.println("Test 7: Negative numbers");
        int[] test7 = { -1, -2, -1, 0, 0, 1, 2, 2 };
        System.out.println("Input: " + Arrays.toString(test7));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test7)));
        System.out.println();

        // Test 8: Large numbers
        System.out.println("Test 8: Large numbers");
        int[] test8 = { 100000000, 99999, 100000000, 500000 };
        System.out.println("Input: " + Arrays.toString(test8));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test8)));
        System.out.println();
        // Test 9: Two elements - both unique
        System.out.println("Test 9: Two elements - both unique");
        int[] test9 = { 7, 9 };
        System.out.println("Input:  " + Arrays.toString(test9));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test9)));
        System.out.println("Expected: [7, 9] (both elements are unique)");
        System.out.println();

        // Test 10: Two elements - both duplicates
        System.out.println("Test 10: Two elements - both duplicates");
        int[] test10 = { 7, 7 };
        System.out.println("Input:  " + Arrays.toString(test10));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test10)));
        System.out.println("Expected: [] (both elements are duplicates)");
        System.out.println();

        // Test 11: Zero values
        System.out.println("Test 11: Zero values");
        int[] test11 = { 0, 1, 0, 2, 3, 3 };
        System.out.println("Input:  " + Arrays.toString(test11));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test11)));
        System.out.println("Expected: [1, 2] (elements that appear only once)");
        System.out.println();

        // Test 12: Performance test with larger array
        System.out.println("Test 12: Performance test");
        int[] test12 = { 1, 2, 3, 4, 5, 1, 2, 6, 7, 8, 9, 10, 6, 7, 11, 12, 13, 14, 15 };
        System.out.println("Input:  " + Arrays.toString(test12));
        System.out.println("Output: " + Arrays.toString(DuplicateNumbers.removeDuplicates(test12)));
        System.out.println("Expected: [3, 4, 5, 8, 9, 10, 11, 12, 13, 14, 15] (elements that appear only once)");
        System.out.println();

        System.out.println("=== All tests completed ===");
        System.out.println("\nNote: Your algorithm removes elements that have ANY duplicate,");
        System.out.println("keeping only elements that appear exactly once in the array.");
    }
}
