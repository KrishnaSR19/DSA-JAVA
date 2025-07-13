/*
 * Q.Given a 2D array matrix that is row-wise sorted. The task is to find the median of the given matrix.
 */

/*
 * Time Complexity: O(M*N) + O(M*N(log(M*N))), where N is the number of rows in the matrix, M is the number of columns in each row. At first, the matrix is traversed to copy the elements, which takes O(MxN) time complexity. Then, the linear array of size (MxN) is sorted, which takes O(MxN log(MxN)) time complexity.
 Space Complexity: O(M*N), As a temporary list is used to store the elements of the matrix.
 */

class Solution {
    // Function to find the median of the matrix.
    public int findMedian(int[][] matrix) {
        List<Integer> lst = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        /*
         * Traverse the matrix and
         * copy the elements to list
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lst.add(matrix[i][j]);
            }
        }

        // Sort the list
        Collections.sort(lst);

        // Return the median element
        return lst.get((n * m) / 2);
    }
}
