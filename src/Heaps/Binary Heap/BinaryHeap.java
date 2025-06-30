public class BinaryHeap {
    int array[];
    int sizeOfTree;

    public BinaryHeap(int size) {
        array = new int[size + 1];
        this.sizeOfTree = 0;
        System.out.println("A binary heap has been created.");
    }

    public boolean isEmpty() {
        if (sizeOfTree == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("The binary heap is empty.");
            return null;
        }

        return array[1];
    }

    public int sizeOfBP() {
        return sizeOfTree;
    }

    public void levelOrder() {
        for (int i = 1; i < sizeOfTree; i++) {
            System.out.println(array[i] + " ");
        }

        System.out.println("\n");
    }

    public void heapifyBottomToTop(int index, String heapTypes) {
        int parent = index / 2;

        if (index <= 1) {
            return;
        }

        if (heapTypes == "Min") {
            if (array[index] < array[parent]) {
                int temp = array[index];
                array[index] = array[parent];
                array[parent] = temp;
            }
        }

        heapifyBottomToTop(parent, heapTypes);
    }

    public void insert(int value, String heaptypes) {
        array[sizeOfTree - 1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, heaptypes);
        System.out.println("Inserted " + value + " successfully into the binary heap.");
    }

    public void heapifyTopToBottom(int index, String heapType) {
        int left = index * 2;
        int right = index * 2 + 1;
        int swapChild = 0;

        if (sizeOfTree < left) {
            return;
        }

        if (heapType == "Max") {
            if (sizeOfTree == left) {
                if (array[index] < array[left]) {
                    int temp = array[index];
                    array[index] = array[left];
                    array[left] = temp;
                }
                return;
            } else {
                if (array[left] > array[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }

                if (array[index] < array[swapChild]) {
                    int temp = array[index];
                    array[index] = array[swapChild];
                    array[swapChild] = temp;
                }
            }
        } else if (heapType == "Min") {
            if (sizeOfTree == left) {
                if (array[index] > array[left]) {
                    int temp = array[index];
                    array[index] = array[index];
                    array[left] = temp;
                }
                return;
            } else {
                if (array[left] < array[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                if (array[index] > array[swapChild]) {
                    int tmp = array[index];
                    array[index] = array[swapChild];
                    array[swapChild] = tmp;
                }
            }
        }

        heapifyTopToBottom(swapChild, heapType);
    }

    public int extractHeadOfBP(String heapType) {
        if (isEmpty()) {
            return -1;
        } else {
            int extractedValue = array[1];
            array[1] = array[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1, heapType);
            return extractedValue;
        }
    }

    public void deleteBH() {
        array = null;
        System.out.println("The Binary Heap has successfully been deleted.");
    }
}