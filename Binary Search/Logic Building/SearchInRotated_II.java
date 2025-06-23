/*
 * Brute Force
 * Time Complexity:O(N), for iterating through N elements, where N is the size of the given array.

Space Complexity:O(1), not using any extra space to solve this problem.
 */

public boolean searchInARotatedSortedArrayII(int[] arr, int target) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {

        if (arr[i] == target)
            return true;
    }

    return false;
}

/*
 * Optimal
 * Time Complexity:O(logN) for the best and average cases. As in the best and
 * average scenarios, the binary search algorithm is primarily used and hence
 * the time complexity is O(logN).
 * However, in the worst-case scenario, it'll be O(N/2) where all array elements
 * are the same but not the target (e.g., given array = {3, 3, 3, 3, 3, 3, 3}),
 * we continue to reduce the search space by adjusting the low and high pointers
 * until they intersect, which will end up taking O(N/2) time complexity.
 * 
 * Space Complexity:O(1), as we are not using any extra space to solve this
 * problem.
 */
class Solution {
    public boolean searchInARotatedSortedArrayII(ArrayList<Integer> nums, int k) {
        int n = nums.size();
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums.get(mid) == k)
                return true;

            // handles duplicate cases
            if (nums.get(low).equals(nums.get(mid)) && nums.get(mid).equals(nums.get(high))) {
                low++;
                high--;
                continue;
            }

            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) <= k && k <= nums.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums.get(mid) <= k && k <= nums.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}