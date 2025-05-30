public class SinglyLinkedListTests {
    private static int testPassed = 0;
    private static int testTotal = 0;

    private static void assertTrue(String testName, boolean condition) {
        testTotal++;
        if (condition) {
            System.out.println("Successful test: " + testName);
        } else {
            System.out.println("Unsuccessful test: " + testName);
        }
    }

    private static void assertEquals(String testName, Object expected, Object actual) {
        testTotal++;

        if ((expected == null && actual == null) || (expected != null && expected.equals(actual))) {
            System.out.println("Successful test: " + testName);
            testPassed++;
        } else {
            System.out.println("Unsuccessful tests: " + testName);
        }
    }

    private static int getLength(SinglyLinkedList list) {
        int count = 0;
        while (list.get(count) != null) {
            count++;
        }
        return count;
    }

    private static void testNodeCreation() {
        System.out.println("--- Testing Node creation ---");

        Node node1 = new Node(5);
        assertEquals("Node value initialization", 5, node1.value);
        assertEquals("Node next initialization", null, node1.next);

        Node node2 = new Node(-10);
        assertEquals("Node negative value", -10, node2.value);

        Node node3 = new Node(0);
        assertEquals("Node zero value", 0, node3.value);
    }

    private static void testNodeLinking() {
        System.out.println("--- Node linking tests ---");

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        assertEquals("FirstNode links to second", node2, node1.next);
        assertEquals("Second node links to third", node3, node2.next);
        assertEquals("Third node next is null", null, node3.next);
        assertEquals("Chain traversal", 2, node1.next.value);
        assertEquals("Chain traversal deep", 3, node1.next.next.value);
    }

    private static void testConstructor() {
        System.out.println("--- Constructor tests ---");
        SinglyLinkedList list = new SinglyLinkedList(10);

        Node headNode = list.get(0);
        assertTrue("Head node exists", headNode != null);
        assertEquals("Head Node value", 10, headNode.value);
        assertEquals("Initial length", 1, getLength(list));

        Node firstNode = list.get(0);
        assertTrue("Single node setup", firstNode != null && firstNode.next == null);
    }

    private static void testAppend() {
        System.out.println("--- Append tests ---");
        SinglyLinkedList list = new SinglyLinkedList(1);

        list.append(2);
        assertEquals("Length after first append", 2, getLength(list));
        assertEquals("Second element value", 2, list.get(1).value);

        list.append(3);
        list.append(4);
        assertEquals("Length after multiple appends", 4, getLength(list));
        assertEquals("Last element value", 4, list.get(3).value);
    }

    private static void testPrepend() {
        System.out.println("--- Prepend tests ---");

        SinglyLinkedList list = new SinglyLinkedList(2);

        list.prepend(1);
        assertEquals("Length after prepend", 2, getLength(list));
        assertEquals("First element after prepend", 1, list.get(0).value);
        assertEquals("Second element after prepend", 2, list.get(1).value);

        list.prepend(0);
        assertEquals("Multiple prepends length", 3, getLength(list));
        assertEquals("First element after multiple prepends", 0, list.get(0).value);
    }

    private static void testRemoveLast() {
        System.out.println("--- Remove last tests ---");

        SinglyLinkedList list = new SinglyLinkedList(1);
        list.append(2);
        list.append(3);

        Node removed = list.removeLast();
        assertEquals("Removed ndoe value", 3, removed.value);
        assertEquals("Length after remove", 2, getLength(list));
        assertEquals("New last elements", 2, list.get(1).value);

        list.removeLast();
        list.removeLast();
        Node removedFromEmpty = list.removeLast();
        assertEquals("Remove from an empty list", null, removedFromEmpty);
        assertEquals("Empty list length", 0, getLength(list));
    }

    private static void testRemoveFirst() {
        System.out.println("--- Remove first tests ---");

        SinglyLinkedList list = new SinglyLinkedList(1);
        list.append(2);
        list.append(3);

        Node removed = list.removeFirst();
        assertEquals("Removed first node value", 1, removed.value);
        assertEquals("Length after remove first", 2, getLength(list));
        assertEquals("New first element", 2, list.get(0).value);

        list.removeFirst();
        list.removeFirst();
        Node removedFromEmpty = list.removeFirst();
        assertEquals("Remove first from empty list", null, removedFromEmpty);
    }

    private static void testGet() {
        System.out.println("--- Get Method Tests ---");

        SinglyLinkedList list = new SinglyLinkedList(10);
        list.append(20);
        list.append(30);

        assertEquals("Get first element", 10, list.get(0).value);
        assertEquals("Get middle element", 20, list.get(1).value);
        assertEquals("Get last element", 30, list.get(2).value);

        assertEquals("Get negative index", null, list.get(-1));
        assertEquals("Get out of bounds index", null, list.get(3));
        assertEquals("Get way out of bounds", null, list.get(100));
    }

    private static void testSet() {
        System.out.println("--- Set method tests ---");

        SinglyLinkedList list = new SinglyLinkedList(1);
        list.append(2);
        list.append(3);

        assertTrue("Set valid index", list.set(1, 99));
        assertEquals("Value after set", 99, list.get(1).value);

        assertTrue("Set first element", list.set(0, 11));
        assertEquals("Last element after set", 33, list.get(2).value);

        assertTrue("Set invalid negative index returns false", !list.set(-1, 50));
        assertTrue("Set invalid high index returns false", !list.set(3, 50));
    }

    private static void testInsert() {
        System.out.println("--- Insert Method Tests ---");

        SinglyLinkedList list = new SinglyLinkedList(1);
        list.append(3);

        assertTrue("Insert in middle", list.insert(1, 2));
        assertEquals("Length after insert", 3, getLength(list));
        assertEquals("Inserted value", 2, list.get(1).value);
        assertEquals("Vaues in order", 1, list.get(0).value);
        assertEquals("Values in order", 3, list.get(2).value);

        assertTrue("Insert at beginning", list.insert(0, 0));
        assertEquals("Insert at beginning value", 0, list.get(0).value);
        assertEquals("Length after insert at beginning", 4, getLength(list));

        assertTrue("Insert at end", list.insert(4, 4));
        assertEquals("Insert at end value", 4, list.get(4).value);

        assertTrue("Insert invalid negative index", !list.insert(-1, 99));
        assertTrue("Insert invalid high index", !list.insert(10, 99));
    }

    private static void testRemove() {
        System.out.println("\n--- Remove Method Tests ---");

        SinglyLinkedList list = new SinglyLinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);

        Node removed = list.remove(2);
        assertEquals("Removed middle value", 3, removed.value);
        assertEquals("Length after remove", 3, getLength(list));
        assertEquals("Values after remove", 4, list.get(2).value);

        Node removedFirst = list.remove(0);
        assertEquals("Removed first value", 1, removedFirst.value);

        Node removedLast = list.remove(1);
        assertEquals("Removed last value", 4, removedLast.value);

        assertEquals("Remove invalid negative index", null, list.remove(-1));
        assertEquals("Remove invalid high index", null, list.remove(10));
    }

    private static void testReverse() {
        System.out.println("\n--- Reverse Method Tests ---");

        SinglyLinkedList list = new SinglyLinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.reverse();

        assertEquals("First element after reverse", 4, list.get(0).value);
        assertEquals("Second element after reverse", 3, list.get(1).value);
        assertEquals("Third element after reverse", 2, list.get(2).value);
        assertEquals("Fourth element after reverse", 1, list.get(3).value);
        assertEquals("Length unchanged after reverse", 4, getLength(list));

        SinglyLinkedList singleList = new SinglyLinkedList(42);
        singleList.reverse();
        assertEquals("Single element reverse", 42, singleList.get(0).value);
        assertEquals("Single element length", 1, getLength(singleList));
    }

    private static void testEdgeCases() {
        System.out.println("\n--- Edge Cases Tests ---");

        SinglyLinkedList singleList = new SinglyLinkedList(100);
        Node removed = singleList.removeLast();
        assertEquals("Remove last from single element", 100, removed.value);
        assertEquals("Single element removal length", 0, getLength(singleList));

        Node removedFromEmpty = singleList.removeLast();
        assertEquals("Remove from empty", null, removedFromEmpty);

        SinglyLinkedList largeList = new SinglyLinkedList(Integer.MAX_VALUE);
        largeList.append(Integer.MIN_VALUE);
        assertEquals("Large positive value", Integer.MAX_VALUE, largeList.get(0).value);
        assertEquals("Large negative value", Integer.MIN_VALUE, largeList.get(1).value);

        SinglyLinkedList zeroList = new SinglyLinkedList(0);
        zeroList.append(0);
        assertEquals("Zero value handling", 0, zeroList.get(0).value);
        assertEquals("Multiple zeros", 0, zeroList.get(1).value);
    }

    public static void main(String[] args) {
        System.out.println("Starting Node and SinglyLinkedList Tests...\n");

        // Node tests
        testNodeCreation();
        testNodeLinking();

        // SinglyLinkedList tests
        testConstructor();
        testAppend();
        testPrepend();
        testRemoveLast();
        testRemoveFirst();
        testGet();
        testSet();
        testInsert();
        testRemove();
        testReverse();
        testEdgeCases();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("Test Results: " + testPassed + "/" + testTotal + " tests passed");

        if (testPassed == testTotal) {
            System.out.println("All tests PASSED!");
        } else {
            System.out.println("Some tests FAILED!");
        }
    }

}