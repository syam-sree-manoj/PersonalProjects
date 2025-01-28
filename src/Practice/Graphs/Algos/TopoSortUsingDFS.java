package Practice.Graphs.Algos;

import java.util.*;

public class TopoSortUsingDFS {
    // https://www.youtube.com/watch?v=5lZ0iJMrUMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=21
    // TC : V+E
    /*
        Linear order of vertices such that if there is edge between u & v, u appears before v in that ordering.
        Topo sort can be calculated for DIRECTED ACYCLIC GRAPH

     */
    public void constructGraph(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

    }

    public List<Integer> topoSort(ArrayList<ArrayList<Integer>> graph){

        int n = graph.size();
        int[] visited = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                dfs(graph, i, visited, stack);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!stack.isEmpty()){
            ans.add(stack.pollLast());
        }

        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> graph, int node, int[] visited, Deque<Integer> stack){
        visited[node] = 1;

        for(int adjNode : graph.get(node)){
            if(visited[adjNode] == 0){
                dfs(graph, adjNode, visited, stack);
            }
        }

        // once all the paths are visited and returning from current node
        // add current node to stack
        stack.addLast(node);
    }
}
