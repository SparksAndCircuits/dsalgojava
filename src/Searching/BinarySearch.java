public class BinarySearch {
    public static int BinarySearch(int array[], int value) {
        int start = 0;
        int end = array.length - 1;
        int middle = (start + end) / 2;

        while (array[middle] != value && start <= end) {
            if (value < array[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }

            middle = (start + end) / 2;
        }

        if (array[middle] == value) {
            System.out.println("The element is found at the index: " + middle);
            return middle;
        } else {
            System.out.println("The element " + value + " was not found.");
            return -1;
        }
    }
}