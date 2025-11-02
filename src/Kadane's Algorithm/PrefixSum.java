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

    public static void demonstrateRangeSumQuery(){
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6};
        RangeSumQuery rsq = new RangeSumQuery(array);
        rsq.sumRange(2, 5);
        rsq.sumRange(0, 3);
        rsq.sumRange(4, 7);
    }

    
}
