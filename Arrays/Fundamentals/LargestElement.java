package Arrays.Fundamentals;

import java.util.Arrays;

/**
 * Brute Force is directly sort the array and print the last element(that will
 * also be brute force)
 * TC O(nlogn)
 */
public class LargestElement {
        public static int largestElement(int[]  nums) {
        Arrays.sort(nums);
        int largest = nums[nums.length - 1];
        return largest;
    }

}

/*
 * Optimal approach
 * TC O(n)
 */

public class LargestElement {
    public int largestElement(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }

}
