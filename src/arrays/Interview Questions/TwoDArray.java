//Given a 2D array calculate the sum of diagonal elements
public class TwoDArray {
    public static int sumDiagonalElements(int[][] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i][i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Matrix:");
        for (int[] row : matrix1) {
            for (int val : row) {
                System.out.print(val + " ");
            }

            System.out.println(" ");
        }

        System.out.println("The sum of both diagonals: " + sumDiagonalElements(matrix1));
    }
}
