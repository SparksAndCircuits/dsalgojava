//package arrays.LeetCode;

/* You are given two integer arrays. Write a program to checkf
 * if they are permutations of each other.
 */
public class RotateMatrix {
    public boolean rotateMatrix(int[][] matrix) {

        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }

        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        return true;
    }

    private void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    private boolean matricesEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }

        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) {
                return false;
            }

            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void runAllTests() {
        System.out.println("--- Matrix rotation tests ---");

        testEmptyMatrix();
        testNonSquareMatrix();
        test1x1Matrix();
        test2x2Matrix();
        test3x3Matrix();
        test4x4Matrix();
        testLargerMatrix();
        testNegativeNumbers();
        testZeroMatrix();
        testIdenticalElements();

        System.out.println("Tests are completed");
    }

    // Test case 1
    private void testEmptyMatrix() {
        System.out.println("Test 1: Empty Matrix");
        int[][] matrix = {};
        boolean result = rotateMatrix(matrix);
        System.out.println("Expected: false");
        System.out.println("Actual: " + result);
        System.out.println("Pass: " + (!result) + "\n");
    }

    // Test case 2
    private void testNonSquareMatrix() {
        System.out.println("Test 2: Non square matrix");
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
        boolean result = rotateMatrix(matrix);
        System.out.println("Expected: false");
        System.out.println("Actual: " + result);
        System.out.println("Pass: " + (!result) + "\n");
    }

    // Test case 3
    private void test1x1Matrix() {
        System.out.println("Test 3: 1x1 Matrix");
        int[][] matrix = { { 5 } };
        int[][] expected = { { 5 } };

        System.out.println("Before rotation");
        printMatrix(matrix);
        boolean result = rotateMatrix(matrix);
        printMatrix(matrix);
        boolean isCorrect = result && matricesEqual(matrix, expected);
        System.out.println("Expected: false");
        System.out.println("Actual: " + result);
        System.out.println("Pass: " + isCorrect + "\n");
    }

    // Test case 4
    private void test2x2Matrix() {
        System.out.println("Test 4: 2x2 Matrix");
        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        int[][] expected = { { 3, 1 }, { 4, 2 } };

        System.out.println("Before rotation");
        printMatrix(matrix);
        boolean result = rotateMatrix(matrix);
        printMatrix(matrix);
        boolean isCorrect = result && matricesEqual(matrix, expected);
        System.out.println("Expected: false");
        System.out.println("Actual: " + result);
        System.out.println("Pass: " + isCorrect + "\n");
    }

    // Test case 5
    private void test3x3Matrix() {
        System.out.println("Test 5: 3x3 Matrix");
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] expected = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };

        System.out.println("Before rotation");
        printMatrix(matrix);
        boolean result = rotateMatrix(matrix);
        printMatrix(matrix);
        boolean isCorrect = result && matricesEqual(matrix, expected);
        System.out.println("Expected: false");
        System.out.println("Actual: " + result);
        System.out.println("Pass: " + isCorrect + "\n");
    }

    // Test case 6
    private void test4x4Matrix() {
        System.out.println("Test 6: 4x4 matix");
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int[][] expected = { { 13, 9, 5, 1 }, { 14, 10, 6, 2 }, { 15, 11, 7, 3 }, { 16, 12, 8, 4 } };

        System.out.println("Before rotation");
        printMatrix(matrix);

        boolean result = rotateMatrix(matrix);

        System.out.println("After rotation");
        printMatrix(matrix);

        boolean isCorrect = result && matricesEqual(matrix, expected);
        System.out.println("Expected return: true." + result);
        System.out.println("PASS: " + isCorrect + "\n");
    }

    // Test case 7
    private void testLargerMatrix() {
        int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 } };
        int[][] expected = { { 21, 16, 11, 6, 1 }, { 22, 17, 12, 7, 2 }, { 23, 18, 13, 8, 3 }, { 24, 19, 14, 9, 4 },
                { 25, 20, 15, 5 } };

        System.out.println("Before rotation");
        printMatrix(matrix);

        boolean result = rotateMatrix(matrix);

        System.out.println("After rotation");
        printMatrix(matrix);

        boolean isCorrect = result && matricesEqual(matrix, expected);
        System.out.println("Expected return: true." + result);
        System.out.println("PASS: " + isCorrect + "\n");
    }

    // Test case 8
    private void testNegativeNumbers() {
        System.out.println("Test 8: Matrix with Negative Numbers");
        int[][] matrix = { { -1, -2 }, { -3, -4 } };
        int[][] expected = { { -3, -1 }, { -4, -2 } };

        System.out.println("Before rotation");
        printMatrix(matrix);

        boolean result = rotateMatrix(matrix);

        System.out.println("After rotation");
        printMatrix(matrix);

        boolean isCorrect = result && matricesEqual(matrix, expected);
        System.out.println("Expected return: true." + result);
        System.out.println("PASS: " + isCorrect + "\n");
    }

    // Test case 9
    private void testZeroMatrix() {
        System.out.println("Test 9: Matrix with All Zeros");
        int[][] matrix = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        int[][] expected = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

        System.out.println("Before rotation");
        printMatrix(matrix);

        boolean result = rotateMatrix(matrix);

        System.out.println("After rotation");
        printMatrix(matrix);

        boolean isCorrect = result && matricesEqual(matrix, expected);
        System.out.println("Expected return: true." + result);
        System.out.println("PASS: " + isCorrect + "\n");
    }

    // Test case 10
    private void testIdenticalElements() {
        System.out.println("Test 9: Matrix with All Zeros");
        int[][] matrix = { { 7, 7, 7 }, { 7, 7, 7 }, { 7, 7, 7 } };
        int[][] expected = { { 7, 7, 7 }, { 7, 7, 7 }, { 7, 7, 7 } };

        System.out.println("Before rotation");
        printMatrix(matrix);

        boolean result = rotateMatrix(matrix);

        System.out.println("After rotation");
        printMatrix(matrix);

        boolean isCorrect = result && matricesEqual(matrix, expected);
        System.out.println("Expected return: true." + result);
        System.out.println("PASS: " + isCorrect + "\n");
    }

    public static void main(String[] args) {
        RotateMatrix tester = new RotateMatrix();
        tester.runAllTests();
    }
}
