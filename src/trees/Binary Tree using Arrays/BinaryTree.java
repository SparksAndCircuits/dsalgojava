public class BinaryTree {
    String[] array;
    int lastUsedIndex;

    public BinaryTree(int size) {
        array = new String[size + 1];
        this.lastUsedIndex = 0;
        System.out.println("You have created a blank tree of size: " + size + " has been created.");
    }

    // Preorder traversal
    public void preOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }

        System.out.print(array[index] + " ");
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    // Inorder traversal
    public void inOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }

        inOrder(index * 2);
        System.out.println(array[index] + " ");
        inOrder(index * 2 + 1);
    }

    // PostOrder traversal
    public void postOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }

        postOrder(index * 2);
        postOrder(2 * index + 1);
        System.out.println(array[index] + " ");
    }

    // levelOrder traversal
    public void levelOrder() {
        for (int i = 0; i < lastUsedIndex; i++) {
            System.out.println(array[i] + " ");
        }
    }

    // Binary tree search
    public int search(String value) {
        for (int i = 0; i <= lastUsedIndex; i++) {
            if (array[i] == value) {
                System.out.println(value + "exists at location " + i);
                return i;
            }
        }

        System.out.println("The value does not exist in the binary tree.");
        return -1;
    }

    // Insert method
    boolean isFull() {
        if (array.length - 1 == lastUsedIndex) {
            return true;
        } else {
            return false;
        }
    }

    public void insert(String value) {
        if (!isFull()) {
            array[lastUsedIndex + 1] = value;
            lastUsedIndex++;
            System.out.println("The value of " + value + " has been inserted into the binary tree");
        } else {
            System.out.println("The binary tree is full");
        }
    }

    // Deletion of a node in a Binary tree
    public void delete(String value) {
        int location = search(value);

        if (location == -1) {
            return;
        } else {
            array[location] = array[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("The Binary tree node has successfully been deleted.");
        }
    }

    // Deletion of the entire binary tree
    public void deleteBT() {
        Object root = null;
        System.out.println("The binary tree has successfully been deleted.");
    }
}