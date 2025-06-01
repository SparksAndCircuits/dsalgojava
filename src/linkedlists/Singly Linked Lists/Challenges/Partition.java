public class Partition {
    Node head;
    Node tail;

    LinkedList partition(LinkedList LL, int x) {
        if (LL.head == null)
            return LL;

        LinkedList smaller = new LinkedList();
        LinkedList greaterEqual = new LinkedList();

        Node currentNode = LL.head;

        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = null;

            if (currentNode.value < x) {
                if (smaller.head == null) {
                    smaller.head = currentNode;
                    smaller.tail = currentNode;
                } else {
                    smaller.tail.next = currentNode;
                    smaller.tail = currentNode;
                }
                smaller.size++;
            } else {
                if (greaterEqual.head == null) {
                    greaterEqual.head = currentNode;
                    greaterEqual.tail = currentNode;
                } else {
                    greaterEqual.tail.next = currentNode;
                    greaterEqual.tail = currentNode;
                }
                greaterEqual.size++;
            }

            currentNode = nextNode;
        }

        if (smaller.head == null) {
            LL.head = greaterEqual.head;
            LL.tail = greaterEqual.tail;
        } else if (greaterEqual.head == null) {
            LL.head = smaller.head;
            LL.tail = smaller.tail;
        } else {
            smaller.tail.next = greaterEqual.head;
            LL.head = smaller.head;
            LL.tail = greaterEqual.tail;
        }

        return LL;
    }

    boolean verifyPartition(LinkedList LL, int x) {
        Node current = LL.head;
        boolean foundGreaterEqual = false;

        while (current != null) {
            if (current.value >= x) {
                foundGreaterEqual = true;
            } else if (foundGreaterEqual) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Partition p = new Partition();

        System.out.println("=== Partition Linked List Test Cases ===\n");

        // Test Case 1: Empty list
        System.out.println("Test 1: Empty list");
        LinkedList test1 = new LinkedList();
        System.out.print("Original: ");
        test1.printList();
        p.partition(test1, 5);
        System.out.print("After partition (x=5): ");
        test1.printList();
        System.out.println("Is valid partition: " + p.verifyPartition(test1, 5));
        System.out.println();

        // Test Case 2: Single element less than x
        System.out.println("Test 2: Single element less than x");
        LinkedList test2 = new LinkedList();
        test2.createFromArray(new int[] { 3 });
        System.out.print("Original: ");
        test2.printList();
        p.partition(test2, 5);
        System.out.print("After partition (x=5): ");
        test2.printList();
        System.out.println("Is valid partition: " + p.verifyPartition(test2, 5));
        System.out.println();

        // Test Case 3: Single element greater than x
        System.out.println("Test 3: Single element greater than x");
        LinkedList test3 = new LinkedList();
        test3.createFromArray(new int[] { 7 });
        System.out.print("Original: ");
        test3.printList();
        p.partition(test3, 5);
        System.out.print("After partition (x=5): ");
        test3.printList();
        System.out.println("Is valid partition: " + p.verifyPartition(test3, 5));
        System.out.println();

        // Test Case 4: All elements less than x
        System.out.println("Test 4: All elements less than x");
        LinkedList test4 = new LinkedList();
        test4.createFromArray(new int[] { 1, 2, 3, 4 });
        System.out.print("Original: ");
        test4.printList();
        p.partition(test4, 5);
        System.out.print("After partition (x=5): ");
        test4.printList();
        System.out.println("Is valid partition: " + p.verifyPartition(test4, 5));
        System.out.println();

        // Test Case 5: All elements greater than or equal to x
        System.out.println("Test 5: All elements >= x");
        LinkedList test5 = new LinkedList();
        test5.createFromArray(new int[] { 5, 6, 7, 8 });
        System.out.print("Original: ");
        test5.printList();
        p.partition(test5, 5);
        System.out.print("After partition (x=5): ");
        test5.printList();
        System.out.println("Is valid partition: " + p.verifyPartition(test5, 5));
        System.out.println();

        // Test Case 6: Mixed elements - classic example
        System.out.println("Test 6: Mixed elements");
        LinkedList test6 = new LinkedList();
        test6.createFromArray(new int[] { 3, 5, 8, 5, 10, 2, 1 });
        System.out.print("Original: ");
        test6.printList();
        p.partition(test6, 5);
        System.out.print("After partition (x=5): ");
        test6.printList();
        System.out.println("Is valid partition: " + p.verifyPartition(test6, 5));
        System.out.println();

        // Test Case 7: Elements equal to x
        System.out.println("Test 7: Multiple elements equal to x");
        LinkedList test7 = new LinkedList();
        test7.createFromArray(new int[] { 5, 5, 5, 5 });
        System.out.print("Original: ");
        test7.printList();
        p.partition(test7, 5);
        System.out.print("After partition (x=5): ");
        test7.printList();
        System.out.println("Is valid partition: " + p.verifyPartition(test7, 5));
        System.out.println();

        // Test Case 8: Already partitioned
        System.out.println("Test 8: Already partitioned");
        LinkedList test8 = new LinkedList();
        test8.createFromArray(new int[] { 1, 2, 3, 5, 6, 7 });
        System.out.print("Original: ");
        test8.printList();
        p.partition(test8, 5);
        System.out.print("After partition (x=5): ");
        test8.printList();
        System.out.println("Is valid partition: " + p.verifyPartition(test8, 5));
        System.out.println();

        // Test Case 9: Reverse order
        System.out.println("Test 9: Reverse order");
        LinkedList test9 = new LinkedList();
        test9.createFromArray(new int[] { 9, 8, 7, 6, 4, 3, 2, 1 });
        System.out.print("Original: ");
        test9.printList();
        p.partition(test9, 5);
        System.out.print("After partition (x=5): ");
        test9.printList();
        System.out.println("Is valid partition: " + p.verifyPartition(test9, 5));
        System.out.println();

        // Test Case 10: Large partition value
        System.out.println("Test 10: Partition value larger than all elements");
        LinkedList test10 = new LinkedList();
        test10.createFromArray(new int[] { 1, 2, 3, 4, 5 });
        System.out.print("Original: ");
        test10.printList();
        p.partition(test10, 10);
        System.out.print("After partition (x=10): ");
        test10.printList();
        System.out.println("Is valid partition: " + p.verifyPartition(test10, 10));
        System.out.println();
    }
}
