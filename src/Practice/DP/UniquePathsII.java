package Practice.DP;

public class UniquePathsII {
    // https://leetcode.com/problems/unique-paths-ii/
    public int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(grid[0][0] == 1) return 0;

        if(grid[rows-1][cols-1] == 1) return 0;

        Integer[][] memo = new Integer[rows][cols];
        return solve(grid, 0, 0, memo);
    }

    public int solve(int[][] grid, int currRow, int currCol, Integer[][] memo){
        int rows = grid.length;
        int cols = grid[0].length;

        if(currRow == rows-1 && currCol == cols-1){
            // reach bottom right corner
            return 1;
        }

        if(memo[currRow][currCol] != null) return memo[currRow][currCol];

        int[][] dirs = {{1,0}, {0,1}};
        int totalPaths = 0;
        for(int[] dir : dirs){
            int nextRow = currRow + dir[0];
            int nextCol = currCol + dir[1];
            if(isValid(grid, rows, cols, nextRow, nextCol)){
                totalPaths += solve(grid, nextRow, nextCol, memo);
            }
        }

        memo[currRow][currCol] = totalPaths;
        return totalPaths;
    }

    private boolean isValid(int[][] grid, int rows, int cols, int row, int col){
        return row < rows && col < cols && grid[row][col] == 0;
    }
}
