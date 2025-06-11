/*
 * Q .Given an integer array nums. Return the number of inversions in the array.
Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

It indicates how close an array is to being sorted.
A sorted array has an inversion count of 0.
An array sorted in descending order has maximum inversion.
 */


/*
Brute Force
Time Complexity: O(N2), for using 2 nested loops, where N is the size of the array.
Space Complexity: O(1), no extra space is used.
 */ 

import java.util.*;

class Solution {
    // Function to find number of inversions in an array
    public long numberOfInversions(int[] nums) {
        
        // Size of the array
        int n = nums.length;

        // Count the number of pairs
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                /* If nums[i] is greater than 
                nums[j], increase count by 1*/
                if (nums[i] > nums[j]) {
                    cnt++;
                }
            }
        }

        // Return the count of inversions
        return cnt;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        
        // Create an instance of Solution class
        Solution sol = new Solution();

        long result = sol.numberOfInversions(nums);
        
        // Print the number of inversions found
        System.out.println("The number of inversions is: " + result);
    }
}

/*
 * Optimal(By using merge sort)
 Time Complexity: O(NxlogN), where N is size of the given array. We are not changing the merge sort algorithm except by adding a variable to it. So, the time complexity is as same as the merge sort.
Space Complexity: O(N), in the merge sort there is use a temporary array to store elements in sorted order.
 */

 class Solution {
    
    /* Merge function to count 
    inversions and merge sorted halves */
    private long merge(int[] arr, int low, int mid, int high) {
        
        // Temporary array for merging
        int[] temp = new int[high - low + 1];
        
        // Starting indices of left and right halves
        int left = low;
        int right = mid + 1;
        int index = 0;

        // Count variable to count the pairs
        long cnt = 0;

        // Merge sorted halves into temp array
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
                
                // Count inversions
                cnt += (mid - left + 1);
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp[index++] = arr[right++];
        }

        /* Copy elements from temp 
        array back to original array */
        System.arraycopy(temp, 0, arr, low, high - low + 1);
        
        // Return the count of inversions
        return cnt;
    }

    // Merge sort function to recursively sort and count inversions
    private long mergeSort(int[] arr, int low, int high) {
        long cnt = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            
            // Sort left half
            cnt += mergeSort(arr, low, mid);
            
            // Sort right half
            cnt += mergeSort(arr, mid + 1, high);
            
            // Merge and count inversions
            cnt += merge(arr, low, mid, high);
        }
        return cnt;
    }
    
    // Public function to find number of inversions in an array
    public long numberOfInversions(int[] nums) {
        
        // Size of the array
        int n = nums.length;

        // Count the number of pairs
        return mergeSort(nums, 0, n - 1);
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};

        // Create an instance of Solution class
        Solution sol = new Solution();

        long result = sol.numberOfInversions(nums);

        // Print the number of inversions found
        System.out.println("The number of inversions are: " + result);
    }
}
