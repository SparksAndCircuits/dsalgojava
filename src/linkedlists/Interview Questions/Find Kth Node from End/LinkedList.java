/*
 * Implement a method called findKthFromEnd that returns the k-th node from the end of a singly linked list
 *  - The linked list does not store its length, so you must determine the correct node without using a size property.
 *  - The value of k is 1-based:
 *      - k = 1 returns the last node(tail).
 *      - k = 2 returns the second-to-last node
 *      - k = list length returns the head node
 *      - k <= 0 or k > list length returns null
 *  - You must solve the problem using the two pointer technique, ensuring the solution runs in a single traversal of the list (O(n) time, O(1) space)
 */
public class LinkedList {
    private Node head;
    private Node tail;

    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.value);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node findKthFromEnd(int k) {
        if (k <= 0) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }

            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
