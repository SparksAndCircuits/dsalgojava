import java.util.*;

public class SlidingWindow {

    // Fixed Size Window

    // Problem 1: Maximum sum of K consecutive elements
    public static int maxSumFixedWindow(int[] array, int k) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        // Calculate sum of the first window.
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += array[i];
        }

        int maxSum = windowSum;

        // Slide the window: add next element, remove first element
        for (int i = k; i < array.length; i++) {
            windowSum = windowSum + array[i] - array[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // Problem 2: Average of all K-size subarrays
    public static double[] averageOfSubarrays(int[] array, int k) {
        if (array == null || array.length == 0) {
            return new double[0];
        }

        double[] result = new double[array.length - k + 1];
        double windowSum = 0;

        // first window
        for (int i = 0; i < k; i++) {
            windowSum += array[i];
        }

        result[0] = windowSum / k;

        // Slide the window
        for (int i = k; i < array.length; i++) {
            windowSum = windowSum + array[i] - array[i - k];
            result[i - k + 1] = windowSum / k;
        }

        return result;
    }

    // Variable size window

    // problem 3: Smallest subarray with sum >= target
    public static int minSubArrayLen(int target, int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int minLen = Integer.MAX_VALUE;
        int windowSum = 0;
        int left = 0;

        for (int right = 0; right < array.length; right++) {
            windowSum += array[right];

            // Shrink window while condition is met
            while (windowSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                windowSum -= array[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // Problem 4: Longest substring without repeating characters
    public static int longestSubstringWithoutRepeating(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If character alread in window, move left pointer
            if (charIndex.containsKey(c)) {
                left = Math.max(left, charIndex.get(c) + 1);
            }

            charIndex.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Problem 5: Longest substring with at most k distinct characters.
    public static int longestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

            // Shrink window if too many distinct characters
            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);

                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Problem 6: Maximum of all subarrays of size k (using deqeue)
    public static int[] maxSlidingWindow(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }

        int[] result = new int[array.length - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // Stores indices

        for (int i = 0; i < array.length; i++) {
            // Remove elements outside current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements (They're useless)
            while (!deque.isEmpty() && array[deque.peekLast()] < array[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Add to result once window is full
            if (i >= k - 1) {
                result[i - k + 1] = array[deque.peekFirst()];
            }
        }

        return result;
    }

    // Problem 7: Fruits into baskets (max 2 types in window)
    public static int maxFruitsInBaskets(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }

        Map<Integer, Integer> fruitCount = new HashMap<>();
        int maxFruits = 0;
        int left = 0;

        for (int right = 0; right < fruits.length; right++) {
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            // More than 2 types of fruits
            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);

                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }

                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    // Problem 8: Minimum window substring containing all characters of target
    public static String minWindowSubstring(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCount = new HashMap<>();
        int required = targetCount.size();
        int formed = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (targetCount.containsKey(c) && windowCount.get(c).intValue() == targetCount.get(c).intValue()) {
                formed++;
            }

            // Try to shrink window
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLen = left;
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                if (targetCount.containsKey(leftChar) && windowCount.get(leftChar) < targetCount.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    // Problem 9: count subarrays with product less than k
    public static int numSubarrayProductLessThanK(int[] array, int k) {
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < array.length; right++) {
            product *= array[right];

            while (product >= k) {
                product /= array[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== FIXED SIZE WINDOW ===");
        int[] arr1 = { 2, 1, 5, 1, 3, 2 };
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Max sum (k=3): " + maxSumFixedWindow(arr1, 3));
        System.out.println("Averages (k=3): " + Arrays.toString(averageOfSubarrays(arr1, 3)));

        System.out.println("\n=== VARIABLE SIZE WINDOW ===");
        int[] arr2 = { 2, 3, 1, 2, 4, 3 };
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Min length with sum >= 7: " + minSubArrayLen(7, arr2));

        System.out.println("\n=== STRING PROBLEMS ===");
        String s1 = "abcabcbb";
        System.out.println("String: " + s1);
        System.out.println("Longest without repeating: " + longestSubstringWithoutRepeating(s1));

        String s2 = "eceba";
        System.out.println("\nString: " + s2);
        System.out.println("Longest with 2 distinct: " + longestSubstringKDistinct(s2, 2));

        System.out.println("\n=== MAX SLIDING WINDOW ===");
        int[] arr3 = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("Max in each window (k=3): " + Arrays.toString(maxSlidingWindow(arr3, 3)));

        System.out.println("\n=== MINIMUM WINDOW SUBSTRING ===");
        String s3 = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("String: " + s3 + ", Target: " + t);
        System.out.println("Minimum window: " + minWindowSubstring(s3, t));

        System.out.println("\n=== PRODUCT LESS THAN K ===");
        int[] arr4 = { 10, 5, 2, 6 };
        System.out.println("Array: " + Arrays.toString(arr4));
        System.out.println("Subarrays with product < 100: " + numSubarrayProductLessThanK(arr4, 100));
    }
}
