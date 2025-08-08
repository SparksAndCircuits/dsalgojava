//Describe how you could use a single array to implement three stacks
public class ThreeInOne {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;
    int[] array;
    int topOfStack;

    public ThreeInOne(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public boolean isFull(int stackNum) {
        if (sizes[stackNum] == stackCapacity) {
            System.out.println("The stack is full.");
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty(int stackNum) {
        if (topOfStack == -1) {
            return true;
        } else {
            return false;
        }
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    // private void push(int stackNum, int value) {
    //     if (isFull(stackNum)) {
    //     System.out.println("The Stack is Full");
    //     } else {
    //     sizes[stackNum]++;
    //     values[indexOfTop(stackNum)] = value;
    //     }
    // }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("The stack is empty.");
            return -1;
        } else {
            int topStack = array[stackNum];
            topStack--;
            return topStack;
        }
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("The stack is empty.");
            return -1;
        } else {
            return array[indexOfTop(stackNum)];
        }
    }
}
