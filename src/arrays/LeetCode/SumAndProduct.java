/*
 * Create a function which calculates the sum and product of elements of array.
 * Find the time complextiy for the created method.
 */

public class SumAndProduct {
    public void spOfArray(int[] array) {
        int sum = 0;
        int product = 1;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }

        System.out.println(sum + ", " + product);
    }

    public static void main(String[] args) {
        SumAndProduct main = new SumAndProduct();
        int[] customArray = { 1, 2, 3, 4, 5 };
        main.spOfArray(customArray);
    }
}
