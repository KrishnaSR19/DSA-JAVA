/*
 *Q. Given an integer array nums. Find the subarray with the largest product, and return the product of the elements present in that subarray.
A subarray is a contiguous non-empty sequence of elements within an array.
 */

 /*
  * Brute Force

  */


  import java.util.*;

class Solution {
    // Function to find maximum product subarray
    public int maxProduct(int[] nums) {
        // Initialize result to minimum possible integer
        int result = Integer.MIN_VALUE;

        // Iterate through all subarrays
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int prod = 1;

                // Calculate product of subarray 
                for (int k = i; k <= j; k++) {
                    prod *= nums[k];
                }

                // Update the result with maximum product found
                result = Math.max(result, prod);
            }
        }

        // Return the maximum product found
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 7, 1, 2};

        // Create an instance of the Solution class
        Solution sol = new Solution();

        int maxProd = sol.maxProduct(nums);

        // Print the result
        System.out.println("The maximum product subarray: " + maxProd);
    }
}
