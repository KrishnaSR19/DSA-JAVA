package Arrays.Fundamentals;
import java.util.*;

public class LineareSerach {
    

// Linear Search Function
    public int linearSearch(int[] nums, int target) {
        // Traverse the entire array
        for (int i = 0; i < nums.length; i++) {

            // Check if current element is target
            if (nums[i] == target) {

                // Return if target found
                return i;

            }
        }
        // If target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 4;

        // Create an instance of the Solution class
        Solution sol = new Solution();

         // Call the linearSearch method
        int result = sol.linearSearch(nums, target);
        
        System.out.println(result);
    }


    
}
