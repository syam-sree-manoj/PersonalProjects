package Practice.Graphs;
import  java.util.*;

public class CourseSchedule {
    // https://leetcode.com/problems/course-schedule/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // there shouldn't be any cycle in the graph to complete all the courses

        List<List<Integer>> graph = constructGraph(prerequisites, numCourses);

        return solve(graph, numCourses);

    }

    public List<List<Integer>> constructGraph(int[][] prereq, int numCourses){

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList());
        }

        for(int[] edge : prereq){
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }

    public boolean solve(List<List<Integer>> graph, int numCourses){
        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        for(int i=0 ;i<numCourses; i++){
            if(visited[i] == 0){
                if(checkCycleDfs(graph, numCourses, visited, pathVisited, i)){
                    return false;
                }
            }
        }

        return true;

    }

    public boolean checkCycleDfs(List<List<Integer>> graph, int numCourses, int[] visited, int[] pathVisited, int node){
        visited[node] = 1;
        pathVisited[node] = 1;

        for(int adjNode : graph.get(node)){
            if(visited[adjNode] == 0){
                if(checkCycleDfs(graph, numCourses, visited, pathVisited, adjNode)){
                    return true;
                }
            } else if(pathVisited[adjNode] == 1){
                // this node is already visted in current path
                // so cycle detected
                return true;
            }
        }

        pathVisited[node] = 0;
        return false;
    }
}

