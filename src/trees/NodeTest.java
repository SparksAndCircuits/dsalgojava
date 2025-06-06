public class NodeTest {
    public static void testNodeContstructors() {
        Node node = new Node("Root");
        if (node.data.equals("Root") && node.children != null && node.children.isEmpty()) {
            System.out.println("TestNode constructor: Passed!");
        } else {
            System.out.println("TestNodeConstructor: Failed!");
        }
    }

    public static void testAddChild() {
        Node parent = new Node("Parent");
        Node child = new Node("child");
        parent.addChild(child);

        if (parent.children.size() == 1 && parent.children.get(0).data.equals("Child")) {
            System.out.println("TestAddChild: Passed!");
        } else {
            System.out.println("TestAddChild: Failed!");
        }

    }

    public static void testPrintSingleNode() {
        Node node = new Node("Root");
        String expected = "Root\n";
        String result = node.print(0);

        if (result.equals(expected)) {
            System.out.println("TestPrintSingleNode: Passed!");
        } else {
            System.out.println("TestPrintSingleNode: Failed!");
        }
    }

    public static void testPrintWithChildren() {
        Node parent = new Node("Parent");
        parent.addChild(new Node("Child1"));
        parent.addChild(new Node("Child2"));
        String expected = "Parent\n Child1\n child2\n";
        String result = parent.print(0);

        if (result.equals(expected)) {
            System.out.println("TestPrintWithChildren: Passed!");
        } else {
            System.out.println("TestPrintWithChildren: Failed!");
        }
    }

    public static void testPrintMultipleLevels() {
        Node root = new Node("Root");
        Node child1 = new Node("Child1");
        Node child2 = new Node("Child2");
        Node grandChild = new Node("GrandChild");
        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(grandChild);
        String expected = "Root\n Child1\n GrandChild\n Child2\n";
        String result = root.print(0);
        if (result.equals(expected)) {
            System.out.println("TestPrintMultipleLevels: Passed!");
        } else {
            System.out.println("TestPrintMultipleLevels: Failed!");
        }
    }

    public static void main(String[] args) {
        testNodeContstructors();
        testAddChild();
        testPrintSingleNode();
        testPrintWithChildren();
        testPrintMultipleLevels();
        System.out.println("All tests have been completed!");
    }
}
