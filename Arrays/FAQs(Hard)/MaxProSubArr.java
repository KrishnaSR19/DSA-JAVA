/*
 *Q. Given an integer array nums. Find the subarray with the largest product, and return the product of the elements present in that subarray.
A subarray is a contiguous non-empty sequence of elements within an array.
 */

 /*
  * Brute Force
Time Complexity: O(N3) for using 3 nested loops for finding all possible subarrays and their product. Here N is the size of the array.

Space Complexity: O(1), as no additional space is used apart from the input array.
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


/*
 * Better
 * Time Complexity: O(N2) for using 2 nested loops for finding all possible subarrays and their product. Here N is the size of the array.

Space Complexity: O(1) as no additional space is used apart from the input array.
 */


 import java.util.*;

class Solution {
    // Function to find maximum product subarray
    public int maxProduct(int[] nums) {
        // Initialize result with first element of nums
        int result = nums[0];

        /* Iterate through each element
        as a starting point of subarray */
        for (int i = 0; i < nums.length; i++) {
            // Initialize p with nums[i]
            int p = nums[i];

            /* Iterate through subsequent elements
            to form subarrays starting from nums[i] */
            for (int j = i + 1; j < nums.length; j++) {
                
                /* Update result with the
                max of current result and p */
                result = Math.max(result, p);

                // Update p by multiplying with nums[j]
                p *= nums[j];
            }

            // Update result for subarray ending at nums[i]
            result = Math.max(result, p);
        }

        // Return maximum product subarray found
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 7, 1, 2};

        // Create an instance of the Solution class
        Solution sol = new Solution();

        int maxProd = sol.maxProduct(nums);

        // Print the result
        System.out.println("The maximum product subarray: " + maxProd);
    }
}


/*
 * Optimal
 * Time Complexity: O(N), where N is the size of the array
Traversing the given array using single for loop takes linear time.
Space Complexity: O(1), as only couple of variables are used.
 */

 class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int ans = Integer.MIN_VALUE; // to store the answer
        
        // Indices to store the prefix and suffix multiplication
        int prefix = 1, suffix = 1;
        
        // Iterate on the elements of the given array
        for (int i = 0; i < n; i++) {
            
            /* Resetting the prefix and suffix
            multiplication if they turn out to be zero */
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            
            // update the prefix and suffix multiplication
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            
            // store the maximum as the answer
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        
        // return the result
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 7, 1, 2};
        
        // Creating an object of Solution class
        Solution sol = new Solution();
        
        /* Function call to find the product of
        elements in maximum product subarray */
        int ans = sol.maxProduct(nums);
        
        System.out.println("The product of elements in maximum product subarray is: " + ans);
    }
}