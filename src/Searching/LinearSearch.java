public class LinearSearch {
    public static int LinearSearch(int array[], int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                System.out.println("The element was found at the following index: " + i);
                return i;
            }
        }

        System.out.println("The element: " + value + " was not found");
        return -1;
    }
}
