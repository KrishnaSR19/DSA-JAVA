
/*
 * Q.Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.
 */

/*
  Brute Force
 * Time Complexity: O(N2), where N is the size of the array. Since we are using nested loops to count occurrences of every element between 1 to N.
Space Complexity: O(1) as no extra space is used.
 */
import java.util.*;

class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length; // Size of the array
        int repeating = -1, missing = -1;

        // Find the repeating and missing number:
        for (int i = 1; i <= n; i++) {
            // Count the occurrences:
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) cnt++;
            }

            // Check if i is repeating or missing
            if (cnt == 2) repeating = i;
            else if (cnt == 0) missing = i;

            /* If both repeating and missing
            are found, break out of loop*/
            if (repeating != -1 && missing != -1)
                break;
        }

        // Return {repeating, missing}
        return new int[] {repeating, missing};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};
        
        // Create an instance of Solution class
        Solution sol = new Solution();

        int[] result = sol.findMissingRepeatingNumbers(nums);
        
        // Print the repeating and missing numbers found
        System.out.println("The repeating and missing numbers are: {" + result[0] + ", " + result[1] + "}");
    }
}

/*
 * Better(Hash)
 */

// Method -1 using hash

class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check from 1 to n for missing and repeating
        for (int i = 1; i <= nums.length; i++) {
            Integer count = map.get(i);
            if (count == null) {
                result[1] = i; // Missing number
            } else if (count == 2) {
                result[0] = i; // Repeating number
            }
        }

        return result;
    }
}

// Method 2
import java.util.*;

class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {
        
        // Size of the array
        int n = nums.length;
        
        // Hash array to count occurrences
        int[] hash = new int[n + 1];
        
        // Update the hash array:
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }

        int repeating = -1, missing = -1;
        
        // Find the repeating and missing number:
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            /* If both repeating and missing 
            are found, break out of loop*/
            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        
        // Return [repeating, missing]
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};
        
        // Create an instance of Solution class
        Solution sol = new Solution();

        int[] result = sol.findMissingRepeatingNumbers(nums);
        
        // Print the repeating and missing numbers found
        System.out.println("The repeating and missing numbers are: {" + result[0] + ", " + result[1] + "}");
    }
}

/*
 * Optimal(using equations)
 * Time Complexity: O(N), as a single loop is used, where N is the size of the
 * given array.
 * Space Complexity: O(1) no extra space is used.
 */

import java.util.*;

class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {

        // Size of the array
        long n = nums.length;

        // Sum of first n natural numbers
        long SN = (n * (n + 1)) / 2;

        // Sum of squares of first n natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        /*
         * Calculate actual sum (S) and sum
         * of squares (S2) of array elements
         */
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * (long) nums[i];
        }

        // Compute the difference values
        long val1 = S - SN;

        // S2 - S2n = X^2 - Y^2
        long val2 = S2 - S2N;

        // Calculate X + Y using X + Y = (X^2 - Y^2) / (X - Y)
        val2 = val2 / val1;

        /*
         * Calculate X and Y from X + Y and X - Y
         * X = ((X + Y) + (X - Y)) / 2
         * Y = X - (X - Y)
         */
        long x = (val1 + val2) / 2;
        long y = x - val1;

        // Return the results as [repeating, missing]
        return new int[] { (int) x, (int) y };
    }

}

/*
 * Optimal(XOR)
 * Time Complexity: O(N), using only one loop running for N times, where N is
 * the size of the given array.
 * 
 * Space Complexity: O(1) no extra space is used.
 */

class Solution {
    // Function to find repeating and missing numbers
    public int[] findMissingRepeatingNumbers(int[] nums) {
        // size of the array
        int n = nums.length;

        int xr = 0;

        for (int i = 0; i < n; i++) {
            // XOR of all elements in nums
            xr = xr ^ nums[i];

            // XOR of numbers from 1 to n
            xr = xr ^ (i + 1);
        }

        // Get the rightmost set bit in xr
        int number = (xr & ~(xr - 1));

        // Group the numbers based on the differentiating bit
        // Number that falls into the 0 group
        int zero = 0;

        // Number that falls into the 1 group
        int one = 0;

        for (int i = 0; i < n; i++) {
            /*
             * Check if nums[i] belongs to the 1 group
             * based on the differentiating bit
             */
            if ((nums[i] & number) != 0) {
                // XOR operation to find numbers in the 1 group
                one = one ^ nums[i];
            } else {
                // XOR operation to find numbers in the 0 group
                zero = zero ^ nums[i];
            }
        }

        // Group numbers from 1 to n based on differentiating bit
        for (int i = 1; i <= n; i++) {

            /*
             * Check if i belongs to the 1 group
             * based on the differentiating bit
             */
            if ((i & number) != 0) {
                // XOR operation to find numbers in the 1 group
                one = one ^ i;
            } else {
                // XOR operation to find numbers in the 0 group
                zero = zero ^ i;
            }

        }

        // Count occurrences of zero in nums
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == zero) {
                cnt++;
            }
        }

        if (cnt == 2) {
            /*
             * zero is the repeating number,
             * one is the missing number
             */
            return new int[] { zero, one };
        }

        /*
         * one is the repeating number,
         * zero is the missing number
         */
        return new int[] { one, zero };
    }
}
