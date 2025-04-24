
/*
 * Brute Force
 * Time Complexity: O(N^2), where N is the size of the array. In the worst case i.e. if the missing number is N itself, the outer loop will run for N times, and for every single number the inner loop will also run for approximately N times. So, the total time complexity will be O(N^2).
   Space Complexity: O(1) , as no extra space is used.
 */

public class FIndMissing {
    import java.util.*;
    // Function to find the missing number
    public int missingNumber(int[] nums) {
        // Calculate N from the length of nums
        int N = nums.length;
        
        // Outer loop that runs from 0 to N
        for (int i = 0; i <= N; i++) {
            /* Flag variable to check 
            if an element exists*/
            int flag = 0;
            
            /* Search for the element 
            using linear search*/
            for (int j = 0; j < N; j++) {
                if (nums[j] == i) {
                    // i is present in the array
                    flag = 1;
                    break;
                }
            }
            
            // Check if the element is missing (flag == 0)
            if (flag == 0) return i;
        }
        
        /* The following line will never 
        execute, it is just to avoid warnings*/
        return -1;
    }
}

/*
 * Better
 * Time Complexity: O(N) + O(N) ~ O(2N), where N is size of the array + 1. For storing the frequencies in the hash array, the program takes O(N) time complexity and for checking the frequencies in the second step again O(N) is required. So, the total time complexity is O(N) + O(N)
Space Complexity: O(N) where N is size of the array + 1, as extra hash space is used.
 */

 import java.util.Arrays;

class Solution {
    //  Function to find the missing number
    public int missingNumber(int[] nums) {
        int N = nums.length; 
        
        // Array to store frequencies, initialized to 0
        int[] freq = new int[N+1];
        
        // Storing the frequencies in the array
        for (int num : nums) {
            freq[num]++;
        }
        
        // Checking the frequencies for numbers 0 to N
        for (int i = 0; i <= N; i++) {
            if (freq[i] == 0) {
                return i;
            }
        }
        
        /* This line will never execute, 
        it is just to avoid warnings */
        return -1;
    }
}



