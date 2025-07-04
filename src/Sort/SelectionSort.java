public class SelectionSort {
    static void SelectionSort(int[] a) {
        for (int j = 0; j < a.length; j++) {
            int minimumIndex = 0;

            for (int i = j + 1; i < a.length; i++) {
                if (a[i] < a[minimumIndex]) {
                    minimumIndex = i;
                }
            }

            if (minimumIndex != j) {
                int temp = a[j];
                a[j] = a[minimumIndex];
                a[minimumIndex] = temp;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
}