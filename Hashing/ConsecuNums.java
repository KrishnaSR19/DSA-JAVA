/*
 * Q.Given an array nums of n integers, return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.
 */



/*
 * Brute Force
 * Time Complexity: O(N3), where N is the size of the array.
 In the worst case, all N elements form a single consecutive sequence. Each element in nums is checked in the outer loop O(N) times. The inner while loop could also run O(N) times for one outer iteration. Since linearSearch() is called inside the conditional statement of the while loop and itself runs in O(N), this results in a cubic time complexity.
 
 Space Complexity: O(1), as we are not using any extra space to solve this problem.
 */

// Helper function to perform linear search

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

private boolean linearSearch(int[] a, int num) {
        int n = a.length;
        // Traverse through the array

// If the array is empty
    if (nums.length == 0) {
        return 0;
    }
    int n = nums.length;
    // Initialize the longest sequence length
    int longest = 1;

    // Iterate through each element in the array
    for (int i = 0; i < n; i++) {
        // Current element
        int x = nums[i];
        // Count of the current sequence
        int cnt = 1;

        // Search for consecutive numbers
        while (linearSearch(nums, x + 1) == true) {
            // Move to the next number in the sequence
            x += 1;
            // Increment the count of the sequence
            cnt += 1;
        }

        // Update the longest sequence length found so far
        longest = Math.max(longest, cnt);
    }
    return longest;
}

/*
 * Better
 * Time Complexity: O(NlogN) + O(N), here N is the size of the given array.
 * Here, O(NlogN) is for sorting the array. To find the longest sequence, we use
 * a loop that results in O(N).
 * 
 * Space Complexity: O(1), as we are not using any extra space to solve this
 * problem.
 */

public int longestConsecutive(int[] nums) {

    // Return 0 if array is empty
    if (n == 0)
        return 0;

    Arrays.sort(nums); // Sort the array

    // Track last smaller element
    int lastSmaller = Integer.MIN_VALUE;
    // Count current sequence length
    int cnt = 0;
    // Track longest sequence length
    int longest = 1;

    for (int i = 0; i < n; i++) {
        // If consecutive number exists
        if (nums[i] - 1 == lastSmaller) {
            // Increment sequence count
            cnt += 1;
            // Update last smaller element
            lastSmaller = nums[i];
        }
        // If consecutive number doesn't exist
        else if (nums[i] != lastSmaller) {
            // Reset count for new sequence
            cnt = 1;
            // Update last smaller element
            lastSmaller = nums[i];
        }
        // Update longest if needed
        longest = Math.max(longest, cnt);
    }
    return longest;
}


/*
 * Optimal
 * Time Complexity: O(N) + O(2xN) ~ O(3xN), where N is the size of the array. The function takes O(N) to insert all elements into the set data structure. After that, for every starting element, we find the consecutive elements. Although nested loops are used, the set will be traversed at most twice in the worst case. Therefore, the time complexity is O(2xN) instead of O(N2).

Space Complexity: O(N), as we use a set data structure to solve this problem.
Note: The time complexity assumes that we use an unordered_set, which has O(1) time complexity for set operations.

In the worst case, if the set operations take O(N), the total time complexity would be approximately O(N2). If we use a set instead of an unordered_set, the set operations will have a time complexity of O(logN), resulting in a total time complexity of O(NlogN).
 */

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        // If the array is empty
        if (n == 0) return 0;

        // Initialize the longest sequence length
        int longest = 1; 
        Set<Integer> st = new HashSet<>();

        // Put all the array elements into the set
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        /* Traverse the set to 
           find the longest sequence */
        for (int it : st) {
            // Check if 'it' is a starting number of a sequence
            if (!st.contains(it - 1)) {
                // Initialize the count of the current sequence
                int cnt = 1; 
                // Starting element of the sequence
                int x = it; 

                // Find consecutive numbers in the set
                while (st.contains(x + 1)) {
                    // Move to the next element in the sequence
                    x = x + 1; 
                    // Increment the count of the sequence
                    cnt = cnt + 1; 
                }
                // Update the longest sequence length
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }


