public class BinaryToDecimal {
    Node head;

    public int binaryToDecimal() {
        int num = 0;
        Node current = head;

        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }

        return num;
    }
}
