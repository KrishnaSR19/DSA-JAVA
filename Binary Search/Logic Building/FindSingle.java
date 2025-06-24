/*
 * Given an array nums sorted in non-decreasing order. Every number in the array except one appears twice. Find the single number in the array.
 */

/*
 * Brute Force-I
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
        // Dummy return statement(should never reach here)
        return -1;

    }
}

/*
 * Brute -II
 * Time Complexity:O(N), where N is size of the array. As the array is being
 * traversed only once using a loop.
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1).
 */

public int singleNonDuplicate(int[] nums) {
    int n = nums.length; // Size of the array.

    /*
     * XOR all the elements to find
     * the single non-duplicate element.
     */
    int ans = 0;
    for (int i = 0; i < n; i++) {
        ans ^= nums[i];
    }

    /*
     * Return the single non
     * duplicate element found.
     */
    return ans;
}

/*
 * Optimal(Binary Search)
 * Time Complexity:O(logN), N is size of the given array. We are basically using
 * the Binary Search algorithm.
 * Space Complexity: As no additional space is used, so the Space Complexity is
 * O(1)
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length; // Size of the array.

        // Edge cases:
        if (n == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If nums[mid] is the single element:
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            // We are in the left part:
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1])
                    || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                // Eliminate the left half:
                low = mid + 1;
            }
            // We are in the right part:
            else {
                // Eliminate the right half:
                high = mid - 1;
            }
        }
        // Dummy return statement:
        return -1;
    }

}
