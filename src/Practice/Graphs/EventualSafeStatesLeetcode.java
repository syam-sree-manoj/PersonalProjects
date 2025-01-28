package Practice.Graphs;
import java.util.*;

public class EventualSafeStatesLeetcode {
    // https://leetcode.com/problems/find-eventual-safe-states/description/
    // https://www.youtube.com/watch?v=uRbJ1OF9aYM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=20


    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        int[] safeNode = new int[n];

        // there can be components so we go over all nodes
        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                checkForCycle(i,visited,pathVisited,graph, safeNode);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(safeNode[i] == 1){
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean checkForCycle(int node, int[] visited, int[] pathVisited, int[][] graph, int[] safeNode){
        visited[node] = 1;
        pathVisited[node] = 1;

        for(int adjNode : graph[node]){
            if(visited[adjNode] != 0){
                // when ever we find a cycle we return true
                if(checkForCycle(adjNode, visited, pathVisited, graph, safeNode)){
                    safeNode[node] = 0;
                    return true;
                }

            } else if (pathVisited[adjNode] == 1) {
                // cycle in graph
                // node can not be a safe node
                safeNode[node] = 0;
                return true;
            }
        }
        // if you reach here that means there is no cycle starting from this node
        safeNode[node] = 1;
        pathVisited[node] = 0;
        return false;
    }

}
