/*
 * Given an array of integers nums of unique elements. Return all possible subsets (power set) of the array.
Do not include the duplicates in the answer.
 */

 /*
Time Complexity: O(2N*N) (where N is the size of the array) –
The outer loop runs for count numbers of times, and count is 2N resulting in O(2N) TC.
The inner for loop runs to check N bits, resulting in O(N) TC.
Space Complexity: O(2N*N) – Space required to store the power set (approximately).
  */
class Solution {
    /* Function call to get the
    Power set of given array */
    public List<List<Integer>> powerSet(int[] nums) {
        
        // Variable to store size of array
        int n = nums.length;
        
        // To store the answer
        List<List<Integer>> ans = new ArrayList<>();
        
        /* Variable to store the 
        count of total susbsets */
        int count = (1 << n);
        
        // Traverse for every value
        for (int val = 0; val < count; val++) {
            
            // To store the current subset
            List<Integer> subset = new ArrayList<>();
     
            // Traverse on n bits
            for (int i = 0; i < n; i++) {
                if ((val & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            } 
            /* Add the current subset 
            to final answer */
            ans.add(subset);
        }    
        // Return stored answer
        return ans;
    }
}
