/* Write a program to check if an array is unique or not */

public class ContainsDuplicates {
    public boolean isUnique(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] == intArray[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ContainsDuplicates mn = new ContainsDuplicates();
        int[] intArray = { 1, 2, 3, 4, 5, 6 };
        boolean result = mn.isUnique(intArray);
        System.out.println(result);
    }
}
