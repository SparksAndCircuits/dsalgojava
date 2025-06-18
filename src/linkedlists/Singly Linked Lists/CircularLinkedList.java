public class CircularLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public class Node{
        public int value;
        public Node next;
    }

    public Node createCSLL(int nodeValue){
        head = new Node();
        Node node = new Node();

        node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }
}
