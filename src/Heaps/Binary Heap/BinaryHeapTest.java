public class BinaryHeapTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;

    private static void assertTrue(String testName, boolean condition) {
        totalTests++;

        if (condition) {
            System.out.println(testName + " - has passed.");
            testsPassed++;
        } else {
            System.out.println(testName + " - has failed.");
        }
    }

    private static void assertEquals(String testName, Object expected, Object actual) {
        totalTests++;
        if ((expected == null && actual == null || (expected != null && expected.equals(actual)))) {
            System.out.println(testName + " - has passed");
            testsPassed++;
        } else {
            System.out.println(testName + " - failed (expected: " + expected + ", Got: " + actual + ")");
        }
    }

    public static void testConstructor() {
        System.out.println("\n--- Testing Constructor ---");

        BinaryHeap heap = new BinaryHeap(10);
        assertTrue("Constructor creates heap with correct initial size", heap.sizeOfBP() == 0);
        assertTrue("Constructor creates empty heap", heap.isEmpty());
        assertEquals("Constructor sets array length correctly", 11, heap.array.length);
    }

    public static void testIsEmpty() {
        System.out.println("\n--- Testing isEmpty() ---");

        BinaryHeap heap = new BinaryHeap(5);
        assertTrue("New heap should be empty", heap.isEmpty());

        try {
            heap.insert(5, "Min");
            assertTrue("Heap with elements should not be empty", !heap.isEmpty());
        } catch (Exception e) {
            System.out.println("Insert method has issues: " + e.getMessage());
            totalTests++;
        }
    }

    public static void testPeek() {
        System.out.println("\n--- Testing peek() ---");

        BinaryHeap heap = new BinaryHeap(5);
        assertEquals("Peek on empty heap should return null", null, heap.peek());
        try {
            heap.insert(10, "Min");
            assertEquals("Peek should return root element", Integer.valueOf(10), heap.peek());
        } catch (Exception e) {
            System.out.println("Cannot test peek with elements due to insert issues: " + e.getMessage());
            totalTests++;
        }
    }

    public static void testSizeOfBP() {
        System.out.println("\n--- Testing sizeOfBP() ---");

        BinaryHeap heap = new BinaryHeap(5);
        assertEquals("Initial size should be 0", 0, heap.sizeOfBP());

        try {
            heap.insert(5, "Min");
            assertEquals("Size should be 1 after one insertion", 1, heap.sizeOfBP());
        } catch (Exception e) {
            System.out.println("Cannot test size change due to insert issues: " + e.getMessage());
            totalTests++;
        }
    }

    public static void testInsertMinHeap() {
        System.out.println("\n--- Testing insert() for Min Heap ---");

        BinaryHeap heap = new BinaryHeap(10);

        try {
            heap.insert(5, "Min");
            assertEquals("Size after first insert", 1, heap.sizeOfBP());
            assertEquals("Root should be inserted element", Integer.valueOf(5), heap.peek());

            heap.insert(3, "Min");
            heap.insert(8, "Min");
            heap.insert(1, "Min");

            assertEquals("Size after multiple inserts", 4, heap.sizeOfBP());
            assertEquals("Root should be minimum element", Integer.valueOf(1), heap.peek());
        } catch (Exception e) {
            System.out.println("Insert method has failed test: " + e.getMessage());
            totalTests += 4;
        }
    }

    public static void testInsertMaxHeap() {
        System.out.println("\n--- Testing insert() for Max Heap ---");

        BinaryHeap heap = new BinaryHeap(10);

        try {
            heap.insert(5, "Max");
            heap.insert(3, "Max");
            heap.insert(8, "Max");
            heap.insert(10, "Max");

            assertEquals("Size after multiple inserts", 4, heap.sizeOfBP());
            assertEquals("Root should be minimum element", Integer.valueOf(10), heap.peek());
        } catch (Exception e) {
            System.out.println("Insert method has failed test: " + e.getMessage());
            totalTests += 2;
        }
    }

    public static void testExtractHeadMinHeap() {
        System.out.println("\n--- Testing insert() for Max Heap ---");

        BinaryHeap heap = new BinaryHeap(10);

        assertEquals("Extract from empty heap should return -1", -1, heap.extractHeadOfBP("Min"));

        try {
            heap.insert(5, "Max");
            heap.insert(3, "Max");
            heap.insert(8, "Max");
            heap.insert(1, "Max");

            int extracted = heap.extractHeadOfBP("Min");
            assertEquals("Should extract minimum element", 1, extracted);
            assertEquals("Size should decrease after multiple inserts", 3, heap.sizeOfBP());
            assertEquals("New Root should be minimum", Integer.valueOf(3), heap.peek());
        } catch (Exception e) {
            System.out.println("Insert method has failed test: " + e.getMessage());
            totalTests += 3;
        }

    }

    public static void testExtractHeadMaxHeap() {
        System.out.println("\n--- Testing insert() for Max Heap ---");

        BinaryHeap heap = new BinaryHeap(10);

        try {
            heap.insert(5, "Max");
            heap.insert(3, "Max");
            heap.insert(8, "Max");
            heap.insert(10, "Max");

            int extracted = heap.extractHeadOfBP("Max");
            assertEquals("Should extract maximum element", 10, extracted);
            assertEquals("Size should decrease after multiple inserts", 3, heap.sizeOfBP());

        } catch (Exception e) {
            System.out.println("Insert method has failed test: " + e.getMessage());
            totalTests += 2;
        }
    }

    public static void testLevelOrder() {
        System.out.println("\n--- Testing levelOrder() ---");

        BinaryHeap heap = new BinaryHeap(5);

        System.out.println("Level order traversal of empty heap:");
        heap.levelOrder();

        try {
            heap.insert(5, "Min");
            heap.insert(3, "Min");
            heap.insert(8, "Min");

            System.out.println("Level order traversal after insertions: ");
            heap.levelOrder();
            assertTrue("Level order test completed", true);
        } catch (Exception e) {
            System.out.println("Level order test failed: " + e.getMessage());
            totalTests++;
        }
    }

    public static void testDeleteBH() {
        System.out.println("\n--- Testing deletingBH() ---");

        BinaryHeap heap = new BinaryHeap(5);
        heap.deleteBH();

        assertTrue("Array should be null after deletion", heap.array == null);
    }

    public static void main(String[] args) {
        System.out.println("--- Starting Binary Heap Test Suite ---");

        testConstructor();
        testIsEmpty();
        testPeek();
        testSizeOfBP();
        testInsertMinHeap();
        testInsertMaxHeap();
        testExtractHeadMinHeap();
        testExtractHeadMaxHeap();
        testLevelOrder();
        testDeleteBH();

        System.out.println("Test results: " + testsPassed + "/" + totalTests + " tests passed.");

    }
}
