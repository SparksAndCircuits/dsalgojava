public class CircularSinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCSLL(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insert(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            createCSLL(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
            tail.next = head;
        } else if (location >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }

            node.next = tempNode.next;
            tempNode.next = node;
        }

        size++;
    }

    public void traversalCSLL() {
        if (head != null) {
            Node tempNode = head;

            for (int i = 0; i < size; i++) {
                System.out.println(tempNode.value);

                if (i != size - 1) {
                    System.out.println(" -> ");
                }

                tempNode = tempNode.next;
            }
        } else {
            System.out.println("\n Circular Singly Linked List does not exist!");
        }
    }

    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;

            for (int i = 0; i < size; i++) {

                if (tempNode.value == nodeValue) {
                    System.out.println("Found node at location: " + i);
                    return true;
                }
            }
        }

        System.out.println("Node was not found in the circular Singly linked list.");
        return false;
    }

    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The Circular Singly linked list does not exist!");
            return;
        } else if (location == 0) {
            head = head.next;
            tail.next = head;
            size--;

            if (size == 0) {
                tail = null;
                head.next = null;
                head = null;
            }
        } else if (location >= size) {
            Node tempNode = head;

            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }

            if (tempNode == head) {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }

            tempNode.next = head;
            tail = tempNode;
            size--;
        } else {
            Node tempNode = head;

            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }

            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void deleteCSLL() {
        if (head == null) {
            System.out.println("The CSLL does not exist.");
        } else {
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("The CSLL has been deleted.");
        }
    }
}
