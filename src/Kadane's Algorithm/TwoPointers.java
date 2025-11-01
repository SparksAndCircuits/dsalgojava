import java.util.*;

public class TwoPointers {
    // Core pattern 1: opposite ends
    // Two Sum - sorted array
    public static int[] twoSumSorted(int[] array, int target) {
        System.out.println("\n --- Pattern 1: Opposite Ends ---");
        System.out.println("Problem: Two Sum in sorted array");
        System.out.println("Array: " + Arrays.toString(array) + ", target: " + target);

        int left = 0, right = array.length - 1;

        while (left < right) {
            int sum = array[left] + array[right];
            System.out.println(" Left = " + left + " (" + array[left] + "), right = " + right + " (" + array[right]
                    + "), sum = " + sum);

            if (sum == target) {
                System.out.println("Target was found!");
                return new int[] { left, right };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { -1, 1 };
    }

    // Core pattern 2: Same Direction
    // Remove duplicates from a sorted array
    public static int removeDuplicates(int[] array) {
        System.out.println("\n---Pattern 2: Same Direction (Fast & Slow) ---");
        System.out.println("Problem: Remove duplicates in-place");
        System.out.println("Array: " + Arrays.toString(array));

        if (array.length == 0) {
            return 0;
        }

        int slow = 0;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] != array[slow]) {
                slow++;
                array[slow] = array[fast];
                System.out.println(" Moved Array[" + fast + "]= " + array[fast] + " to position " + slow);
            }
        }

        System.out.println(" Result: " + (slow + 1) + " unique elements");
        return slow + 1;
    }
}
