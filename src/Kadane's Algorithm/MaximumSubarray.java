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

    public static void main(String[] args) {
        int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println("Array: " + java.util.Arrays.toString(array));
        System.out.println("\nBrute Force Result: " + maxSubarrayBruteForce(array));
        System.out.println("Kadane's Algorithm Result: " + maxSubArrayKadane(array));
        System.out.println("\nWith Indices: " + maxSubarrayWithIndices(array));
    }
}