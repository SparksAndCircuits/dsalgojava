/* Given an array of integers nums and an integer target, return indicies of the two numbers such that they add up to the target. You may assuime that each input would have exactly one solution, and you may not use the same element twice. */

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution found");
    }

    // Test Case 1
    public static void testBasicCase() {
        System.out.println("Test 1: Basic case.");
        TwoSum twoSum = new TwoSum();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] expected = { 0, 1 };

        try {
            int[] actual = twoSum.twoSum(nums, target);
            if (Arrays.equals(actual, expected)) {
                System.out.println("This test has passed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            } else {
                System.out.println("This test has failed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            }
        } catch (Exception e) {
            System.out.println("This test failed. The exception that was thrown was. " + e.getMessage());
        }

        System.out.println();
    }

    // Test Case 2
    public static void testFirstTwoElements() {
        System.out.println("Test 2: First two elements.");
        TwoSum twoSum = new TwoSum();
        int[] nums = { 3, 2, 4 };
        int target = 5;
        int[] expected = { 0, 1 };

        try {
            int[] actual = twoSum.twoSum(nums, target);
            if (Arrays.equals(actual, expected)) {
                System.out.println("This test has passed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            } else {
                System.out.println("This test has failed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            }
        } catch (Exception e) {
            System.out.println("This test failed. The exception that was thrown was. " + e.getMessage());
        }

        System.out.println();
    }

    // Test case 3
    public static void testLastTwoElements() {
        System.out.println("Test 3: Test last two elements.");
        TwoSum twoSum = new TwoSum();
        int[] nums = { 1, 2, 3, 4 };
        int target = 7;
        int[] expected = { 2, 3 };

        try {
            int[] actual = twoSum.twoSum(nums, target);
            if (Arrays.equals(actual, expected)) {
                System.out.println("This test has passed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            } else {
                System.out.println("This test has failed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            }
        } catch (Exception e) {
            System.out.println("This test failed. The exception that was thrown was. " + e.getMessage());
        }

        System.out.println();
    }

    // Test case 4
    public static void testNegativeNumbers() {
        System.out.println("Test 4: Test Negative numbers.");
        TwoSum twoSum = new TwoSum();
        int[] nums = { -1, -2, -3, -4, -5 };
        int target = -8;
        int[] expected = { 2, 4 };

        try {
            int[] actual = twoSum.twoSum(nums, target);
            if (Arrays.equals(actual, expected)) {
                System.out.println("This test has passed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            } else {
                System.out.println("This test has failed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            }
        } catch (Exception e) {
            System.out.println("This test failed. The exception that was thrown was. " + e.getMessage());
        }

        System.out.println();
    }

    // Test case 5
    public static void testZeroTarget() {
        System.out.println("Test 5: Test zero targets.");
        TwoSum twoSum = new TwoSum();
        int[] nums = { -1, 0, 1, 2 };
        int target = 0;
        int[] expected = { 0, 2 };

        try {
            int[] actual = twoSum.twoSum(nums, target);
            if (Arrays.equals(actual, expected)) {
                System.out.println("This test has passed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            } else {
                System.out.println("This test has failed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            }
        } catch (Exception e) {
            System.out.println("This test failed. The exception that was thrown was. " + e.getMessage());
        }

        System.out.println();
    }

    // Test case 6
    public static void testLargerArray() {
        System.out.println("Test 6: Larger Array.");
        TwoSum twoSum = new TwoSum();
        int[] nums = { 1, 3, 7, 9, 2 };
        int target = 11;
        int[] expected = { 1, 3 };

        try {
            int[] actual = twoSum.twoSum(nums, target);
            if (Arrays.equals(actual, expected)) {
                System.out.println("This test has passed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            } else {
                System.out.println("This test has failed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            }
        } catch (Exception e) {
            System.out.println("This test failed. The exception that was thrown was. " + e.getMessage());
        }

        System.out.println();
    }

    // Test case 7
    public static void testNegativeTarget() {
        System.out.println("Test 7: Negative Target.");
        TwoSum twoSum = new TwoSum();
        int[] nums = { 5, -3, 2, -1 };
        int target = -4;
        int[] expected = { 1, 3 };

        try {
            int[] actual = twoSum.twoSum(nums, target);
            if (Arrays.equals(actual, expected)) {
                System.out.println("This test has passed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            } else {
                System.out.println("This test has failed. The expected result was: " + Arrays.toString(expected)
                        + " , We got the following: " + actual);
            }
        } catch (Exception e) {
            System.out.println("This test failed. The exception that was thrown was. " + e.getMessage());
        }

        System.out.println();
    }

    // Test case 8
    public static void testNoSolutionCase() {
        System.out.println("Test 8: No solution.");
        TwoSum twoSum = new TwoSum();
        int[] nums = { 1, 2, 3 };
        int target = 7;
        // int[] expected = { 2, 3 };

        try {
            int[] actual = twoSum.twoSum(nums, target);
            System.out.println("This test has failed. The expected result was: " + Arrays.toString(actual));
        } catch (IllegalArgumentException e) {
            System.out.println("This test has passed. The expected result was:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("This test failed. The exception that was thrown was.  " + e.getClass().getSimpleName()
                    + ": " + e.getMessage());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--- Tests for twoSum ---");

        testBasicCase();
        testFirstTwoElements();
        testLastTwoElements();
        testNegativeNumbers();
        testZeroTarget();
        testLargerArray();
        testNegativeTarget();
        testNoSolutionCase();

        System.out.println("--- Tests for twoSum have been completed ---");
    }
}
