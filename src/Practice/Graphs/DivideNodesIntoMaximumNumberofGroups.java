package Practice.Graphs;

import java.util.*;

public class DivideNodesIntoMaximumNumberofGroups {
    // https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/


    // Approach-1
    /*
    Intuition
To solve the first part of the problem, note that once we assign a single node to one of the two groups, the rest of the assignments are automatically determined. Nodes directly connected to the first node must go in the second group, their neighbors must return to the first group, and so on.

To check if the graph is bipartite, we "color" the nodes using two colors (one for each group), ensuring that any two connected nodes have different colors. If this coloring fails, the graph is not bipartite, and we can immediately return -1.

If the graph is bipartite, we calculate the maximum number of groups we can divide the nodes into for each connected component separately. Intuitively, to achieve the largest number of groups, we spread the nodes as far apart as possible. This means that instead of simply assigning a neighboring node to the same group as the one it was previously associated with, we always try to assign it to a new group.

An important observation here is that the maximum number of groups in a component is determined by the longest shortest path between any pair of nodes in that component. This is similar to finding the "height" of the component if it were structured like a tree, with different nodes as potential roots. The longest shortest path essentially tells us how many layers or groups can be created based on the distances between the nodes.

Finally, we repeat this for all connected components in the graph and sum up the results to get the answer.


     */
    class UsingGraphColoringLongestShortestPath{

        // Main function to calculate the maximum number of magnificent sets
        public int magnificentSets(int n, int[][] edges) {
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(n);
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<Integer>());
            }
            for (int[] edge : edges) {
                // Transition to 0-index
                adjList.get(edge[0] - 1).add(edge[1] - 1);
                adjList.get(edge[1] - 1).add(edge[0] - 1);
            }

            int[] colors = new int[n];
            Arrays.fill(colors, -1);
            for (int node = 0; node < n; node++) {
                if (colors[node] != -1) continue;
                // Start coloring from uncolored nodes
                colors[node] = 0;
                // If the graph is not bipartite, return -1
                if (!isBipartite(adjList, node, colors)) return -1;
            }

            // Calculate the longest shortest path for each node
            int[] distances = new int[n];
            for (int node = 0; node < n; node++) {
                distances[node] = getLongestShortestPath(adjList, node, n);
            }

            // Calculate the total maximum number of groups across all components
            int maxNumberOfGroups = 0;
            boolean[] visited = new boolean[n];
            for (int node = 0; node < n; node++) {
                if (visited[node]) continue;
                // Add the number of groups for this component to the total
                maxNumberOfGroups += getNumberOfGroupsForComponent(adjList, node, distances, visited);
            }

