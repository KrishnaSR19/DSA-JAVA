/*
 * Q.Given a sorted array of nums consisting of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 */

/*
 * Brute Force
Time Complexity: O(N), where N is the size of the given array. We are using the Linear Search algorithm, which iterates linearly resulting in N time complexity.
Space Complexity: O(1), as we are not using any extra space to solve this problem.
 */

public int searchInsert(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] >= target)
            return i;
    }

    return nums.length;
}

/*
 * Optimal
 * Time Complexity: O(logN), where N is the size of the given array. We are
 * using the Binary Search algorithm, which divides the search space in half
 * each time, resulting in a logarithmic time complexity.
 * 
 * Space Complexity: O(1), as we are not using any extra space to solve this
 * problem.
 */

public int searchInsert(int[] nums, int target) {
    int n = nums.length;
    int low = 0;
    int high = n - 1;
    int ans = n;

    while (low <= high) {
        int mid = (low + high) / 2;
        if (nums[mid] >= target) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }

    }

    return ans;
}
