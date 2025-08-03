
//Write a function which takes integer array as a parameter and returns a new integer array with unique elements. (Remove duplicates)
import java.util.Arrays;

public class DuplicateNumber {
    public static int[] removeDuplicate(int[] array) {
        int[] uniqueArray = new int[array.length];
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                uniqueArray[result] = array[i];
                result++;
            }
        }

        return Arrays.copyOf(uniqueArray, result);
    }

    public static void main(String[] args) {
        int[] test = { 1, 2, 2, 3, 4, 4, 4, 5 };
        System.out.println("Original Array: " + Arrays.toString(test));
        System.out.println("Removing Duplicates: " + Arrays.toString(removeDuplicate(test)));
    }
}