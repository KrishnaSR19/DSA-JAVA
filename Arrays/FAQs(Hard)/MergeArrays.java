/*
 * Q.Given two integer arrays nums1 and nums2. Both arrays are sorted in non-decreasing order.
Merge both the arrays into a single array sorted in non-decreasing order.

The final sorted array should be stored inside the array nums1 and it should be done in-place.
nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s.
nums2 has a length of n.
 */

/*
 * Brute Force
 * Time Complexity: O(N+M) + O(N+M), where N and M are the sizes of the given arrays. O(N+M) is for copying the elements from nums1[] and nums2[] to the third array. And another O(N+M) is for filling back nums1[].
Space Complexity: O(N+M) for using an extra array of size N+M.
 */


// Function to merge two sorted arrays nums1 and nums2

import java.util.Arrays;

public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // Declare a 3rd array and 2 pointers:
        int[] merged = new int[m + n];
        int left = 0;
        int right = 0;
        int index = 0;

        /* Insert elements from nums1 and nums2 into
        merged array using left and right pointers */
        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                merged[index++] = nums1[left++];
            } else {
                merged[index++] = nums2[right++];
            }
        }

        // If right pointer reaches the end of nums2:
        while (left < m) {
            merged[index++] = nums1[left++];
        }

        // If left pointer reaches the end of nums1:
        while (right < n) {
            merged[index++] = nums2[right++];
        }

        /* Copy elements from merged array
        array back to nums1 */
        for (int i = 0; i < m + n; i++) {
            nums1[i] = merged[i];
        }
    }


    /*
     * Optimal-I
     * Time Complexity: O(min(N, M)) + O(NxlogN) + O(MxlogM), where N and M are the sizes of the given arrays. O(min(N, M)) is for swapping the array elements. And O(NxlogN) and O(MxlogM) are for sorting the two arrays.

Space Complexity: O(1) as no additional space is used apart from the input array.




     */


    // Function to merge two sorted arrays nums1 and nums2
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for nums1 (end of valid elements)
        int left = m - 1;
        
        // Pointer for nums2 (beginning of valid elements)
        int right = 0;
        
        /* Swap the elements until nums1[left]
        is smaller than nums2[right]*/
        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } 
            //break otherwise
            else break;
        }
        
        // Sort nums1 from index 0 to m-1
        Arrays.sort(nums1, 0, m);
        
        // Sort nums2 from start to end
        Arrays.sort(nums2);
        
        // Put the elements of nums2 in nums1
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
    }
    
  