package Practice.Graphs;

import java.util.*;

public class MakingALargeIsland {
    // https://leetcode.com/problems/making-a-large-island/
    // https://www.youtube.com/watch?v=lgiz0Oup6gM

    // using disjoint set data structure since graph is changing dynamically
    public int largestIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int totalEle = rows * cols;
        DisjointSet ds = new DisjointSet(totalEle);
        constructGraph(grid, rows, cols, ds);

        int[] size = ds.getSize();
        System.out.println(Arrays.toString(size));
        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};


        int maxTotalSize = Integer.MIN_VALUE;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                Set<Integer> ultimateParentSet = new HashSet<>();
                if(grid[i][j] == 0){
                    for(int[] dir : dirs){
                        int dx = dir[0] + i;
                        int dy = dir[1] + j;
                        if( isValid(rows, cols, dx, dy) &&  grid[dx][dy] == 1){
                            int adjNodeNum = dx * cols + dy;
                            ultimateParentSet.add(ds.findUltimateParent(adjNodeNum));
                        }
                    }
                }
                int totalSize = 0;
                for(Integer parentNode : ultimateParentSet){
                    totalSize += size[parentNode];
                }
                maxTotalSize = Math.max(totalSize+1, maxTotalSize);
            }
        }
        for(int cell=0; cell < totalEle; cell++){
            maxTotalSize = Math.max(maxTotalSize, size[cell]);
        }
        return maxTotalSize;
    }

    void constructGraph(int[][] grid, int rows, int cols, DisjointSet ds){
        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    int nodeNum = (i * cols) + j;
                    for(int[] dir : dirs){
                        int dx = dir[0] + i;
                        int dy = dir[1] + j;
                        if(isValid(rows, cols, dx, dy) && grid[dx][dy] == 1){
                            int adjNodeNum = dx * cols + dy;
                            ds.union(nodeNum, adjNodeNum);
                        }
                    }
                }
            }
        }

    }

    boolean isValid(int rows, int cols, int dx, int dy){
        if( dx < 0 || dy < 0 || dx >=rows || dy >= cols ) return false;
        return true;
    }


    class DisjointSet{
        int[] parents;
        int[] size;

        DisjointSet(int n){
            parents = new int[n];
            for(int i=0; i<n; i++){
                parents[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }
        boolean union(int u, int v){
            int uUltimateParent = findUltimateParent(u);
            int vUltimateParent = findUltimateParent(v);
            if(uUltimateParent == vUltimateParent) return false;
            if(size[uUltimateParent] < size[vUltimateParent]){
                // attach u to v
                size[vUltimateParent] += size[uUltimateParent];
                parents[uUltimateParent] = vUltimateParent;
            }else{
                // attach v to u
                size[uUltimateParent] += size[vUltimateParent];
                parents[vUltimateParent] = uUltimateParent;
            }
            return true;
        }


        int findUltimateParent(int u){
            if(parents[u] == u){
                return u;
            }
            int ultimateParent = findUltimateParent(parents[u]);
            parents[u] = ultimateParent;
            return ultimateParent;
        }

        int[] getSize(){
            return size;
        }
    }


}
