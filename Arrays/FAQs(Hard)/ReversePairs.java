/*
 *Q. Given an integer array nums. Return the number of reverse pairs in the array.
An index pair (i, j) is called a reverse pair if:

0 <= i < j < nums.length
nums[i] > 2 * nums[j].
 */



/*
 * Brute Force
 * Time Complexity: O(N2), where N is size of the given array. For using nested loops here and those two loops roughly run for N times.

Space Complexity: O(1), no extra space is used to solve this problem.
 */

 import java.util.*;

class Solution {
    /* Function to count reverse
    pairs where a[i] > 2 * a[j]*/
    public int reversePairs(int[] nums) {
        
        // Call countPairs with the array and its length
        return countPairs(nums, nums.length); 
        
    }

    /* Helper function to count pairs
    satisfying the condition a[i] > 2 * a[j]*/
    private int countPairs(int[] nums, int n) {
        
        // Initialize count of reverse pairs
        int cnt = 0;
        
        /* Nested loops to check each
        pair (i, j) where i < j*/
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                /* Check if the condition 
                a[i] > 2 * a[j] holds*/
                if (nums[i] > 2 * nums[j]) {
                    
                    /* Increment count if
                    condition is satisfied*/
                    cnt++; 
                    
                }
            }
        }
        // Return the total count of reverse pairs
        return cnt; 
    }

    public static void main(String[] args) {
        
        int[] nums = {6, 4, 1, 2, 7}; 
        
        // Create an instance of the Solution class
        Solution sol = new Solution(); 
        
        int cnt = sol.reversePairs(nums); 
        
        // Output the result
        System.out.println("The number of reverse pairs is: " + cnt);
    }
}
