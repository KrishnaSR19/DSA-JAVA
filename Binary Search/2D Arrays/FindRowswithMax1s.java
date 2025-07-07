/*
 * Q.Given a non-empty grid mat consisting of only 0s and 1s, where all the rows are sorted in ascending order, find the index of the row with the maximum number of ones.
If two rows have the same number of ones, consider the one with a smaller index. If no 1 exists in the matrix, return -1.
 */

/*     Brute Force Approach
    * Time Complexity: O(N * M), where N is the number of rows and M is the number of columns in the matrix. We traverse each row to count the number of 1's.
    * Space Complexity: O(1), as we are using a constant amount of space for variables.
 */

class Solution {
    public int rowWithMax1s(int[][] mat) {
        int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns

        int cnt_max = 0; // Max count of 1's found
        int index = -1; // Index of row with max 1's

        // Traverse each row
        for (int i = 0; i < n; i++) {
            int cnt_ones = 0; // 1's in current row

            // Count 1's in current row
            for (int j = 0; j < m; j++) {
                cnt_ones += mat[i][j];
            }

            // Update max count and index if current row has more 1's
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index; // Return the row index
    }
}