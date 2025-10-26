/*
 * Brute Force Approach
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int n = nums.length;
        
        // Check each subarray starting at index `i`
        for (int i = 0; i < n; i++) {
            // Track contiguous zeroes starting from index `i`
            for (int j = i; j < n && nums[j] == 0; j++) {
                // Increment count each time a zero-filled subarray is found
                count++;
            }
        }
        
        return count;
    }
}

/*
 * Optimized Approach
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        int zeroCount = 0;
        
        for (int num : nums) {
            // Check if the current number is zero
            if (num == 0) {
                // Extend the current zero sequence
                zeroCount++;
            } else {
                // Calculate subarrays for the zero sequence
                result += zeroCount * (zeroCount + 1L) / 2;
                // Reset zero sequence counter
                zeroCount = 0;
            }
        }
        
        // If the last element was part of a zero sequence, add its subarrays
        result += zeroCount * (zeroCount + 1L) / 2;
        
        return result;
    }
}