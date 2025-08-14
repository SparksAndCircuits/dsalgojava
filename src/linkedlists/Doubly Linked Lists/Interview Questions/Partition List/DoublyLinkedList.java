public class DoublyLinkedList {
    private Node head;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
    }

    public Node getHead() {
        return head;
    }

    public void printList() {
        StringBuilder output = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            output.append(temp.value);

            if (temp.next != null) {
                output.append(" <-> ");
            }

            temp = temp.next;
        }

        System.out.println(output.toString());
    }

    public void makeEmpty() {
        head = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void partitionList(int x) {
        if (head == null) {
            return;
        }

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                current.prev = prev1;
                prev1 = current;
            } else {
                prev2.next = current;
                current.prev = prev2;
                prev2 = current;
            }

            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;

        if (dummy2.next != null) {
            dummy2.next.prev = prev1;
        }

        head = dummy1.next;

        if (head != null) {
            head.prev = null;
        }
    }
}
