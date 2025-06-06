public class QueueArray {
    int[] array;
    int topOfQueue;
    int beginningOfQueue;

    public QueueArray(int size) {
        this.array = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("The queue was successfully created with a size of: " + size);
    }

    public boolean isFull() {
        if (topOfQueue == array.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (beginningOfQueue == -1 || beginningOfQueue == array.length) {
            return true;
        } else {
            return false;
        }
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The queue is full.");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            array[topOfQueue] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        } else {
            topOfQueue++;
            array[topOfQueue] = value;
            System.out.println("Successfully inserted." + value + " in the queue");
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty!");
            return -1;
        } else {
            int result = array[beginningOfQueue];
            beginningOfQueue++;

            if (beginningOfQueue > topOfQueue) {
                beginningOfQueue = topOfQueue = -1;
            }

            return result;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return array[beginningOfQueue];
        } else {
            System.out.println("The queue is empty.");
            return -1;
        }
    }

    public void deleteQueue() {
        array = null;
        System.out.println("The queue is successfully deleted.");
    }
}