/*Q.
 * Provided with a goal integer target and an array of unique integer candidates, provide a list of all possible combinations of candidates in which the selected numbers add up to the target. The combinations can be returned in any order.
A candidate may be selected from the pool an infinite number of times. There are two distinct combinations if the frequency of at least one of the selected figures differs.
The test cases are created so that, for the given input, there are fewer than 150 possible combinations that add up to the target.
If there is no possible subsequences then return empty vector.
 */

/*
 * Time Complexity: O(K*2N), where N is the number of elements, due to the exponential number of possible combinations explored in the worst case. For each subset, it may take up to K operations to process, where K is the maximum length of any subset in the result
Space Complexity: O(K*N), where N is the maximum depth of recursion, which corresponds to the length of the combination path stored in memory.
 */

class Solution {

    // Recursive function to find all subsequences with the given target sum
    public void func(List<Integer> v, int i, int sum, List<Integer> v2, List<List<Integer>> ans) {
        // Base case: if the sum is zero, add the current subsequence to the result
        if (sum == 0) {
            ans.add(new ArrayList<>(v2));
            return;
        }

        // Base case: if the sum becomes negative or no elements are left
        if (sum < 0 || i < 0) {
            return;
        }

        // Exclude the current element and move to the next
        func(v, i - 1, sum, v2, ans);

        // Include the current element in the subsequence
        v2.add(v.get(i));

        // Recursively call the function with the included element
        func(v, i, sum - v.get(i), v2, ans);

        // Backtrack by removing the last added element
        v2.remove(v2.size() - 1);
    }

    // Main function to find all unique combinations of candidates that sum to the
    // target
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        // Convert the array to a list for easier manipulation
        for (int num : candidates) {
            v.add(num);
        }

        // Start the recursive process
        func(v, v.size() - 1, target, new ArrayList<>(), ans);

        return ans;
    }
}

