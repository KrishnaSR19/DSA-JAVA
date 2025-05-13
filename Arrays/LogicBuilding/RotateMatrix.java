
/*
 * Q.Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
The rotation must be done in place, meaning the input 2D matrix must be modified directly.
 */

/*
 * Time Complexity: O(N2) +O(N2), to linearly iterate and put elements into dummy matrix and another O(N2) to copy elements of dummy matrix back to original matrix.
  Space Complexity: O(N2), to store the elements in the dummy matrix.
 */




public class RotateMatrix {
    class Solution {
    //Function to rotate the given matrix by 90 degrees clockwise
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        
        // Initialize new matrix to store rotated values
        int[][] rotated = new int[n][n];
        
        // Perform rotation logic
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        
        // Copy rotated elements to original matrix
        for (int i = 0; i < n; i++) {
            System.arraycopy(rotated[i], 0, matrix[i], 0, n);
        }
    }
}
}
