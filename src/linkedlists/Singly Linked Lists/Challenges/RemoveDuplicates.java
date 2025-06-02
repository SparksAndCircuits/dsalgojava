import java.util.Set;
import java.util.HashSet;

public class RemoveDuplicates {
    Node head;

    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;

        while (current != null) {
            if (values.contains(current.value)) {
                previous.next = current.next;
            } else {
                values.add(current.value);
                previous = current;
            }

            current = current.next;
        }
    }

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int[] toArray() {
        if (head == null) {
            return new int[0];
        }

        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        int[] result = new int[count];
        current = head;
        int i = 0;

        while (current != null) {
            result[i++] = current.value;
            current = current.next;
        }

        return result;
    }
}
