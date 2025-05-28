package arrays.LeetCode;

/* Write a function called middle that takes an array and returns a new array that contains all but the first and last element */
import java.util.Arrays;

public class MiddleFunction {
    public static int[] middle(int[] array) {

        if (array.length <= 2) {
            return new int[0];
        }

        int[] middleArray = new int[array.length - 2];

        int index = 1;

        while (index < array.length - 1) {
            middleArray[index - 1] = array[index];
            index++;
        }

        return middleArray;
    }
}
