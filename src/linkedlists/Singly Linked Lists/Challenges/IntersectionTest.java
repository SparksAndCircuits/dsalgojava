public class IntersectionTest {
    private Intersection intersection = new Intersection();

    private Node createList(int... values) {
        if (values.length == 0) {
            return null;
        }

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        return head;
    }

    // Test case 1:
    public void testBothListsNull() {
        Node result = intersection.findIntersection(null, null);
        assert result == null : "Expected null when both lists are null";
        System.out.println("Test case 1 passed. Both lists are null");
    }

    // Test caase 2:
    public void testFirstListNull() {
        Node list2 = createList(1, 2, 3);
        Node result = intersection.findIntersection(null, list2);
        assert result == null : "Expected null when first list is null";
        System.out.println("Test case 2 passed. The first list is null");
    }

    // Test case 3:
    public void testSecondListNull() {
        Node list1 = createList(1, 2, 3);
        Node result = intersection.findIntersection(list1, null);
        assert result == null : "Expected null when second list is null";
        System.out.println("Test case 3 passed. The second list is null");
    }

    // Test case 4:
    public void testNoIntersection() {
        Node list1 = createList(1, 2, 3);
        Node list2 = createList(4, 5, 6);
        Node result = intersection.findIntersection(list1, list2);
        assert result == null : "Expected null when the lists don't intersect";
        System.out.println("Test case 4 passed. There is no intersection");
    }

    // Test case 5:
    public void testInersectionAtBeginning() {
        Node commonList = createList(1, 2, 3);
        Node result = intersection.findIntersection(commonList, commonList);
        assert result == commonList : "Expected intersection at the beginning";
        System.out.println("Test Case 5 passed. There is an intersection at the beginning of the list");
    }

    // Test case 6:
    public void testIntersectionMiddleSameLength() {
        Node list1 = createList(1, 2);
        Node list2 = createList(7, 8);
        Node commonTail = createList(3, 4, 5);

        list1.next.next = commonTail;
        list2.next.next = commonTail;

        Node result = intersection.findIntersection(list1, list2);
        assert result == commonTail : "Expected intersection will be at common tail";
        System.out.println("Test case 6 passed: Intersection in middle and has the same length");
    }

    // Test case 7:
    public void testIntersectionFirstListLonger() {
        Node list1 = createList(1, 2, 3, 4);
        Node list2 = createList(7, 8);
        Node commonTail = createList(5, 6);

        list1.next.next.next.next = commonTail;
        list2.next.next = commonTail;

        Node result = intersection.findIntersection(list1, list2);
        assert result == commonTail : "Expected intersection at common Tail";
        System.out.println("Test case 7 passed: Intersection at the longer first list");
    }

    // Test case 8:
    public void testIntersectionSecondListLonger() {
        Node list1 = createList(1, 2);
        Node list2 = createList(7, 8, 9, 10);
        Node commonTail = createList(3, 4);

        list1.next.next = commonTail;
        list2.next.next.next.next = commonTail;

        Node result = intersection.findIntersection(list1, list2);
        assert result == commonTail : "Expected interection at common Tail";
        System.out.println("Test case 8 passed: Intersection while second list is longer");
    }

    // Test case 9
    public void testSingleNodeIntersection() {
        Node singleNode = new Node(42);
        Node list1 = createList(1, 2, 3);
        Node list2 = createList(4, 5);

        list1.next.next.next = singleNode;
        list2.next.next = singleNode;
        Node result = intersection.findIntersection(list1, list2);
        assert result == singleNode : "Expected intersection at single node";
        System.out.println("Test case 9 passed: Single node intersection");
    }

    // Test case 10:
    public void testSingleNodeListIntersection() {
        Node singleNode = new Node(1);
        Node longerList = createList(2, 3, 4);
        longerList.next.next.next = singleNode;

        Node result = intersection.findIntersection(singleNode, longerList);
        assert result == singleNode : "Expected intersection at single node";
        System.out.println("Test case 10 passed: Single node list intersection");
    }

    // Test case 11:
    public void testVeryDifferentLengths() {
        Node shortList = createList(1);
        Node longList = createList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        Node commonNode = createList(99);

        shortList.next = commonNode;
        longList.next.next.next.next.next.next.next.next.next = commonNode;

        Node result = intersection.findIntersection(shortList, longList);
        assert result == commonNode : "Epected intersection despite different lengths";
        System.out.println("Test case 11 passed: Very different lengths");
    }

    // Test case 12:
    public void testGetTailAndSizeNull() {
        Node2 result = intersection.getTailAndSize(null);
        assert result == null : "Expected null for getTailAndSize with null input";
        System.out.println("Test case 12 passed: getTailAndSize with null input");
    }

    // Test case 13:
    public void testGetTailAndSizeSingleNode() {
        Node singleNode = new Node(42);
        Node2 result = intersection.getTailAndSize(singleNode);
        assert result != null : "Expected a non null result for the single node";
        System.out.println("Test case 13 passed: getTailAndSize with single node");
    }

    // Test case 14
    public void testIntersectionAtLastNodeOnly() {
        Node lastNode = new Node(100);
        Node list1 = createList(1, 2, 3);
        Node list2 = createList(4, 5, 6, 7);

        list1.next.next.next = lastNode;
        list2.next.next.next.next = lastNode;

        Node result = intersection.findIntersection(list1, list2);
        assert result == lastNode : "Expected intersection at the last node";
        System.out.println("Test case 14 passed: Intersection at last node only");
    }

    public static void main(String[] args) {
        IntersectionTest tests = new IntersectionTest();

        System.out.println("--- Intersection detection test cases are being run ---");

        tests.testBothListsNull();
        tests.testFirstListNull();
        tests.testSecondListNull();
        tests.testNoIntersection();
        tests.testInersectionAtBeginning();
        tests.testIntersectionMiddleSameLength();
        tests.testIntersectionFirstListLonger();
        tests.testIntersectionSecondListLonger();
        tests.testSingleNodeIntersection();
        tests.testSingleNodeListIntersection();
        tests.testVeryDifferentLengths();
        tests.testGetTailAndSizeNull();
        tests.testGetTailAndSizeSingleNode();
        tests.testIntersectionAtLastNodeOnly();

        System.out.println("--- Intersection detection test cases have been completed ---");
    }
}
