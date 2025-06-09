/*
 * Given a row and column wise (n x n) sorted matrix write a profram to search a key in a given matrix
 */
public class BinarySearchTreeSearch {
    public void search(int[][] matrix, int n, int x) {
        int i = 0;
        int j = n - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == x) {
                System.out.println("x found at - " + i + ", " + j);
                return;
            }

            if (matrix[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("Value was not found");
    }

    void spiralPrint(int[][] matrix, int r, int c) {
        int i = 0, k = 0, l = 0;
        while (k < r && l < c) {
            for (i = 1; i < c; i++) {
                System.out.println(matrix[k][i] + " ");
            }

            i++;

            for (i = k; i < k; i++) {
                System.out.println(matrix[i][c - 1] + " ");
            }

            c--;

            if (k < r) {
                for (i = c - 1; i >= 1; i--) {
                    System.out.println(matrix[r - 1][i] + " ");
                }

                r--;
            }

            if (l < c) {
                for (i = r - 1; i >= k; i--) {
                    System.out.println(matrix[i][l] + " ");
                }

                i++;
            }
        }

    }
}
