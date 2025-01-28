package Practice.Graphs;
import  java.util.*;

public class CourseScheduleII {
    // using Kahn algo
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] topo = new int[numCourses];

        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = constructGraph(prerequisites, numCourses, indegree);


        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                dq.addLast(i);
            }
        }
        int i=0;
        while(!dq.isEmpty()){
            int node = dq.pollFirst();
            topo[i++] = node;
            for(int adjNode : graph.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0){
                    dq.addLast(adjNode);
                }
            }
        }

        if(i == numCourses){
            return topo;
        }


        return new int[0];

    }

    public List<List<Integer>> constructGraph(int[][] prereq, int numCourses, int[] indegree){

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList());
        }

        for(int[] edge : prereq){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        return graph;
    }
}
