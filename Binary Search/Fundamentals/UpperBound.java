/*
 * Given a sorted array of nums and an integer x, write a program to find the upper bound of x. The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than a given key i.e. x.
If no such index is found, return the size of the array.
 */


/*
 * Brute Force(Linear Search)
 * Time Complexity: O(N), where N is the size of the given array. In the worst case, we have to traverse the entire array. This is the time complexity of the linear search algorithm.
Space Complexity: O(1), no extra space is used to solve this problem.
 */
  public int lowerBound(int[] nums, int x) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        if (nums[i] > x) {
            return i;
        }
    }
    return n;
}


/*
 * Optimal(Binary Search)
 * Time Complexity: O(log N), where N is the size of the given array. For using
 * the Binary Search algorithm, the search space is divided in half each time,
 * resulting in a logarithmic time complexity.
 * 
 * Space Complexity: O(1), not using any extra space to solve this problem.
 */

// Function to find the lower bound
public int lowerBound(int[] nums, int x) {
    int low = 0, high = nums.length - 1;
    int ans = nums.length;

    while (low <= high) {
        int mid = (low + high) / 2;
        /*
         * Check if mid element
         * is a potential answer
         */
        if (nums[mid] >x) {
            ans = mid;
            // Search left half
            high = mid - 1;
        } else {
            // Search right half
            low = mid + 1;
        }
    }
    return ans;
}
