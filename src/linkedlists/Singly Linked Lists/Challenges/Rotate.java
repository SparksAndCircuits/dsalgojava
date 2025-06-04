public class Rotate {
    Node head;
    Node tail;

    public String rotate(int number) {
        Node prevNode = head;
        int index = number;
        int length = 1;

        if (number < 0) {
            index = number + length;
        }

        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return "No rotation";
        }

        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.next;
        }

        if (prevNode == null) {
            return "No rotation";
        }

        tail.next = head;
        head = prevNode.next;
        tail = prevNode;
        prevNode.next = null;
        return "Success";
    }
}
