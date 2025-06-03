/* Implement a method called reverseBetweeen that reverses the nodes
 * of the list between indxes StartIndex and EndIndex. Its Important
 * to note that you should only rearrange the nodes themselves, not
 * just the values.*/
public class ReverseBetween {
    Node head;

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) {
            return;
        }

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;
    }

    public void createList(int[] values) {
        if (values.length == 0) {
            head = null;
            return;
        }

        head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
    }

    public boolean isEqual(ReverseBetween other) {
        Node current1 = this.head;
        Node current2 = other.head;

        while (current1 != null && current2 != null) {
            if (current1.value != current2.value) {
                return false;
            }

            current1 = current1.next;
            current2 = current2.next;
        }

        return current1 == null && current2 == null;
    }

    public int getLength() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public int getValueAt(int index) {
        if (index < 0 || head == null) {
            return -1;
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        return (current != null) ? current.value : -1;
    }

    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.println(current.value);

            while (current != null) {
                System.out.print(current.value);
                if (current.next != null) {
                    System.out.print("->");
                }

                current = current.next;
            }

            System.out.println();
        }
    }
}
