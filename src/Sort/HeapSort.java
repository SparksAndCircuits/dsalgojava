public class HeapSort {
    int[] array = null;

    public HeapSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        BinaryHeap bh = new BinaryHeap(array.length);
        for (int i = 0; i < array.length; i++) {
            bh.insertInHeap(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = bh.extracHeadOfHeap();
        }
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
