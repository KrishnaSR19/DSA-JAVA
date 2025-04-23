/*
 * Brute Force
 */

import java.util.*;
public class RemoveDulpli {
        // Function to remove duplicates from the array
        public int removeDuplicates(int[] nums) {
            
            // TreeSet to store unique elements in sorted order
            Set<Integer> s = new TreeSet<>();
            
            // Add all elements from array to the set
            for (int val : nums) {
                s.add(val);
            }
            
            // Get the number of unique elements
            int k = s.size();
            
            int j = 0;
            // Copy unique elements from set to array
            for (int val : s) {
                nums[j++] = val;
            }
            
            // Return the number of unique elements
            return k;
        }
}

/*
 * Optimal
 */

 import java.util.*;

     // Function to remove duplicates from the array
     public int removeDuplicates(int[] nums) {
         // Edge case: if array is empty
         if (nums.length == 0) {
             return 0;
         }
         
         // Initialize pointer for unique elements
         int i = 0;
         
         // Iterate through the array
         for (int j = 1; j < nums.length; j++) {
             /*If current element is different 
             from the previous unique element*/
             if (nums[i] != nums[j]) {
                 /* Move to the next position in 
                 the array for the unique element*/
                 i++;
                 /* Update the current position 
                    with the unique element*/
                 nums[i] = nums[j];
             }
         }
         
         // Return the number of unique elements
         return i + 1;
     }
 
 


 
 
