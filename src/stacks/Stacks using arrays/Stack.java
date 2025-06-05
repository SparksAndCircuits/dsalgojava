public class Stack {
    int[] array;
    int topOfStack;

    public Stack(int size) {
        this.array = new int[size];
        this.topOfStack = -1;
        System.out.println("The stack has been created with a size of: " + size);
    }

    public boolean isEmpty() {
        if (topOfStack == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (topOfStack == array.length - 1) {
            System.out.println("The stack is full.");
            return true;
        } else {
            return false;
        }
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("The stack is full!");
        } else {
            array[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("The value has successfully been inserted");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return -1;
        } else {
            int topStack = array[topOfStack];
            topOfStack--;
            return topStack;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return -1;
        } else {
            return array[topOfStack];
        }
    }

    public void deleteStack() {
        array = null;
        System.out.println("The stack has successfully been deleted.");
    }

    public static void main(String[] args) {
        System.out.println("--- Testing the stack program ---");

        // Test case 1:
        System.out.println("Test 1: Creating a stack of size 4.");
        Stack stack = new Stack(4);
        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("Is the stack full? " + stack.isFull());
        System.out.println();

        // Test case 2:
        System.out.println("Test 2: Testing peek and pop on empty stack.");
        System.out.println("The peek() results are: " + stack.peek());
        System.out.println("The pop() results are: " + stack.pop());
        System.out.println();

        // Test case 3:
        System.out.println("Test 3: Adding elements to the stack.");
        stack.push(10);
        System.out.println("After push method. " + stack.isEmpty());
        System.out.println("Peek method: " + stack.peek());
        stack.push(20);
        System.out.println("After pushing 20 into stack. " + stack.peek());
        stack.push(30);
        System.out.println("After pushing 30 into stack. " + stack.peek());
        stack.push(40);
        System.out.println("After pushing 40 into stack. " + stack.peek());
        System.out.println("Is the stack full? " + stack.isFull());
        System.out.println();

        // Test case 4:
        System.out.println("Test 4: Testing stack overflow.");
        stack.push(50);
        System.out.println();

        // Test case 5:
        System.out.println("Test 5: Testing pop operations");
        System.out.println("Popped: " + stack.pop());
        System.out.println("Peek() after pop: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Is the stack empty: " + stack.isEmpty());
        System.out.println();

        // Test case 6:
        System.out.println("Test 6: Emptying the stack completly");
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is the stack empty: " + stack.isEmpty());
        System.out.println("Pop after an empty stack: " + stack.pop());
        System.out.println();

        // Test case 7:
        System.out.println("Test 7: Refelling stack after emptying");
        stack.push(100);
        stack.push(200);
        System.out.println(stack.peek());
        System.out.println();

        // Test case 8:
        System.out.println("Test 8: Deletion of a stack.");
        stack.deleteStack();
    }
}