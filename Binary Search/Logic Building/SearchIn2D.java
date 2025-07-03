/*
 * Q.You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
 */



/*
 * Time Complexity: O(log(m * n)), where m is the number of rows and n is the number of columns in the matrix.
 * Space Complexity: O(1), as we are using a constant amount of space for variables
 */


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;       // Number of rows
        int n = matrix[0].length;    // Number of columns
        
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Convert 1D index to 2D coordinates
            int row = mid / n;
            int col = mid % n;

            int midElement = matrix[row][col];

            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
