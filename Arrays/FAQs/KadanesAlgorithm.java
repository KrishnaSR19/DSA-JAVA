
/*\
 * Given an integer array nums, find the subarray with the largest sum and return the sum of the elements present in that subarray.
A subarray is a contiguous non-empty sequence of elements within an array.
 */


/*
 * Time Complexity: O(N3), where N is the size of the array. Using three nested loops, each running approximately N times.
  Space Complexity: O(1) no extra space used.
 */


class Solution{
// Function to find maximum sum of subarrays
public int maxSubArray(int[] nums) {
    
    /* Initialize maximum sum with
    the smallest possible integer*/
    int maxi = Integer.MIN_VALUE;

    // Iterate over each starting index of subarrays
    for (int i = 0; i < nums.length; i++) {
        
        /* Iterate over each ending index
        of subarrays starting from i*/
        for (int j = i; j < nums.length; j++) {
            
            /* Variable to store the sum
            of the current subarray*/
            int sum = 0;

            // Calculate the sum of subarray nums[i...j]
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }

            /* Update maxi with the maximum of its current
            value and the sum of the current subarray*/
            maxi = Math.max(maxi, sum);
        }
    }

    // Return the maximum subarray sum found
    return maxi;
}
}