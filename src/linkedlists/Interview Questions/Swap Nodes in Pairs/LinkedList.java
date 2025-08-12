/*
 * Write a method swapPairs() inside a LinkedList class that swaps every two adjacent nodes in a singly linked List.
 * 
 * The method should update the linked list in place by changing the next pointers not by swapping values
 * 
 * The linked list does not have tail or length attributes (you will not need them).
 * 
 * The method should work correctly for:
 *  - Empty Lists
 *  - Single-node lists
 *  - Even-length lists
 *  - Odd-Length lists
 */
public class LinkedList {
    private Node head;

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
                    System.out.print(" -> ");
                }
            }

            System.out.println();
        }
    }

    public void makeEmpty() {
        head = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void swapPairs() {
        if (head == null || head.next == null) {
            return;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            Node first = prev.next;
            Node second = prev.next.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
        }

        head = dummy.next;
    }
}
