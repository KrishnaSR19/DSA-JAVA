/*
 * Q.Given an array of integers nums and an integer target. Return the indices(0 - indexed) of two elements in nums such that they add up to target.
Each input will have exactly one solution, and the same element cannot be used twice. Return the answer in non-decreasing order.
 */


/* Brute Force
 * Time Complexity:O(N 2), For using two nested loops to traverse the array, where N is the length of that array.
Space Complexity: O(1), not using extra space.
 */

import java.util.*;
public class TwoSum {

class Solution {
    /* Function to find two indices in the array `nums`
       such that their elements sum up to `target`.
    */
    public int[] twoSum(int[] nums, int target) {
        
        int n = nums.length;
        //create ans array to store ans
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                /* if nums[i] + nums[j] is equal to 
                   target put i and j in ans */
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
                
            }
        }
        
        // Return {-1, -1} if no such pair is found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int n = 5;
        int[] nums = {2, 6, 5, 8, 11};
        int target = 14;
        
        // Create an instance of the Solution class
        Solution sol = new Solution();
        
        // Call the twoSum method to find the indices
        int[] ans = sol.twoSum(nums, target);
        
        // Print the result
        System.out.println("This is the answer: [" + ans[0] + ", " + ans[1] + "]");
    }
}

}
