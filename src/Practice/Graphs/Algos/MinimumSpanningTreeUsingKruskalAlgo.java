package Practice.Graphs.Algos;

import java.util.*;

public class MinimumSpanningTreeUsingKruskalAlgo {
    // https://www.youtube.com/watch?v=DMnDM_sxVig&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=47
    // kruskal's algo uses disjoint set
    // we use sorting of edges based on weights

    MinimumSpanningTreeUsingKruskalAlgo(){

    }
    public int kruskalAlgo(int n, ArrayList<ArrayList<ArrayList<Integer>>> graph){

        ArrayList<Edge> edges = new ArrayList<>();

        for(int i=0; i<n; i++ ){
            for(int j=0; j<graph.get(i).size(); j++){
                int adjNode = graph.get(i).get(j).get(0);
                int wt = graph.get(i).get(j).get(1);
                int node = i;
                edges.add(new Edge(i, adjNode, wt));
            }
        }

        DisjointSet ds = new DisjointSet(n);

        Collections.sort(edges, (a,b) -> a.weight-b.weight);

        int mstSum = 0;

        // iterate through sorted edges
        for(int i=0; i<edges.size(); i++){
            int wt = edges.get(i).weight;
            int u = edges.get(i).u;
            int v = edges.get(i).v;

            if(ds.findParent(u) != ds.findParent(v)){
                // we can connect u,v with this edge
                mstSum += wt;
                ds.unionBySize(u,v);
            }
        }
        return mstSum;
    }
    class Edge{
        int u,v,weight;
        Edge(int u, int v, int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
}
