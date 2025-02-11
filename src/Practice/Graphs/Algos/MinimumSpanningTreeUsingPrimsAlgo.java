package Practice.Graphs.Algos;

import java.util.*;

public class MinimumSpanningTreeUsingPrimsAlgo {
    // https://www.youtube.com/watch?v=ZSPjZuZWCME&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=44
    // Undirected wighted graph
    // TC : E log E
    // SC : E
    public void primsAlgo(List<List<Node>> graph){

        int[] visited = new int[graph.size()];
        List<List<Integer>> mstEdges = new ArrayList<>();
        int mstSum = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            if(a.weight < b.weight){
                return -1;
            }else{
                return 1;
            }
        });

        pq.offer(new Node(0, 0, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(visited[node.currNode] == 1){
                continue;
            }

            mstEdges.add(Arrays.asList(node.parent, node.currNode, node.weight));
            mstSum += node.weight;
            visited[node.currNode] = 1;

            List<Node> neighbours = graph.get(node.currNode);
            for(Node neighbor : neighbours ){
                if(visited[neighbor.currNode] == 0){
                    pq.offer(new Node(node.currNode, neighbor.currNode, neighbor.weight));
                }
            }
        }


    }

    class Node{
        int parent, currNode, weight;
        Node(int parent, int currNode, int weight){
            this.parent = parent;
            this.currNode = currNode;
            this.weight = weight;
        }
    }
}



