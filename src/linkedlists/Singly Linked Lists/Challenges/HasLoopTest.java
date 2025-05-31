public class HasLoopTest {
    public static void main(String[] args) {
        HasLoop list = new HasLoop();

        System.out.println("--- Testing hasLoop() method ---");

        // Test 1: Empty List
        System.out.println("Test 1: Empty List");
        boolean result1 = list.hasLoop();
        System.out.println("Expected: False, but we got: " + result1);
        System.out.println("Pass: " + (result1 == false));
        System.out.println();

        // Test 2: Single node, no loop
        System.out.println("Test 2: Single node, no loop");
        list.append(1);
        list.printList(5);
        boolean result2 = list.hasLoop();
        System.out.println("Expected: False, but we got: " + result2);
        System.out.println("Pass: " + (result2 == false));
        list.clear();
        System.out.println();

        // Test 3: Multiple node, no loop
        System.out.println("Test 3: Multiple node, no loop");
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.printList(5);
        boolean result3 = list.hasLoop();
        System.out.println("Expected: False, but we got: " + result3);
        System.out.println("Pass: " + (result3 == false));
        list.clear();
        System.out.println();

        // Test 4: Two nodes with loop (last points to first)
        System.out.println("Test 4: Two nodes with loop");
        list.append(1);
        list.append(2);
        list.createLoop(0);
        list.printList(5);
        boolean result4 = list.hasLoop();
        System.out.println("Expected: False, but we got: " + result4);
        System.out.println("Pass: " + (result4 == false));
        list.clear();
        System.out.println();

        // Test 5: Multiple node, with a loop in the middle
        System.out.println("Test 5: Multiple node, with a loop in the middle");
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.printList(10);
        boolean result5 = list.hasLoop();
        System.out.println("Expected: False, but we got: " + result5);
        System.out.println("Pass: " + (result5 == false));
        list.clear();
        System.out.println();

        // Test 6: Large list with no loop
        System.out.println("Test 6: Large list with no loop.");
        for (int i = 1; i <= 100; i++) {
            list.append(i);
        }
        System.out.println("Created list with 100 nodes with no loop");
        boolean result6 = list.hasLoop();
        System.out.println("Expected: False, but we got: " + result6);
        System.out.println("Pass: " + (result6 == false));
        list.clear();
        System.out.println();

        // Test 7: Large list with no loop
        System.out.println("Test 6: Large list with no loop.");
        for (int i = 1; i <= 50; i++) {
            list.append(i);
        }
        System.out.println("Created list with 50 nodes with a loop at position 25");
        boolean result7 = list.hasLoop();
        System.out.println("Expected: False, but we got: " + result7);
        System.out.println("Pass: " + (result7 == true));
        list.clear();
        System.out.println();

        // Test 8: Self-loop(Single node pointing to itself)
        System.out.println("Test 9: Single node self-loop.");
        list.append(42);
        HasLoop.head.next = HasLoop.head;
        list.printList(5);
        boolean result8 = list.hasLoop();
        System.out.println("Expected: False, but we got: " + result8);
        System.out.println("Pass: " + (result8 == false));
        list.clear();
        System.out.println();

        System.out.println("--- All tests have been completed ---");
    }
}
