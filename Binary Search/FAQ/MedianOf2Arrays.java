/*
 * (Hard)
 * Q.Given two sorted arrays arr1 and arr2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * The median is defined as the middle value of a sorted list of numbers. In
 * case the length of the list is even, the median is the average of the two
 * middle elements.
 */

/*
 * Brute Force
   * Time Complexity: O(m + n), where m and n are the sizes of the two arrays.
   * Space Complexity: O(m + n), as we are merging the two arrays into a new array.
 */
class Solution {
    public double median(int[] arr1, int[] arr2) {
        // Size of two given arrays
        int n1 = arr1.length, n2 = arr2.length;

        int[] merged = new int[n1 + n2];
        // Apply the merge step
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j])
                merged[k++] = arr1[i++];
            else
                merged[k++] = arr2[j++];
        }

        // Copy the remaining elements
        while (i < n1)
            merged[k++] = arr1[i++];
        while (j < n2)
            merged[k++] = arr2[j++];

        // Find the median
        int n = n1 + n2;
        if (n % 2 == 1) {
            return (double) merged[n / 2];
        }

        double median = ((double) merged[n / 2] + (double) merged[(n / 2) - 1]) / 2.0;
        return median;
    }
}

/*
 * Better
 * Time Complexity:O(N1+N2), where N1 and N2 are the sizes of the given arrays.
 * As, both are arrays are being traversed linearly.
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 */

class Solution {
    public double median(int[] arr1, int[] arr2) {
        // Size of two given arrays
        int n1 = arr1.length, n2 = arr2.length;
        int n = n1 + n2; // Total size

        // Required indices for median calculation
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1el = -1, ind2el = -1;

        // Apply the merge step
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                if (cnt == ind1)
                    ind1el = arr1[i];
                if (cnt == ind2)
                    ind2el = arr1[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1)
                    ind1el = arr2[j];
                if (cnt == ind2)
                    ind2el = arr2[j];
                cnt++;
                j++;
            }
        }

        // Copy the remaining elements
        while (i < n1) {
            if (cnt == ind1)
                ind1el = arr1[i];
            if (cnt == ind2)
                ind2el = arr1[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1)
                ind1el = arr2[j];
            if (cnt == ind2)
                ind2el = arr2[j];
            cnt++;
            j++;
        }

        // Find the median
        if (n % 2 == 1) {
            return (double) ind2el;
        }

        return (double) ((double) (ind1el + ind2el)) / 2.0;
    }
}

/*
 * Optimal
 * Time Complexity: O(log(min(N1,N2))), where N1 and N2 are the sizes of two given arrays. As, binary search is being applied on the range [0, min(N1, N2)]
 * Space Complexity: As no additional space is used, so the Space Complexity is O(1).
 */
class Solution {
    // Function to find the median of two sorted arrays.
    public double median(int[] arr1, int[] arr2) {
        // Size of two given arrays
        int n1 = arr1.length, n2 = arr2.length;
        /*
         * Ensure arr1 is not larger than
         * arr2 to simplify implementation
         */
        if (n1 > n2)
            return median(arr2, arr1);

        int n = n1 + n2;

        // Length of left half
        int left = (n1 + n2 + 1) / 2;

        // Apply binary search
        int low = 0, high = n1;
        while (low <= high) {

            // Calculate mid index for arr1
            int mid1 = (low + high) >>> 1;

            // Calculate mid index for arr2
            int mid2 = left - mid1;

            // Calculate l1, l2, r1, and r2
            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                // If condition for finding median
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                // Eliminate the right half of arr1
                high = mid1 - 1;
            } else {
                // Eliminate the left half of arr1
                low = mid1 + 1;
            }
        }
        // Dummy statement
        return 0;
    }
}
