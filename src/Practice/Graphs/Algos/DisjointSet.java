package Practice.Graphs.Algos;

import java.util.List;

public class DisjointSet {
    // https://www.youtube.com/watch?v=aBxjDBC4M1U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=46
    // Union and find parent takes constant time i.e 4*alpha
    // whenever you change the graph dynamically you use DISJOINT SET data structure
    List<Integer> rank;
    List<Integer> parent;

    List<Integer> size;

    public DisjointSet(int n){
        for(int i=0; i<=n; i++){
            rank.add(0);
            parent.add(i);

        }
    }

    int findParent(int u){
        if(parent.get(u) == u){
            return u;
        }

        int ultimateParent = findParent(parent.get(u));
        parent.set(u,ultimateParent);

        return ultimateParent;
    }

    boolean unionBySize(int u, int v){
        int ultimateParentOfU = findParent(u);
        int ultimateParentOfV = findParent(v);

        if(ultimateParentOfU == ultimateParentOfV) return false;

        if(size.get(ultimateParentOfU) < size.get(ultimateParentOfV)){
            // u get attached to v
            parent.set(ultimateParentOfU, ultimateParentOfV);
            size.set(ultimateParentOfV, ultimateParentOfU+ultimateParentOfV);
        }else{
            parent.set(ultimateParentOfV, ultimateParentOfU);
            size.set(ultimateParentOfU, ultimateParentOfU+ultimateParentOfV);
        }
        return true;
    }


    boolean unionByRank(int u, int v){
        int ultimateParentOfU = findParent(u);
        int ultimateParentOfV = findParent(v);

        if(ultimateParentOfU == ultimateParentOfV) return false;

        if(rank.get(ultimateParentOfU) < rank.get(ultimateParentOfV)){
            parent.set(ultimateParentOfU, ultimateParentOfV);
        }else if(rank.get(ultimateParentOfU) > rank.get(ultimateParentOfV)){
            parent.set(ultimateParentOfV, ultimateParentOfU);
        }else{
            parent.set(ultimateParentOfV, ultimateParentOfU);
            int uRank = rank.get(ultimateParentOfU);
            rank.set(ultimateParentOfU, uRank+1);
        }
        return true;
    }


}
