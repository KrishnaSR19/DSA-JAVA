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

/*
 * Time Complexity: O(log(max)) * O(N(logM)), where N is the number of rows in
 * the matrix, M is the number of columns in each row. Our search space ranges
 * from [min, max], where min is the minimum and max is the maximum element of
 * the matrix. Binary search is applied within this search space, which operates
 * with a time complexity of O(log(max)). Then, the countSmallEqual() function
 * is called for each 'mid', which has a time complexity of O(N*log(M)).
 * 
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 */

class Solution {
    // Function to find the upper bound of an element
    private int upperBound(int[] arr, int x, int m) {
        int low = 0, high = m - 1;
        int ans = m;

        // Apply binary search
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] > x, it can be a possible answer
            if (arr[mid] > x) {
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

    // Function to find the count of elements smaller than or equal to x
    private int countSmallEqual(int[][] matrix, int n, int m, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += upperBound(matrix[i], x, m);
        }
        // Return the count
        return cnt;
    }

    // Function to find the median in a matrix
    public int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Initialize low and high
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // Point low and high to right elements
        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }

        int req = (n * m) / 2;

        // Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            /*
             * Store the count of elements
             * lesser than or equal to mid
             */
            int smallEqual = countSmallEqual(matrix, n, m, mid);
            if (smallEqual <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Return low as answer
        return low;
    }
}
