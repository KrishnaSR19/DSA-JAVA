
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
        // Function to rotate the given matrix by 90 degrees clockwise
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

/*
 * Optimal
 * Time Complexity: O(N2) +O(N2), to linearly iterate and find transpose of the
 * matrix and another O(N2) to find the reverse of each row.
 * Space Complexity: O(1), as no extra space is being used.
 */

class Solution {
    // Rotate the given matrix by 90 degrees clockwise.

    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                // Swap elements across the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        // Reverse each row of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {

                // Swap elements symmetrically
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;

            }
        }
    }
}
