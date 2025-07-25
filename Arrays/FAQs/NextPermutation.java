/*
Brute Force
 * Complexity Analysis
Time Complexity: O(N × N!), where N is the size of the input array.
Generating all permutations involves exploring N! arrangements, and each permutation requires O(N) time to construct, resulting in O(N × N!). Although sorting the permutations and performing a linear search add to the total time, the dominant factor remains O(N × N!) due to the exponential nature of permutation generation.

Space Complexity: O(N × N!)
Recursion stack takes up to O(N) space, and storing all permutations requires O(N × N!) space.

 ****Implementing this will be of no use in interviews.Just tell how it works
 */

 class Solution {

    // Function to get the next permutation of given array
    public void nextPermutation(int[] nums) {
        // Get all the Permutations
        List<List<Integer>> ans = getAllPermutations(nums);

        int index = -1; // Current permutation index

        /* Perform a linear search to get the
        permutation of current permutation */
        for(int i = 0; i < ans.size(); i++) {
            if(match(nums, ans.get(i))) {
                index = i;
                break;
            }
        }

        // Next Permutation index
        int nextPermutationIndex = -1;
        if(index == ans.size() - 1) nextPermutationIndex =  0;
        else nextPermutationIndex = index+1;

        // Store the next permutation in-place
        for(int i = 0; i < nums.length; i++) {
            nums[i] = ans.get(nextPermutationIndex).get(i);
        }

        return;
    }

    /* Function to generate all permutations of 
    the given array in sorted order */
    private List<List<Integer>> getAllPermutations(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // To store the permutation

        // Recursive Helper function call 
        helperFunc(0, nums, ans);

        // Sort the result
        Collections.sort(ans, (a, b) -> {
            for(int i = 0; i < a.size(); i++) {
                if(!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        return ans; // Return the result
    }

    // Helper function to get all the permutations of the given array
    private void helperFunc(int ind, int[] nums, List<List<Integer>> ans) {

        // Base case
        if(ind == nums.length) {
            // Add the permutation to the answer
            List<Integer> temp = new ArrayList<>();
            for(int num : nums) temp.add(num);
            ans.add(temp);
            return;
        }

        // Traverse the array
        for(int i = ind; i < nums.length; i++) {
            swap(nums, ind, i); // Swap-In

            // Recursively call the helper function
            helperFunc(ind + 1, nums, ans);

            swap(nums, ind, i); // Swap-Out
        }

        return;
    }

    // Function to swap two numbers
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // Function to match two arrays
    private boolean match(int[] nums, List<Integer> list) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != list.get(i)) return false;
        }
        return true;
    }
}

 /*
  * Better
  Note that for C++ users, there is an STL function available to find the next permutation of the given array.
The function next_permutation() from the <algorithm> header modifies the array in-place to the next lexicographical permutation. If the array is already the highest permutation, it rearranges it to the lowest possible order (i.e., sorted in ascending order). This function runs in O(N) time and is the most efficient way to solve this problem in C++.
  */

  /*
   * Optimal
   * Time Complexity: O(N), where N is the size of the input array.
Finding the pivot takes O(N) time. Finding the next greater element also takes O(N) in the worst case. And, reversing the subarray takes O(N). All this adds up to a total of O(N) time complexity.
Space Complexity: O(1), as the modification is done in-place and no extra data structure was used apart from a few variables.
   * 
   */

  import java.util.*;

class Solution {
    // Function to get the next permutation of given array
    public void nextPermutation(int[] nums) {
        int n = nums.length; // Size of the given array
        
        // To store the index of the first smaller element from right
        int ind = -1; 
        
        // Find the first index from the end where nums[i] < nums[i+1]
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        
        /* If no such index exists, array is in descending order
           So, reverse it to get the smallest permutation */
        if(ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        // Find the element just greater than nums[ind] from the end
        for(int i = n - 1; i > ind; i--) {
            if(nums[i] > nums[ind]) {
                swap(nums, i, ind); // Swap with nums[ind]
                break;
            }
        }
        
        // Reverse the right half to get the next smallest permutation
        reverse(nums, ind + 1, n - 1);
        return;
    }
    
    // Helper Function to swap two numbers in an array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // Helper function to reverse the array
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        /* Creating an instance of 
           Solution class */
        Solution sol = new Solution();

        // Output the original array
        System.out.print("Given array: ");
        for(int x : nums) System.out.print(x + " ");

        // Function call to get the next permutation of given array
        sol.nextPermutation(nums);

        // Output the next permutation
        System.out.print("\nNext Permutation: ");
        for(int x : nums) System.out.print(x + " ");
    }
}
