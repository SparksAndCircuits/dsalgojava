/* You have two numbers repersented by a linkedlist, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1'st digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linkedlist
 */
public class SumList {
    Node head;

    SinglyLinkedList sumList(SinglyLinkedList LLA, SinglyLinkedList LLB) {
        Node n1 = LLA.head;
        Node n2 = LLB.head;
        int carry = 0;
        SinglyLinkedList resultLL = new SinglyLinkedList(1);

        while (n1 != null || n2 != null) {
            int result = carry;

            if (n1 != null) {
                result += n1.value;
                n1 = n1.next;
            }

            if (n2 != null) {
                result += n2.value;
                n2 = n2.next;
            }

            resultLL.insert1(result % 10);
            carry = result / 10;
        }

        return resultLL;
    }
}
