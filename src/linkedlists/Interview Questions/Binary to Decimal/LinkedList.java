/*
 * You have a linked list where each node represents a binary digit(0 or 1). The gpal
 * of the binaryToDecimal function is to convert this binary number, represented by the 
 * linkedlist, into its decimal equivalent.
 */
public class LinkedList {
    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
    }

    public Node getHead() {
        return head;
    }

    public void printList() {
        Node temp = head;

        if (temp == null) {
            System.out.println("Empty");
        } else {
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;

                if (temp != null) {
                    System.out.println(" -> ");
                }
            }

            System.out.println();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
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
        }
    }

    public int binaryToDecimal() {
        int num = 0;
        Node current = head;

        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }

        return num;
    }
}
