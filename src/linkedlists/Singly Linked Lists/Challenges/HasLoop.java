/* Write a method called hasLoop that is part of the linked list class.
 * The method should be able to detect if there is a cycle or a loop
 * present in the linked list. You are required to use Floyd's cycle-
 * finding algorithm to detect the loop. Constraints: You are not allowed
 * to use any additional data structures (Such as arrays or modifying the
 * existing data structures. You can only traverse once).
 */
public class HasLoop {
    static Node head;

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public void append(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(value);
    }

    public void createLoop(int position) {
        if (head == null) {
            return;
        }

        Node current = head;
        Node loopNode = null;
        int count = 0;

        while (current.next != null) {
            if (count == position) {
                loopNode = current;
            }
            current = current.next;
            count++;
        }

        if (loopNode != null) {
            current.next = loopNode;
        }
    }

    public void clear() {
        head = null;
    }

    public void printList(int maxNodes) {
        Node current = head;
        int count = 0;
        System.out.print("List: ");

        while (current != null && count < maxNodes) {
            System.out.print(current.value + " -> ");
            current = current.next;
            count++;
        }

        if (current != null) {
            System.out.print("...(continues)");
        } else {
            System.out.print("null");
        }

        System.out.println();
    }
}