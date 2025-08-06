//How would you design a stack which, in addition to push and pop, has a function min which returns the min element?

import java.util.Stack;

class StackMinimum {
    private Stack<StackNode> stack;

    private class StackNode {
        int value;
        int min;

        StackNode(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    public StackMinimum() {
        stack = new Stack<>();
    }

    public void push(int value) {
        int currentMin = isEmpty() ? value : Math.min(value, min());
        stack.push(new StackNode(value, currentMin));
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        return stack.pop().value;
    }

    public int min() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return stack.peek().min;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        return stack.peek().value;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}