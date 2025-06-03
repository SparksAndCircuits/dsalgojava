public class ReverseBetweenTests {

    // Test case 1:
    public static void testBasicReverse() {
        System.out.println("Test case 1: Basic reverse(index 1 to 3)");
        ReverseBetween list = new ReverseBetween();
        list.createList(new int[] { 1, 2, 3, 4, 5 });

        System.out.print("Before: ");
        list.printList();

        list.reverseBetween(1, 3);

        System.out.print("After: ");
        list.printList();

        ReverseBetween expected = new ReverseBetween();
        expected.createList(new int[] { 1, 4, 3, 2, 5 });

        System.out.print("Expected:");
        expected.printList();

        boolean result = list.isEqual(expected);
        System.out.println("Result: " + (result ? "Pass" : "Fail"));

        System.out.println("Verification: ");
        System.out.println(" Position 0: " + list.getValueAt(0) + " (expected: 1)");
        System.out.println(" Position 1: " + list.getValueAt(1) + " (expected: 4)");
        System.out.println(" Position 2: " + list.getValueAt(2) + " (expected: 3)");
        System.out.println(" Position 3: " + list.getValueAt(3) + " (expected: 2)");
        System.out.println(" Position 4: " + list.getValueAt(4) + " (expected: 5)");
        System.out.println();
    }

    // Test case 2: reverse entire list
    public static void testReverseEntireList() {
        System.out.println("Test case 2: Reverse entire list (index 0 to 4)");
        ReverseBetween list = new ReverseBetween();
        list.createList(new int[] { 1, 2, 3, 4, 5 });

        System.out.print("Before: ");
        list.printList();

        list.reverseBetween(0, 4);

        System.out.print("After: ");
        list.printList();

        ReverseBetween expected = new ReverseBetween();
        expected.createList(new int[] { 5, 4, 3, 2, 1 });

        System.out.print("Expected: ");
        expected.printList();

        boolean result = list.isEqual(expected);
        System.out.println("Result: " + (result ? "Pass" : "Fail"));
        System.out.println("Length check: " + (list.getLength() == 5 ? "Pass" : "Fail"));
        System.out.println();
    }

    // Test case 3: Reverse single element (no change expected)
    public static void testReverseSingleElement() {
        System.out.println("Test case 3: Reverse single element (Index 2 to 2)");
        ReverseBetween list = new ReverseBetween();
        list.createList(new int[] { 1, 2, 3, 4, 5 });

        ReverseBetween original = new ReverseBetween();
        original.createList(new int[] { 1, 2, 3, 4, 5 });

        System.out.print("Before: ");
        list.printList();

        list.reverseBetween(2, 2);

        System.out.println("After: ");
        list.printList();

        System.out.println("Expected: ");
        original.printList();

        boolean result = list.isEqual(original);
        System.out.println("Result: " + (result ? "Pass" : "Fail"));
        System.out.println(
                "No change expected - middle element should remain: " + (list.getValueAt(2) == 3 ? "Pass" : "Fail"));
        System.out.println();
    }

    // Test case 4: Reverse first two elements
    public static void testReverseFirstTwoElements() {
        System.out.println("Test case 4: Reverse first two elements (index 0 to 1)");
        ReverseBetween list = new ReverseBetween();
        list.createList(new int[] { 1, 2, 3, 4, 5 });

        System.out.println("Before:");
        list.printList();

        list.reverseBetween(0, 1);

        System.out.print("After: ");
        list.printList();

        ReverseBetween expected = new ReverseBetween();
        expected.createList(new int[] { 2, 1, 3, 4, 5 });

        System.out.print("Expected: ");
        expected.printList();

        boolean result = list.isEqual(expected);
        System.out.println("Result: " + (result ? "Pass" : "Fail"));
        System.out.println("First element check: " + (list.getValueAt(0) == 2 ? "Pass" : "Fail"));
        System.out.println("First element check: " + (list.getValueAt(1) == 1 ? "Pass" : "Fail"));
        System.out.println();
    }

    // Test Case 5: Reverse last two elements
    public static void testReverseLastTwoElements() {
        System.out.println("Test Case 5: Reverse last two elements (index 3 to 4)");
        ReverseBetween list = new ReverseBetween();
        list.createList(new int[] { 1, 2, 3, 4, 5 });

        System.out.print("Before: ");
        list.printList();

        list.reverseBetween(3, 4);

        System.out.print("After:  ");
        list.printList();

        ReverseBetween expected = new ReverseBetween();
        expected.createList(new int[] { 1, 2, 3, 5, 4 });

        System.out.print("Expected: ");
        expected.printList();

        boolean result = list.isEqual(expected);
        System.out.println("Result: " + (result ? "PASS" : "FAIL"));
        System.out.println("Fourth element check: " + (list.getValueAt(3) == 5 ? "PASS" : "FAIL"));
        System.out.println("Fifth element check: " + (list.getValueAt(4) == 4 ? "PASS" : "FAIL"));
        System.out.println();
    }

    // Test Case 6: Reverse middle section
    public static void testReverseMiddleSection() {
        System.out.println("Test Case 6: Reverse middle section (index 2 to 5)");
        ReverseBetween list = new ReverseBetween();
        list.createList(new int[] { 1, 2, 3, 4, 5, 6, 7 });

        System.out.print("Before: ");
        list.printList();

        list.reverseBetween(2, 5);

        System.out.print("After:  ");
        list.printList();

        ReverseBetween expected = new ReverseBetween();
        expected.createList(new int[] { 1, 2, 6, 5, 4, 3, 7 });

        System.out.print("Expected: ");
        expected.printList();

        boolean result = list.isEqual(expected);
        System.out.println("Result: " + (result ? "PASS" : "FAIL"));
        System.out.println("Length preserved: " + (list.getLength() == 7 ? "PASS" : "FAIL"));
        System.out.println();
    }

    // Test Case 7: Empty list
    public static void testEmptyList() {
        System.out.println("Test Case 7: Empty list");
        ReverseBetween list = new ReverseBetween();
        list.createList(new int[] {});

        System.out.print("Before: ");
        list.printList();

        list.reverseBetween(0, 1); // Should handle gracefully

        System.out.print("After:  ");
        list.printList();

        boolean result = (list.head == null);
        System.out.println("Result: " + (result ? "PASS" : "FAIL"));
        System.out.println("Head is null: " + (list.head == null ? "PASS" : "FAIL"));
        System.out.println("Length is 0: " + (list.getLength() == 0 ? "PASS" : "FAIL"));
        System.out.println();
    }

    // Test Case 8: Single node list
    public static void testSingleNodeList() {
        System.out.println("Test Case 8: Single node list");
        ReverseBetween list = new ReverseBetween();
        list.createList(new int[] { 42 });

        System.out.print("Before: ");
        list.printList();

        list.reverseBetween(0, 0);

        System.out.print("After:  ");
        list.printList();

        boolean result = (list.getValueAt(0) == 42 && list.getLength() == 1);
        System.out.println("Result: " + (result ? "PASS" : "FAIL"));
        System.out.println("Value preserved: " + (list.getValueAt(0) == 42 ? "PASS" : "FAIL"));
        System.out.println("Length is 1: " + (list.getLength() == 1 ? "PASS" : "FAIL"));
        System.out.println();
    }

    // Test Case 9: Reverse from start to middle
    public static void testReverseFromStartToMiddle() {
        System.out.println("Test Case 9: Reverse from start to middle (index 0 to 2)");
        ReverseBetween list = new ReverseBetween();
        list.createList(new int[] { 1, 2, 3, 4, 5 });

        System.out.print("Before: ");
        list.printList();

        list.reverseBetween(0, 2);

        System.out.print("After:  ");
        list.printList();

        ReverseBetween expected = new ReverseBetween();
        expected.createList(new int[] { 3, 2, 1, 4, 5 });

        System.out.print("Expected: ");
        expected.printList();

        boolean result = list.isEqual(expected);
        System.out.println("Result: " + (result ? "PASS" : "FAIL"));
        System.out.println("New head value: " + (list.getValueAt(0) == 3 ? "PASS" : "FAIL"));
        System.out.println();
    }

    // Test Case 10: Reverse from middle to end
    public static void testReverseFromMiddleToEnd() {
        System.out.println("Test Case 10: Reverse from middle to end (index 2 to 4)");
        ReverseBetween list = new ReverseBetween();
        list.createList(new int[] { 1, 2, 3, 4, 5 });

        System.out.print("Before: ");
        list.printList();

        list.reverseBetween(2, 4);

        System.out.print("After:  ");
        list.printList();

        ReverseBetween expected = new ReverseBetween();
        expected.createList(new int[] { 1, 2, 5, 4, 3 });

        System.out.print("Expected: ");
        expected.printList();

        boolean result = list.isEqual(expected);
        System.out.println("Result: " + (result ? "PASS" : "FAIL"));
        System.out.println("Tail value: " + (list.getValueAt(4) == 3 ? "PASS" : "FAIL"));
        System.out.println();
    }

    // Test Case 11: Edge case where start equals end
    public static void testEdgeCaseStartEqualsEnd() {
        System.out.println("Test Case 11: Edge case start equals end (index 1 to 1)");
        ReverseBetween list = new ReverseBetween();
        list.createList(new int[] { 10, 20, 30 });

        ReverseBetween original = new ReverseBetween();
        original.createList(new int[] { 10, 20, 30 });

        System.out.print("Before: ");
        list.printList();

        list.reverseBetween(1, 1);

        System.out.print("After:  ");
        list.printList();

        System.out.print("Expected: ");
        original.printList();

        boolean result = list.isEqual(original);
        System.out.println("Result: " + (result ? "PASS" : "FAIL"));
        System.out.println("No change expected: " + (list.getValueAt(1) == 20 ? "PASS" : "FAIL"));
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Running ReverseBetween Test Cases\n");

        testBasicReverse();
        testReverseEntireList();
        testReverseSingleElement();
        testReverseFirstTwoElements();
        testReverseLastTwoElements();
        testReverseMiddleSection();
        testEmptyList();
        testSingleNodeList();
        testReverseFromStartToMiddle();
        testReverseFromMiddleToEnd();
        testEdgeCaseStartEqualsEnd();

        System.out.println("\nAll test cases completed!");
    }
}
