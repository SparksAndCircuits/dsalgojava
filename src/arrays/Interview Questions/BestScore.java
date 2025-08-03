//Given an array, write a function to get first and second best scores from the array and return it in a new array.
//The array may contain duplicates.
public class BestScore {
    public static int[] findTopTwoScores(int[] array) {
        int bestScore = Integer.MIN_VALUE;
        int secondBestScore = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > bestScore) {
                secondBestScore = bestScore;
                bestScore = array[i];
            } else if (array[i] > secondBestScore && array[i] != bestScore) {
                secondBestScore = array[i];
            }
        }

        return new int[] { bestScore, secondBestScore };
    }

    public static void main(String[] args) {
        int[] scores1 = { 84, 85, 86, 87, 85, 90, 85, 83, 23, 45, 84, 1, 2, 0 };
        int[] result1 = findTopTwoScores(scores1);
        System.out.println("Test 1 - Input: [84,85,86,87,85,90,85,83,23,45,84,1,2,0]");
        System.out.println("Result: [" + result1[0] + ", " + result1[1] + "]");

        int[] score2 = { 90, 89, 87, 85 };
        int[] result2 = findTopTwoScores(score2);
        System.out.println("\nTest 2 -Input: [90,89,87,85]");
        System.out.println(("Result: [" + result2[0] + ", " + result2[1] + "]"));
    }
}
