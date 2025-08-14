/*
 *  - Write a method that takes two indices (startIndex, endIndex) and reverse the nodes between those indices.
 *  - The original list must be modified in place.
 *  - Constraints:
 *      - StartIndex and EndIndex are zero-based
 *      - The list may be empty or contain a single node
 *      - If startIndex == endIndex, no changes should occur.
 *      - You must maintain the integrity of both next and prev pointers.
 */
public class DoublyLinkedList {
    private Node head;

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

    public void reverseBetween(int startIndex, int endIndex) {
        if(head == null || startIndex == endIndex){
            return;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        Node prev = dummy;
        for(int i = 0; i< startIndex; i++){
            prev = prev.next;
        }

        Node current = prev.next;

        for(int i = 0; i < endIndex - startIndex; i++){
            Node nodeToMove = current.next;

            current.next = nodeToMove.next;
            if(nodeToMove.next != null){
                nodeToMove.next.prev = current;
            }

            nodeToMove.next = prev.next;
            prev.next.prev = nodeToMove;

            prev.next = nodeToMove;
            nodeToMove.prev = prev;
        }

        head = dummy.next;
        head.prev = null;
    }
}
