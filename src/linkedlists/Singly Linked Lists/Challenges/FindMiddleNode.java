/* Implement a method called findMiddleNode that returns the middle node of the linked list. If the list has an even number of nodes, the methods should return teh second middle node.*/
public class FindMiddleNode {
    Node head;

    public Node findMiddleNode() {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void append(int value){
        if(head == null){
            head = new Node(value);
            return;
        }

        Node current = head;

        while(current.next != null){
            current = current.next;
        }

        current.next = new Node(value);
    }
}
