package Practice.Graphs;

import java.util.*;

public class MaximumEmployeesToBeInvitedToAMeeting {
    // https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/
    // https://www.youtube.com/watch?v=aPBELJa-LM8 [just get the idea of approach and not the solution]
    // implementation taken from leetcode solution
    // used topological sorting
    /*

    Topological sort is an algorithm traditionally used in DAGs (Directed Acyclic Graphs) to order nodes in a way that for every directed edge u to v, node u comes before node v. This ordering allows us to process nodes one by one, ensuring that we handle dependencies before processing dependent nodes.

However, in this context, we don't have a pure DAG because of the cycles. But we can still use topological sorting to help with eliminating non-cycle nodes and focusing on cycles that we need to handle more carefully. In fact, identifying and processing these cycles is key to finding the solution.

The idea is to first process nodes in topological order to remove non-cycle nodes and focus on the cycles that need further examination.

To implement this, we begin by calculating the in-degree for each node. The in-degree of a node indicates how many nodes point to it. In this case, the "favorite" relationship can be seen as a directed edge from one person to another. After populating the in-degree array, we initialize a queue that will help us with the topological sort. The queue initially contains all nodes that have an in-degree of zero (i.e., nodes with no incoming edges). These are the nodes that do not form part of any cycle and can be processed in topological order.

Next, we start the process of topologically sorting the nodes while calculating the depth of each node. The depth represents the longest path from any starting node to that particular node. As we process each node, we decrement the in-degree of its neighbor (as we "remove" the edge), and if any neighbor's in-degree becomes zero, it is added to the queue. During this process, we also update the depth of each node, ensuring that it reflects the longest path leading to that node.

Once the topological sort is completed and we have processed all non-cycle nodes, we move on to detect cycles. For each node that remains in the graph (i.e., nodes with a non-zero in-degree), we trace the cycle by following the favorite links. As we trace the cycle, we mark the nodes as visited by setting their in-degree to zero, and count the length of the cycle.

If the cycle length is 2, we know it’s a two-person mutual favorite cycle. In this case, we add the combined depths of both nodes in the cycle to the total invitation count for two-cycles. This is because both nodes can invite the maximum number of people based on their depths.

For longer cycles, we simply update the longest cycle length, since a longer cycle can accommodate more people in the seating arrangement.

At the end, the result is the maximum of the longest cycle length and the total size of the two-cycle groups.

     */
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];

        // Calculate in-degree for each node
        for (int person = 0; person < n; ++person) {
            inDegree[favorite[person]]++;
        }

        // Topological sorting to remove non-cycle nodes
        Queue<Integer> q = new LinkedList<>();
        for (int person = 0; person < n; ++person) {
            if (inDegree[person] == 0) {
                q.offer(person);
            }
        }

        int[] depth = new int[n]; // Depth of each node
        Arrays.fill(depth, 1);

        while (!q.isEmpty()) {
            int currentNode = q.poll();
            int nextNode = favorite[currentNode];
            depth[nextNode] = Math.max(depth[nextNode], depth[currentNode] + 1);
            if (--inDegree[nextNode] == 0) {
                q.offer(nextNode);
            }
        }

        int longestCycle = 0;
        int twoCycleInvitations = 0;

        // Detect cycles
        for (int person = 0; person < n; ++person) {
            if (inDegree[person] == 0) continue; // Already processed

            int cycleLength = 0;
            int current = person;
            while (inDegree[current] != 0) {
                inDegree[current] = 0; // Mark as visited
                cycleLength++;
                current = favorite[current];
            }

            if (cycleLength == 2) {
                // For 2-cycles, add the depth of both nodes
                twoCycleInvitations += depth[person] + depth[favorite[person]];
            } else {
                longestCycle = Math.max(longestCycle, cycleLength);
            }
        }

        return Math.max(longestCycle, twoCycleInvitations);
    }
}
