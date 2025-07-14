/*
 * LeetCode Problem: 16. 3Sum Closest
 * Problem Link: https://leetcode.com/problems/3sum-closest/
 * Description: Given an array of integers nums and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 * Time Complexity: O(n^2), where n is the length of the input array nums.
 * Space Complexity: O(1), as we are using a constant amount of space.
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];  // Initialize with first 3 elements

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];

                // If exact match found
                if (currSum == target) {
                    return currSum;
                }

                // Update closestSum if needed
                if (Math.abs(currSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currSum;
                }

                // Move pointers
                if (currSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}
