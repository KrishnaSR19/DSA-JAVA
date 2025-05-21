import java.util.*;



/*
 * Brute Force
 * Time Complexity: O(NxlogN), where N is the size of the array. As the optimal sorting take O(N * logN) time.
Space Complexity: O(1) no extra space is used to solve the problem.
 */
class Solution {
    // Function to sort the array
    public void sortZeroOneTwo(int[] nums) {
        // Sort the array using Arrays.sort
        Arrays.sort(nums);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 1, 0, 2};
        
        // Create an instance of Solution class
        Solution sol = new Solution();
        
        sol.sortZeroOneTwo(nums);
        
        // Print the array elements
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}



/*
 * Better(3 pointer)
 * Time Complexity: O(N)+O(N) = O(2N), where N is the size of the array. There are 2 traversals in the array to count the frequencies then in second iteration we are overwriting.
Space Complexity: O(1) no extra space used.
 */
import java.util.*;

class Solution {
    // Function to sort the array containing only 0s, 1s, and 2s
    public void sortZeroOneTwo(int[] nums) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        // Counting the number of 0s, 1s, and 2s in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) cnt0++;
            else if (nums[i] == 1) cnt1++;
            else cnt2++;
        }

        /* Placing the elements in the
           original array based on counts */
        // placing 0's
        for (int i = 0; i < cnt0; i++) nums[i] = 0;

        // placing 1's
        for (int i = cnt0; i < cnt0 + cnt1; i++) nums[i] = 1; 
        
        // placing 2's
        for (int i = cnt0 + cnt1; i < nums.length; i++) nums[i] = 2;
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 2, 0, 1};
        
        // Create an instance of Solution class
        Solution sol = new Solution();
        
        sol.sortZeroOneTwo(nums);
        
        // Print the array elements after sorting
        System.out.println("After sorting:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}


