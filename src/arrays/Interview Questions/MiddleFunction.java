//Write a function called middle that takes an array and 
//returns a new array that contains all but the first and last elements
public class MiddleFunction {
    public static int[] middle(int[] array) {
        int[] result = new int[array.length - 2];

        for (int i = 1; i < array.length - 1; i++) {
            result[i - 1] = array[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test1 = { 1, 2, 3, 4, 5 };
        int[] result1 = middle(test1);

        System.out.println("Input: [1, 2, 3, 4, 5] -> Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);

            if (i < result1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
