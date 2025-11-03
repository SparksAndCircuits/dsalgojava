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
}
