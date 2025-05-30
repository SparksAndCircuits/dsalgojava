public class FindKthFromTheEndTest {
    private FindKthLoopFromTheEnd list;

    public FindKthFromTheEndTest() {
        list = new FindKthLoopFromTheEnd();
    }

    public void setupList() {
        list = new FindKthLoopFromTheEnd();
    }

    private void addValues(int[] values) {
        for (int value : values) {
            list.append(value);
        }
    }

    private void printList() {
        if (list.head == null) {
            System.out.print("[]");
            return;
        }

        System.out.print("[");
        Node current = list.head;

        while (current != null) {
            System.out.print(current.value);

            if (current.next != null) {
                System.out.print(", ");
            }

            current = current.next;
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

    private void runTest(String testName, int[] listValues, int k, Integer expectedValue) {
        System.out.println("--- " + testName + " ---");

        setupList();
        addValues(listValues);

        System.out.print("List: ");
        printList();
        System.out.println("List Size: " + getListSize());
        System.out.println("Looking for " + k + " th node from the end");

        Node result = list.findKthLoopFromTheEnd(k);

        if (expectedValue == null) {
            System.out.println("Expected: null");
            System.out.println("Actual: " + (result == null ? "null" : result.value));

            if (result == null) {
                System.out.println("This test has passed");
            } else {
                System.out.println("This test has failed.");
            }
        } else {
            System.out.println("Expected: " + expectedValue);
            System.out.println("Actual: " + (result == null ? "null" : result.value));

            if (result != null && result.value == expectedValue) {
                System.out.println("The test has passed");
            } else {
                System.out.println("The test has failed");
            }
        }
    }

    // Test Case
    public void testBasicFunctionality() {
        int[] values = { 1, 2, 3, 4, 5 };
        runTest("1st from the end", values, 1, 5);
        runTest("2nd from the end", values, 2, 4);
        runTest("3rd from the end", values, 3, 3);
        runTest("4th from the end", values, 4, 2);
        runTest("5th from the end", values, 5, 1);
    }

    public void testSingleElement() {
        int[] values = { 42 };

        runTest("Single element - 1st from end", values, 1, 42);
        runTest("Single element - 2nd from end", values, 2, null);
    }

    public void testTwoElement() {
        int[] values = { 10, 20 };
        runTest("Two Elements - 1st from the end", values, 1, 20);
        runTest("Two Elements - 2nd from the end", values, 2, 10);
        runTest("Two elements - 3rd from the end", values, 3, null);
    }

    public void testEmptyList() {
        int[] values = {};
        runTest("Empty list - 1st from the end", values, 1, null);
        runTest("Empty list - 5th from the end", values, 5, null);
    }

    public void testKGreaterThanListSize() {
        int[] values = { 1, 2, 3 };
        runTest("K = 4 with 3 elements", values, 4, null);
        runTest("K = 10 with 3 elements", values, 10, null);
    }

    public void testKEqualsToListSize() {
        int[] values = { 7, 8, 9, 10 };
        runTest("K equals list size", values, 4, 7);
    }

    public void testKIsZerp() {
        int[] values = { 1, 2, 3 };
        runTest("K is Zero", values, 0, null);
    }

    public void testLargerList() {
        int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        runTest("Large List - 1st from the end", values, 1, 10);
        runTest("Large List - 5th from the end", values, 5, 6);
        runTest("Large List - 10th from the end", values, 10, 1);
    }

    public void testDuplicateValues() {
        int[] values = { 5, 3, 5, 3, 5 };

        runTest("Duplicates - 1st from the end", values, 1, 5);
        runTest("Duplicates - 2nd from the end", values, 2, 3);
        runTest("Duplicates - 3rd from the end", values, 3, 5);
        runTest("Duplicates - 4th from the end", values, 4, 3);
        runTest("Duplicates - 5th from the end", values, 5, 5);
    }

    public void testNegativeK() {
        int[] values = { 1, 2, 3 };
        runTest("Negative K (-1)", values, -1, null);
        runTest("Negative K (-5)", values, -5, null);
    }

    public void testAppendFunctionality() {
        System.out.println("--- Testing append functionality --- ");

        setupList();
        System.out.println("Initial list: ");
        printList();

        System.out.println("Appending 1: ");
        list.append(1);
        System.out.println("List after appending: ");
        printList();

        System.out.println("Appending 2,3,4: ");
        list.append(2);
        list.append(3);
        list.append(4);
        System.out.println("After appending: ");
        printList();
    }

    public void runAllTests() {
        System.out.println("--- FindKthFromTheEnd tests are starting ---");
        testBasicFunctionality();
        testSingleElement();
        testTwoElement();
        testEmptyList();
        testKGreaterThanListSize();
        testKEqualsToListSize();
        testKIsZerp();
        testLargerList();
        testDuplicateValues();
        testNegativeK();
        testAppendFunctionality();

        System.out.println("All tests have been completed.");
    }

    public static void main(String[] args) {
        FindKthFromTheEndTest tester = new FindKthFromTheEndTest();
        tester.runAllTests();
    }

}
