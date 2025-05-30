/* Given two dimensional arrays calculate the sum of the diagonal elements. */
public class SumDiagonalElements {
    public static int sumDiagonalElements(int[][] array) {
        int sum = 0;
        int numRows = array.length;

        for (int i = 0; i < numRows; i++) {
            sum += array[i][i];
        }

        return sum;
    }

    // Test 1: 3x3 square matrix.
    public static void testSquareMatrix3x3() {
        System.out.println("Test 1: 3x3 square matrix.");
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int expected = 15;
        int actual = SumDiagonalElements.sumDiagonalElements(matrix);

        if (actual == expected) {
            System.out.println(
                    "This test has passed. The expected result was: " + expected + " We got the following: " + actual);
        } else {
            System.out.println("This test failed. What we expected: " + expected + " what we got: " + actual);
        }

        System.out.println();
    }

    // Test 2: 2x2 square matrix
    public static void testSquareMatrix2x2() {
        System.out.println("Test 2: 2x2 square matrix.");
        int[][] matrix = { { 10, 20 }, { 40, 50 } };
        int expected = 50;
        int actual = SumDiagonalElements.sumDiagonalElements(matrix);

        if (actual == expected) {
            System.out.println(
                    "This test has passed. The expected result was: " + expected + " We got the following: " + actual);
        } else {
            System.out.println("This test failed. What we expected: " + expected + " what we got: " + actual);
        }

        System.out.println();
    }

    // Test 3: Single Element
    public static void testSingleElement() {
        System.out.println("Test 3: Single Element.");
        int[][] matrix = { { 10 } };
        int expected = 10;
        int actual = SumDiagonalElements.sumDiagonalElements(matrix);

        if (actual == expected) {
            System.out.println(
                    "This test has passed. The expected result was: " + expected + " We got the following: " + actual);
        } else {
            System.out.println("This test failed. What we expected: " + expected + " what we got: " + actual);
        }

        System.out.println();
    }

    // Test 4: Negative Numbers
    public static void testNegativeNumbers() {
        System.out.println("Test 4: Negative Numbers.");
        int[][] matrix = { { -1, 2, 3 }, { 4, -5, 6 }, { 7, 8, -9 } };
        int expected = -15;
        int actual = SumDiagonalElements.sumDiagonalElements(matrix);

        if (actual == expected) {
            System.out.println(
                    "This test has passed. The expected result was: " + expected + " We got the following: " + actual);
        } else {
            System.out.println("This test failed. What we expected: " + expected + " what we got: " + actual);
        }

        System.out.println();
    }

    // Test 5: Zero values.
    public static void testZeroElements() {
        System.out.println("Test 5: Zero Elements.");
        int[][] matrix = { { 0, 2, 3 }, { 4, 0, 6 }, { 7, 8, 0 } };
        int expected = 0;
        int actual = SumDiagonalElements.sumDiagonalElements(matrix);

        if (actual == expected) {
            System.out.println(
                    "This test has passed. The expected result was: " + expected + " We got the following: " + actual);
        } else {
            System.out.println("This test failed. What we expected: " + expected + " what we got: " + actual);
        }

        System.out.println();
    }

    // Test 6: 4x4 matrix.
    public static void testLargerMatrix() {
        System.out.println("Test 6: 4x4 matrix.");
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int expected = 34;
        int actual = SumDiagonalElements.sumDiagonalElements(matrix);

        if (actual == expected) {
            System.out.println(
                    "This test has passed. The expected result was: " + expected + " We got the following: " + actual);
        } else {
            System.out.println("This test failed. What we expected: " + expected + " what we got: " + actual);
        }

        System.out.println();
    }

    // Test 7: Negative and positive numbers.
    public static void testMixedNumbers() {
        System.out.println("Test 7: Negative and positive numbers.");
        int[][] matrix = { { 5, -2, 3 }, { -4, 10, -6 }, { 7, -8, -15 } };
        int expected = 0;
        int actual = SumDiagonalElements.sumDiagonalElements(matrix);

        if (actual == expected) {
            System.out.println(
                    "This test has passed. The expected result was: " + expected + " We got the following: " + actual);
        } else {
            System.out.println("This test failed. What we expected: " + expected + " what we got: " + actual);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--- Testing suite for SumDiagonalElements ---");

        testLargerMatrix();
        testMixedNumbers();
        testNegativeNumbers();
        testSingleElement();
        testSquareMatrix2x2();
        testSquareMatrix3x3();
        testZeroElements();

        System.out.println("--- Tests for SumDiagonalElements have been completed. ---");
    }
}
