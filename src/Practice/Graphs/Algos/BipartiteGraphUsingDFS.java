package Practice.Graphs.Algos;

import java.util.ArrayList;

public class BipartiteGraphUsingDFS {

    private boolean isBipartite( ArrayList<ArrayList<Integer>> adjList, int node, int[] colors) {
        for (int neighbor : adjList.get(node)) {
            // If a neighbor has the same color as the current node, the graph is not bipartite
            if (colors[neighbor] == colors[node]) return false;

            // If the neighbor is already colored, skip it
            if (colors[neighbor] != -1) continue;

            // Assign the opposite color to the neighbor
            colors[neighbor] = (colors[node] + 1) % 2;

            // Recursively check bipartiteness for the neighbor; return false if it fails
            if (!isBipartite(adjList, neighbor, colors)) return false;
        }
        // If all neighbors are properly colored, return true
        return true;
    }
}
