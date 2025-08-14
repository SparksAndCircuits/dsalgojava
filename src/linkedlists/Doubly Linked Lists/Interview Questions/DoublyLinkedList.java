/*
 * Write a method to determine whether a given doubly linked list reads the same forwards and backwards.
 * 
 * Method name: isPalindrome
 */
public class DoublyLinkedList {
    private Node head;
    private Node tail;
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
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }

        System.out.println("Length: " + length);
        System.out.println("\nDoubly Linked List");

        if (length == 0) {
            System.out.println("Empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length++;
    }

    public boolean isPalindrome() {
        if (length <= 1) {
            return true;
        }

        Node frontNode = head;
        Node backNode = tail;

        for (int i = 0; i < length / 2; i++) {
            if (frontNode.value != backNode.value) {
                return false;
            }

            frontNode = frontNode.next;
            backNode = backNode.prev;
        }

        return true;
    }
}
