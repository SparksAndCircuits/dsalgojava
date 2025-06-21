public class CircularDoubleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    Node create(int nodeValue) {
        head = new Node();
        Node newNode = new Node();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
        size = 1;
        return head;
    }

    public void insert(int value, int location) {
        Node newNode = new Node();
        newNode.value = value;

        if (head == null) {
            create(value);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        } else if (location >= size) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }

            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }

        size++;
    }

    public void traversal() {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);

                if (i != size - 1) {
                    System.out.print(" -> ");
                }

                tempNode = tempNode.next;

            }

        } else {
            System.out.println("The Circular Double Linked List does not exist!");
        }

        System.out.println();
    }

    public void reverseTraversal() {
        if (head != null) {
            Node tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" <- ");
                }

                tempNode = tempNode.prev;
            }
        } else {
            System.out.println("The Circular Double Linked List does not exist!");
        }
    }

    public boolean search(int value) {
        if (head != null) {
            Node tempNode = head;

            for (int i = 0; i < size; i++) {
                if (tempNode.value == value) {
                    System.out.println("The node was found at the location: " + i);
                    return true;
                }

                tempNode = tempNode.next;
            }
        }

        System.out.println("Node was not found in the LinkedList!");
        return false;
    }

    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The circular double linked list does not exist.");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
                size--;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size--;
            }
        } else if (location >= size) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
                size--;
                return;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                size--;
            }
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }

            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }

    public void deleteCDLL() {
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }

        head = null;
        tail = null;
        System.out.println("The circular double linked list has been deleted.");
    }
}
