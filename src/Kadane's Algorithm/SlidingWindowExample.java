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

    // Example 2: Variable size window
    // Problem: Find smallest subarray with sum >= target

    public static int minSubarrayLen(int target, int[] array) {
        System.out.println("\n--- Variable window: Smallest subarray with sum >= " + target + " ---");
        System.out.println("Array: " + java.util.Arrays.toString(array));
        System.out.println();

        int minLen = Integer.MAX_VALUE;
        int windowSum = 0;
        int left = 0;
        int step = 1;

        for (int right = 0; right < array.length; right++) {
            // Expand: Add element to window
            windowSum += array[right];
            System.out.println("Step " + step + ": Expand window");
            System.out.println(" Window: [" + right + " ] = " + array[right]);
            System.out.println(" Window: [" + left + "-" + right + "]");
            System.out.println(" windowSum = " + windowSum);

            // Shrink: Remove elements while conditions is satisfied
            while (windowSum >= target) {
                int currentLen = right - left + 1;
                System.out.println(" Condition met! windowSum (" + windowSum + ") >= target (" + target + ")");
                System.out.println(" Current window length: " + currentLen);

                if (currentLen < minLen) {
                    minLen = currentLen;
                    System.out.println(" New min length found! minLen = " + minLen);
                }

                // Try to shrink
                System.out.println(" Attempting to shrink... ");
                System.out.println(" Remove array[ " + left + "] = " + array[left]);
                windowSum -= array[left];
                left++;
                System.out.println("  New windowSum = " + windowSum);
                System.out.println(" New window: [" + left + "-" + right + "]");
            }

            System.out.println();
            step++;
        }

        int result = minLen == Integer.MAX_VALUE ? 0 : minLen;
        System.out.println("Final Result: " + result);
        return result;
    }

    // Example 3: String - No repeating characters
    // Problem: Longest substring without repeating characters

    public static int longestUniqueSubstring(String s) {
        System.out.println("\n--- Variable window: Longest substring without repeating ---");
        System.out.println("String: \"" + s + "\"");
        System.out.println();

        java.util.Map<Character, Integer> charIndex = new java.util.HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            System.out.println("Step " + (right + 1) + ": Process '" + c + "' at index " + right);

            // If character exists in the current window
            if (charIndex.containsKey(c) && charIndex.get(c) >= left) {
                int oldLeft = left;
                left = charIndex.get(c) + 1;
                System.out.println(" Character '" + c + " ' aready in window at index " + charIndex.get(c));
                System.out.println(" Moving left pointer from " + oldLeft + " to" + left);
            }

            charIndex.put(c, right);
            int currentLen = right - left + 1;
            String currentWindow = s.substring(left, right + 1);
            System.out.println(" Window: [" + left + "-" + right + "] = ] \"" + currentWindow + "\"");
            System.out.println(" Length: " + currentLen);

            if (currentLen > maxLen) {
                maxLen = currentLen;
                System.out.println(" New maximum length! maxLen = " + maxLen);
            }

            System.out.println();
        }

        System.out.println("Final Result: " + maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        // Example 1: Fixed window
        int[] array1 = { 2, 1, 5, 1, 3, 2 };
        maxSumFixedWindow(array1, 3);

        // Example 2: Variable window (sum)
        int[] arr2 = { 2, 3, 1, 2, 4, 3 };
        minSubarrayLen(7, arr2);

        System.out.println("\n" + "=".repeat(70) + "\n");

        // Example 3: Variable window (string)
        longestUniqueSubstring("abcabcbb");
    }
}
