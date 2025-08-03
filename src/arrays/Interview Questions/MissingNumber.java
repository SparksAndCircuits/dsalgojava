//Write a java function called findMissingNumberInArray that takes an integer array containing n-1 unique elemnts from a range of 1 to n, with one missing number, and returns the missing number.
public class MissingNumber {
    static int findMissingNumberInArray(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] test = { 1, 2, 4, 5, 6 };
        System.out.println("Test Array: [1,2,4,5,6]");
        System.out.println("Missing Number: " + findMissingNumberInArray(test));
    }
}
