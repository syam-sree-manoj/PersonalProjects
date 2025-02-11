package Practice.Heap;

import java.util.*;

public class FindKPairswithSmallestSums {
    // https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
    // https://www.youtube.com/watch?v=iY6-u0yt-Is

    public List<List<Integer>> kSmallestPairs(int[] arr1, int[] arr2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Pair> visited = new HashSet<>();

        int m = arr1.length;
        int n = arr2.length;

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> {
            if(a.sum < b.sum){
                return -1;
            }
            return 1;
        });

        minHeap.offer(new Node(0,0,arr1[0]+arr2[0]));
        visited.add(new Pair(0,0));

        Node node;
        int u;
        int v;
        while( k > 0 && !minHeap.isEmpty()){
            node = minHeap.poll();
            ans.add(Arrays.asList(arr1[node.u], arr2[node.v]));
            k--;
            u = node.u;
            v = node.v;
            if(u+1 < m && !visited.contains(new Pair(u+1,v))){
                minHeap.offer(new Node (u+1,v,arr1[u+1]+arr2[v]) );
                visited.add(new Pair(u+1,v));
            }
            if( v+1 < n && !visited.contains(new Pair(u,v+1))){
                minHeap.offer(new Node (u,v+1,arr1[u]+arr2[v+1]) );
                visited.add(new Pair(u,v+1));
            }
        }
        return ans;
    }

    class Node{
        int u, v, sum;
        Node(int u, int v, int sum){
            this.u = u;
            this.v = v;
            this.sum = sum;
        }
        @Override
        public String toString() {
            return "(" + u + ", " + v + ", sum=" + sum + ")";
        }
    }

    class Pair{
        int u;
        int v;
        Pair(int u, int v){
            this.u = u;
            this.v = v;
        }
    }
}
