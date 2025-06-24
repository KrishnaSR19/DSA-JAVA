/*
 * Q.Given an integer array nums of size N, sorted in ascending order with distinct values, and then rotated an unknown number of times (between 1 and N), find the minimum element in the array.
 */

/*
 * Optimal
 * Time Complexity:O(log(N)), where N is size of the array. Because binary search is being used.
Space Complexity:O(1) As no additional space is used.
 */
class Solution {

    public int findMin(ArrayList<Integer> arr) {
        // Initialize low and high indices
        int low = 0, high = arr.size() - 1;

        // Initialize ans to maximum integer value
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            // Check if left part is sorted
            if (arr.get(low) <= arr.get(mid)) {
                /*
                 * Update ans with minimum
                 * of ans and arr[low]
                 */
                ans = Math.min(ans, arr.get(low));
                // Move to the right part
                low = mid + 1;
            } else {
                /*
                 * Update ans with minimum
                 * of ans and arr[mid]
                 */
                ans = Math.min(ans, arr.get(mid));
                // Move to the left part
                high = mid - 1;
            }
        }
        // Return the minimum element found
        return ans;
    }
}
