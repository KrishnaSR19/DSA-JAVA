/*
 *Q.Given a 2-D array mat where the elements of each row are sorted in
 * non-decreasing order, and the first element of a row is greater than the last
 * element of the previous row (if it exists), and an integer target, determine
 * if the target exists in the given mat or not.
 */

/*
 * Brute Force Approach
 * Time Complexity: O(N * M), where N is the number of rows and M is the number of columns in the matrix. We traverse each element to check for the target.
 * Space Complexity: O(1), as we are using a constant amount of space for variables
 */
class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        if (mat.length == 0 || mat[0].length == 0) {
            return false;
        }
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

/*
 * Better Binary Search Approach
 * Time Complexity: O(N + logM), where N is given row number, M is given column
 * number. The rows are traversed in O(N) time complexity. Binary search is
 * applied only once for a particular row, resulting in a time complexity of O(N
 * + logM) instead of O(N*logM).
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 */
class Solution {
    private boolean binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents overflow for large low/high

            if (nums[mid] == target)
                return true;
            else if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    // Searches for a target in a sorted 2D matrix
    public boolean searchMatrix(int[][] mat, int target) {
        // Handle empty matrix cases
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return false;
        }

        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            // Check if target could be in the current row (optimized search)
            if (mat[i][0] <= target && target <= mat[i][m - 1]) {
                return binarySearch(mat[i], target);
            }
        }
        return false;
    }
}

/*
 * Optimal Approach I
 * Time Complexity: O(log(N*M)), where N is the number of rows in the matrix, M
 * is the number of columns in each row. As, binary search is being applied on
 * the 1-D array of size N*M.
 * 
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 */

import java.util.*;

class Solution {
    // Function to search for a given target in matrix
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = n * m - 1;

        // Perform binary search
        while (low <= high) {
            int mid = (low + high) / 2;

            // Calculate the row and column
            int row = mid / m;
            int col = mid % m;

            // If target is found return true
            if (mat[row][col] == target)
                return true;
            else if (mat[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        // Return false if target is not found
        return false;
    }
}


/*
 * Optimal Approach II
 * Time Complexity: O(log(N*M)), where N is the number of rows in the matrix, M
 * is the number of columns in each row. As, binary search is being applied on
 * the 1-D array of size N*M.
 * Space Complexity: As no additional space is used, so the Space Complexity is O(1). 
 */

 class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;

            if(searchRow(matrix[mid],target)==true){
                return true;
            }
            
            if(matrix[mid][0]>target){
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }
        return false;
        
    }

    public boolean searchRow(int [] matrix, int target){
        int n =matrix.length;
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(matrix[mid]==target){
                return true;
            }
            else if(matrix[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}
