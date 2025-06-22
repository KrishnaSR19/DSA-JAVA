
/*
 * Q.Given an integer array nums, sorted in ascending order (with distinct values) and a target value k. The array is rotated at some pivot point that is unknown. Find the index at which k is present and if k is not present return -1.
 */

/*
 * Brute Force
 * Time Complexity: O(N), N = size of the given array. Since we have to iterate through the entire array to check if the target is present in the array.

Space Complexity: O(1), as we have not used any extra data structures. This makes space complexity, even in the worst case, O(1).
 */

class Solution {
    public int search(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k)
                return i;
        }
        return -1;
    }
}

/*
 * Optimal(Binary Search)
 * Time Complexity: O(logN), as the search space is reduced logarithmically,
 * where N is the size of the given array.
 * 
 * Space Complexity: O(1), not using any extra data structure.
 */

public int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;

    while (low <= high) {
        int mid = (low + high) / 2;

        if (nums[mid] == target)
            return mid;

        if (nums[low] <= nums[mid]) {
            if (nums[low] <= target && target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else {
            if (nums[mid] <= target && target <= nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    return -1;
}
