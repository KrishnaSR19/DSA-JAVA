/*
 * Koko Eating Bananas
 * A monkey is given n piles of bananas, where the 'ith' pile has nums[i] bananas. An integer h represents the total time in hours to eat all the bananas.
Each hour, the monkey chooses a non-empty pile of bananas and eats k bananas. If the pile contains fewer than k bananas, the monkey eats all the bananas in that pile and does not consume any more bananas in that hour.
Determine the minimum number of bananas the monkey must eat per hour to finish all the bananas within h hours.
 */

 /*
  * Brute Force
  * Time Complexity: O(N * M), where N is the number of piles and M
    * is the maximum number of bananas in a pile. The while loop runs M times
    * and the for loop runs N times.
    * Space Complexity: O(1), as no extra space is used.
  */

class Solution {
    // Helper function to find the maximum element in the array
    private int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        int n = v.length;

        // Find the maximum element
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    /* Helper function to calculate total hours
       required at given hourly rate */
    private long calculateTotalHours(int[] v, int hourly) {
        long totalH = 0;
        int n = v.length;

        // Calculate total hours required
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) v[i] / (double) hourly);
        }
        return totalH;
    }

    // Function to find the minimum rate to eat bananas
    public int minimumRateToEatBananas(int[] nums, int h) {
        // Find the maximum number of bananas
        int maxi = findMax(nums);

        /* Find the minimum value of k
           that satisfies the condition */
        for (int i = 1; i <= maxi; i++) {
            long reqTime = calculateTotalHours(nums, i);
            if (reqTime <= (long) h) {
                return i;
            }
        }

        /* Dummy return statement (should 
           not be reached in valid cases) */
        return maxi;
    }
}
