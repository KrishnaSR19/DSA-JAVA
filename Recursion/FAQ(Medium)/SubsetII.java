/*
 * Q.Given an integer array nums, which can have duplicate entries, provide the power set. Duplicate subsets cannot exist in the solution set. Return the answer in any sequence.
 */

/*Time Complexity: O(2^N * N) - Each element is either included or excluded, leading to an exponential number of subsets.

Space Complexity: O(N) - The space complexity is dominated by the recursion stack, which can go as deep as the number of elements in the input list. 
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // Sort to group duplicates
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(current)); // Add current subset

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates at the same recursive level
            if (i > index && nums[i] == nums[i - 1])
                continue;

            current.add(nums[i]); // Choose
            backtrack(i + 1, nums, current, ans); // Explore
            current.remove(current.size() - 1); // Unchoose
        }
    }
}
