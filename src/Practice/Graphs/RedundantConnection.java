package Practice.Graphs;

import Practice.Graphs.Algos.DisjointSet;

public class RedundantConnection {
    // https://leetcode.com/problems/redundant-connection/

    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(1000);
        // construct the graph using disjoint set
        for(int i=0; i<edges.length; i++){
            if(ds.union(edges[i][0], edges[i][1])){
                // added to the constructing graph
                continue;
            }else{
                // not added that means this is a redundant edge
                return edges[i];
            }
        }
        return new int[]{-1,-1};
    }

    class DisjointSet{
        int[] parent;
        int[] size;
        DisjointSet(int vertices){
            parent = new int[vertices+1];
            size = new int[vertices+1];
            for(int i=0; i<=vertices; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int u){
            if(parent[u] == u){
                return u;
            }
            int ultimateParent = findParent(parent[u]);
            parent[u] = ultimateParent;
            return ultimateParent;
        }

        boolean union(int u, int v){
            int ultimateParentOfU = findParent(u);
            int ultimateParentOfV = findParent(v);

            if(ultimateParentOfU == ultimateParentOfV){
                // u, v present in same component
                return false;
            }

            if(size[ultimateParentOfU] < size[ultimateParentOfV]){
                // attach u to v
                size[ultimateParentOfV] += size[ultimateParentOfU];
                parent[ultimateParentOfU] = ultimateParentOfV;
            }else{
                size[ultimateParentOfU] += size[ultimateParentOfV];
                parent[ultimateParentOfV] = ultimateParentOfU;
            }
            return true;
        }
    }
}
