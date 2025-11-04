import java.util.*;

public class PrefixSum {
    // Problem 1: Basic range sum query

    static class RangeSumQuery {
        private int[] prefix;

        public RangeSumQuery(int[] array) {
            System.out.println("\n--- Problem 1: Range sum query ---");
            System.out.println("Original array: " + Arrays.toString(array));
            System.out.println("\nBuilding prefix sum array: ");

            int n = array.length;
            prefix = new int[n + 1];
            prefix[0] = 0; // Dummy

            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + array[i];
                System.out.println("Prefix[" + (i + 1) + "] = prefix[" + i + "] + array[" + i + "] = " + prefix[i]
                        + " + " + array[i] + " = " + prefix[i + 1]);
            }

            System.out.println("\nFinal prefix array: " + Arrays.toString(prefix));
        }

        public int sumRange(int left, int right) {
            System.out.println("\nQuery: sum from index " + left + " to " + right);
            int sum = prefix[right + 1] - prefix[left];
            System.out.println("prefix[" + (right + 1) + "] - prefix[" + left + "]=" + prefix[right + 1] + " - "
                    + prefix[left] + "=" + sum);
            return sum;
        }
    }

    public static void demonstrateRangeSumQuery() {
        int[] array = { 3, 1, 4, 1, 5, 9, 2, 6 };
        RangeSumQuery rsq = new RangeSumQuery(array);
        rsq.sumRange(2, 5);
        rsq.sumRange(0, 3);
        rsq.sumRange(4, 7);
    }

    // Problem 2: Subarray sum equals k
    public static int subarraySumEqualsK(int[] array, int k) {
        System.out.println("\n--- Problem 2: Subarray sum equals k ---");
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Target K: " + k);
        System.out.println("\nStep-by-Step process:");

        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // Empty prefix

        int count = 0;
        int currentSum = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];

            System.out.println("\nIndex " + i + ": array[" + i + "] = " + array[i]);
            System.out.println("CurrentSum = " + currentSum);

            int target = currentSum - k;
            System.out.println("Looking for prefix sum = " + target + " (currentSum - k)");

            if (prefixCount.containsKey(target)) {
                int occurrences = prefixCount.get(target);
                count += occurrences;
                System.out.println("Found " + occurrences + " occurrence(s)!");
                System.out.println("Total count now = " + count);
            } else {
                System.out.println("Not found!");
            }

            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
            System.out.println("Updated map: " + prefixCount);
        }

        System.out.println("\nTotal subarrays with sum = " + k + ": " + count);
        return count;
    }

    public static void demonstrateSubarraySum() {
        int[] array = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
        int k = 3;
        subarraySumEqualsK(array, k);
    }

    // Problem 3: Countiguous Array (Equals 0s and 1s)
    public static int findMaxLengthEqualsZerosOnes(int[] array) {
        System.out.println("\n--- Problem 3: Longest subarray with quals 0s and 1s ---");
        System.out.println("original array: " + Arrays.toString(array));

        // Transform: 0 -> -1, keep 1 as 1
        int[] transformed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            transformed[i] = (array[i] == 0) ? -1 : 1;
        }

        System.out.println("Transformed: " + Arrays.toString(transformed));
        System.out.println("(Now looking for longest subarray with sum = 0)");

        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        firstOccurrence.put(0, -1); // Before array starts.

        int maxLen = 0;
        int sum = 0;
        String longestSubarray = "";

        System.out.println("\nStep-by-Step");
        for (int i = 0; i < transformed.length; i++) {
            sum += transformed[i];

            System.out.println("\nIndex " + i + ": value = " + transformed[i] + "(original = " + array[i] + ")");
            System.out.println("Running sum = " + sum);

            if (firstOccurrence.containsKey(sum)) {
                int firstIndex = firstOccurrence.get(sum);
                int length = i - firstIndex;
                System.out.println("Sum: " + sum + " seen at index " + firstIndex);
                System.out
                        .println("Subarray length: " + length + " (from index " + (firstIndex + 1) + " to " + i + ")");

                if (length > maxLen) {
                    maxLen = length;
                    longestSubarray = Arrays.toString(Arrays.copyOfRange(array, firstIndex + 1, i + 1));
                    System.out.println("New maximum length: " + maxLen);
                }
            } else {
                System.out.println("First time seeing sum = " + sum);
                firstOccurrence.put(sum, i);
            }

            System.out.println("Map: " + firstOccurrence);
        }

        System.out.println("\nLongest subarray: " + longestSubarray);
        System.out.println("Length: " + maxLen);
        return maxLen;
    }

    public static void demonstrateContiguousArray() {
        int[] array = { 0, 1, 0, 1, 1, 0, 0, 1 };
        findMaxLengthEqualsZerosOnes(array);
    }

    // Problem 4: Product except self
    public static int[] productExceptSelf(int[] array) {
        System.out.println("\n--- Problem 4: Product of Array except self ---");
        System.out.println("Array: " + Arrays.toString(array));

        int n = array.length;
        int[] result = new int[n];

        // Step 1: Left prefix products
        System.out.println("\nStep 1: Build prefix products");
        result[0] = 1;
        System.out.println("result[0] = 1 (No elements to the left.)");

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * array[i - 1];
            System.out.println("Result[" + i + "] = result[" + (i - 1) + "] x array[" + (i - 1) + "] = " + result[i - 1]
                    + " x " + array[i - 1] + " = " + result[i]);
        }
        System.out.println("After left pass: " + Arrays.toString(result));

        // Step 2: Right prefix products
        System.out.println("\nStep 2: Multiply by right prefix products");
        int rightProduct = 1;
        System.out.println("rightProduct = 1 (no elements to the right of last)");

        for (int i = n - 1; i >= 0; i--) {
            System.out.println("\nIndex " + i + "] = " + result[i] + " (left products)");
            result[i] = result[i] * rightProduct;
            System.out.println("After: result[" + i + "] = " + result[i] + " (left x right)");
            rightProduct += array[i];
            System.out.println("update rightProduct: " + rightProduct);
        }

        System.out.println("\n Final result: " + Arrays.toString(result));
        return result;
    }

    public static void demonstrateProductExceptSelf() {
        int[] array = { 2, 3, 4, 5 };
        productExceptSelf(array);
    }

    // Problem 5: Range updates(Different arrays)
    static class RangeUpdateArray {
        private int[] diff;
        private int n;

        public RangeUpdateArray(int[] array) {
            System.out.println("\n--- Problem 5: Range updates ---");
            System.out.println("Original Array: " + Arrays.toString(array));

            n = array.length;
            diff = new int[n + 1];

            System.out.println("\nBuilding difference array:");
            diff[0] = array[0];
            System.out.println("diff[0] = array[0] = " + diff[0]);

            for (int i = 1; i < n; i++) {
                diff[i] = array[i] - array[i - 1];
                System.out.println("Diff[" + i + "] = array[" + i + "] - array[" + (i - 1) + "] = " + array[i] + " - "
                        + array[i - 1] + " = " + diff[i]);
            }

            System.out.println("Difference array: " + Arrays.toString(Arrays.copyOf(diff, n)));
        }

        public void rangeUpdate(int left, int right, int val) {
            System.out.println("\n--- Range update ---");
            System.out.println("Add " + val + " to range [" + left + ", " + right + "]");
            System.out.println("Before: diff = " + Arrays.toString(Arrays.copyOf(diff, n)));

            diff[left] += val;
            System.out.println("diff[" + left + "] += " + val + " -> diff[" + left + "] = " + diff[left]);

            if (right + 1 < n) {
                diff[right + 1] -= val;
                System.out.println(
                        "diff[" + (right + 1) + "] -= " + val + " -> diff[" + (right + 1) + "] = " + diff[right + 1]);
            }

            System.out.println("After: diff = " + Arrays.toString(Arrays.copyOf(diff, n)));
        }

        public int[] getArray() {
            System.out.println("\n--- Reconstructing Array ---");
            int[] result = new int[n];
            result[0] = diff[0];
            System.out.println("result[0] = diff[0] = " + result[0]);

            for (int i = 1; i < n; i++) {
                result[i] = result[i - 1] + diff[i];
                System.out.println("result[" + i + "] = reuslt[" + (i - 1) + "] + diff[" + i + "] = " + result[i - 1]
                        + " + " + diff[i] + " = " + result[i]);
            }

            System.out.println("Final array: " + Arrays.toString(result));
            return result;
        }

        public static void demonstrateRangeUpdates() {
            int[] array = { 5, 2, 8, 3, 9 };
            RangeUpdateArray rua = new RangeUpdateArray(array);

            rua.rangeUpdate(1, 3, 10); // Add 10 to indices 1 - 3
            rua.rangeUpdate(0, 2, -5); // Add -5 to indices 0 - 2
            rua.getArray();
        }
    }
}
