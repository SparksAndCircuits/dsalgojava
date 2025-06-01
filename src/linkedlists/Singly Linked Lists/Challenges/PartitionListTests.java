public class PartitionListTests {

    // Test 1:
    private static boolean testEmptyList() {
        try {
            PartitionList partitionList = new PartitionList();
            partitionList.head = null;
            partitionList.partitionList(3);
            return partitionList.head == null;
        } catch (Exception e) {
            System.out.println("Exception in TestEmptyList: " + e.getMessage());
            return false;
        }
    }

    // Test 2:
    private static boolean testSingleNodeLessThanX() {
        try {
            PartitionList partitionList = new PartitionList();
            partitionList.head = new Node(2);
            partitionList.partitionList(3);
            return partitionList.head != null && partitionList.head.value == 2 && partitionList.head.next == null;
        } catch (Exception e) {
            System.out.println("Exception in testSingleNodeLessThan x: " + e.getMessage());
            return false;
        }
    }

    // Test 3: Single node greater than x
    private static boolean testSingleNodeGreaterThanX() {
        try {
            PartitionList partitionList = new PartitionList();
            partitionList.head = new Node(5);

            partitionList.partitionList(3);

            return partitionList.head != null &&
                    partitionList.head.value == 5 &&
                    partitionList.head.next == null;
        } catch (Exception e) {
            System.out.println("Exception in testSingleNodeGreaterThanX: " + e.getMessage());
            return false;
        }
    }

    // Test 4: Single node equal to x
    private static boolean testSingleNodeEqualToX() {
        try {
            PartitionList partitionList = new PartitionList();
            partitionList.head = new Node(3);

            partitionList.partitionList(3);

            return partitionList.head != null &&
                    partitionList.head.value == 3 &&
                    partitionList.head.next == null;
        } catch (Exception e) {
            System.out.println("Exception in testSingleNodeEqualToX: " + e.getMessage());
            return false;
        }
    }

    // Test 5: All nodes less than x
    private static boolean testAllNodesLessThanX() {
        try {
            PartitionList partitionList = new PartitionList();
            partitionList.head = createLinkedList(new int[] { 1, 2, 2, 1 });

            // Create expected result
            Node expected = createLinkedList(new int[] { 1, 2, 2, 1 });

            partitionList.partitionList(5);

            return listsEqual(partitionList.head, expected);
        } catch (Exception e) {
            System.out.println("Exception in testAllNodesLessThanX: " + e.getMessage());
            return false;
        }
    }

    // Test 6: All nodes greater than or equal to x
    private static boolean testAllNodesGreaterOrEqualToX() {
        try {
            PartitionList partitionList = new PartitionList();
            partitionList.head = createLinkedList(new int[] { 5, 6, 7, 5 });

            Node expected = createLinkedList(new int[] { 5, 6, 7, 5 });

            partitionList.partitionList(5);

            return listsEqual(partitionList.head, expected);
        } catch (Exception e) {
            System.out.println("Exception in testAllNodesGreaterOrEqualToX: " + e.getMessage());
            return false;
        }
    }

    // Test 7: Mixed values - basic case
    private static boolean testMixedBasic() {
        try {
            PartitionList partitionList = new PartitionList();
            Node original = createLinkedList(new int[] { 1, 4, 3, 2, 5, 2 });
            partitionList.head = copyList(original);

            partitionList.partitionList(3);

            // Check if partition is correct and order is preserved
            return isValidPartition(partitionList.head, 3) &&
                    hasCorrectRelativeOrder(original, partitionList.head, 3);
        } catch (Exception e) {
            System.out.println("Exception in testMixedBasic: " + e.getMessage());
            // printList("Failed list: ", partitionList.head);
            return false;
        }
    }

    // Test 8: Already partitioned list
    private static boolean testAlreadyPartitioned() {
        try {
            PartitionList partitionList = new PartitionList();
            partitionList.head = createLinkedList(new int[] { 1, 2, 2, 3, 4, 5 });

            Node expected = createLinkedList(new int[] { 1, 2, 2, 3, 4, 5 });

            partitionList.partitionList(3);

            return listsEqual(partitionList.head, expected);
        } catch (Exception e) {
            System.out.println("Exception in testAlreadyPartitioned: " + e.getMessage());
            return false;
        }
    }

    // Test 9: Reverse partitioned list
    private static boolean testReversePartitioned() {
        try {
            PartitionList partitionList = new PartitionList();
            Node original = createLinkedList(new int[] { 5, 4, 3, 2, 1 });
            partitionList.head = copyList(original);

            partitionList.partitionList(3);

            return isValidPartition(partitionList.head, 3) &&
                    hasCorrectRelativeOrder(original, partitionList.head, 3);
        } catch (Exception e) {
            System.out.println("Exception in testReversePartitioned: " + e.getMessage());
            return false;
        }
    }

    // Test 10: Alternating values
    private static boolean testAlternatingValues() {
        try {
            PartitionList partitionList = new PartitionList();
            Node original = createLinkedList(new int[] { 1, 5, 2, 4, 3, 6 });
            partitionList.head = copyList(original);

            partitionList.partitionList(4);

            return isValidPartition(partitionList.head, 4) &&
                    hasCorrectRelativeOrder(original, partitionList.head, 4);
        } catch (Exception e) {
            System.out.println("Exception in testAlternatingValues: " + e.getMessage());
            return false;
        }
    }

    // Test 11: Duplicate values
    private static boolean testDuplicateValues() {
        try {
            PartitionList partitionList = new PartitionList();
            Node original = createLinkedList(new int[] { 3, 1, 3, 4, 3, 2, 3 });
            partitionList.head = copyList(original);

            partitionList.partitionList(3);

            return isValidPartition(partitionList.head, 3) &&
                    hasCorrectRelativeOrder(original, partitionList.head, 3);
        } catch (Exception e) {
            System.out.println("Exception in testDuplicateValues: " + e.getMessage());
            return false;
        }
    }

    // Test 12: Negative values
    private static boolean testNegativeValues() {
        try {
            PartitionList partitionList = new PartitionList();
            Node original = createLinkedList(new int[] { -1, 3, -2, 1, 0, -3 });
            partitionList.head = copyList(original);

            partitionList.partitionList(0);

            return isValidPartition(partitionList.head, 0) &&
                    hasCorrectRelativeOrder(original, partitionList.head, 0);
        } catch (Exception e) {
            System.out.println("Exception in testNegativeValues: " + e.getMessage());
            return false;
        }
    }

    // Test 13: Large list
    private static boolean testLargeList() {
        try {
            PartitionList partitionList = new PartitionList();

            // Create a large list: 1,10,2,9,3,8,4,7,5,6
            int[] largeArray = new int[10];
            for (int i = 0; i < 5; i++) {
                largeArray[i * 2] = i + 1;
                largeArray[i * 2 + 1] = 10 - i;
            }

            Node original = createLinkedList(largeArray);
            partitionList.head = copyList(original);

            partitionList.partitionList(6);

            return isValidPartition(partitionList.head, 6) &&
                    hasCorrectRelativeOrder(original, partitionList.head, 6);
        } catch (Exception e) {
            System.out.println("Exception in testLargeList: " + e.getMessage());
            return false;
        }
    }

    // Test 14: Order preservation test
    private static boolean testOrderPreservation() {
        try {
            PartitionList partitionList = new PartitionList();
            Node original = createLinkedList(new int[] { 2, 8, 1, 9, 4, 7, 3, 6, 5 });
            partitionList.head = copyList(original);

            partitionList.partitionList(5);

            return isValidPartition(partitionList.head, 5) &&
                    hasCorrectRelativeOrder(original, partitionList.head, 5);
        } catch (Exception e) {
            System.out.println("Exception in testOrderPreservation: " + e.getMessage());
            return false;
        }
    }

    // Helper method to create a linked list from array
    private static Node createLinkedList(int[] values) {
        if (values.length == 0)
            return null;

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        return head;
    }

    // Helper method to copy a linked list
    private static Node copyList(Node head) {
        if (head == null)
            return null;

        Node newHead = new Node(head.value);
        Node current = newHead;
        Node original = head.next;

        while (original != null) {
            current.next = new Node(original.value);
            current = current.next;
            original = original.next;
        }

        return newHead;
    }

    // Helper method to check if two linked lists are equal
    private static boolean listsEqual(Node list1, Node list2) {
        Node current1 = list1;
        Node current2 = list2;

        while (current1 != null && current2 != null) {
            if (current1.value != current2.value) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        // Both should be null if lists are equal
        return current1 == null && current2 == null;
    }

    // Helper method to check if partition is valid (all values < x come before all
    // values >= x)
    private static boolean isValidPartition(Node head, int x) {
        Node current = head;
        boolean foundGreaterOrEqual = false;

        while (current != null) {
            if (current.value >= x) {
                foundGreaterOrEqual = true;
            } else if (foundGreaterOrEqual) {
                // Found a value less than x after finding a value >= x
                return false;
            }
            current = current.next;
        }
        return true;
    }

    // Helper method to check if relative order is preserved within partitions
    private static boolean hasCorrectRelativeOrder(Node original, Node result, int x) {
        // Extract nodes < x from original list
        Node originalLessHead = extractNodesLessThan(original, x);
        Node resultLessHead = extractNodesLessThan(result, x);

        if (!listsEqual(originalLessHead, resultLessHead)) {
            return false;
        }

        // Extract nodes >= x from original list
        Node originalGreaterEqualHead = extractNodesGreaterOrEqual(original, x);
        Node resultGreaterEqualHead = extractNodesGreaterOrEqual(result, x);

        return listsEqual(originalGreaterEqualHead, resultGreaterEqualHead);
    }

    // Helper method to extract nodes with values less than x
    private static Node extractNodesLessThan(Node head, int x) {
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        Node original = head;

        while (original != null) {
            if (original.value < x) {
                current.next = new Node(original.value);
                current = current.next;
            }
            original = original.next;
        }

        return dummyHead.next;
    }

    // Helper method to extract nodes with values greater than or equal to x
    private static Node extractNodesGreaterOrEqual(Node head, int x) {
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        Node original = head;

        while (original != null) {
            if (original.value >= x) {
                current.next = new Node(original.value);
                current = current.next;
            }
            original = original.next;
        }

        return dummyHead.next;
    }

    private static void printList(String prefix, Node head) {
        System.out.print(prefix + "[");
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("--- Running Partition list tests ---\n");

        int totalTests = 0;
        int passedTests = 0;
        int failedTests = 0;

        // Test 1:
        totalTests++;
        if (testEmptyList()) {
            passedTests++;
            System.out.println("Test 1 has passed: Empty list");
        } else {
            failedTests++;
            System.out.println("Test 1 has failed: Empty list");
        }

        // Test 2:
        totalTests++;
        if (testSingleNodeLessThanX()) {
            passedTests++;
            System.out.println("Test 2 has passed: Single node less than x");
        } else {
            failedTests++;
            System.out.println("Test 2 has failed: Single node less than x");
        }

        // Test 3: Single node greater than x
        totalTests++;
        if (testSingleNodeGreaterThanX()) {
            passedTests++;
            System.out.println("Test 3 has passed: Single node greater than x");
        } else {
            System.out.println("Test 3 has failed: Single node greater than x");
        }

        // Test 4: Single node equal to x
        totalTests++;
        if (testSingleNodeEqualToX()) {
            passedTests++;
            System.out.println("Test 4 has passed: Single node equal to x");
        } else {
            System.out.println("Test 4 has failed: Single node equal to x");
        }

        // Test 5: All nodes less than x
        totalTests++;
        if (testAllNodesLessThanX()) {
            passedTests++;
            System.out.println("Test 5 has passed: All nodes less than x");
        } else {
            System.out.println("Test 5 has failed: All nodes less than x");
        }

        // Test 6: All nodes greater than or equal to x
        totalTests++;
        if (testAllNodesGreaterOrEqualToX()) {
            passedTests++;
            System.out.println("Test 6 has passed: All nodes >= x");
        } else {
            System.out.println("Test 6 has failed: All nodes >= x");
        }

        // Test 7: Mixed values - basic case
        totalTests++;
        if (testMixedBasic()) {
            passedTests++;
            System.out.println("Test 7 has passed: Mixed values basic");
        } else {
            System.out.println("Test 7 has failed: Mixed values basic");
        }

        // Test 8: Already partitioned list
        totalTests++;
        if (testAlreadyPartitioned()) {
            passedTests++;
            System.out.println("Test 8 has passed: Already partitioned");
        } else {
            System.out.println("Test 8 has failed: Already partitioned");
        }

        // Test 9: Reverse partitioned list
        totalTests++;
        if (testReversePartitioned()) {
            passedTests++;
            System.out.println("Test 9 has passed: Reverse partitioned");
        } else {
            System.out.println("Test 9 has failed: Reverse partitioned");
        }

        // Test 10: Alternating values
        totalTests++;
        if (testAlternatingValues()) {
            passedTests++;
            System.out.println("Test 10 has passed: Alternating values");
        } else {
            System.out.println("Test 10 has failed: Alternating values");
        }

        // Test 11: Duplicate values
        totalTests++;
        if (testDuplicateValues()) {
            passedTests++;
            System.out.println("Test 11 has passed: Duplicate values");
        } else {
            System.out.println("Test 11 has failed: Duplicate values");
        }

        // Test 12: Negative values
        totalTests++;
        if (testNegativeValues()) {
            passedTests++;
            System.out.println("Test 12 has passed: Negative values");
        } else {
            System.out.println("Test 12 has failed: Negative values");
        }

        // Test 13: Large list
        totalTests++;
        if (testLargeList()) {
            passedTests++;
            System.out.println("Test 13 has passed: Large list");
        } else {
            System.out.println("Test 13 has failed: Large list");
        }

        // Test 14: Order preservation test
        totalTests++;
        if (testOrderPreservation()) {
            passedTests++;
            System.out.println("Test 14 has passed: Order preservation");
        } else {
            System.out.println("Test 14 has failed: Order preservation");
        }

        System.out.println(
                "Test Results: " + passedTests + "/" + totalTests + " tests passed" + failedTests + "Failed Tests");
        System.out.println("Success Rate: " + (passedTests * 100 / totalTests) + "%");

    }
}
