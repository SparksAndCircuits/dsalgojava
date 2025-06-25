public class BinarySearchTree {
    BinaryNode root;

    BinarySearchTree(){
        root = null;
    }

    private BinaryNode insert(BinaryNode currentNode, int value){
        if(currentNode == null){
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println("The value was successfully inserted into the Binary Search Tree.");
            return newNode;
        }else if(value <= currentNode.value){
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        }else{
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value){
        insert(root, value);
    }

    public void preOrder(BinaryNode node){
        if(node == null){
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
    }

    public void inOrder(BinaryNode node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(BinaryNode node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
    }
}
