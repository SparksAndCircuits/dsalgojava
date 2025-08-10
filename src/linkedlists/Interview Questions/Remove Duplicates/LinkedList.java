/*
 *  - You are given a singly linked list that contains integer values, where some of these values may be duplicate.
 *  - Note: This linked List class does not have a tail which will make this method easier to implement.
 *  - Your task is to implement a method called removeDuplicates() within the LinkedList class that removes all duplicate values from the list.
 *  - Your method should not create a new list, but rather modify the existing list in-place, preserving the relative order of the nodes.
 *  - You can implement the removeDuplicates() method in two different ways:
 *      1) Using a set (HashSet) - This approach will have a time complexity of O(n), where n is the number of nodes in the linkedlist. You are allowed
 *         to use the provided Set data structure in your implementation.
 *      2) Without using a set - This approach will have a time complexity of O(n^2), where n is the number of nodes in the LinkedList. You are not allowed 
 *         to use any additional data structures for this implementation.
 */

import java.util.HashSet;
import java.util.Set;

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
        length = 1;
    }

    public Node getHead() {
        return head;
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
            System.out.println("Head == null");
        } else {
            System.out.println("Head: " + head.value);
        }

        System.out.println("Length: " + length);
        System.out.println("\nLinkedList: ");

        if (length == 0) {
            System.out.println("Empty!");
        } else {
            printList();
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

        length++;
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        Set<Integer> seen = new HashSet<>();
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (seen.contains(current.value)) {
                previous.next = current.next;
                length--;
            } else {
                seen.add(current.value);
                previous = current;
            }

            current = current.next;
        }
    }

    public void removeDuplicatesNoSet() {
        if (head == null) {
            return;
        }

        Node current = head;

        while (current != null && current.next != null) {
            Node runner = current;

            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                    length--;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }

    public static void main(String[] args) {
        System.out.println("---Testing with HashSet approach ---");
        LinkedList list1 = new LinkedList(1);
        list1.append(2);
        list1.append(3);
        list1.append(2);
        list1.append(4);
        list1.append(3);
        list1.append(5);

        System.out.println("Before removing duplicates: ");
        list1.printAll();

        list1.removeDuplicates();

        System.out.println("\nAfter removing duplicates: ");
        list1.printAll();

        System.out.println("\n---Testing without Set approach ---");
        LinkedList list2 = new LinkedList(1);
        list2.append(2);
        list2.append(3);
        list2.append(2);
        list2.append(4);
        list2.append(3);
        list2.append(5);

        System.out.println("Before removing duplicates: ");
        list2.printAll();

        list2.removeDuplicatesNoSet();

        System.out.println("\nAfter removing duplicates: ");
        list2.printAll();
    }
}
