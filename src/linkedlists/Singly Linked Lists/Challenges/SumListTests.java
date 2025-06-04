public class SumListTests {
    private static SinglyLinkedList createNumberList(int... digits) {
        if (digits.length == 0)
            return null;

        SinglyLinkedList list = new SinglyLinkedList(digits[0]);

        for (int i = 1; i < digits.length; i++) {
            list.insert1(digits[i]);
        }

        return list;
    }

    private static void printNumber(SinglyLinkedList list, String label) {
        System.out.print(label + ": ");
        if (list == null || list.head == null) {
            System.out.println("Empty");
            return;
        }

        Node current = list.head;
        while (current != null) {
            System.out.print(current.value);
            current = current.next;
        }
        System.out.println();
    }

    private static int linkedListToNumber(SinglyLinkedList list) {
        if (list == null || list.head == null)
            return 0;

        int number = 0;
        int multiplier = 1;
        Node current = list.head;

        while (current != null) {
            number += current.value * multiplier;
            multiplier *= 10;
            current = current.next;
        }

        return number;
    }

    private static void testBasicAddition() {
        System.out.println("TEST 1: Basic Addition (No Carry)");

        SinglyLinkedList num1 = createNumberList(2, 4, 3);
        SinglyLinkedList num2 = createNumberList(5, 6, 4);

        printNumber(num1, "Number 1 (342)");
        printNumber(num2, "Number 2 (465)");

        SumList sumList = new SumList();
        SinglyLinkedList result = sumList.sumList(num1, num2);

        printNumber(result, "Result");
        System.out.println("Expected: 7->0->8 (represents 807)");
        System.out.println("Actual sum: " + linkedListToNumber(result));
        System.out.println("Expected sum: 807");
        System.out.println();
    }

    private static void testAdditionWithCarry() {
        System.out.println("TEST 2: Addition with Carry");

        SinglyLinkedList num1 = createNumberList(9, 9);
        SinglyLinkedList num2 = createNumberList(9);

        printNumber(num1, "Number 1 (99)");
        printNumber(num2, "Number 2 (9)");

        SumList sumList = new SumList();
        SinglyLinkedList result = sumList.sumList(num1, num2);

        printNumber(result, "Result");
        System.out.println("Expected: 8->0->1 (represents 108)");
        System.out.println("Actual sum: " + linkedListToNumber(result));
        System.out.println("Expected sum: 108");
        System.out.println();
    }

    private static void testDifferentLengthLists() {
        System.out.println("TEST 3: Different Length Lists");

        SinglyLinkedList num1 = createNumberList(3, 2, 1);
        SinglyLinkedList num2 = createNumberList(5, 4);

        printNumber(num1, "Number 1 (123)");
        printNumber(num2, "Number 2 (45)");

        SumList sumList = new SumList();
        SinglyLinkedList result = sumList.sumList(num1, num2);

        printNumber(result, "Result");
        System.out.println("Expected: 8->6->1 (represents 168)");
        System.out.println("Actual sum: " + linkedListToNumber(result));
        System.out.println("Expected sum: 168");
        System.out.println();
    }

    private static void testSingleDigitAddition() {
        System.out.println("TEST 4: Single Digit Addition");

        SinglyLinkedList num1 = createNumberList(7);
        SinglyLinkedList num2 = createNumberList(8);

        printNumber(num1, "Number 1 (7)");
        printNumber(num2, "Number 2 (8)");

        SumList sumList = new SumList();
        SinglyLinkedList result = sumList.sumList(num1, num2);

        printNumber(result, "Result");
        System.out.println("Expected: 5->1 (represents 15)");
        System.out.println("Actual sum: " + linkedListToNumber(result));
        System.out.println("Expected sum: 15");
        System.out.println();
    }

    private static void testFinalCarry() {
        System.out.println("TEST 5: Final Carry");

        SinglyLinkedList num1 = createNumberList(9, 9, 9);
        SinglyLinkedList num2 = createNumberList(1);

        printNumber(num1, "Number 1 (999)");
        printNumber(num2, "Number 2 (1)");

        SumList sumList = new SumList();
        SinglyLinkedList result = sumList.sumList(num1, num2);

        printNumber(result, "Result");
        System.out.println("Expected: 0->0->0->1 (represents 1000)");
        System.out.println("Actual sum: " + linkedListToNumber(result));
        System.out.println("Expected sum: 1000");
        System.out.println();
    }

    private static void testOneLongerList() {
        System.out.println("TEST 6: One Much Longer List");

        SinglyLinkedList num1 = createNumberList(5, 4, 3, 2, 1);
        SinglyLinkedList num2 = createNumberList(7, 6);

        printNumber(num1, "Number 1 (12345)");
        printNumber(num2, "Number 2 (67)");

        SumList sumList = new SumList();
        SinglyLinkedList result = sumList.sumList(num1, num2);

        printNumber(result, "Result");
        System.out.println("Expected: 2->1->4->2->1 (represents 12412)");
        System.out.println("Actual sum: " + linkedListToNumber(result));
        System.out.println("Expected sum: 12412");
        System.out.println();
    }

    private static void testAddingZero() {
        System.out.println("TEST 7: Adding Zero");

        SinglyLinkedList num1 = createNumberList(6, 5, 4);
        SinglyLinkedList num2 = createNumberList(0);

        printNumber(num1, "Number 1 (456)");
        printNumber(num2, "Number 2 (0)");

        SumList sumList = new SumList();
        SinglyLinkedList result = sumList.sumList(num1, num2);

        printNumber(result, "Result");
        System.out.println("Expected: 6->5->4 (represents 456)");
        System.out.println("Actual sum: " + linkedListToNumber(result));
        System.out.println("Expected sum: 456");
        System.out.println();
    }

    private static void testLargeNumbers() {
        System.out.println("TEST 8: Large Numbers");

        SinglyLinkedList num1 = createNumberList(6, 7, 8, 9);
        SinglyLinkedList num2 = createNumberList(4, 3, 2, 1);

        printNumber(num1, "Number 1 (9876)");
        printNumber(num2, "Number 2 (1234)");

        SumList sumList = new SumList();
        SinglyLinkedList result = sumList.sumList(num1, num2);

        printNumber(result, "Result");
        System.out.println("Expected: 0->1->1->1->1 (represents 11110)");
        System.out.println("Actual sum: " + linkedListToNumber(result));
        System.out.println("Expected sum: 11110");
        System.out.println();
    }

    private static void testAllNines() {
        System.out.println("TEST 9: All Nines (Maximum Carry)");

        SinglyLinkedList num1 = createNumberList(9, 9, 9);
        SinglyLinkedList num2 = createNumberList(9, 9, 9);

        printNumber(num1, "Number 1 (999)");
        printNumber(num2, "Number 2 (999)");

        SumList sumList = new SumList();
        SinglyLinkedList result = sumList.sumList(num1, num2);

        printNumber(result, "Result");
        System.out.println("Expected: 8->9->9->1 (represents 1998)");
        System.out.println("Actual sum: " + linkedListToNumber(result));
        System.out.println("Expected sum: 1998");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Testing SumList Class ===\n");
        testBasicAddition();
        testAdditionWithCarry();
        testDifferentLengthLists();
        testSingleDigitAddition();
        testFinalCarry();
        testOneLongerList();
        testAddingZero();
        testLargeNumbers();
        testAllNines();

        System.out.println("\n=== All tests completed ===");
    }
}
