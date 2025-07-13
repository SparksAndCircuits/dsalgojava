import java.util.*;

public class Kuskal {
    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
    ArrayList<UndirectedEdge> edgeList = new ArrayList<UndirectedEdge>();

    public Kruskal(ArrayList<WeightedNode> nodeList){
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
        WeightedNode first = edge.first;
        WeightedNode second = edge.second;

        first.neighbours.add(second);
        second.neighbours.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
        edgeList.add(edge);
    }

    void kruskal(){
        DisjointSet.makeSet(nodeList);
        Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>(){
            @Override
            public int compare(UndirectedEdge O1, UndirectedEdge O2){
                return O1.weight - O2.weight;
            }
        }

        Collection.sort(edgeList, compartor);
        int cost = 0;

        for(UndirectedEdge edge : edgeList){
            WeightedNode first = edge.first;
            WeightedNode second = edge.second;

            if(!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))){
                DisjointSet.union(first, second);
                cost+=edge.weight;
                System.out.println("Taken " + edge);
            }
        }

        System.out.println("\nTotal cost of MST: " + cost);
    }
}