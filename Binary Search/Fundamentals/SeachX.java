/*
 * Q.Given a sorted array of integers nums with 0-based indexing, find the index
 * of a specified target integer. If the target is found in the array, return
 * its index. If the target is not found, return -1.
 */

/*
 * Brute Force
   TC :O(n)
 */

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}

/*
 * Iterative Search
 * Time Complexity: O(log(N)) (where N is the size of the given array)
 * In each step, the search space is divided into two halves. In the worst case,
 * this process will continue until the search space can no longer be divided
 * and the number of divisions required to reduce the array size to one is
 * log(N), making the overall time complexity O(log(N)).
 * 
 * Space Complexity: O(1)
 * Using only a couple of variables.
 */

public int search(int[] nums, int target) {
    int n = nums.length; // Size of array

    // Pointers to define the search space
    int low = 0, high = n - 1;

    // Until the search space is not empty
    while (low <= high) {
        // Find the middle element
        int mid = (low + high) / 2;

        // If it matches the target
        if (nums[mid] == target)
            return mid;

        // If the target is greater than middle element
        else if (target > nums[mid])
            low = mid + 1;

        // Otherwise
        else
            high = mid - 1;
    }

    // If the target is not found
    return -1;
}
