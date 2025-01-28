package Practice.Graphs.Algos;
import java.util.*;
/*
Give a graph with weights find the shortest path from source to all other vertices. Works for both directed and undirected graphs with non-negative weights.

shortest path graph (SPG) and Minimum spanning tree (using kruskals algo) may or may not be same

Dijkstra's algorithm does not work correctly if the graph contains negative weight edges (regardless of whether it's directed or undirected).
This is because the algorithm assumes that once a node's shortest distance is found, it cannot be improved, which is not true for graphs with negative weights.
If the graph has negative weight edges, you can use Bellman-Ford's algorithm, which is designed to handle such cases.

Algorithm
1. maintain set of processed nodes
2. take array and assign all nodes with distance value = infinite except source node
3. repeat following ( unless all the vertices are processed)
    * pick min value vertex which is not already processed
    * include this selected node in processed set
    * update all the adjacent node distances
        * if new_distance < old_distance then update else skip

Time complexity : E * logV

 */
public class DijkstraAlgo {
    // https://www.youtube.com/watch?v=Sj5Z-jaE2x0 (Therory by techdose)
    // https://www.youtube.com/watch?v=V6H1qAeB-l4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=32 (Striver)
    // https://www.youtube.com/watch?v=3dINsjyfooY&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=34 (why priority queue and not just queue since both give the ans)
    // https://www.youtube.com/watch?v=3dINsjyfooY&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=34 (time complexity of E * logV)
    public static void main(String[] args) {

    }


    public static int minDistanceFromSrcTODestination(Map<Integer,List<Edge>> map, int nodes, int src, int dest){

        int[] disFromSrc = new int[nodes];
        Arrays.fill(disFromSrc, Integer.MAX_VALUE);
        disFromSrc[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.distanceFromSrc < b.distanceFromSrc){
                return -1;
            }
            return 1;
        });

        pq.offer(new Pair(0,src));

        while(!pq.isEmpty()){
            Pair peek = pq.poll();
            int node = peek.node;
            int distFromSrcToNode = disFromSrc[node];
            for(Edge edge : map.get(node)){
                int distFromSrcToEdgeNode = disFromSrc[edge.node];

                if(distFromSrcToNode + edge.weight < distFromSrcToEdgeNode){
                    pq.offer(new Pair(distFromSrcToNode + edge.weight, edge.node));
                    disFromSrc[edge.node] = distFromSrcToNode + edge.weight;
                }
            }
        }

        return disFromSrc[dest];
    }

    class Edge{
        int weight;
        int node;

        Edge(int weight, int node){
            this.node = node;
            this.weight = weight;
        }
    }

    static class Pair{
        int distanceFromSrc;
        int node;

        Pair(int distanceFromSrc, int node){
            this.node = node;
            this.distanceFromSrc = distanceFromSrc;
        }
    }


}
