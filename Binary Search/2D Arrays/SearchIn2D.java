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