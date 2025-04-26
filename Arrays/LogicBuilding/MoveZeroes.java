/*
 * Q.Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same. This must be done in place, without making a copy of the array.
 */


import java.util.*;
/*
 * Brute Force
 *Time Complexity: O(2*N), O(N) for copying non-zero elements from the original to the temporary array. O(X) for again copying it back from the temporary to the original array. O(N-X) for filling zeros in the original array. Here N is the size of the array and X is the number of non-zero elements.
 Space Complexity: O(N), for using a temporary array to solve this problem and the maximum size of the array can be N in the worst case.
 */
class MoveZeroes {
    // Function to move zeroes to the end
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        // Create a temporary array to store non-zero elements
        int[] temp = new int[n];
        int count = 0;

        // Copy non-zero elements to temp
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp[count++] = nums[i];
            }
        }

        // Copy non-zero elements back to nums
        for (int i = 0; i < count; i++) {
            nums[i] = temp[i];
        }

        // Fill the rest with zeroes
        for (int i = count; i < n; i++) {
            nums[i] = 0;
        }
    }

    /*
     * Optimal 1
     * TC O(N)
     * SC O(1) as no use of any extra space is done to solve this problem.
     */
    
     public void moveZeroes(int[] nums) {
        int j = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
          if (nums[i] == 0) {
            j = i;
            break;
          }
        }
        if(j==-1) return;
    
        for (int i = j + 1; i < n; i++) {
          if (nums[i] != 0) {
            swapArr(nums, i, j);
            j++;
          }
        }
      }
    
      public void swapArr(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }

      /*
       * Optimal 2
       * Time Complexity: O(N), where N is size of the array, as we are traversing the array once.
         Space Complexity: O(1) , as no use of any extra space is done to solve this problem.
       */

       public void moveZeroes(int[] nums) {
        int j = 0; // Initialize j to 0

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        // Fill the remaining elements with zeros
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }