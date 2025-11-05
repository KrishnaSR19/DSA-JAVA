/*
 * Number of Good Pairs
 * https://leetcode.com/problems/number-of-good-pairs/
 * Given an array of integers nums, return the number of good pairs.
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 * Example 1:
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-based indices.
 * Example 2:
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 0
 * Constraints:
 * 1 <= nums.length <= 100
 *  1 <= nums[i] <= 100
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


 import java.util.*;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each number
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int count = 0;

        // For each number, add nC2 pairs (n * (n-1) / 2)
        for (int value : map.values()) {
            if (value > 1) {
                count += (value * (value - 1)) / 2;
            }
        }

        return count;
    }
}
