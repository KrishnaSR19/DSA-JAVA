/*
 * Q.Given a sorted array of integers nums with 0-based indexing, find the index
 * of a specified target integer. If the target is found in the array, return
 * its index. If the target is not found, return -1.
 */

/*
 * Brute Force (Linear Search)
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
 * Binary Search Iterative Search
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

/*
 * Binary Search Recursive Method
 * Time Complexity: O(logN), where N is the size of the array
 * In each step, the search space is divided into two halves. In the worst case,
 * this process will continue until the search space can no longer be divided
 * and the number of divisions required to reduce the array size to one is
 * log(N), making the overall time complexity O(logN).
 * 
 * Space Complexity: O(logN), due to the recursion stack space.
 */

// Helper function to find the target in the given range
private int func(int[] nums, int low, int high, int target) {
    // base case
    if (low > high)
        return -1;

    int ind; // to store the index of target
    int mid = low + (high - low) / 2;

    // If target is found, return the index
    if (nums[mid] == target)
        ind = mid;

    // Else if nums[mid] > target, search is left space
    else if (nums[mid] > target)
        ind = func(nums, low, mid - 1, target);

    // Else search in right space
    else
        ind = func(nums, mid + 1, high, target);

    return ind; // Return the index
}

// Function to find the given target in a sorted array
public int search(int[] nums, int target) {
    int n = nums.length;

    // Find the target in the whole array
    return func(nums, 0, n - 1, target);
}
