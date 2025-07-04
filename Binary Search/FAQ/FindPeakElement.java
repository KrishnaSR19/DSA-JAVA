/*
 *Q. Given an array arr of integers. A peak element is defined as an element
 * greater than both of its neighbors. Formally, if arr[i] is the peak element,
 * arr[i - 1] < arr[i] and arr[i + 1] < arr[i]. Find the index(0-based) of a
 * peak element in the array. If there are multiple peak numbers, return the
 * index of any peak number.
 * Note: As there can be many peak values, 1 is given as output if the returned
 * index is a peak number, otherwise 0.
 */

 /*
  * Brute Force
  * Time Complexity: O(n), where n is the number of elements in the array.
    * Space Complexity: O(1), as we are using a constant amount of space for variables.
  */

class Solution {
    // Function to find peak element in the array
    public int findPeakElement(int[] arr) {
        // Size of array
        int n = arr.length;
        
        /* Iterate through the array
           to find the peak element */
        for (int i = 0; i < n; i++) {
            
            // Check if arr[i] is a peak
            if ((i == 0 || arr[i - 1] < arr[i]) && (i == n - 1 || arr[i] > arr[i + 1])) {
                
                // Return the index of peak element
                return i;
            }
        }
        /* Return -1 if no peak element
           found (dummy return) */
        return -1;
    }
}
