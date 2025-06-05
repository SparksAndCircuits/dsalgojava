public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }

        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }

        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        length++;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }

        Node temp = head;

        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node temp = head;

        if (index < length / 2) {

            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;

            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    /*
     * Swap first and last nodes in a doubly linked List. Given a doubly linked
     * list, write a method swapFirstLast() that swaps firs and last nodes in the
     * list.
     */
    public void swapFirstLast() {
        if (length < 2) {
            return;
        }

        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    /*
     * Implement a method called reverse() that reverses the order of the nodes
     * in the list. This method should reverse the order of the list by manupulating
     * the pointer of each node, not by swapping the values within the node.
     */

    public void reverse() {
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.next;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        tail = head;
        head = tail;
        tail = temp;
    }

    /*
     * Write a method to check whether a given doubly linked list reads the same
     * forwasrds
     * and backwards.
     */

    public boolean isPalindrome() {
        if (length <= 1) {
            return true;
        }

        Node forwardNode = head;
        Node backwardsNode = tail;

        for (int i = 0; i < length / 2; i++) {

            if (forwardNode.value != backwardsNode.value) {
                return false;
            }

            forwardNode = forwardNode.next;
            backwardsNode = backwardsNode.prev;
        }

        return true;
    }
}