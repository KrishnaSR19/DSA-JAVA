/*
 * Given an array nums sorted in non-decreasing order. Every number in the array except one appears twice. Find the single number in the array.
 */

/*
 * Brute Force
 * Time Complexity:O(N), where N is size of the array. As the array is being traversed only once using a single loop.

Space Complexity: As no additional space is used, so the Space Complexity is O(1).
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            } else if (i == n - 1) {
                if (nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            } else {
                if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            }

        }
        return -1;

    }
}

