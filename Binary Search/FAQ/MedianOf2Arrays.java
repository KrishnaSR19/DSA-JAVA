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
            if (arr1[i] < arr2[j]) merged[k++] = arr1[i++];
            else merged[k++] = arr2[j++];
        }

        // Copy the remaining elements
        while (i < n1) merged[k++] = arr1[i++];
        while (j < n2) merged[k++] = arr2[j++];

        // Find the median
        int n = n1 + n2;
        if (n % 2 == 1) {
            return (double) merged[n / 2];
        }

        double median = ((double) merged[n / 2] + (double) merged[(n / 2) - 1]) / 2.0;
        return median;
    }
}
