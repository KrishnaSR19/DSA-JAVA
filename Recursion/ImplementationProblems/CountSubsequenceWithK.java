/*
 * Q.Given an array nums and an integer k.Return the number of non-empty subsequences of nums such that the sum of all elements in the subsequence is equal to k.
 */

/*
 * Time Complexity of the recursive approach is O(2^N), where n is the number of elements in the array. This is because each element has two choices (to include or exclude), leading to an exponential number of possible subsets.

Space Complexity is O(N), where n is the maximum depth of the recursion stack. This depth corresponds to the number of elements in the array being considered at any given time.
 */

class Solution {
    // Helper function to count subsequences
    // with the target sum
    private int func(int ind, int sum, int[] nums) {
        // Base case: if sum is 0, one valid
        // subsequence is found
        if (sum == 0)
            return 1;
        // Base case: if sum is negative or
        // index exceeds array size
        if (sum < 0 || ind == nums.length)
            return 0;
        // Recurse by including current number
        // or excluding it from the sum
        return func(ind + 1, sum - nums[ind], nums) + func(ind + 1, sum, nums);
    }

    // Function to start counting subsequences
    public int countSubsequenceWithTargetSum(int[] nums, int target) {
        return func(0, target, nums);
    }
}
