public class BinaryToDecimalTest {
    private BinaryToDecimal converter;

    public BinaryToDecimalTest() {
        converter = new BinaryToDecimal();
    }

    private Node createBinaryList(int[] binaryDigits) {
        if (binaryDigits.length == 0) {
            return null;
        }

        Node head = new Node(binaryDigits[0]);
        Node current = head;

        for (int i = 1; i < binaryDigits.length; i++) {
            current.next = new Node(binaryDigits[i]);
            current = current.next;
        }

        return head;
    }

    // private int calculateExpectedDecimal(int[] binaryDigits) {
    // int result = 0;

    // for (int digit : binaryDigits) {
    // result = result * 2 + digit;
    // }

    // return result;
    // }

    private void printBinary(int[] binary) {
        System.out.println("Binary: ");
        for (int digit : binary) {
            System.out.print(digit);
        }
    }

    private void runTest(String testName, int[] binaryDigits, int expected) {
        System.out.println("--- " + testName + " ---");

        printBinary(binaryDigits);
        System.out.println(" -> Expected Decimal: " + expected);

        converter.head = createBinaryList(binaryDigits);
        int actual = converter.binaryToDecimal();

        System.out.println("Result: " + actual);

        if (actual == expected) {
            System.out.println("This test passed.");
        } else {
            System.out.println("This test failed");
        }
    }

    // Test Case 1:
    public void testSingleBit() {
        runTest("single Bit - 1", new int[] { 1 }, 1);
        runTest("single Bit - 0", new int[] { 0 }, 0);
    }

    // Test Case 2:
    public void testTwoBits() {
        runTest("Two Bits - 10", new int[] { 1, 0 }, 2);
        runTest("Two Bits - 11", new int[] { 1, 1 }, 3);
        runTest("Two Bits - 01", new int[] { 0, 1 }, 1);
        runTest("Two Bits - 00", new int[] { 0, 0 }, 0);
    }

    // Test Case 3:
    public void testThreeBits() {
        runTest("Three Bits - 101", new int[] { 1, 0, 1 }, 5);
        runTest("Three Bits - 111", new int[] { 1, 1, 1 }, 7);
        runTest("Three Bits - 100", new int[] { 1, 0, 0 }, 4);
    }

    // Test Case 4:
    public void testFourBits() {
        runTest("Four Bits - 1010", new int[] { 1, 0, 1, 0 }, 10);
        runTest("Four Bits - 1111", new int[] { 1, 1, 1, 1 }, 15);
        runTest("Four Bits - 1010", new int[] { 1, 0, 0, 0 }, 8);
    }

    // Test Case 5:
    public void testLongerBinary() {
        runTest("Eight Bits - 11010110", new int[] { 1, 1, 0, 1, 0, 1, 1, 0 }, 214);
        runTest("Eight Bits - 10101010", new int[] { 1, 0, 1, 0, 1, 0, 1, 0 }, 170);
    }

    // Test Case 6:
    public void testLeadingZeros() {
        runTest("Leading zeros - 0001", new int[] { 0, 0, 0, 1 }, 1);
        runTest("Leading zeros - 0010", new int[] { 0, 0, 1, 0 }, 2);
    }

    // Test Case 7:
    public void testAllZeros() {
        runTest("All Zeros", new int[] { 0, 0, 0, 0 }, 0);
    }

    // Test Case 8:
    public void testEmptyList() {
        System.out.println("--- Empty List Test ---");
        converter.head = null;

        int result = converter.binaryToDecimal();

        System.out.println("Empty List -> Expected: 0");
        System.out.println("Results: " + result);

        if (result == 0) {
            System.out.println("The test has passed");
        } else {
            System.out.println("The test has failed");
        }
    }

    // Test Case 9:
    public void testLargeBinary() {
        runTest("Ten Bits - All Ones", new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 1023);
        runTest("Eleven Bits - Power of 2", new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 1024);
    }

    public void runAllTests() {
        System.out.println("--- Binary to Decimal Conversion Tests Starting ---");

        testSingleBit();
        testTwoBits();
        testThreeBits();
        testFourBits();
        testLongerBinary();
        testLeadingZeros();
        testAllZeros();
        testEmptyList();
        testLargeBinary();

        System.out.println("--- All tests have been completed --- ");
    }

    public static void main(String[] args) {
        BinaryToDecimalTest tester = new BinaryToDecimalTest();
        tester.runAllTests();
    }
}
