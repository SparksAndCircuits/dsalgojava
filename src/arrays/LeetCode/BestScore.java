package arrays.LeetCode;

/* Given an array, write a function to get the first and second best scores
 * from the array and return it in a new array. The array may contain duplicates.
 */

public class BestScore {
    public static int[] findTopTwoScores(int[] array) {
        int firstHighest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int score : array) {
            if (score > firstHighest) {
                secondHighest = firstHighest;
                firstHighest = score;
            } else if (score > secondHighest && score < firstHighest) {
                secondHighest = score;
            }
        }

        return new int[] { firstHighest, secondHighest };
    }
}
