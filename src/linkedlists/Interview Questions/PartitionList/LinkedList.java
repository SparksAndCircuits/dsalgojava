/*
 * You have a singly linked list that does not have a tail pointer (which will make this method simpler to implement).
 * Given a value x you will need to rearrange the linked list such that all nodes with a value less than x come before 
 * all nodes with a value greater than or equal to x.
 * 
 * Additionally, the relative order of nodes in both partitions should remain unchanged.
 * Constraints:
 *  1) The solution should traverse the linked list at most once.
 *  2) The solution should not create a new linked list.
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

        length++;
    }

    public void partitionList(int x) {
        if (head == null) {
            System.out.println("The singly linked list does not exist.");
        }

        Node beforeHead = new Node(0);
        Node afterHead = new Node(0);

        Node before = beforeHead;
        Node after = afterHead;

        Node current = head;

        while (current != null) {
            if (current.value < x) {
                before.next = current;
                before = current;
            } else {
                after.next = current;
                after = current;
            }

            current = current.next;
        }

        after.next = null;

        before.next = afterHead.next;

        head = beforeHead.next;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        list1.append(4);
        list1.append(3);
        list1.append(2);
        list1.append(5);
        list1.append(2);

        System.out.println("Original List: ");
        list1.printList();

        list1.partitionList(3);
    }
}
