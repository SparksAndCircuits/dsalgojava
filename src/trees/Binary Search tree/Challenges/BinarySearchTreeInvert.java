import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeInvert {
    private Node root;

    private class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    private Node insert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = insert(currentNode.right, value);
        }

        return currentNode;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        }

        insert(root, value);
    }

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();

        if (currentNode != null) {
            queue.add(currentNode);
        }

        while (queue.size() > 0) {
            currentNode = queue.remove();

            if (currentNode != null) {
                results.add(currentNode.value);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }

        return results;
    }

    public void insert() {
        root = invertTree(root);
    }

    private Node invertTree(Node node) {
        if (node == null) {
            return null;
        }

        Node temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);
        return node;
    }
}
