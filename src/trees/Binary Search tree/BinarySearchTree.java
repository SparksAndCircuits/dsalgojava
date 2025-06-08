public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(int value) {
        Node newNode = new Node(value);
        root = newNode;
    }

    // Insertion
    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;

        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }

            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }

                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                return false;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) {
            return false;
        }

        Node temp = root;

        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }

        return false;
    }

    // Validation of a binary tree
    boolean isValid(Node root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.value <= min || root.value >= max) {
            return false;
        }

        boolean left = isValid(root.left, min, root.value);

        if (left) {
            boolean right = isValid(root.right, root.value, max);
            return right;
        }

        return false;
    }

    // Recursive binary search tree contains
    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.value == value) {
            return true;
        }

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    // Recursive Binary search tree insert
    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }

        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) {
            root = new Node(value);
        }
        rInsert(root, value);
    }

    //Recursive Bianry Search tree delete
    private Node deleteNode(Node currentNode, int value){
        if(currentNode == null){
            return null;
        }

        if(value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left, value);
        }else{
            if(currentNode.left == null && currentNode.right == null){
                currentNode = null;
            }else if(currentNode.left == null){
                currentNode = currentNode.right;
            }else if(currentNode)
        }
    }
}
