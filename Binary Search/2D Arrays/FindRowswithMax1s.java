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

/*
 * Optimized Approach using Binary Search
 * Time Complexity:O(N * logM), where N is the number of rows in the matrix, M
 * is the number of columns in each row. As, each row is being traversed once
 * and then binary search is being applied for M columns of every row.
 * 
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 */
class Solution {
    // Helper function to find the lower bound of 1.
    private int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            /*
             * If element at mid is greater than or equal
             * to x then it counld be a possible answer.
             */
            if (arr[mid] >= x) {
                ans = mid;

                // Look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // Return the answer
        return ans;
    }

    /*
     * Function to find the row
     * with the maximum number of 1's
     */
    public int rowWithMax1s(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        /*
         * Variable to store the
         * maximum count of 1's found
         */
        int cnt_max = 0;

        /*
         * Variable to store the index
         * of the row with max 1's
         */
        int index = -1;

        // Traverse each row of the matrix
        for (int i = 0; i < n; i++) {
            // Get the number of 1's
            int cnt_ones = m - lowerBound(mat[i], m, 1);
            // If current row has more 1's than previous max
            // Update the max count and index
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        // Return the index of the row with maximum 1's
        return index;
    }
}
