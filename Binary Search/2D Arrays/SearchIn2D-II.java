/*
 * Q.Given a 2D array matrix where each row is sorted in ascending order from left
 * to right and each column is sorted in ascending order from top to bottom,
 * write an efficient algorithm to search for a specific integer target in the matrix.
 */

/*
 * Brute Force
   * Time Complexity: O(N * M), where N is the number of rows and M is the number of columns in the matrix. We traverse each element to check for the target.
   * Space Complexity: O(1), as we are using a constant amount of space for variables.
 */
public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;

    // Check every element one by one
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] == target)
                return true;
        }
    }

    // Return false if not found
    return false;
}

/*
 * Better
 * Time Complexity: O(N * logM), where N is the number of rows in the matrix, M
 * is the number of columns in each row. All rows are traversed in O(N) time
 * complexity, and binary search is applied to each row. Therefore, the total
 * time complexity is O(N*logM).
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 */
class Solution {
    // Helper function to perform binary search
    private boolean binarySearch(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        // Perform the steps:
        while (low <= high) {
            int mid = (low + high) / 2;

            // Return true if target is found
            if (nums[mid] == target)
                return true;
            else if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        // Return false if target not found
        return false;
    }

    // Function to search for a given target in matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Traverse through each row
        for (int i = 0; i < n; i++) {

            /*
             * Check if target is
             * present in the current row
             */
            boolean flag = binarySearch(matrix[i], target);

            if (flag)
                return true;
        }
        // Return false if target is not found
        return false;
    }
}

/*
 * Optimal
 * Time Complexity: O(N + M), where N is the number of rows in the matrix, M is
 * the number of columns in each row. Traversal starts from (0, M-1), and at
 * most, it can end up in the cell (M-1, 0). Therefore, the total distance can
 * be at most (N+M). Hence, the time complexity is O(N+M).
 * 
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 * 
 */
class Solution {
    // Function to search for a given target in matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Initialize the row and col
        int row = 0, col = m - 1;

        // Traverse the matrix from (0, m-1):
        while (row < n && col >= 0) {

            // Return true if target is found
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                row++;
            else
                col--;
        }
        // Return false if target not found
        return false;
    }
}
