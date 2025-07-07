/*(Medium)
 * Given two sorted arrays a and b of size m and n respectively. Find the kth element of the final sorted array.
 */

/*
 * Time Complexity:O(log(min(M, N))), where M and N are the sizes of two given arrays. As, binary search is being applied on the range [max(0, k-N2), min(k, N1)]. The range length <= min(M, N).
Space Complexity: As no additional space is used, so the Space Complexity is O(1).
 */
class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;

        // Ensure a is smaller array for optimization
        if (m > n) {
            // Swap a and b
            return kthElement(b, a, k);
        }

        // Length of the left half
        int left = k;

        // Apply binary search
        int low = Math.max(0, k - n), high = Math.min(k, m);
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;

            // Initialize l1, l2, r1, r2
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? b[mid2] : Integer.MAX_VALUE;

            // Check if we have found the answer
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                // Eliminate the right half
                high = mid1 - 1;
            } else {
                // Eliminate the left half
                low = mid1 + 1;
            }
        }

        // Dummy return statement
        return -1;
    }
}
