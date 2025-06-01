public class Palindrome {
    boolean isPalindrome(Node head) {
        Node reversed = reverseAndClone(head);

        return isEqual(head, reversed);
    }

    Node reverseAndClone(Node node) {
        Node head = null;

        while (node != null) {
            Node n = new Node(node.value);
            n.next = head;
            head = n;
            node = node.next;
        }

        return head;
    }

    boolean isEqual(Node one, Node two) {
        while (one != null && two != null) {
            if (one.value != two.value) {
                return false;
            }

            one = one.next;
            two = two.next;
        }

        return one == null && two == null;
    }

    Node createList(int[] values) {
        if (values.length == 0) {
            return null;
        }

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        return head;
    }

    void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.value);

            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();

        System.out.println("--- Palindrome Test Cases has started ---");

        // Test case 1:
        System.out.println("Test 1: Empty list.");
        Node test1 = p.createList(new int[] {});
        System.out.print("List: ");
        if (test1 == null) {
            System.out.println("null");
        } else {
            p.printList(test1);
        }
        System.out.println("Is Palindrome: " + p.isPalindrome(test1));
        System.out.println("Expected: True\n");

        // Test case 2:
        System.out.println("Test 2: Single element.");
        Node test2 = p.createList(new int[] { 1 });
        System.out.println("List: ");
        p.printList(test2);
        System.out.println("Is Palindrome: " + p.isPalindrome(test2));
        System.out.println("Expected: true\n");

        // Test case 3:
        System.out.println("Test 3: Two identical elements.");
        Node test3 = p.createList(new int[] { 1, 1 });
        System.out.print("List: ");
        p.printList(test3);
        System.out.println("Is Palindrome: " + p.isPalindrome(test3));
        System.out.println("Expected: true\n");

        // Test case 4:
        System.out.println("Test 4: Tw different elements.");
        Node test4 = p.createList(new int[] { 1, 2 });
        System.out.print("List: ");
        p.printList(test4);
        System.out.println("IsPalindrome: " + p.isPalindrome(test4));
        System.out.println("Expected: false\n");

        // Test case 5:
        System.out.println("Test 5: Odd length palindrome.");
        Node test5 = p.createList(new int[] { 1, 2, 3, 2, 1 });
        System.out.print("List: ");
        p.printList(test5);
        System.out.println("Is Palindrome: " + p.isPalindrome(test5));
        System.out.println("Expected: true\n");

        // Test case 6:
        System.out.println("Test 6: Even length palindrome.");
        Node test6 = p.createList(new int[] { 1, 2, 2, 1 });
        System.out.print("List: ");
        p.printList(test6);
        System.out.println("Is Palindrome: " + p.isPalindrome(test6));
        System.out.println("Expected: false\n");

        // Test case 7:
        System.out.println("Test 7: Not a palindrome (odd length).");
        Node test7 = p.createList(new int[] { 1, 2, 3, 4, 1 });
        System.out.print("List: ");
        p.printList(test7);
        System.out.println("Is Palindrome: " + p.isPalindrome(test7));
        System.out.println("Expected: false\n");

        // Test case 8:
        System.out.println("Test 8: Nod a palindrome (even length).");
        Node test8 = p.createList(new int[] { 1, 2, 3, 4 });
        System.out.println("List: ");
        p.printList(test8);
        System.out.println("Is Palindrome: " + p.isPalindrome(test8));
        System.out.println("Expected: false\n");

        // Test case 9:
        System.out.println("Test 9: Londer palindrome.");
        Node test9 = p.createList(new int[] { 1, 2, 3, 4, 3, 2, 1 });
        System.out.print("List: ");
        p.printList(test9);
        System.out.println("Is Palindrome: " + p.isPalindrome(test9));
        System.out.println("Expected: true\n");

        // TEst case 10:
        System.out.println("Test 10: All same elements.");
        Node test10 = p.createList(new int[] { 5, 5, 5, 5, 5 });
        System.out.print("List: ");
        p.printList(test10);
        System.out.println("Is palindrome: " + p.isPalindrome(test10));
        System.out.println("Expected: true\n");
    }
}
