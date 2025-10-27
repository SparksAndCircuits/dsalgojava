public class SlidingWindowExample {
    // Example 1: Fixed size window
    // Problem 1: Finding maximum sum of any 3 consecutive elements

    public static int maxSumFixedWindow(int[] array, int k) {
        System.out.println("\n=== Fixed Window: Maximum Sum of " + k + " consecutive elements ===");
        System.out.println("Array: " + java.util.Arrays.toString(array));
        System.out.println();

        // Step 1: Calculate the sum of the first window
        int windowSum = 0;
        System.out.println("Step 1: Build initial window");
        for (int i = 0; i < k; i++) {
            windowSum += array[i];
            System.out.println(" Adding array[" + i + "] = " + array[i] + " -> windowSum = " + windowSum);
        }

        System.out.println(" Initial window: indices [0-" + (k - 1) + "], sum = " + windowSum);

        int maxSum = windowSum;
        System.out.println(" maxSum = " + maxSum);

        // Step 2: Slide the window
        System.out.println("\nStep 2: Slide the window");
        for (int i = k; i < array.length; i++) {
            int removed = array[i - k];
            int added = array[i];
            windowSum = windowSum - removed + added;

            System.out.println("Window [" + (i - k + 1) + "-" + i + "]:");
            System.out.println(" Remove array[" + (i - k) + "] = " + removed);
            System.out.println(" Add array[" + i + "] = " + added);
            System.out.println(" windowSum = " + windowSum);

            if (windowSum > maxSum) {
                maxSum = windowSum;
                System.out.println(" - New maximum found! maxSum = " + maxSum);
            }
        }

        System.out.println("\nFinal Result: " + maxSum);
        return maxSum;
    }

    public static void main(String[] args) {
        // Example 1: Fixed window
        int[] array1 = { 2, 1, 5, 1, 3, 2 };
        maxSumFixedWindow(array1, 3);
    }
}
