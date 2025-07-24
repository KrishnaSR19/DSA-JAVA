/*
 * Minimum Path Sum
 * Given a grid filled with non-negative integers, find a path from the top-left corner to the bottom-right corner that minimizes the sum of the numbers along the path. You can only move either down or right at any point in time.
 * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid. This is because we iterate through each cell once.
 * Space Complexity: O(1), since we are modifying the input grid in place and not
 */

 class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;      // rows
        int n = grid[0].length;   // cols

        // Fill first row
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // Fill first column
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // Fill rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1]; // Bottom-right cell
    }
}
