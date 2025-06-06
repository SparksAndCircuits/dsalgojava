public class CircularQueue {
    int[] array;
    int topOfQueue;
    int beginningOfQueue;
    int size;

    public CircularQueue(int size) {
        this.array = new int[size];
        this.size = size;
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("The Ciruclar Queue was successfully created with the size of " + size);
    }

    public boolean isEmpty() {
        if (topOfQueue == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (topOfQueue + 1 == beginningOfQueue) {
            return true;
        } else if (beginningOfQueue == 0 && topOfQueue + 1 == size) {
            return true;
        } else {
            return false;
        }
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The circular queue is full.");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            array[topOfQueue] = value;
            System.out.println("Value was successfully inserted " + value + " in the queue.");
        } else {
            if (topOfQueue + 1 == size) {
                topOfQueue = 0;
            } else {
                topOfQueue++;
            }

            array[topOfQueue] = value;
            System.out.println("Value was successfully inserted " + value + " in the queue");
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The Circular queue is empty.");
            return -1;
        } else {
            int result = array[beginningOfQueue];
            array[beginningOfQueue] = 0;

            if (beginningOfQueue == topOfQueue) {
                beginningOfQueue = topOfQueue = -1;
            } else if (beginningOfQueue + 1 == size) {
                beginningOfQueue = 0;
            } else {
                beginningOfQueue++;
            }

            return result;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The Circular Queue is Empty!");
            return -1;
        } else {
            return array[beginningOfQueue];
        }
    }

    public void deleteQueue() {
        array = null;
        System.out.println("The Circular Queue has successfully has been deleted.");
    }
}