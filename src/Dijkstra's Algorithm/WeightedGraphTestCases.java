import java.util.*;

public class WeightedGraphTestCases {

    public static void testWeightedNodeCreation() {
        System.out.println("Test: Weighted Node creation.");
        WeightedNode node = new WeightedNode("A", 0);

        assert node.name.equals("A") : "Name should be 'A'";
        assert node.index == 0 : "Index should be 0";
        assert node.distance == Integer.MAX_VALUE : "Distance should be MAX_VALUE initially.";
        assert node.neighbours.size() == 0 : "Neighbours should be empty initially.";
        assert node.weightMap.size() == 0 : "WeightMap should be empty initially.";
        assert node.isVisited == false : "isVisited should be false initially.";
        assert node.parent == null : "Parent should be null initially.";

        System.out.println("Weighted Node creation test passed \n");
    }

    public static void testWeightedNodeComparison() {
        System.out.println("Test: WeightedNode Comparison.");

        WeightedNode node1 = new WeightedNode("A", 0);
        WeightedNode node2 = new WeightedNode("B", 1);

        try {
            int result = node1.compareTo(node2);
            System.out.println("Result: " + result);
            System.out.println("Node1 distance after comparison: " + node1.distance);
            System.out.println("Node2 distance after comparison: " + node2.distance);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("Weighted Node comparison test completed (bug detected)\n");
    }

    public static void testWeightedNodeToString() {
        System.out.println("Test: WeightedNode to string.");
        WeightedNode node = new WeightedNode("TestNode", 5);
        String result = node.toString();
        assert result.equals("TestNode") : "toString should return node name.";
        System.out.println("WeightedNode toString test passed\n");
    }

    public static void testWeightedGraphCreation() {
        System.out.println("Test: WeightedGraph creation.");
        ArrayList<WeightedNode> nodes = new ArrayList<>();
        nodes.add(new WeightedNode("A", 0));
        nodes.add(new WeightedNode("B", 1));
        WeightedGraph graph = new WeightedGraph(nodes);
        assert graph.nodeList.size() == 2 : "Graph should have 2 nodes";
        assert graph.nodeList.get(0).name.equals("A") : "First node should be 'A'";
        assert graph.nodeList.get(1).name.equals("B") : "Second node should be 'B'";
        System.out.println("WeightedGraph creation test passed\n");
    }

    public static void testAddWeightedEdge() {
        System.out.println("Test: Add Weighted Edge.");
        ArrayList<WeightedNode> nodes = new ArrayList<>();
        nodes.add(new WeightedNode("A", 0));
        nodes.add(new WeightedNode("B", 1));
        nodes.add(new WeightedNode("C", 2));

        WeightedGraph graph = new WeightedGraph(nodes);

        graph.addWeightedEdge(0, 1, 5);
        graph.addWeightedEdge(1, 2, 3);

        WeightedNode nodeA = nodes.get(0);
        WeightedNode nodeB = nodes.get(1);
        WeightedNode nodeC = nodes.get(2);

        assert nodeA.neighbours.contains(nodeB) : "A should have B as neighbour.";
        assert nodeA.weightMap.get(nodeB) == 5 : "Weight A -> B should be 5";
        assert nodeB.neighbours.contains(nodeA) : "B should have C as neighbour.";
        assert nodeB.weightMap.get(nodeC) == 3 : "Weight B -> C should be 3";

        System.out.println("Add weighted edge test passed\n");
    }

    public static void testDijkstraSimpleGraph() {
        System.out.println("Test: Dijkstra Simple Graph.");
        ArrayList<WeightedNode> nodes = new ArrayList<>();
        nodes.add(new WeightedNode("A", 0));
        nodes.add(new WeightedNode("B", 1));
        nodes.add(new WeightedNode("C", 2));

        WeightedGraph graph = new WeightedGraph(nodes);
        graph.addWeightedEdge(0, 1, 2);
        graph.addWeightedEdge(0, 2, 5);
        graph.addWeightedEdge(1, 2, 1);

        System.out.println("Graph Structure: ");
        System.out.println("A -> B (Weight 2)");
        System.out.println("A -> C (Weight 5)");
        System.out.println("B -> C (Weight 1)");
        System.out.println("\nRunning Dijkstra from A:");

        try {
            graph.dijkstra(nodes.get(0));
            System.out.println("Expected shortest distances from A:");
            System.out.println("A : 0, B : 2, C : 3 (via A->B->C)");
            System.out.println("Actual distances: ");
            for (WeightedNode node : nodes) {
                System.out.println(node.name + " : " + node.distance);
            }
        } catch (Exception e) {
            System.out.println("Exception in Dijkstra: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Dijkstra simple graph test completed\n");
    }

    public static void testDijkstraDisconnectedGraph() {
        System.out.println("Test: Dijkstra Simple Graph.");
        ArrayList<WeightedNode> nodes = new ArrayList<>();
        nodes.add(new WeightedNode("A", 0));
        nodes.add(new WeightedNode("B", 1));
        nodes.add(new WeightedNode("C", 2));

        WeightedGraph graph = new WeightedGraph(nodes);

        graph.addWeightedEdge(0, 1, 3);

        System.out.println("Graph structure (C is disconnected): ");
        System.out.println("A -> B (weight is 3)");
        System.out.println("C is isolated");
        System.out.println("\nRunning Dijkstra from A: ");

        try {
            graph.dijkstra(nodes.get(0));
            System.out.println("Expected: A=0, B=3, C=MAX_VALUE (Unreachable)");
        } catch (Exception e) {
            System.out.println("Exception in Dijkstra: " + e.getMessage());
        }

        System.out.println("Dijkstra disconnected graph test completed\n");
    }

    public static void testDijkstraWithSelfloop() {
        System.out.println("Test: Dijkstra with self-loop");
        ArrayList<WeightedNode> nodes = new ArrayList<>();
        nodes.add(new WeightedNode("A", 0));
        nodes.add(new WeightedNode("B", 1));

        WeightedGraph graph = new WeightedGraph(nodes);

        graph.addWeightedEdge(0, 0, 1);
        graph.addWeightedEdge(0, 1, 5);

        System.out.println("Graph Structure: ");
        System.out.println("A -> A (Weight 1, self-loop)");
        System.out.println("A -> B (Weight 5)");
        System.out.println("Running Dijkstra from A:");

        try {
            graph.dijkstra(nodes.get(0));
        } catch (Exception e) {
            System.out.println("Exception in Dijkstra: " + e.getMessage());
        }

        System.out.println("Dijkstra self-loop test completed\n");
    }

    public static void testPathPrint() {
        System.out.println("Test: Path Print.");
        WeightedNode nodeA = new WeightedNode("A", 0);
        WeightedNode nodeB = new WeightedNode("B", 1);
        WeightedNode nodeC = new WeightedNode("C", 2);

        nodeB.parent = nodeA;
        nodeC.parent = nodeB;

        System.out.println("Path from A to C: (A -> B -> C):");
        try {
            WeightedGraph.pathPrint(nodeC);
        } catch (Exception e) {
            System.out.println("Exception in pathPrint" + e.getMessage());
        }

        System.out.println("Path print test completed\n");
    }

    public static void main(String[] args) {
        System.out.println("--- Starting Weighted Graph Test Cases. ---");

        testWeightedNodeCreation();
        testWeightedNodeComparison();
        testWeightedNodeToString();
        testWeightedGraphCreation();
        testAddWeightedEdge();
        testDijkstraSimpleGraph();
        testDijkstraDisconnectedGraph();
        testDijkstraWithSelfloop();
        testPathPrint();
        System.out.println("\n--- All Test cases completed. ---");
    }
}
