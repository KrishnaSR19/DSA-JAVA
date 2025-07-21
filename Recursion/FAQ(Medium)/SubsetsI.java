/*
 *Q. Given an array nums of n integers.Return sum of all subsets of the array nums.
Output can be printed in any order.
 */

/*
 * Time Complexity: O(2^N), where N is the number of elements in the array. This is because we explore all possible subsets of the array.
 * Space Complexity: O(N), due to the recursion stack depth and storage for the current subset.
 */

class Solution {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // Start the recursion with index 0 and initial sum 0
        func(0, 0, nums, ans);
        return ans;
    }

    private void func(int ind, int sum, int[] nums, List<Integer> ans) {
        // Base case: if index reaches the end of the nums array
        if (ind == nums.length) {
            // Add the current sum to the ans list
            ans.add(sum);
            return;
        }
        // Recursively include the current element in the sum
        func(ind + 1, sum + nums[ind], nums, ans);
        // Recursively exclude the current element from the sum
        func(ind + 1, sum, nums, ans);
    }
}
