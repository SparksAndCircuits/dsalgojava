package arrays;

public class TwoDimensionArray {
    int array[][];

    // Creation of a two dimensional array
    public TwoDimensionArray(int numberOfRows, int numberOfColumns) {
        this.array = new int[numberOfRows][numberOfColumns];

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                array[row][col] = Integer.MIN_VALUE;
            }
        }
    }

    // Inserting a value into a two dimensional array
    public void insert(int row, int col, int value) {
        try {
            if (array[row][col] == Integer.MIN_VALUE) {
                array[row][col] = value;
                System.out.println("The value has been successfully inserted.");
            } else {
                System.out.println("The cell is already occupied.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index for the 2D array");
        }
    }

    // Accessing an element in a two dimensional array
    public void access(int row, int col) {
        System.out.println("\nAccessing row# " + row + "column # " + col);
        System.out.println("The cell value is: " + array[row][col]);
    }

    // Traversal through a two dimensional array
    public void traversal() {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                System.out.println("The array is as follows: " + array[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Search for a value in a two dimensional array
    public void search(int value) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] == value) {
                    System.out.println("Value is found at row: " + row + " and column: " + col);
                    return;
                }
            }
        }

        System.out.println("Value was not found in the array");
    }

    // Deleting a value from a two dimensional array
    public void delete(int row, int col) {
        System.out.println("Successfully deleted the value: " + array[row][col]);
        array[row][col] = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        System.out.println("--- Testing twoDimensionalArray ---\n");

        // Test 1: Basic array creation and initialization
        System.out.println("Test 1: Create a 3x3 array");
        TwoDimensionArray array2D = new TwoDimensionArray(3, 3);
        array2D.traversal();

        // Test 2: Inserting valid elements
        System.out.println("\nTest 2: Inserting elements");
        array2D.insert(0, 0, 10);
        array2D.insert(1, 1, 20);
        array2D.insert(2, 2, 30);
        array2D.insert(0, 2, 15);
        array2D.traversal();

        // Test 3: Try to insert in an occupied cell
        System.out.println("\nTest 3: Trying to insert in an occpied cell");
        array2D.insert(0, 0, 99);
        array2D.traversal();

        // Test 4: Insert at invalid columns and rows
        System.out.println("\nTest 4: Inserting at a invalid column and row");
        array2D.insert(5, 5, 100);
        array2D.insert(-1, 0, 100);
        array2D.insert(0, -1, 100);
        array2D.insert(3, 2, 100);
        array2D.insert(1, 3, 100);
        array2D.traversal();

        // Test 5: Accessing elements
        System.out.println("\nTest 5: Accessing elements");
        array2D.access(0, 0);
        array2D.access(1, 0);
        array2D.access(2, 2);

        // Test 6: Accessing invalid elements
        System.out.println("\nTest 6: Accessing invalid elements");
        array2D.access(5, 5);
        array2D.access(-1, 0);

        // Test 7: Searching for elements
        System.out.println("\nTest 7: Searching for elements");
        array2D.search(20);
        array2D.search(99);
        array2D.search(Integer.MIN_VALUE);

        // Test 8: Deleting elements
        System.out.println("\nTest 8: Deleting elements");
        array2D.delete(1, 1);
        array2D.traversal();

        // Test 9: Delete from empty cell and invalid columns/rows
        System.out.println("\nTest 9: deleting edge cases");
        array2D.delete(1, 1);
        array2D.delete(5, 5);
        array2D.delete(-1, 0);

        // Test 10: Edge case a 1x1 array
        System.out.println("\nTest 10: Edge case: 1x1 array");
        TwoDimensionArray smallArray = new TwoDimensionArray(1, 1);
        smallArray.insert(0, 0, 89);
        smallArray.traversal();
        smallArray.access(0, 0);
        smallArray.search(89);
        smallArray.delete(0, 0);
        smallArray.traversal();

        // Test 11: Edge case- rectangular array
        System.out.println("\nTest 11: Rectangular array");
        TwoDimensionArray rectArray = new TwoDimensionArray(2, 4);
        rectArray.insert(0, 0, 1);
        rectArray.insert(0, 3, 2);
        rectArray.insert(1, 1, 3);
        rectArray.insert(1, 2, 4);
        rectArray.traversal();

        // Test 12: Fill entire array
        System.out.println("\nTest 12: Filling entire small array");
        TwoDimensionArray fullArray = new TwoDimensionArray(2, 2);
        int value = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                fullArray.insert(i, j, value++);
            }
        }

        fullArray.traversal();

        // Test 13: Edge Case - Create a 0x0 array
        System.out.println("\nTest case 13: Edge case - Create a 0x0 array");
        try {
            TwoDimensionArray zeroArray = new TwoDimensionArray(0, 0);
            System.out.println("0x0 array was created");
            zeroArray.traversal();
        } catch (Exception e) {
            System.out.println("Exception with 0x0 array: " + e.getClass().getSimpleName());
        }

        // Test 14: Testing special values
        System.out.println("\bTest cae 14: Testing with special values");
        TwoDimensionArray specialArray = new TwoDimensionArray(2, 2);
        specialArray.insert(0, 0, 0);
        specialArray.insert(0, 1, -100);
        specialArray.insert(1, 0, Integer.MAX_VALUE);
        specialArray.traversal();
        specialArray.search(0);
        specialArray.search(Integer.MAX_VALUE);

        System.out.println("\n--- All test cases have been complete ---");
    }
}
