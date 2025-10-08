import java.util.*;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);

        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ":");

            for (int j = 0; j < nodeList.get(i).neighbours.size(); j++) {
                if (j == nodeList.get(i).neighbours.size() - 1) {
                    s.append((nodeList.get(i).neighbours.get(j).name));
                } else {
                    s.append((nodeList.get(i).neighbours.get(j).name) + "->");
                }
            }

            s.append("\n");
        }

        return s.toString();
    }

    public int V() {
        return nodeList.size();
    }

    public Iterable<Integer> adj(int v) {
        ArrayList<Integer> neighbourIndices = new ArrayList<>();

        for (GraphNode neighbour : nodeList.get(v).neighbours) {
            neighbourIndices.add(neighbour.index);
        }

        return neighbourIndices;
    }
}
