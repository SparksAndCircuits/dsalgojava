public class RemoveDuplicatesTest {

    private static boolean arrayEquals(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    // Test case 1:
    public static void testEmptyList() {
        System.out.println("Test 1: Empty list:");
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.removeDuplicates();

        int[] result = rd.toArray();
        assert result.length == 0;
        System.out.println("This test passed: The empty list was handled correctly\n");
    }

    // Test case 2:
    public static void testSingleNode() {
        System.out.println("Test 2: Single node");
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.addNode(5);

        System.out.println("Before removing duplicates:  ");
        rd.printList();

        rd.removeDuplicates();

        System.out.println("After removing duplicates: ");
        rd.printList();

        int[] result = rd.toArray();
        assert result.length == 1 && result[0] == 5 : "Expected single node with a value of 5";
        System.out.println("Test 2 has passed: Single node preserved\n");
    }

    // Test case 3:
    public static void testNoDuplicates() {
        System.out.println("Test 3: No Duplicates.");
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.addNode(1);
        rd.addNode(2);
        rd.addNode(3);
        rd.addNode(4);
        rd.addNode(5);

        System.out.print("Before: ");
        rd.printList();

        rd.removeDuplicates();

        System.out.print("After: ");
        rd.printList();

        int[] result = rd.toArray();
        int[] expected = { 1, 2, 3, 4 };
        assert arrayEquals(result, expected) : "Expected no changes to unique list";
        System.out.println("Test 3 passed: No duplicates list unchanges\n");
    }

    // Test case 4:
    public static void testAllDuplicates() {
        System.out.println("Test 4: All duplicates");
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.addNode(7);
        rd.addNode(7);
        rd.addNode(7);
        rd.addNode(7);

        System.out.print("Before removing duplicates: ");
        rd.printList();

        rd.removeDuplicates();

        System.out.print("After removing duplicates:");
        rd.printList();

        int[] result = rd.toArray();
        int[] expected = { 7 };
        assert arrayEquals(result, expected) : "Expected single element";
        System.out.println("Test 4 passed: All duplicates removed except for the first\n");
    }

    // Test 5:
    public static void testConsecutiveDuplicates() {
        System.out.println("Test 5: Consecutive Duplicates");
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.addNode(1);
        rd.addNode(1);
        rd.addNode(2);
        rd.addNode(2);
        rd.addNode(3);

        System.out.print("Before removing duplicates: ");
        rd.printList();

        rd.removeDuplicates();

        System.out.print("After removing duplicates: ");
        rd.printList();

        int[] result = rd.toArray();
        int[] expected = { 1, 2, 3 };
        assert arrayEquals(result, expected) : "Expected consecutive duplicates removed";
        System.out.println("Test 5 passed: Consecutive duplicates handled correctly\n");
    }

    // Test case 6:
    public static void testNonConsecutiveDuplicates() {
        System.out.println("Test 6: Non-Consecutive Duplicates");
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.addNode(1);
        rd.addNode(2);
        rd.addNode(3);
        rd.addNode(1);
        rd.addNode(2);

        System.out.print("Before: ");
        rd.printList();

        rd.removeDuplicates();

        System.out.print("After: ");
        rd.printList();

        int[] result = rd.toArray();
        int[] expected = { 1, 2, 3 };
        assert arrayEquals(result, expected) : "Expected non-consecutive duplicates removed";
        System.out.println("Test 6 passed: Non-Consecutive duplicates handled correctly\n");
    }

    // Test case 7:
    public static void testMixedDuplicates() {
        System.out.println("Test 7: Mixed Duplicates Pattern");
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.addNode(1);
        rd.addNode(2);
        rd.addNode(1);
        rd.addNode(3);
        rd.addNode(2);
        rd.addNode(4);
        rd.addNode(3);

        System.out.print("Before: ");
        rd.printList();

        rd.removeDuplicates();

        System.out.print("After: ");
        rd.printList();

        int[] result = rd.toArray();
        int[] expected = { 1, 2, 3, 4 };
        assert arrayEquals(result, expected) : "Expected mixed pattern duplicates removed";
        System.out.println("Test 7 passed: Mixed duplicates handled correctly\n");
    }

    // Test case 8:
    public static void testDuplicatesAtEnd() {
        System.out.println("Test 8: Duplicates at End");
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.addNode(1);
        rd.addNode(2);
        rd.addNode(3);
        rd.addNode(3);
        rd.addNode(3);

        System.out.print("Before: ");
        rd.printList();

        rd.removeDuplicates();

        System.out.print("After: ");
        rd.printList();

        int[] result = rd.toArray();
        int[] expected = { 1, 2, 3 };
        assert arrayEquals(result, expected) : "Expected duplicates at end removed";
        System.out.println("Test 8 passed: Duplicates at the end handled correctly\n");
    }

    // Test case 9:
    public static void testLargeList() {
        System.out.println("Test 9: Large List");
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] input = { 1, 5, 3, 8, 5, 2, 1, 9, 3, 7, 8, 4, 2, 6, 9 };

        for (int val : input) {
            rd.addNode(val);
        }

        System.out.print("Before: ");
        rd.printList();

        rd.removeDuplicates();

        System.out.print("After: ");
        rd.printList();

        int[] result = rd.toArray();
        int[] expected = { 1, 5, 3, 8, 2, 9, 7, 4, 6 };
        assert arrayEquals(result, expected) : "Expected large list duplicates removed";
        System.out.println("Test 9 passed: Large list handled correctly\n");
    }

    // Test 10:
    public static void testNegativeNumbers() {
        System.out.println("Test 10: Negative Numbers");
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.addNode(-1);
        rd.addNode(0);
        rd.addNode(-1);
        rd.addNode(1);
        rd.addNode(0);
        rd.addNode(-2);

        System.out.print("Before: ");
        rd.printList();

        rd.removeDuplicates();

        System.out.print("After: ");
        rd.printList();

        int[] result = rd.toArray();
        int[] expected = { -1, 0, 1, -2 };
        assert arrayEquals(result, expected) : "Expected negative number duplicates removed";
        System.out.println("Test 10 passed: Negative numbers handled correctly\n");
    }

    public static void main(String[] args) {
        System.out.println("--- Running remove duplicate test cases. ---");

        testEmptyList();
        testSingleNode();
        testNoDuplicates();
        testAllDuplicates();
        testConsecutiveDuplicates();
        testNonConsecutiveDuplicates();
        testMixedDuplicates();
        testDuplicatesAtEnd();
        testLargeList();
        testNegativeNumbers();

        System.out.println("All test cases completed!");
    }
}
