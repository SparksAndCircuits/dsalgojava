public class DepthFirstSearch {
    private Boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new Boolean[G.v()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    private boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
