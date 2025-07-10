import java.util.*;

public class FloysdWarshall {
    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

    public FloysdWarshall(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    void floysdWarshall() {
        int size = nodeList.size();
        int[][] v = new int[size][size];

        for (int i = 0; i < size; i++) {
            WeightedNode first = nodeList.get(i);

            for (int j = 0; j < size; j++) {
                WeightedNode second = nodeList.get(j);

                if (i == j) {
                    v[i][j] = 0;
                } else if (first.getWeightMap().containsKey(second)) {
                    v[i][j] = first.getWeightMap().get(second);
                } else {
                    v[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int k = 0; k < nodeList.size(); k++) {
            for (int i = 0; i < nodeList.size(); i++) {
                for (int j = 0; j < nodeList.size(); j++) {
                    if (v[i][j] > v[i][k] + v[k][j]) {
                        v[i][j] = v[i][k] + v[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println("Printing distance list for node" + nodeList.get(i) + " : ");
            for (int j = 0; j < size; j++) {
                System.out.println(v[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void addWeightedEdge(int i, int j, int d) {
        WeightedNode first = nodeList.get(i - 1);
        WeightedNode second = nodeList.get(j - 1);
        first.getNeighbours().add(second);
        first.getWeightMap().put(second, d);
    }
}
