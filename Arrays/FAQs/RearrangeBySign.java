/*
 * Q.Given an integer array nums of even length consisting of an equal number of positive and negative integers.Return the answer array in such a way that the given conditions are met:
Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
 */

/*
 * Brute Force
 * TC:O(2n)
 * SC:O(n)
 */

package Arrays.FAQs;
import java.util.ArrayList;
import java.util.List;

public class RearrangeBySign {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }
        int k = 0;
        int j = 0;

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                nums[i] = pos.get(k);
                k++;
            } else {
                nums[i] = neg.get(j);
                j++;
            }
        }

        return nums;
    }
}


/*
 * Brute force efficient
 * Time Complexity: O(N+N/2), where N is the size of the array. O(N) for traversing the array once for segregating positives and negatives and another O(N/2) for adding those elements alternatively to the array.
Space Complexity: O(N/2 + N/2) = O(N), N/2 space required to store each of the positive and negative elements in separate arrays.
 */

import java.util.*;
class Solution {
    // Function to rearrange the given array by signs
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        
        /* Define 2 vectors, one for storing positive 
        and other for negative elements of the array.*/
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
  
        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) pos.add(nums[i]);
            else neg.add(nums[i]);
        }
  
        // Positives on even indices, negatives on odd.
        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = pos.get(i);
            nums[2 * i + 1] = neg.get(i);
        }
        
        // Return the result
        return nums;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -4, -5};
        
        // Create an instance of Solution class
        Solution sol = new Solution();
        
        int[] ans = sol.rearrangeArray(A);
        
        // Print the result
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}

