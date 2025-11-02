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

    // Cycle pattern 3: Cycle Detection
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        // Floyd's cycle detection
        public static boolean hasCycle(ListNode head) {
            System.out.println("\n--- Pattern 3: Cycle Detection (Tortoise and hare)");

            if (head == null) {
                return false;
            }

            ListNode slow = head, fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    System.out.println(" Cycle Detected!");
                    return true;
                }
            }

            System.out.println("No Cycle");
            return false;
        }
    }

    // Core Pattern 4: Partitioning
    // Dutch National Flag (3 - way partitioning)
    public static void sortColours(int[] array) {
        System.out.println("\n--- Pattern 4: Partitioning (Multiple pointers) ---");
        System.out.println("Problem: Sort 0s, 1s, 2s");
        System.out.println("Array: " + Arrays.toString(array));

        int left = 0, current = 0, right = array.length - 1;

        while (current <= right) {
            if (array[current] == 0) {
                swap(array, left++, current++);
            } else if (array[current] == 2) {
                swap(array, current, right--);
            } else {
                current++;
            }
        }

        System.out.println("Sorted: " + Arrays.toString(array));
    }

    // Advance Pattern 1: Multiple Pairs
    // 3Sum - Find all unique triplets that sum to zero
    public static List<List<Integer>> threeSum(int[] array) {
        System.out.println("\n--- Advanced Pattern 1: Multiple pairs (3 Sum)");
        System.out.println("Problem: Find triplets that sum to 0");
        System.out.println(" Array: " + Arrays.toString(array));

        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            // Skip duplicates for first element
            if (i > 0 && array[i] == array[i + 1]) {
                continue;
            }

            int left = i + 1, right = array.length + 1;
            int target = -array[i];

            System.out.println("\n Fix array[" + i + "]= " + array[i] + ", looking for pairs that sum to " + target);

            while (left < right) {
                int sum = array[left] + array[right];

                if (sum == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    System.out.println("Found: [" + array[i] + ", " + array[left] + ", " + array[right] + "]");

                    // Skip duplicates
                    while (left < right && array[left] == array[left + 1]) {
                        left++;
                    }

                    while (left < right && array[right] == array[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println("\n Total triplets found: " + result.size());
        return result;
    }

    // Advanced pattern 2: Merging
    // Merge two sorted arrays
    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        System.out.println("\n---Advanced Pattern 2: merging ---");
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));

        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                result[k] = array1[i];
                System.out.println("Take array1[" + i + "]=" + array1[i]);
                i++;
            } else {
                result[k] = array2[j];
                System.out.println("Take array2 [" + j + "]=" + array2[j]);
                j++;
            }

            k++;
        }

        while (i < array1.length) {
            result[k++] = array1[i++];
        }

        while (j < array2.length) {
            result[k++] = array2[j++];
        }

        System.out.println("Merged: " + Arrays.toString(result));
        return result;
    }

    // Advanced Pattern 3: Subsequence Matching
    // Is subsequence
    public static boolean isSubsequence(String s, String t) {
        System.out.println("\n---Advanced Pattern 3: Subsequence matching ---");
        System.out.println("Check if \"" + s + "\" us a subsequence of \"" + t + "\"");

        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            System.out.println("Comparing s[" + i + "]= " + s.charAt(i) + "' with t[" + j + "]='" + t.charAt(j) + "'");

            if (s.charAt(i) == t.charAt(j)) {
                System.out.println("Match! Advance both");
                i++;
            }

            j++;
        }

        boolean result = (i == s.length());
        System.out.println("Result: " + result);
        return result;
    }

    // Advanced Pattern 4: Trapping/Area problems
    // Trapping Rain Water
    public static int trapRainWater(int[] height) {
        System.out.println("\n---Advanced Pattern 4: Trapping Water");
        System.out.println("Heights: " + Arrays.toString(height));

        if (height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    int water = leftMax - height[left];
                    totalWater += water;
                    System.out.println("At index " + left + ": trapped " + water + " units");
                }

                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    int water = rightMax - height[right];
                    totalWater += water;
                    System.out.println("At index " + right + ": trapped " + water + " units");
                }

                right--;
            }
        }

        System.out.println("Total water trapped: " + totalWater);
        return totalWater;
    }

    // Advanced Pattern 5: Backspace String compare
    // Compare string with backspaces
    public static boolean backspaceCompare(String s, String t) {
        System.out.println("\n--- Advanced Pattern 5: Backspace comparison ---");
        System.out.println("String 1: \"" + s + "\"");
        System.out.println("String 2: \"" + t + "\"");

        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            // Find the next valid character in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            // Find the next valid character in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    System.out.println("Mismatch: '" + s.charAt(i) + "' vs '" + t.charAt(j) + "'");
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                System.out.println("Different lengths after backspaces");
                return false;
            }

            i--;
            j--;
        }

        System.out.println("Strngs are not equal!");
        return true;
    }

    // Advanced Patern 6: Partition with pivot
    // Sort array by parity (evens first, odds last)
    public static int[] sortByParity(int[] array) {
        System.out.println("\n--- Advanced Pattern 6: Partition by parity ---");
        System.out.println("Array: " + Arrays.toString(array));

        int left = 0, right = array.length - 1;

        while (left < right) {
            // Find odd numbers from left
            while (left < right && array[left] % 2 == 0) {
                left++;
            }

            // Find even numbers from right
            while (left < right && array[right] % 2 == 1) {
                right--;
            }

            if (left < right) {
                System.out.println(
                        "Swap array[" + left + "]=" + array[left] + "With array[" + right + "]=" + array[right]);
                swap(array, left, right);
                left++;
                right--;
            }
        }

        System.out.println("Result: " + Arrays.toString(array));
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
