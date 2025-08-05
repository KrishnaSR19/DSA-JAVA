/*
 * Q. Find the minimum path sum from top to bottom in a triangle.
 * Given a triangle represented as a list of lists, where each inner list contains integers,
 * find the minimum path sum from the top to the bottom.
 * The path can only move to adjacent numbers on the row below.
 * The function should return the minimum path sum.
 * Example:
 * Input: [[2], [3, 4], [6, 5,7, 8], [4, 1, 8, 3]]
 * Output: 11 (2 + 3 + 5 + 1)
 */
    
 class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        // Start by copying the last row into dp
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        
        // Bottom-up DP
        for (int row = n - 2; row >= 0; row--) {
            for (int i = 0; i <= row; i++) {
                dp[i] = triangle.get(row).get(i) + Math.min(dp[i], dp[i + 1]);
            }
        }
        
        return dp[0]; // Top of the triangle
    }
}


/*
 * Optimized
 */

 class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Create a memoization matrix to store results of subproblems
        // Initialized to Integer.MAX_VALUE to represent "uncomputed"
        int[][] memo = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        // Start recursion from the top of the triangle (row 0, col 0)
        return helper(triangle, 0, 0, memo);
    }

    // Helper function to recursively find minimum path sum
    private int helper(List<List<Integer>> triangle, int row, int col, int[][] memo) {
        // Base case: If we’re on the last row, return the value at that cell
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        // If result for this cell is already computed, return it
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }

        // Recurse to the two possible positions in the next row:
        // - directly below (col)
        // - diagonally right (col + 1)
        int left = helper(triangle, row + 1, col, memo);
        int right = helper(triangle, row + 1, col + 1, memo);

        // Store the result in memo: current value + min of two possible paths
        memo[row][col] = triangle.get(row).get(col) + Math.min(left, right);

        // Return the computed value for current position
        return memo[row][col];
    }
}
