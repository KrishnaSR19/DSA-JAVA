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
