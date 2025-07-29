/*
 * LeetCode Problem: Unique Paths
 * Problem Link: https://leetcode.com/problems/unique-paths/    
 * Description: Given a m x n grid, find the number of unique paths from the top-left corner to the bottom-right corner.
 * You can only move either down or right at any point in time. 
 * The grid is represented as a matrix with m rows and n columns.
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */


class Solution {
    public int uniquePaths(int m, int n) {
        long res = 1;

        // Use the formula: C(m+n-2, n-1)
        for (int i = 1; i <= n - 1; i++) {
            res = res * (m - 1 + i) / i;
        }

        return (int) res;
    }
}
