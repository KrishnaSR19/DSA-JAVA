import java.util.*;

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

