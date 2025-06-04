import java.util.ArrayList;
import java.util.EmptyStackException;

/* Write a push method to add an item onto a stack that is implemented with an arraylist.
 * We will modify the stack class to abe able store multiple data types by using a generic
 * parameter type <T>. This will allow the class tto hold integers, characters or any other
 * datatypes.
 */
public class Stack<T> {
    private ArrayList<T> stackList = new ArrayList<>();

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public void push(T value) {
        stackList.add(value);
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return 0;
    }
}
