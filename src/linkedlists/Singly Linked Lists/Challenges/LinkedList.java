public class LinkedList {
    Node head;
    Node tail;
    int size;

    LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    void add(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    void printList() {
        Node current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.value);

            if (current.next != null) {
                System.out.print(", ");
            }

            current = current.next;
        }

        System.out.println("]");
    }

    int[] toArray() {
        int[] result = new int[size];
        Node current = head;
        int index = 0;

        while (current != null) {
            result[index++] = current.value;
            current = current.next;
        }

        return result;
    }

    void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    void createFromArray(int[] values) {
        clear();
        for (int value : values) {
            add(value);
        }
    }
}
