/*
 *Q. Given an array nums of size n, which denotes the positions of stalls, and an integer k, which denotes the number of aggressive cows, assign stalls to k cows such that the minimum distance between any two cows is the maximum possible. Find the maximum possible minimum distance.
 */

/*
 * Brute Force
 Time Complexity:O(NlogN) + O(N *(max-min)), where N is size of the array, max is the maximum element in array, min is the minimum element in array.
O(NlogN) for sorting the array. The loop runs for 1 to (max-min) to check all possible distances. Inside the loop, canWePlace() function is being called for each distance. Now, inside the canWePlace() function, the loop runs for N times.
Space Complexity: As no additional space is used, so the Space Complexity is O(1).
 */
class Solution {
    /*
     * Function to check if we can place 'cows' cows
     * with at least 'dist' distance apart
     */
    private boolean canWePlace(int[] nums, int dist, int cows) {
        // Size of array
        int n = nums.length;

        // Number of cows placed
        int cntCows = 1;

        // Position of last placed cow
        int last = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] - last >= dist) {
                // Place next cow
                cntCows++;

                // Update the last location
                last = nums[i];
            }
            if (cntCows >= cows)
                return true;
        }
        return false;
    }

    /*
     * Function to find the maximum possible minimum
     * distance 'k' cows can have between them in nums
     */
    public int aggressiveCows(int[] nums, int k) {
        // Size of array
        int n = nums.length;
        // Sort the nums
        Arrays.sort(nums);

        int limit = nums[n - 1] - nums[0];
        for (int i = 1; i <= limit; i++) {
            if (!canWePlace(nums, i, k)) {
                return (i - 1);
            }
        }
        // Return the answer
        return limit;
    }
}
