package Practice.Heap;
import java.util.*;
public class DesignaNumberContainerSystem {
    // https://leetcode.com/problems/design-a-number-container-system/
    HashMap<Integer,PriorityQueue<Integer>> numSmallestIndexPQMap;
    HashMap<Integer,Integer> indexNumberMap;
    public DesignaNumberContainerSystem() {
        numSmallestIndexPQMap = new HashMap();
        indexNumberMap = new HashMap();
    }

    public void change(int index, int number) {
        indexNumberMap.put(index, number);
        numSmallestIndexPQMap.compute(number, (key,val) -> {
            if(val == null) val = new PriorityQueue<>();
            val.offer(index);
            return val;
        });
    }

    public int find(int number) {
        PriorityQueue<Integer> pq = numSmallestIndexPQMap.getOrDefault(number, null);
        if(pq == null) return -1;
        while( !pq.isEmpty() && indexNumberMap.get(pq.peek()) != number){
            pq.poll();
        }
        if(pq.isEmpty()) return -1;
        return pq.peek();
    }
}
