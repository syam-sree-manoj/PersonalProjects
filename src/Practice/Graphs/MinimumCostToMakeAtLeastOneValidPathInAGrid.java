package Practice.Graphs;

import java.util.PriorityQueue;

public class MinimumCostToMakeAtLeastOneValidPathInAGrid {
    // used Dijkstra algo
    // https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
    // https://www.youtube.com/watch?v=N2BzRdhHJ2c

    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Direction arrays corresponding to 1 (right), 2 (left), 3 (down), 4 (up)
        int[] dx = {0, 0, 0, 1, -1};
        int[] dy = {0, 1, -1, 0, 0};

        // Cost array to track the minimum cost to reach each cell
        int[][] cost = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        // Priority queue to process cells with the minimum cost first
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.costFromSrc - b.costFromSrc);

        // Start from (0, 0) with cost 0
        pq.offer(new Node(0, 0, 0));
        cost[0][0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currentCost = node.costFromSrc;
            int row = node.row, col = node.col;

            // If we've already processed this cell with a smaller cost, skip it
            if (currentCost > cost[row][col]) continue;

            // If we reach the bottom-right cell, return the cost
            if (row == rows - 1 && col == cols - 1) return currentCost;

            // Explore all directions
            for (int i = 1; i <= 4; i++) {
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];

                if (isValid(nextRow, nextCol, rows, cols)) {
                    int newCost = currentCost + (grid[row][col] == i ? 0 : 1);
                    if (newCost < cost[nextRow][nextCol]) {
                        cost[nextRow][nextCol] = newCost;
                        pq.offer(new Node(newCost, nextRow, nextCol));
                    }
                }
            }
        }

        return -1; // This should never be reached if the grid is valid
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }

    class Node {
        int costFromSrc, row, col;

        Node(int costFromSrc, int row, int col) {
            this.costFromSrc = costFromSrc;
            this.row = row;
            this.col = col;
        }
    }
}


