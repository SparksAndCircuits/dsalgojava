import java.util.ArrayList;

public class Node {
    String data;
    ArrayList<Node> children;

    public Node(String data) {
        this.data = data;
        this.children = new ArrayList<Node>();
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    public String print(int level) {
        String ret;
        ret = " ".repeat(level) + data + "\n";

        for (Node node : this.children) {
            ret += node.print(level + 1);
        }

        return ret;
    }
}