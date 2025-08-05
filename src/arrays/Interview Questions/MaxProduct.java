//How to find maximum product of two integers in the array where all elements are postive.
public class MaxProduct {
    public int maxProduct(int[] intArray) {
        int first = 0;
        int second = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > first) {
                second = first;
                first = intArray[i];
            } else if (intArray[i] > second) {
                second = intArray[i];
            }
        }

        return first * second;
    }
}
