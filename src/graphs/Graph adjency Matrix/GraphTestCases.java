import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class GraphTestCases {
    private static int testCount = 0;
    private static int passedTests = 0;

    private static String captureOutput(Runnable action) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        action.run();

        System.setOut(originalOut);
        return baos.toString().trim();
    }

    public static void runTest(String testName, boolean condition) {
        testCount++;
        if (condition) {
            passedTests++;
            System.out.println(testName + " has passed the test.");
        } else {
            System.out.println(testName + " has failed the test.");
        }
    }

    // Test case 1: Empty Graph
    private static void testEmptyGraph() {
        System.out.println("Test 1: Empty Graph");
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        Graph graph = new Graph(nodes);

        String bfsOutput = captureOutput(() -> graph.bfs());
        String dfsOutput = captureOutput(() -> graph.dfs());

        runTest("Empty graph BFS", bfsOutput.isEmpty());
        runTest("Empty graph DFS", dfsOutput.isEmpty());
        System.out.println();
    }

    // Test case 2: Single Node
    public static void testSingleNode() {
        System.out.println("Test 2: Single Node");
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        Graph graph = new Graph(nodes);

        String bfsOutput = captureOutput(() -> graph.bfs());
        String dfsOutput = captureOutput(() -> graph.dfs());

        runTest("Single node BFS", bfsOutput.equals("A"));
        runTest("Single node DFS", dfsOutput.equals("A"));
        System.out.println();
    }

    // Test case 3: Two Connected Nodes
    private static void testTwoConnectedNodes() {
        System.out.println("Test 3: Two Connected Nodes");
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        nodes.add(new GraphNode("B", 1));
        Graph graph = new Graph(nodes);
        graph.addUndirectedEdge(0, 1);

        String bfsOutput = captureOutput(() -> graph.bfs());
        String dfsOutput = captureOutput(() -> graph.dfs());

        runTest("Two connected nodes BFS", bfsOutput.equals("A B"));
        runTest("Two connected nodes DFS", dfsOutput.equals("A B"));
        System.out.println();
    }

    // Test case 4: Two Disconnected nodes
    private static void testTwoDisconnectedNodes() {
        System.out.println("Test 4: Two Disconnected Nodes");
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        nodes.add(new GraphNode("B", 1));
        Graph graph = new Graph(nodes);

        String bfsOutput = captureOutput(() -> graph.bfs());
        String dfsOutput = captureOutput(() -> graph.dfs());

        runTest("Two connected nodes BFS", bfsOutput.equals("A B"));
        runTest("Two connected nodes DFS", dfsOutput.equals("A B"));
        System.out.println();
    }

    // Test case 5: Linear Graph (A-B-C-D)
    private static void testLinearGraph() {
        System.out.println("Test 5: Linear Graph (A-B-C-D)");
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        nodes.add(new GraphNode("B", 0));
        nodes.add(new GraphNode("C", 0));
        nodes.add(new GraphNode("A", 0));
        Graph graph = new Graph(nodes);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(2, 3);

        String bfsOutput = captureOutput(() -> graph.bfs());
        String dfsOutput = captureOutput(() -> graph.dfs());

        System.out.println("BFS Output: " + bfsOutput);
        System.out.println("DFS Output: " + dfsOutput);

        runTest("Linear graph BFS starts with A", bfsOutput.startsWith("A"));
        runTest("Linear graph DFS starts with A", dfsOutput.startsWith("A"));
        runTest("Linear graph BFS contains all nodes", bfsOutput.contains("A") && bfsOutput.contains("B")
                && bfsOutput.contains("C") && bfsOutput.contains("D"));
        runTest("Linear graph DFS contains all nodes", dfsOutput.contains("A") && dfsOutput.contains("B")
                && dfsOutput.contains("C") && dfsOutput.contains("D"));
        System.out.println();
    }

    // Test case 6: Complete Graph (all nodes connected)
    private static void testCompleteGraph() {
        System.out.println("Test 6: Complete Graph (A-B-C all connected)");
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        nodes.add(new GraphNode("B", 1));
        nodes.add(new GraphNode("C", 2));
        Graph graph = new Graph(nodes);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(0, 2);

        String bfsOutput = captureOutput(() -> graph.bfs());
        String dfsOutput = captureOutput(() -> graph.dfs());

        System.out.println("BFS Output: " + bfsOutput);
        System.out.println("DFS Output: " + dfsOutput);

        runTest("Complete graph BFS visits all nodes",
                bfsOutput.contains("A") && bfsOutput.contains("B") && bfsOutput.contains("C"));
        runTest("Complete graph DFS visits all nodes",
                dfsOutput.contains("A") && dfsOutput.contains("B") && dfsOutput.contains("C"));
        System.out.println();
    }

    // Test case 7: cyclic graphs
    private static void testCyclicGraph() {
        System.out.println("Test 7: Cyclic Graph (A-B-C-A)");
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        nodes.add(new GraphNode("B", 1));
        nodes.add(new GraphNode("C", 2));
        Graph graph = new Graph(nodes);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(2, 0);

        String bfsOutput = captureOutput(() -> graph.bfs());
        String dfsOutput = captureOutput(() -> graph.dfs());

        System.out.println("BFS Output: " + bfsOutput);
        System.out.println("DFS Output: " + dfsOutput);

        runTest("Cyclic graph BFS visits all nodes exactly once",
                bfsOutput.split("").length == 3);
        runTest("Cyclic graph DFS visits all nodes exactly once",
                dfsOutput.split("").length == 3);
        System.out.println();
    }

    // Test case 8: Disconnected Components
    private static void testDisconnectedComponents() {
        System.out.println("Test 8: Disconnected Components (A - B) and (C - D)");
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        nodes.add(new GraphNode("B", 1));
        nodes.add(new GraphNode("C", 2));
        nodes.add(new GraphNode("D", 3));
        Graph graph = new Graph(nodes);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(2, 3);

        String bfsOutput = captureOutput(() -> graph.bfs());
        String dfsOutput = captureOutput(() -> graph.dfs());

        System.out.println("BFS Output: " + bfsOutput);
        System.out.println("DFS Output: " + dfsOutput);

        runTest("Disconnected components BFS visits all nodes",
                bfsOutput.contains("A") && bfsOutput.contains("B") && bfsOutput.contains("C")
                        && bfsOutput.contains("D"));
        runTest("Disconnected components DFS visits all nodes",
                dfsOutput.contains("A") && dfsOutput.contains("B") && dfsOutput.contains("C")
                        && bfsOutput.contains("D"));
        System.out.println();
    }

    // Test case 9: Star Graph (One center node connected to all others)
    private static void testStarGraph() {
        System.out.println("Test 9: Star Graph (A connected to B, C, and D)");
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        nodes.add(new GraphNode("B", 1));
        nodes.add(new GraphNode("C", 2));
        nodes.add(new GraphNode("D", 3));
        Graph graph = new Graph(nodes);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);

        String bfsOutput = captureOutput(() -> graph.bfs());
        String dfsOutput = captureOutput(() -> graph.dfs());

        System.out.println("BFS Output: " + bfsOutput);
        System.out.println("DFS Output: " + dfsOutput);

        runTest("Single node BFS", bfsOutput.startsWith("A"));
        runTest("Single node DFS", dfsOutput.startsWith("A"));
        System.out.println();
    }

    // Test Case 10: Complex Graph
    private static void testComplexGraph() {
        System.out.println("Test 10: Complex Graph");
        ArrayList<GraphNode> nodes = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            nodes.add(new GraphNode(String.valueOf((char) ('A' + i)), i));
        }

        Graph graph = new Graph(nodes);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(3, 5);
        graph.addUndirectedEdge(4, 5);

        String bfsOutput = captureOutput(() -> graph.bfs());
        String dfsOutput = captureOutput(() -> graph.dfs());

        System.out.println("BFS Output: " + bfsOutput);
        System.out.println("DFS Output: " + dfsOutput);

        runTest("Complex graph BFS visits all 6 nodes", bfsOutput.split(" ").length == 6);
        runTest("Complex graph DFS visits all 6 nodes", dfsOutput.split(" ").length == 6);
        System.out.println();
    }

    // Test case 11: Graph toString method
    private static void testGraphToString() {
        System.out.println("Test 11: Graph toString method");
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        nodes.add(new GraphNode("B", 1));
        Graph graph = new Graph(nodes);
        graph.addUndirectedEdge(0, 1);

        String graphString = graph.toString();
        System.out.println("Graph string representation: ");
        System.out.println(graphString);

        runTest("Graph toString contains node names", graphString.contains("A") && graphString.contains("B"));
        runTest("Graph toString contains adjacency information", graphString.contains("1"));
        System.out.println();
    }

    // Test case 12: getNeighbours method
    private static void testGetNeighbours() {
        System.out.println("Test 12: getNeighbours method");
        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        nodes.add(new GraphNode("B", 1));
        nodes.add(new GraphNode("C", 2));
        Graph graph = new Graph(nodes);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);

        ArrayList<GraphNode> neighborA = graph.getNeighbours(nodes.get(0));
        ArrayList<GraphNode> neighborB = graph.getNeighbours(nodes.get(1));

        System.out.println("Neighbours of A: " + neighborA);
        System.out.println("Neighbours of B: " + neighborB);

        runTest("A has 2 neighbours", neighborA.size() == 2);
        runTest("B has 1 neighbour", neighborB.size() == 1);
        runTest("A's neighbours are B and C", neighborA.contains(nodes.get(1)) && neighborB.contains(nodes.get(2)));
        runTest("B's neighbour is A", neighborB.contains(nodes.get(0)));
    }

    public static void main(String[] args) {
        System.out.println("--- Graph Test Suite ---");

        testEmptyGraph();
        testSingleNode();
        testTwoConnectedNodes();
        testTwoDisconnectedNodes();
        testLinearGraph();
        testCompleteGraph();
        testCyclicGraph();
        testDisconnectedComponents();
        testStarGraph();
        testComplexGraph();
        testGraphToString();
        testGetNeighbours();

        System.out.println("--Test Symmary--");
        System.out.println("Total Tests: " + testCount);
        System.out.println("Passed tests: " + passedTests);
        System.out.println("Failed tests: " + (testCount - passedTests));
    }

}
