import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    // PreOrder tarversal
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // InOrder traversal
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }

    // PostOrder traversal
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }

    // Level order traversal
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node presentNode = queue.remove();
            System.out.println(presentNode.value + " ");

            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }

            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    // Binary tree search
    public void search(String value) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node presentNode = queue.remove();

            if (presentNode.value == value) {
                System.out.println("The value is - " + value + " is found in the tree.");
                return;
            } else {
                if (presentNode.left != null) {
                    queue.add(presentNode.right);
                }
            }
        }

        System.out.println("The value - " + value + " is not found in the tree.");
    }

    // Insertion into a binary tree
    public void insert(String value) {
        Node newNode = new Node();
        newNode.value = value;

        if (root == null) {
            root = newNode;
            System.out.println("Inserted new node at root.");
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node presentNode = queue.remove();

            if (presentNode.left == null) {
                presentNode.left = newNode;
                System.out.println("Value was successfully inserted into the binary tree.");
                break;
            } else if (presentNode.right == null) {
                presentNode.right = newNode;
                System.out.println("Successfully inserted");
                break;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    // get deepest node of a binary tree
    public Node getDeepestNode() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node presentNode = null;
        while (!queue.isEmpty()) {
            presentNode = queue.remove();

            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }

            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }

        return presentNode;
    }

    // Deletion of deepest node
    public void deleteDepestNode() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node previousNode, presentNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();

            if (presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if (presentNode.right == null) {
                presentNode.left = null;
                return;
            }

            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }
}