            return maxNumberOfGroups;
        }


        // Computes the longest shortest path (height) in the graph starting from the source node
        private int getLongestShortestPath(ArrayList<ArrayList<Integer>> adjList, int srcNode, int n) {
            // Initialize a queue for BFS and a visited array
            Queue<Integer> nodesQueue = new LinkedList<Integer>();
            boolean[] visited = new boolean[n];

            nodesQueue.add(srcNode);
            visited[srcNode] = true;
            int distance = 0;

            // Perform BFS layer by layer
            while (!nodesQueue.isEmpty()) {
                // Process all nodes in the current layer
                int numOfNodesInLayer = nodesQueue.size();
                for (int i = 0; i < numOfNodesInLayer; i++) {
                    int currentNode = nodesQueue.poll();

                    // Visit all unvisited neighbors of the current node
                    for (int neighbor : adjList.get(currentNode)) {
                        if (visited[neighbor]) continue;
                        visited[neighbor] = true;
                        nodesQueue.add(neighbor);
                    }
                }
                // Increment the distance for each layer
                distance++;
            }
            // Return the total distance (longest shortest path)
            return distance;
        }

        // Calculates the maximum number of groups for a connected component
        private int getNumberOfGroupsForComponent(ArrayList<ArrayList<Integer>> adjList, int node, int[] distances, boolean[] visited) {
            // Start with the distance of the current node as the maximum
            int maxNumberOfGroups = distances[node];
            visited[node] = true;

            // Recursively calculate the maximum for all unvisited neighbors
            for (int neighbor : adjList.get(node)) {
                if (visited[neighbor]) continue;
                maxNumberOfGroups = Math.max(maxNumberOfGroups, getNumberOfGroupsForComponent(adjList, neighbor, distances, visited));
            }
            return maxNumberOfGroups;
        }


        // Checks if the graph is bipartite starting from the given node
        private boolean isBipartite(ArrayList<ArrayList<Integer>> adjList, int node, int[] colors) {
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

    /*
    Intuition
In this approach, instead of checking bipartiteness to find if there is a valid split, we attempt to directly maximize the number of groups the graph can be partitioned into. Let's first consider the strategy for a single component:

We begin by assigning each node in the component to the first group. From there, we attempt to propagate this group assignment to the neighboring nodes, creating a new group for each "layer" of neighbors. This means that nodes at the same distance from the starting node would belong to the same group, while nodes at different distances would belong to different groups.

However, if we ever come across a neighbor that has already been assigned the same group as the current node, it means that it's not possible to partition the graph in the way we're attempting. In that case, the graph is not partitionable, and we return -1.

Once we explore all possible groups for the component by starting the process at each node in the component, we find the maximum number of groups that can be formed. This maximum value will be the largest number of groups we can use to partition the nodes of that particular component.

Finally, to compute the answer for the entire graph, we repeat this process for each connected component, summing the maximum number of groups from all components. To efficiently track the connected nodes and perform the necessary computations, we use the Union-Find data structure, which helps us manage and combine the connected components as we progress through the graph.
     */
    class UsingBFSAndUnionFind{
        class Solution {

            // Main function to calculate the maximum number of groups for the entire graph
            public int magnificentSets(int n, int[][] edges) {
                List<List<Integer>> adjList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    adjList.add(new ArrayList<>());
                }
                int[] parent = new int[n];
                int[] depth = new int[n];
                Arrays.fill(parent, -1);

                // Build the adjacency list and apply Union-Find for each edge
                for (int[] edge : edges) {
                    adjList.get(edge[0] - 1).add(edge[1] - 1);
                    adjList.get(edge[1] - 1).add(edge[0] - 1);
                    union(edge[0] - 1, edge[1] - 1, parent, depth);
                }

                Map<Integer, Integer> numOfGroupsForComponent = new HashMap<>();

                // For each node, calculate the maximum number of groups for its component
                for (int node = 0; node < n; node++) {
                    int numberOfGroups = getNumberOfGroups(adjList, node, n);
                    if (numberOfGroups == -1) return -1; // If invalid split, return -1
                    int rootNode = find(node, parent);
                    numOfGroupsForComponent.put(
                            rootNode,
                            Math.max(
                                    numOfGroupsForComponent.getOrDefault(rootNode, 0),
                                    numberOfGroups
                            )
                    );
                }

                // Calculate the total number of groups across all components
                int totalNumberOfGroups = 0;
                for (int numberOfGroups : numOfGroupsForComponent.values()) {
                    totalNumberOfGroups += numberOfGroups;
                }
                return totalNumberOfGroups;
            }

            // Function to calculate the number of groups for a given component starting from srcNode
            private int getNumberOfGroups(
                    List<List<Integer>> adjList,
                    int srcNode,
                    int n
            ) {
                Queue<Integer> nodesQueue = new LinkedList<>();
                int[] layerSeen = new int[n];
                Arrays.fill(layerSeen, -1);
                nodesQueue.offer(srcNode);
                layerSeen[srcNode] = 0;
                int deepestLayer = 0;

                // Perform BFS to calculate the number of layers (groups)
                while (!nodesQueue.isEmpty()) {
                    int numOfNodesInLayer = nodesQueue.size();
                    for (int i = 0; i < numOfNodesInLayer; i++) {
                        int currentNode = nodesQueue.poll();
                        for (int neighbor : adjList.get(currentNode)) {
                            // If neighbor hasn't been visited, assign it to the next layer
                            if (layerSeen[neighbor] == -1) {
                                layerSeen[neighbor] = deepestLayer + 1;
                                nodesQueue.offer(neighbor);
                            } else {
                                // If the neighbor is already in the same layer, return -1 (invalid partition)
                                if (layerSeen[neighbor] == deepestLayer) {
                                    return -1;
                                }
                            }
                        }
                    }
                    deepestLayer++;
                }
                return deepestLayer;
            }

            // Find the root of the given node in the Union-Find structure
            private int find(int node, int[] parent) {
                while (parent[node] != -1) node = parent[node];
                return node;
            }

            // Union operation to merge two sets
            private void union(int node1, int node2, int[] parent, int[] depth) {
                node1 = find(node1, parent);
                node2 = find(node2, parent);

                // If both nodes already belong to the same set, no action needed
                if (node1 == node2) return;

                // Union by rank (depth) to keep the tree balanced
                if (depth[node1] < depth[node2]) {
                    int temp = node1;
                    node1 = node2;
                    node2 = temp;
                }
                parent[node2] = node1;

                // If the depths are equal, increment the depth of the new root
                if (depth[node1] == depth[node2]) depth[node1]++;
            }
        }
    }

}
