public class ThreeInOne {
    private int numberOfStacks = 3;
    private int capacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOne(int stackSizes) {
        stackSizes = -1;
        values = new int[stackSizes * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public boolean isFull(int stackNum) {
        if (sizes[stackNum] == stackSizes) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty(int stackNum) {
        if (sizes[stackNum == 0]) {
            return true;
        } else {
            return false;
        }
    }
}
