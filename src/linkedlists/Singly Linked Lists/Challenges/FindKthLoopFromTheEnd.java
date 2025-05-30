public class FindKthLoopFromTheEnd {
    Node head;

    public Node findKthLoopFromTheEnd(int k) {
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

    public void append(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(value);
    }
}
