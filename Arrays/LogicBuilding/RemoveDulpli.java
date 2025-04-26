/*
 * Given an integer array nums sorted in non-decreasing order, remove all duplicates in-place so that each unique element appears only once. Return the number of unique elements in the array.
If the number of unique elements be k, then,
Change the array nums such that the first k elements of nums contain the unique values in the order that they were present originally.
The remaining elements, as well as the size of the array does not matter in terms of correctness.
An array sorted in non-decreasing order is an array where every element to the right of an element is either equal to or greater in value than that element.
 */

/*
 * Brute Force
 *Time Complexity: O(N * log N) + O(N), for using hashset, it will take O(N * log N) and also to traverse the array once O(N). Here N is the size of the array.
Space Complexity: O(N) because in the worst case, all the elements of the array can be unique and it will take O(N) space. Here N represents the size of the array.
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
 * Time Complexity: O(N), for single traversal of the array, where N is the size of the array.
   Space Complexity: O(1), not using any extra space.
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
 
 


 
 
