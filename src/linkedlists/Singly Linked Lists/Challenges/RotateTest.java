public class RotateTest {
    private static Rotate createRotateWithList(int... values) {
        Rotate rotate = new Rotate();

        if (values.length == 0) {
            return rotate;
        }

        rotate.head = new Node(values[0]);
        Node current = rotate.head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        rotate.tail = current;
        return rotate;
    }

    private static void printList(Rotate rotate, String testName) {
        System.out.print(testName + " - List: ");

        if (rotate.head == null) {
            System.out.println("Empty");
            return;
        }

        Node current = rotate.head;
        int count = 0;

        while (current != null && count < 10) {
            System.out.print(current.value);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
            count++;
        }

        System.out.println();
    }

    // Test case 1: Empty List
    private static void testEmptyList() {
        System.out.println("Test 1: Empty list");
        Rotate rotate = createRotateWithList();

        try {
            String result = rotate.rotate(1);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        printList(rotate, "After rotation");
        System.out.println();
    }

    // Test case 2: Single Node List
    private static void testSingleNodeList() {
        System.out.println("Test 2: Single Node List");
        Rotate rotate = createRotateWithList(5);

        printList(rotate, "Before Rotation");

        String result = rotate.rotate(0);
        System.out.println("Rotate by 0 - Result: " + result);
        printList(rotate, "After rotate by 0");

        rotate = createRotateWithList(5);
        result = rotate.rotate(1);
        System.out.println("Rotate by 1 - Result: " + result);
        printList(rotate, "After rotate by 1.");
        System.out.println();
    }

    // Test case 3: Two Node List
    private static void testTwoNodeList() {
        System.out.println("Test 3: Two Node List");
        Rotate rotate = createRotateWithList(1, 2);

        printList(rotate, "Before Rotation");

        String result = rotate.rotate(1);
        System.out.println("Rotate by 1 - Result: " + result);
        printList(rotate, "After Rotation");
        System.out.println();
    }

    // Test case 4: Three Node List
    private static void testThreeNodeList() {
        System.out.println("Test 4: Three Node List");

        Rotate rotate = createRotateWithList(1, 2, 3);
        printList(rotate, "Before Rotation");

        String result = rotate.rotate(1);
        System.out.println("Rotate by 1 - Result: " + result);
        printList(rotate, "After rotate by 1");

        rotate = createRotateWithList(1, 2, 3);
        result = rotate.rotate(2);
        System.out.println("Rotate by 2 - Result: " + result);
        printList(rotate, "After rotate by 2");
        System.out.println();
    }

    // Test case 5: Four Node List
    private static void testFourNodeList() {
        System.out.println("Test 5: Four node list");
        Rotate rotate = createRotateWithList(1, 2, 3, 4);

        printList(rotate, "Before Rotation");

        String result = rotate.rotate(2);
        System.out.println("Rotate by 2 - Result: " + result);
        printList(rotate, "After Rotation");
        System.out.println();
    }

    // Test case 6: Rotate By Zero
    private static void testRotateByZero() {
        System.out.println("Test 6: Rotate by zero");
        Rotate rotate = createRotateWithList(10, 20, 30);

        printList(rotate, "Before Rotation");

        String result = rotate.rotate(0);
        System.out.println("Rotate by 0 - Result: " + result);
        printList(rotate, "After Rotation");
        System.out.println();
    }

    // Test case 7: Negative numbers
    private static void testNegativeRotation() {
        System.out.println("Test 7: Negative Rotation");
        Rotate rotate = createRotateWithList(1, 2, 3, 4);

        printList(rotate, "Before rotation");

        String result = rotate.rotate(-1);
        System.out.println("Rotate by -1 - Result: " + result);
        printList(rotate, "After rotation");
        System.out.println();
    }

    // Test case 8: Out of bound rotation
    private static void testOutOfBoundsRotation() {
        System.out.println("Test 8: Out of Bounds Rotation.");
        Rotate rotate = createRotateWithList(1, 2, 3);

        printList(rotate, "Before rotation");

        String result = rotate.rotate(5);
        System.out.println("Rotate by 5 - Result: " + result);
        printList(rotate, "After rotation");

        rotate = createRotateWithList(1, 2, 3);
        result = rotate.rotate(-10);
        System.out.println("Rotate by -10 - Result: " + result);
        printList(rotate, "After rotation");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Rotate Class ---");
        testEmptyList();
        testSingleNodeList();
        testTwoNodeList();
        testThreeNodeList();
        testFourNodeList();
        testRotateByZero();
        testNegativeRotation();
        testOutOfBoundsRotation();

        System.out.println("\n--- All tests completed. ---");
    }
}
