/*
 * Q.Given an array of integers nums and an integer limit as the threshold value, find the smallest positive integer divisor such that upon dividing all the elements of the array by this divisor, the sum of the division results is less than or equal to the threshold value.
Each result of the division is rounded up to the nearest integer greater than or equal to that element.
 */

 /*
  * Brute Force
    * Time Complexity: O(n * m)
    * The outer loop runs for m iterations (where m is the maximum element in nums) and the inner loop runs for n iterations (where n is the size of nums). Thus, the overall time complexity is O(n * m).
    * Space Complexity: O(1), as there are no additional data structures used.
  */

class Solution {
    // Function to find the smallest divisor
    public int smallestDivisor(int[] nums, int limit) {
        // Size of array
        int n = nums.length;

        // Find the maximum element in nums
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        // Find the smallest divisor
        for (int d = 1; d <= maxi; d++) {
            int sum = 0;

            /* Calculate the sum of ceil
            (nums.get(i) / d) for all elements */
            for (int i = 0; i < n; i++) {
                sum += Math.ceil((double) nums[i] / (double)(d));
            }

            // Check if the sum is <= limit
            if (sum <= limit)
                return d;
        }

        // Return -1 if no valid divisor found
        return -1;
    }
}


/*
 * Optimal
 * Time Complexity: O(n * log(maxi))
 * The binary search runs in O(log(maxi)) time, and for each iteration, we
 * calculate the sum of ceil(nums[i] / mid) in O(n) time, leading to an overall
 * time complexity of O(n * log(maxi)). 
 * Space Complexity: O(1), as there are no additional data structures used.
 */

class Solution {
    // Function to find the smallest divisor
    public int smallestDivisor(int[] nums, int limit) {
        // Size of array
        int n = nums.length;

        // Find the maximum element in nums
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        // Binary search for the smallest divisor
        int low = 1, high = maxi;
        while (low < high) {
            int mid = low + (high - low) / 2;
            long sum = 0;

            // Calculate the sum of ceil(nums[i] / mid)
            for (int i = 0; i < n; i++) {
                sum += Math.ceil((double) nums[i] / mid);
            }

            // Adjust search space based on the sum
            if (sum <= limit) {
                high = mid; // Try smaller divisor
            } else {
                low = mid + 1; // Increase divisor
            }
        }

        return low; // Return the smallest divisor found
    }
