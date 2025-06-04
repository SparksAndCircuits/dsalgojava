import java.util.ArrayList;
import java.util.EmptyStackException;

/*
 * The reverse string takes a single parameter string, which is the string you want to reverse. 
 * Return a new string with the letters in reverse order.
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

    public T pop() {

        if (stackList.isEmpty()) {
            return null;
        }

        return stackList.remove(stackList.size() - 1);
    }

    public static String reverseString(String string) {
        Stack<Character> stack = new Stack<>();
        String reversedString = " ";

        for (char c : string.toCharArray()) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        return reversedString;
    }

    public static boolean isBooleanParentheses(String parentheses) {
        Stack<Character> stack = new Stack<>();

        for (char p : parentheses.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
