/*
 * Given n roses and an array nums where nums[i] denotes that the 'ith' rose will bloom on the nums[i]th day, only adjacent bloomed roses can be picked to make a bouquet. Exactly k adjacent bloomed roses are required to make a single bouquet. Find the minimum number of days required to make at least m bouquets, each containing k roses. Return -1 if it is not possible.
 */

/*
 * Brute Force
Time Complexity:O((max-min+1) * N), where max is the maximum element of the array, min is the minimum element of the array, N is size of the array}.
As, running a loop to check answers that are in the range of [min, max]. For every possible answer, the possible() function is being called. Inside the possible() function, traversing the entire array, which results in O(N).
Space Complexity: As no additional space is used, so the Space Complexity is O(1).
 */

class Solution {
    /* Function to check if it's possible to make
    m bouquets with k flowers each on day*/
    private boolean possible(int[] nums, int day, int m, int k) {
        int n = nums.length; 
        
        // Count of flowers bloomed
        int cnt = 0; 
        
        // Count of bouquets formed
        int noOfB = 0; 

        // Count number of bouquets that can be formed
        for (int i = 0; i < n; i++) {
            if (nums[i] <= day) {
                // Increment flower count
                cnt++; 
            } else {
                /* Calculate number of bouquets
                formed with flowers <= day */
                noOfB += (cnt / k);
                
                // Reset flower count
                cnt = 0; 
            }
        }
        // Add remaining flowers as a bouquet
        noOfB += (cnt / k); 

        /* Return true if enough 
        bouquets can be formed */
        return noOfB >= m; 
    }

    /* Function to find the earliest day to
    make m bouquets of k flowers each*/
    public int roseGarden(int n, int[] nums, int k, int m) {
        
        /* Calculate the minimum 
           number of flowers required*/
        long val = (long) m * k; 
        
        /* Impossible case: not enough 
           flowers to make m bouquets*/
        if (val > n) return -1; 
        
        /* Find maximum and minimum
           bloom days in the array */
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, nums[i]); 
            maxi = Math.max(maxi, nums[i]); 
        }

        /* Linear search to find the
        earliest day to make m bouquets */
        for (int i = mini; i <= maxi; i++) {
            if (possible(nums, i, m, k))
                return i;
        }
        
        // Return-1 if no such day exists
        return -1;
    }

}
