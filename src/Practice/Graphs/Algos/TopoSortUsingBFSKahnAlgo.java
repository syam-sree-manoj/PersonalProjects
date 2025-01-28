package Practice.Graphs.Algos;

import java.util.*;

public class TopoSortUsingBFSKahnAlgo {
    // https://www.youtube.com/watch?v=73sneFXuTEg&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=22
    // we use indegree to solve
    // TC : V+E
    /*
        Linear order of vertices such that if there is edge between u & v, u appears before v in that ordering.
        Topo sort can be calculated for DIRECTED ACYCLIC GRAPH

     */
    public void constructGraph(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        indegree[2]++;
        adj.get(2).add(3);
        indegree[3]++;
        adj.get(3).add(4);
        indegree[4]++;
        adj.get(3).add(7);
        indegree[7]++;
        adj.get(4).add(5);
        indegree[5]++;
        adj.get(5).add(6);
        indegree[6]++;
        adj.get(7).add(5);
        indegree[5]++;
        adj.get(8).add(9);
        indegree[9]++;
        adj.get(9).add(10);
        indegree[10]++;
        adj.get(10).add(8);
        indegree[8]++;
    }

    public List<Integer> kahnAlgo(ArrayList<ArrayList<Integer>> graph, int[] indegree){
        List<Integer> toppSortList = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.addLast(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.pollFirst();
            toppSortList.add(node);
            for(int adjNode : graph.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0){
                    q.addLast(adjNode);
                }
            }
        }

        return toppSortList;
    }

}
