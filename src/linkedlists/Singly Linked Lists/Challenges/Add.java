public class Add {
    Node add(Node a, Node b) {
        Node temp = new Node(0);
        Node tail = temp;
        int carry = 0;

        while (a != null || b != null) {
            int x = (a != null) ? a.value : 0;
            int y = (b != null) ? b.value : 0;
            int sum = carry + x + y;

            carry = sum / 10;
            tail.next = new Node(sum % 10);
            tail = tail.next;

            if (a != null) {
                a = a.next;
            }

            if (b != null) {
                b = b.next;
            }
        }

        if (carry > 0) {
            tail.next = new Node(carry);
        }

        return temp.next;
    }
    
}
