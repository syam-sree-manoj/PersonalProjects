package Practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class IPO {
    // https://leetcode.com/problems/ipo/
    // https://www.youtube.com/watch?v=1IUzNJ6TPEM
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
        int n = profits.length;

        // has only projects that we can afford
        PriorityQueue<Node> maxProfitsHeap = new PriorityQueue<>((a,b) -> {
            if(a.profit > b.profit){
                return -1;
            }else{
                return 1;
            }
        });

        PriorityQueue<Node> minCapitalHeap = new PriorityQueue<>((a,b) -> {
            if(a.capital < b.capital){
                return -1;
            }
            return 1;
        });

        for(int i=0; i<n; i++){
            minCapitalHeap.offer(new Node(capitals[i], profits[i]));
        }

        while(k > 0){
            while( minCapitalHeap.peek().capital <= w ){
                maxProfitsHeap.offer(minCapitalHeap.poll());
            }
            if(!maxProfitsHeap.isEmpty()){
                Node node = maxProfitsHeap.poll();
                k--;
                w += node.profit;
            }else{
                // empty means no nodes to process
                return w;
            }
        }
        return w;
    }

    class Node{
        int capital;
        int profit;
        Node(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }
}
