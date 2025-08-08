/*
 * Write a method called hasLoop that is part of the linked list class.
 * 
 * The method should be able to detect if there is a cycle or loop present in the linked list.
 * 
 * You are required to use Floyd's cycle-finding algorithm (also known as the  "Tortoise and the hare" algorithm) to detect the loop.
 * 
 * This algorithm uses two pointers: as slow ponter and a fast pointer. The slow pointer moves one step at a time, while the fast pointer moves
 * two steps at a time. If there is a loop in the linked list, the two pointers will eventually meet at some point. If there is no loop, the fast 
 * pointer will reach the end of the list.
 * 
 * The method should follow these guidelines:
 * 1) Create two pointers, slow and fast, both initially pointing to the head of the linkedList.
 * 2) Traverse the list with the slow pointer moving one step at a time, while the fast pointer moves two steps at a time.
 * 3) If there is a loop in the list, the fast pointer will eventually meet the slow pointer if this occurs, the method should return true.
 * 4) If the fast pointer reacheas the end of the list or encounters a null value, it means there is no loop in the list. In this case, the method should return false.
 */

public class LinkedList {
    private Node head;
    private Node tail;
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
        tail = newNode;
        length = 1;
    }

    public Node gethead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
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
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        length++;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        if (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
