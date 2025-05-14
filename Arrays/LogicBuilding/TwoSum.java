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




/*
 * Better 
 * Time Complexity:O(N), where N is the size of the array. The loop runs N times in the worst case and searching in a hashmap takes O(1) generally. So the time complexity is O(N).
Note:In the worst case(which rarely happens), the unordered_map takes O(N) to find an element. In that case, the time complexity will be O(N2). If we use map instead of unordered_map,
 the time complexity will be O(N* logN) as the map data structure takes logN time to find an element.
Space Complexity: O(N) for using the map data structure.
 */

 import java.util.*;

class Solution {
    /* Function to find two indices in the array `nums`
       such that their elements sum up to `target`.
    */
    public int[] twoSum(int[] nums, int target) {
        
        // Map to store (element, index) pairs
        Map<Integer, Integer> mpp = new HashMap<>();
        
        // Size of the nums array
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Current number in the array
            int num = nums[i];
            
            // Number needed to reach the target
            int moreNeeded = target - num;

            // Check if the complement exists in map
            if (mpp.containsKey(moreNeeded)) {
                /* Return the indices of the two
                numbers that sum up to target*/
                return new int[]{mpp.get(moreNeeded), i};
            }

            // Store current number and its index in map
            mpp.put(num, i);
        }

        // If no such pair found, return {-1, -1}
        return new int[]{-1, -1};
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 8, 11};
        int target = 14;

        // Create an instance of Solution class
        Solution sol = new Solution();
        
        // Call the twoSum method from Solution class
        int[] ans = sol.twoSum(nums, target);

        // Print the result
        System.out.println("Indices of the two numbers that sum up to " + target + " are: [" + ans[0] + ", " + ans[1] + "]");
    }
}

