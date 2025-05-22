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