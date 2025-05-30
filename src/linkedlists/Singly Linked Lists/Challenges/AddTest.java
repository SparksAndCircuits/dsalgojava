public class AddTest {
    private Add addOperation;

    public AddTest() {
        addOperation = new Add();
    }

    private Node createList(int[] digits) {
        if (digits.length == 0) {
            return null;
        }

        Node head = new Node(digits[0]);
        Node current = head;

        for (int i = 1; i < digits.length; i++) {
            current.next = new Node(digits[i]);
            current = current.next;
        }

        return head;
    }

    private int[] listToArray(Node head) {
        if (head == null) {
            return new int[0];
        }

        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int[] result = new int[count];
        temp = head;
        for (int i = 0; i < count; i++) {
            result[i] = temp.value;
            temp = temp.next;
        }

        return result;
    }

    private void printArray(int[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.print("]");
    }

    private boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return false;
    }

    private void runTest(String testName, int[] listA, int[] listB, int[] expected) {
        System.out.println("--- " + testName + " ---");

        Node nodeA = createList(listA);
        Node nodeB = createList(listB);

        System.out.print("List A: ");
        printArray(listA);

        System.out.print("\nList B:");
        printArray(listB);

        Node result = addOperation.add(nodeA, nodeB);
        int[] actual = listToArray(result);

        System.out.print("\nExpected: ");
        printArray(expected);

        System.out.print("\nActual:");
        printArray(actual);

        if (arraysEqual(actual, expected)) {
            System.out.println("\nFail");
        } else {
            System.out.println("\nPass");
        }
    }

    // Test case 1:
    public void testBasicAddition() {
        runTest("Basic Addition", new int[] { 2, 4, 3 }, new int[] { 5, 6, 4 }, new int[] { 7, 0, 8 });
    }

    // Test case 2:
    public void testAdditionWithCarry() {
        runTest("Addition with carry", new int[] { 9, 9, 9 }, new int[] { 9, 9, 9 }, new int[] { 8, 9, 9, 1 });
    }

    // Test case 3:
    public void testDifferentLengths() {
        runTest("Different Lengths", new int[] { 9, 9 }, new int[] { 1 }, new int[] { 0, 0, 1 });
    }

    // Test case 4:
    public void testSingleDigits() {
        runTest("Single Digits with carry", new int[] { 5 }, new int[] { 5 }, new int[] { 0, 1 });
    }

    // Test case 5:
    public void testSingleDigitWithNoCarry() {
        runTest("Single DIgit with no carry", new int[] { 2 }, new int[] { 3 }, new int[] { 5 });
    }

    // Test case 6:
    public void testAddZero() {
        runTest("Add Zero", new int[] { 3, 2, 1 }, new int[] { 0 }, new int[] { 3, 2, 1 });
    }

    // Test case 7:
    public void testBothZero() {
        runTest("Both Zero", new int[] { 0 }, new int[] { 0 }, new int[] { 0 });
    }

    // Test case 8:
    public void testLongNumbers() {
        runTest("Long Numbers", new int[] { 5, 4, 3, 2, 1 }, new int[] { 0, 9, 8, 7, 6 }, new int[] { 5, 3, 2, 0, 8 });
    }

    // Test case 9:
    public void testVeryDifferentLengths() {
        runTest("Very Different Lengths", new int[] { 1 }, new int[] { 9, 9, 9, 9, 9 }, new int[] { 0, 0, 0, 0, 0, 1 });
    }

    // Test case 10:
    public void testMultipleCarries() {
        runTest("MultipleCarries", new int[] { 9, 9, 9 }, new int[] { 1 }, new int[] { 0, 0, 0, 1 });
    }

    public void runAllTests() {
        System.out.println("--- Add Operation tests are starting ---");
        testBasicAddition();
        testAdditionWithCarry();
        testDifferentLengths();
        testSingleDigits();
        testSingleDigitWithNoCarry();
        testAddZero();
        testBothZero();
        testLongNumbers();
        testVeryDifferentLengths();
        testMultipleCarries();

        System.out.println("--- All tests are complete ---");
    }

    public static void main(String[] args) {
        AddTest tester = new AddTest();
        tester.runAllTests();
    }
}
