/*(Hard)
 * Split Array Largest Sum
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * 
 * 
 */

/*
 * Brute Force
   * Time Complexity: O(n^m), where n is the number of elements in the array and m is the number of partitions.
   * Space Complexity: O(m), as we are using a stack to store the current partition.
 */

class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        // Calculate the range of possible answers
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]); // minimum possible maxSum (no subarray can have less than the largest
                                          // element)
            high += nums[i]; // maximum possible maxSum (all elements in one subarray)
        }

        // Brute force over each possible maxSum
        for (int maxSum = low; maxSum <= high; maxSum++) {
            if (canSplit(nums, maxSum, k)) {
                return maxSum;
            }
        }

        return -1; // Should never reach here if input is valid
    }

    // Helper function to check if we can split into <= k subarrays with given
    // maxSum
    public boolean canSplit(int[] nums, int maxSum, int k) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                subarrays++;
                currentSum = num;
            }
        }

        return subarrays <= k;
    }
}

/*
 * Optimal
 * Time Complexity: O(n log(maxSum)), where n is the number of elements in the
 * array and maxSum is the maximum element in the array.
 * Space Complexity: O(1), as we are using a constant amount of space for
 * variables.
 * 
 */

class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        // If students/partitions more than number of books/elements → not possible
        if (k > n)
            return -1;

        // Initialize binary search range
        int low = Integer.MIN_VALUE; // Minimum max sum (at least the max element)
        int high = 0; // Maximum max sum (sum of all elements)

        // Find low = max element, high = sum of all elements
        for (int i = 0; i < n; i++) {
            low = Math.max(nums[i], low);
            high += nums[i];
        }

        // Binary search on the "answer space" (possible max sum of subarrays)
        while (low <= high) {
            int mid = (low + high) / 2;

            // Count how many subarrays needed if max sum allowed is mid
            if (countSubarray(nums, mid) > k) {
                // Too many subarrays needed → increase allowed sum
                low = mid + 1;
            } else {
                // Possible to split in ≤ k subarrays → try smaller max sum
                high = mid - 1;
            }
        }

        // Final answer will be the minimum possible largest subarray sum
        return low;
    }

    // Helper method to count subarrays needed when max sum per subarray is 'limit'
    public int countSubarray(int[] nums, int limit) {
        int subarrays = 1;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // If current number fits into current subarray
            if (currentSum + nums[i] <= limit) {
                currentSum += nums[i];
            } else {
                // Start new subarray
                subarrays++;
                currentSum = nums[i];
            }
        }

        return subarrays;
    }
}
