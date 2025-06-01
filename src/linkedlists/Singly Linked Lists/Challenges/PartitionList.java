/* Given a value of x you need to rearrange the linkedlist such that all nodes
 * with value less than x comes before all nodes with a greater value than or 
 * equal to x. Additionally, the relative order of nodes in both partions should
 * remain unchanged.
 * Constraints:
 * 1) The solution should traverse in the linked list of most one
 * 2) The solution should not create a new linked list
 */
public class PartitionList {
    Node head;

    public void PartitionList(int x) {
        if (head == null) {
            return;
        }

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }

            current = current.next;
            prev2.next = null;
            prev1.next = dummy2.next;
            head = dummy1.next;
        }
    }
}
