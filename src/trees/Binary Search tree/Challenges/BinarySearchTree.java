
/*
 * Convert sorted array to balanced BST.
 * The task is to develop a method that takes a sorted array of integers as inputs and constructs a height - balanced BST.
 * This invloves creating a BST where the depth of the two subtrees of any node does not differ more than one.
 * Achieving a height balanced tree is crcuial for optimizing the efficiency of the tree operations, ensuring that 
 * the BST remains efficicent for search, insertion, and deletion across all levels of tree.
 */
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;

    public Node getNode() {
        return root;
    }

    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(this.root, result);
        return result;
    }

    private void inOrderHelper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inOrderHelper(node.left, result);
        result.add(node.value);
        inOrderHelper(node.right, result);
    }

    public boolean isBalanced() {
        return height(this.root) != -1;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);

        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(node.right);

        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void sortedArrayToBST(int[] nums) {
        this.root = sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        Node node = new Node(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }
}
