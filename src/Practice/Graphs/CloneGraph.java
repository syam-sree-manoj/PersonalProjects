package Practice.Graphs;
import java.util.*;

public class CloneGraph {
    // https://leetcode.com/problems/clone-graph
    // https://www.youtube.com/watch?v=mQeF6bN8hMk

    public Node cloneGraph(Node node) {
        if(node == null) return node;

        Map<Node, Node> oldToNewMap = new HashMap<>();

        int[] processed = new int[101];

        Deque<Node> dq = new ArrayDeque<>();
        dq.addLast(node);
        while(!dq.isEmpty()){
            Node n = dq.pollFirst();
            if(processed[n.val] == 1){
                continue;
            }
            Node copyNode = oldToNewMap.computeIfAbsent(n, key -> new Node(n.val)  );
            processed[n.val] = 1;

            for(Node nei : n.neighbors){
                Node neiCopy = oldToNewMap.computeIfAbsent(nei, key -> new Node(nei.val) );
                if(processed[neiCopy.val] == 0){
                    neiCopy.neighbors.add(copyNode);
                    copyNode.neighbors.add(neiCopy);
                    dq.addLast(nei);
                }
            }
        }

        return oldToNewMap.get(node);
    }



    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
