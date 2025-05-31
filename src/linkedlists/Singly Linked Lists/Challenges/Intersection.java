/* Given two (Singly) linked lists, determine if the two lists intersect.
 * Note that the intersection is defined based on reference, not value. That
 * is, if the kth node of the first linked list is the exact same node as the 
 * jth node of the second linked list, then they are intersecting. */

public class Intersection {
    Node findIntersection(Node list1, Node list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        Node2 result1 = getTailAndSize(list1);
        Node2 result2 = getTailAndSize(list2);

        if (result1.tail != result2.tail) {
            return null;
        }

        Node shorter = result1.length < result2.length ? list1 : list2;
        Node longer = result1.length < result2.length ? list2 : list1;

        longer = getKthNode(longer, Math.abs(result1.length - result2.length));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    Node2 getTailAndSize(Node list) {
        if (list == null) {
            return null;
        }

        int length = 1;
        Node current = list;

        while (current != null) {
            length++;
            current = current.next;
        }

        return new Node2(current, length);
    }

    private Node getKthNode(Node head, int k) {
        Node current = head;

        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }

        return current;
    }
}