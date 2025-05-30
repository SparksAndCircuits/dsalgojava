public class FindMiddleNodeTest {
    private FindMiddleNode list;

    public FindMiddleNodeTest() {
        list = new FindMiddleNode();
    }

    private void setupList() {
        list = new FindMiddleNode();
    }

    private void addValues(int[] values) {
        for (int value : values) {
            list.append(value);
        }
    }

    private void printListWithPositions() {
        if (list.head == null) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");
        Node current = list.head;
        int position = 1;
        while (current != null) {
            System.out.print(current.value + "(Position: " + position + " )");

            if (current.next != null) {
                System.out.print(", ");
            }

            current = current.next;
            position++;
        }

        System.out.print("]");
    }

    private int getListSize() {
        int size = 0;
        Node current = list.head;
        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }

    private int getExpectedMiddlePosition(int size) {
        if (size == 0) {
            return 0;
        }
        if (size % 2 == 1) {
            return (size + 1) / 2;
        } else {
            return size / 2 + 1;
        }
    }

    private Node getNodeAtPosition(int position) {
        if (position <= 0) {
            return null;
        }

        Node current = list.head;

        for (int i = 1; i < position && current != null; i++) {
            current = current.next;
        }

        return current;
    }

    private void runTest(String testName, int[] listValues, Integer expectedValue, int expectedPosition) {
        System.out.println("--- " + testName + " ---");

        setupList();
        addValues(listValues);

        int size = getListSize();
        System.out.print("List: ");
        printListWithPositions();
        System.out.println("\nList size: " + size);

        if (size > 0) {
            int calculateMiddlePos = getExpectedMiddlePosition(size);
            System.out.println("Expected middle position: " + calculateMiddlePos
                    + (size % 2 == 0 ? "(2nd middle for even length)" : "(true middle for odd length)"));
        }

        Node result = list.findMiddleNode();

        if (expectedValue == null) {
            System.out.println("Expected: null");
            System.out.println("Actual: " + (result == null ? "null" : result.value));

            if (result == null) {
                System.out.println("This test was passed.");
            } else {
                System.out.println("This test was failed.");
            }
        } else {
            System.out.println("Expected: " + expectedValue + " at position " + expectedPosition);
            System.out.println("Actual: " + (result == null ? "null" : result.value));

            if (result != null && result.value == expectedValue) {
                System.out.println("This test has passed.");
            } else {
                System.out.println("This test has failed");
            }
        }
    }

    // Test case 1:
    public void testEmptyList() {
        runTest("Empty List", new int[] {}, null, 0);
    }

    // Test case 2:
    public void testSingleNode() {
        runTest("Single Node", new int[] { 42 }, 42, 1);
    }

    // Test case 3:
    public void testTwoNodes() {
        runTest("Two Nodes(Even)", new int[] { 1, 2 }, 2, 2);
    }

    // Test case 4:
    public void testThreeNodes() {
        runTest("Three Nodes (Odd)", new int[] { 1, 2, 3 }, 2, 2);
    }

    // Test case 5:
    public void testFourNodes() {
        runTest("Four Nodes (Even)", new int[] { 1, 2, 3, 4 }, 3, 3);
    }

    // Test case 6:
    public void testFiveNodes() {
        runTest("Five Nodes (Odd)", new int[] { 1, 2, 3, 4, 5 }, 3, 3);
    }

    // Test case 7:
    public void testSixNodes() {
        runTest("Six Nodes (Even)", new int[] { 1, 2, 3, 4, 5, 6 }, 4, 4);
    }

    // Test case 8:
    public void testSevenNodes() {
        runTest("Seven Nodes (Odd)", new int[] { 10, 20, 30, 40, 50, 60, 70 }, 40, 4);
    }

    // Test case 9:
    public void testEightNodes() {
        runTest("Eight Nodes (Even)", new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 5, 5);
    }

    // Test case 10:
    public void testLargeOddList() {
        runTest("Nine nodes (Large Odd)", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 5, 5);
    }

    // Test case 11:
    public void testLargeEvenList() {
        runTest("Ten Nodes (Large Even)", new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 6, 6);
    }

    // Test case 12:
    public void testWithDuplicates() {
        runTest("Duplicates - Odd length", new int[] { 5, 5, 3, 3, 5 }, 3, 3);
        runTest("Duplicates - Even Length", new int[] { 1, 1, 2, 2, 3, 3 }, 2, 4);
    }

    // Test case 13:
    public void testWithNegativeNumbers() {
        runTest("Negative Numbers - Odd", new int[] { -3, -2, -1, 0, 1 }, -1, 3);
        runTest("Negative Numbers - Even", new int[] { -4, -3, -2, -1 }, -2, 3);
    }

    private int findPosition(Node target) {
        Node current = list.head;
        int position = 1;
        while (current != null) {
            if (current == target) {
                return position;
            }

            current = current.next;
            position++;
        }

        return -1;
    }

    public void demonstrateAlgorithm() {
        System.out.println("--- Algorithm Demonstration ---");
        setupList();
        addValues(new int[] { 1, 2, 3, 4, 5, 6 });
        System.out.print("\nList: ");
        printListWithPositions();
        System.out.println("Step-by-Step execution: ");

        Node slow = list.head;
        Node fast = list.head;
        int step = 0;

        System.out.printf("Step %d: slow=pos%d(val:%d), fast=pos%d(val:%d)%n", step, findPosition(slow), slow.value,
                findPosition(fast), fast.value);

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            step++;

            System.out.printf("Step %d: slow=pos%d(val:%d), fast=%s%n", step, findPosition(slow), slow.value,
                    fast != null ? "pos" + findPosition(fast) + "(val:" + fast.value + ")" : "null");
        }

        System.out.println("Result: Middle node is " + slow.value + " at position " + findPosition(slow));
    }

    public void runAllTests() {
        System.out.println("--- Starting Find Middle Node Tests ---");
        testEmptyList();
        testSingleNode();
        testTwoNodes();
        testThreeNodes();
        testFourNodes();
        testFiveNodes();
        testSixNodes();
        testSevenNodes();
        testEightNodes();
        testLargeOddList();
        testLargeEvenList();
        testWithDuplicates();
        testWithNegativeNumbers();

        System.out.println("--- All tests have been completed ---");
    }

    public static void main(String[] args) {
        FindMiddleNodeTest tester = new FindMiddleNodeTest();
        tester.runAllTests();
    }
}
