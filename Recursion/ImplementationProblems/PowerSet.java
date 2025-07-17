/*
 *Q.Given an array of integers nums of unique elements. Return all possible subsets (power set) of the array.
  Do not include the duplicates in the answer.
 */

/*
 * Time Complexity O(2^N): Each element in the array has two choices: either to be included in a subset or not, leading to 2^n possible subsets.
Space Complexity O(N * 2^N): We generate 2^n subsets, and each subset can have up to n elements. Additionally, the recursion stack can go up to a depth of n.
 */
class Solution {

    // Main function to generate the power set (all subsets) of the given array
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // Final list to store all subsets
        List<Integer> current = new ArrayList<>(); // Temporary list to store the current subset

        // Start backtracking from index 0
        backtrack(0, nums.length, nums, current, ans);

        return ans; // Return the final list of subsets
    }

    // Recursive helper function to explore all possible subsets
    public void backtrack(int index, int n, int[] nums, List<Integer> current, List<List<Integer>> ans) {

        // Base case: If we have considered all elements
        if (index == n) {
            // Add the current subset to the final answer list
            ans.add(new ArrayList<>(current)); // Make a copy to avoid mutation later
            return;
        }

        // Choice 1: Exclude the current element and move to the next
        backtrack(index + 1, n, nums, current, ans);

        // Choice 2: Include the current element
        current.add(nums[index]);

        // Continue exploring with current element included
        backtrack(index + 1, n, nums, current, ans);

        // Backtrack: Remove the last added element to try other combinations
        current.remove(current.size() - 1);
    }
}
