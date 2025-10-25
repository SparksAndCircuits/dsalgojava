public class MaximumSubarray {
    // Brute Force Approach - O(n^2) time complexity.
    public static int maxSubarrayBruteForce(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int maxSum = Integer.MIN_VALUE;

        // Try every possible subarray
        for (int i = 0; i < array.length; i++) {
            int currentSum = 0;

            // Extend the subarray from position i
            for (int j = i; j < array.length; j++) {
                currentSum += j;
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    // Kadane's Algorithm - O(n) time complexity
    public static int maxSubArrayKadane(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int maxSoFar = array[0]; // Best Sum we've seen overall
        int maxEndingHere = array[0]; // Best sum ending at current position.

        for (int i = 1; i < array.length; i++) {
            // Either extend the exisitng subarray or start fresh
            maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);

            // update our global maximum
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    // Enhanced version that also returns the subarray Index
    public static Result maxSubarrayWithIndices(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int maxSoFar = array[0];
        int maxEndingHere = array[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxEndingHere + array[i]) {
                maxEndingHere = array[i];
                tempStart = i;
            } else {
                maxEndingHere = maxEndingHere + array[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        return new Result(maxSoFar, start, end);
    }

    static class Result {
        int maxSum;
        int startIndex;
        int endIndex;

        Result(int maxSum, int startIndex, int endIndex) {
            this.maxSum = maxSum;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public String toString() {
            return String.format("Max Sum: %d, Indices: [%d. %d]", maxSum, startIndex, endIndex);
        }
    }

    // Variation 1: Maximum Circular Subarray
    // Handle arrays where subarray can wrap around (Circular)
    public static int maxCircularSubarray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        // Case 1: Maximum subarray is in the middle (normal Kadane's)
        int maxKadane = maxSubArrayKadane(array);

        // Case 2: Maximum subarray wraps arround
        // This equlas: total_sum - minimum_subarray
        int totalSum = 0;
        for (int i = 0; i < array.length; i++) {
            totalSum += array[i];
            array[i] = -array[i]; // invert for finding minimum
        }

        int maxWrap = totalSum + maxSubArrayKadane(array);

        // Restore array
        for (int i = 0; i < array.length; i++) {
            array[i] = -array[i];
        }

        // Handle all negative case
        return (maxWrap == 0) ? maxKadane : Math.max(maxKadane, maxWrap);
    }

    // Variation 2: Maximum Product Subarray
    // Handles both positive and negative numbers (negative can become positive)
    public static int maxProductSubarray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int maxSoFar = array[0];
        int maxEndingHere = array[0];
        int minEndingHere = array[0]; // Track minimum (negative*negative = positive)

        for (int i = 1; i < array.length; i++) {
            int temp = maxEndingHere;

            // Maximum can come from: current element, max*current, or min*current
            maxEndingHere = Math.max(array[i], Math.max(maxEndingHere * array[i], minEndingHere * array[i]));

            minEndingHere = Math.min(array[i], Math.min(temp * array[i], minEndingHere * array[i]));

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    // Variation 3: Maximum Subarray with At least K Elements
    public static int maxSubarrayAtLeastK(int[] array, int k) {
        if (array == null || array.length < k) {
            throw new IllegalArgumentException("Invalid Input");
        }

        // First, find sum of first K element
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += array[i];
        }

        int currentSum = maxSum;
        int prevSum = 0; // Best sum we can get before window of size k

        for (int i = k; i < array.length; i++) {
            // Add previous best if it's positive
            prevSum = Math.max(prevSum + array[i - k], 0);
            currentSum = currentSum + array[i] - array[i - k];
            maxSum = Math.max(maxSum, currentSum);
            maxSum = Math.max(maxSum, currentSum + prevSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println("Array: " + java.util.Arrays.toString(array));
        System.out.println("\nBrute Force Result: " + maxSubarrayBruteForce(array));
        System.out.println("Kadane's Algorithm Result: " + maxSubArrayKadane(array));
        System.out.println("\nWith Indices: " + maxSubarrayWithIndices(array));
    }
}