public class NumberOfPathsToReachLastCell {
    public int numberofPaths(int array[][], int row, int col, int cost) {
        if (cost < 0) {
            return 0;
        }

        if (row == 0 && col == 0) {
            return (array[0][0] - cost == 0) ? 1 : 0;
        }

        if (row == 0) {
            return numberofPaths(array, 0, col - 1, cost - array[row][col]);
        }

        if (col == 0) {
            return numberofPaths(array, row - 1, 0, cost - array[row][col]);
        }

        int noOfPathsFromPreviousRow = numberofPaths(array, row - 1, col, cost - array[row][col]);
        int noOfPathsFromPreviousCol = numberofPaths(array, row, col - 1, cost - array[row][col]);

        return noOfPathsFromPreviousRow + noOfPathsFromPreviousCol;
    }
}
