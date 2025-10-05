/*
 * Q.Given an array of integers nums, each element in the array represents the maximum jump length at that position. Initially starting at the first index of the array, determine if it is possible to reach the last index. Return true if the last index can be reached, otherwise return false.
 */

 /*
  * Time Complexity: O(N) where N is the length of the array. We iterate through the input array exactly once and at each element perform constant time operations.
Space Complexity: O(1) no extra space used.
  */

class Solution {
    public boolean canJump(int[] nums) {
        // Initialize maximum index
        int maxIndex = 0;

        // Iterate through each index of the array
        for (int i = 0; i < nums.length; i++) {
            /*
             * If the current index
             * is greater than the
             * maximum reachable index
             * it means we cannot move
             * forward and should
             * return false
             */
            if (i > maxIndex) {
                return false;
            }
            /*
             * Update the maximum index that can be
             * reached by comparing
             * the current maxIndex with the sum
             * of the current index and
             * the maximum jump from that index
             */
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        /*
         * If we complete the
         * loop, it means we
         * can reach the
         * last index
         */
        return true;
    }
}